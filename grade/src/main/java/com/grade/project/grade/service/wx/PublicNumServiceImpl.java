package com.grade.project.grade.service.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.grade.project.grade.mapper.GradeWxPublicNumMapper;
import com.grade.project.grade.mapper.vo.PublicNumVoMapper;
import com.grade.project.grade.model.GradeAccount;
import com.grade.project.grade.model.GradeWxPublicNum;
import com.grade.project.grade.model.GradeWxPublicNumExample;
import com.grade.project.grade.model.vo.PublicNumVo;
import com.grade.project.grade.util.wx.EmojiUtil;
import com.grade.project.grade.util.wx.WxUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicNumServiceImpl implements PublicNumService {

    @Autowired
    private PublicNumVoMapper publicNumVoMapper;
    @Autowired
    private GradeWxPublicNumMapper gradeWxPublicNumMapper;

    @Override
    public List<PublicNumVo> getPublicNumList(Integer userId) {
        return publicNumVoMapper.getPublicNumList(userId);
    }

    @Override
    public String saveWxUserIfo(String code, GradeAccount gradeAccount) {
        String wxUserInfo = WxUserInfo.getWxUserInfo(gradeAccount.getAppid(),gradeAccount.getAppSecrect(),code);
        JSONObject jsonObject = (JSONObject) JSON.parse(wxUserInfo);
        if(jsonObject != null){
            String openid = jsonObject.getString("openid");
            String nickname = EmojiUtil.filterEmoji(jsonObject.getString("nickname"));
            GradeWxPublicNum wxNum = new GradeWxPublicNum();
            wxNum.setOpenId(openid);
            wxNum.setUserId(gradeAccount.getUserId());
            wxNum.setWxUserName(nickname);
            GradeWxPublicNumExample gradeWxPublicNum = new GradeWxPublicNumExample();
            //根据公众号appid   及授权返回的openid   授权用户的userid  查询当前用户是否认证过
            gradeWxPublicNum.createCriteria().andAppidEqualTo(gradeAccount.getAppid()).andOpenIdEqualTo(openid).andUserIdEqualTo(gradeAccount.getUserId());
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
