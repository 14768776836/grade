package com.grade.project.grade.service.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.grade.project.grade.mapper.GradeAccountMapper;
import com.grade.project.grade.mapper.GradeWxPublicNumMapper;
import com.grade.project.grade.mapper.vo.PublicNumVoMapper;
import com.grade.project.grade.model.GradeAccount;
import com.grade.project.grade.model.GradeAccountExample;
import com.grade.project.grade.model.GradeWxPublicNum;
import com.grade.project.grade.model.GradeWxPublicNumExample;
import com.grade.project.grade.model.vo.PublicNumVo;
import com.grade.project.grade.util.wx.EmojiUtil;
import com.grade.project.grade.util.wx.WxUserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicNumServiceImpl implements PublicNumService {

    @Autowired
    private PublicNumVoMapper publicNumVoMapper;
    @Autowired
    private GradeWxPublicNumMapper gradeWxPublicNumMapper;
    @Autowired
    private GradeAccountMapper gradeAccountMapper;

    @Override
    public List<PublicNumVo> getPublicNumList(Integer userId) {
        return publicNumVoMapper.getPublicNumList(userId);
    }

    @Override
    public String saveWxUserIfo(String code, GradeAccount gradeAccount) {
        int userid = gradeAccount.getUserId();
        /**
         * 注意：
         * 写此判断是为了满足两种情况  if中的处理是为了满足第二种
         * 1.总代理添加商户的时候，校验公众号绑定总代理自己的信息
         * 2.普通用户在认证新的商户号成功拿到code以后，由于安全问题，前端在此功能只会传递公众号appid，不会再传递appSecrect,所以根据appid再查询对应的appSecrect值
         */
        if(StringUtils.isBlank(gradeAccount.getAppSecrect())){
            //将userId定义到新的值中是因为gradeAccountMapper.selectByExample方法查询后，userId就会变成总代理的
            GradeAccountExample gradeAccountExample = new GradeAccountExample();
            gradeAccountExample.createCriteria().andAppidEqualTo(gradeAccount.getAppid());
            List<GradeAccount> glist = gradeAccountMapper.selectByExample(gradeAccountExample);
            if(glist.size() > 0){
                gradeAccount = glist.get(0);
            }
        }
        String wxUserInfo = WxUserInfo.getWxUserInfo(gradeAccount.getAppid(),gradeAccount.getAppSecrect(),code);
        JSONObject jsonObject = (JSONObject) JSON.parse(wxUserInfo);
        if(jsonObject != null){
            String openid = jsonObject.getString("openid");
            String nickname = EmojiUtil.filterEmoji(jsonObject.getString("nickname"));
            GradeWxPublicNum wxNum = new GradeWxPublicNum();
            wxNum.setOpenId(openid);
            wxNum.setUserId(userid);
            wxNum.setWxUserName(nickname);
            wxNum.setWxHeadImg(jsonObject.getString("headimgurl"));
            GradeWxPublicNumExample gradeWxPublicNum = new GradeWxPublicNumExample();
            //根据公众号appid   及授权返回的openid   授权用户的userid  查询当前用户是否认证过
            gradeWxPublicNum.createCriteria().andAppidEqualTo(gradeAccount.getAppid()).andOpenIdEqualTo(openid).andUserIdEqualTo(userid);
            List<GradeWxPublicNum> wxPublicNum = gradeWxPublicNumMapper.selectByExample(gradeWxPublicNum);
            if(wxPublicNum.size() > 0){
                //认证过   更新相关信息
                wxNum.setId(wxPublicNum.get(0).getId());
                gradeWxPublicNumMapper.updateByPrimaryKeySelective(wxNum);
            }else{
                //没认证过，保存信息
                wxNum.setAppid(gradeAccount.getAppid());
                gradeWxPublicNumMapper.insertSelective(wxNum);
            }
        }else{
            return "用户信息获取失败！";
        }
        return "SUCCESS";
    }
}
