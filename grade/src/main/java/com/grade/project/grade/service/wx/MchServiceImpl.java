package com.grade.project.grade.service.wx;

import com.grade.project.grade.mapper.GradeAccountMapper;
import com.grade.project.grade.mapper.GradeWxPublicNumMapper;
import com.grade.project.grade.mapper.MchPayOrderMapper;
import com.grade.project.grade.mapper.UserMapper;
import com.grade.project.grade.model.*;
import com.grade.project.grade.util.StatusUtils;
import com.grade.project.grade.util.wx.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MchServiceImpl implements MchService {

    private static final Logger logger = LoggerFactory.getLogger(MchServiceImpl.class);

    @Autowired
    private GradeAccountMapper gradeAccountMapper;
    @Autowired
    private GradeWxPublicNumMapper gradeWxPublicNumMapper;
    @Autowired
    private MchPayOrderMapper mchPayOrderMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<GradeAccount> getMchList(Integer userId) {
        GradeAccountExample gradeAccountExample = new GradeAccountExample();
        gradeAccountExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo(StatusUtils.IS_DEL_0);
        gradeAccountExample.setOrderByClause(" GMT_CREATE DESC");//时间倒序排序
        return gradeAccountMapper.selectByExample(gradeAccountExample);
    }

    @Override
    public int saveMchMessage(GradeAccount gradeAccount) {
        gradeAccount.setGmtModified(new Date());
        gradeAccount.setGmtCreate(new Date());
        return gradeAccountMapper.insertSelective(gradeAccount);
    }

    @Override
    public int delMch(Integer id) {
        GradeAccount gradeAccount = new GradeAccount();
        gradeAccount.setId(id);
        gradeAccount.setIsDel(StatusUtils.IS_DEL_1);
        return gradeAccountMapper.updateByPrimaryKeySelective(gradeAccount);
    }

    @Override
    public Map<String, Object> payMchToUser(HttpServletRequest request, GradeAccount gradeAccount, BigDecimal amount,String desc) {
        int userId = gradeAccount.getUserId();
        Map<String, Object> dataMap = new HashMap<>();
        boolean orderStatus = false;
        String msg = "转账成功";
        String orderNum = PayCommonUtil.getOrderIdByUUId();//订单编号
        String wxUserName = "";
        try {
            User u =userMapper.selectByPrimaryKey(userId);//获取当前用户详细信息
            MchPayOrder mchPayOrder = new MchPayOrder();
            //获取此用户认证的公众号信息
            GradeWxPublicNumExample gradeWxPublicNumExample = new GradeWxPublicNumExample();
            //根据用户id  appid查询认证信息
            gradeWxPublicNumExample.createCriteria().andUserIdEqualTo(userId).andAppidEqualTo(gradeAccount.getAppid());
            //获取用户认证公众号详细数据
            List<GradeWxPublicNum> user = gradeWxPublicNumMapper.selectByExample(gradeWxPublicNumExample);
            if(user.size() > 0){
                GradeWxPublicNum gradeWxPublicNum = user.get(0);//收款人公众号相关信息
                wxUserName = gradeWxPublicNum.getWxUserName();
                if(!StringUtils.isBlank(gradeWxPublicNum.getOpenId())){
                    Map<String, String> parm = new HashMap<>();
                    int price = amount.multiply(new BigDecimal(100)).intValue();//金额转化以分为单位
                    Map<String, String> restmap = null;
                    // 订单生成的机器 IP
                    String spbill_create_ip = PayCommonUtil.getIpAddress(request);
                    spbill_create_ip = (spbill_create_ip.split(","))[0];
                    parm.put("mch_appid", gradeAccount.getAppid()); //公众账号appid
                    parm.put("mchid", gradeAccount.getMchId()); //商户号
                    parm.put("nonce_str", PayCommonUtil.CreateNoncestr()); //随机字符串
                    parm.put("partner_trade_no", orderNum); //商户订单号
                    parm.put("openid", gradeWxPublicNum.getOpenId()); //用户openid
                    parm.put("check_name", "NO_CHECK"); //校验用户姓名选项 OPTION_CHECK
                    parm.put("amount", String.valueOf(price)); //转账金额
                    parm.put("desc", desc); //企业付款描述信息
                    parm.put("spbill_create_ip", spbill_create_ip); //Ip地址
                    parm.put("sign", PayCommonUtil.getSign(parm,gradeAccount.getApiKey() ));

                    String restxml = HttpUtils.posts(WxConfigUtils.TRANSFERS_PAY, XmlUtil.xmlFormat(parm, false),gradeAccount.getFilePath());
                    logger.info("转账返回报文：" + restxml);
                    restmap = XmlUtil.xmlParse(restxml);//xml格式数据转换为map
                    if (CollectionUtil.isNotEmpty(restmap) && "SUCCESS".equals(restmap.get("result_code"))) {
                        //保存转账成功相关账单数据
                        orderStatus = true;
                        mchPayOrder.setPayStatus(StatusUtils.ORDER_STATUS_0);
                    }else{
                        if (CollectionUtil.isNotEmpty(restmap)) {
                            logger.info("转账失败：" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
                            msg = restmap.get("err_code_des");
                            mchPayOrder.setPayStatus(StatusUtils.ORDER_STATUS_3);
//                            gradeAccountMapper.insertSelective(gradeAccount);//保存商户信息
                        }
                    }
                    saveMchMessage(gradeAccount);
                }else{
                    logger.info("用户id="+userId+",openId丢失！");
                    msg ="转账失败";
                    mchPayOrder.setPayStatus(StatusUtils.ORDER_STATUS_2);
                }
            }else{
                logger.info("用户id="+userId+",当前用户未授权“"+gradeAccount.getGzName()+"”公众号信息 appid="+gradeAccount.getAppid());
                msg = "当前用户未授权“"+gradeAccount.getGzName()+"”公众号信息";
                mchPayOrder.setPayStatus(StatusUtils.ORDER_STATUS_1);
            }

            dataMap.put("success",orderStatus);
            dataMap.put("msg", msg);

            //保存转账相关信息
            mchPayOrder.setUserId(userId);//收款人用户id
            mchPayOrder.setWxUserName(wxUserName);//收款人对应微信用户昵称
            mchPayOrder.setParentCode(u.getParentCode());//收款用户所属上级邀请人
            mchPayOrder.setPayPrice(amount);//收款金额
            mchPayOrder.setOrderNum(orderNum);//订单编号
            mchPayOrder.setPayMsg(msg);//收款信息
            mchPayOrderMapper.insertSelective(mchPayOrder);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", "校验失败");
        }
        return dataMap;
    }

}
