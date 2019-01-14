package com.grade.project.grade.task;

import com.alibaba.fastjson.JSONObject;
import com.grade.project.grade.mapper.MchPayOrderMapper;
import com.grade.project.grade.mapper.vo.OrderVoMapper;
import com.grade.project.grade.model.MchPayOrder;
import com.grade.project.grade.model.User;
import com.grade.project.grade.model.vo.GradeOrderVo;
import com.grade.project.grade.util.StatusUtils;
import com.grade.project.grade.util.wx.PayCommonUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.grade.project.grade.util.ApplicationContextProvider.getBean;

public class OrderThread implements Runnable {

    private User user;//获取利润金额的邀请码
    private GradeOrderVo gradeOrderVo;//获取总代设置的分润数据


    public OrderThread(User user, GradeOrderVo gradeOrderVo){
        this.user = user;
        this.gradeOrderVo = gradeOrderVo;
    }

    @Override
    public void run() {
        OrderVoMapper orderVoMapper = getBean(OrderVoMapper.class);
        MchPayOrderMapper mchPayOrderMapper = getBean(MchPayOrderMapper.class);

        List<User> userChildrenList = new ArrayList<>();
        userChildrenList.add(user);
        BigDecimal countPirce = new BigDecimal("0.00");
        for(int i = 1; i <= gradeOrderVo.getRunLevel();i++){
            userChildrenList = orderVoMapper.getChildrenList(userChildrenList);
            BigDecimal price = orderVoMapper.countChildrenPay(userChildrenList,gradeOrderVo.getStartTime(),gradeOrderVo.getEndTime());//获取充值总金额
            JSONObject jsonObject = JSONObject.parseObject(gradeOrderVo.getRunPercent());
            BigDecimal runB = new BigDecimal(jsonObject.getString(String.valueOf(i)));
            //当前级数的分润 = price(当前下级用户充值总额) x 分润级数对应的比例
            countPirce.add(price.multiply((runB.multiply(new BigDecimal("100")))));
        }
        mchPayOrderMapper.insertSelective(generateOrder(user,gradeOrderVo.getExtensionCode(),countPirce));
    }

    /**
     * 通过上级以及该分支的总代理、打款金额生成订单
     *
     * @param u1            生成订单的用户
     * @param extensionCode 总代理的推广码
     * @param res           分成数额
     * @return
     */

    private MchPayOrder generateOrder(User u1, String extensionCode, BigDecimal res) {
        MchPayOrder order1 = new MchPayOrder();
        order1.setOrderNum(PayCommonUtil.getOrderIdByUUId());   //设置订单号
        // 账单未支付状态
        order1.setPayStatus(StatusUtils.ORDER_STATUS_4);
        order1.setUserId(u1.getId());       //设置用户id
        order1.setParentCode(u1.getParentCode());  //设置直属上级推广码
        order1.setGeneralAgentCode(extensionCode);    //设置本支线总代理的推广码
        order1.setPayPrice(res);    //设置打款金额
        order1.setWxUserName(u1.getUsername()); //设置用户昵称
        order1.setGmtCreate(new Date());    //设置创建订单时间
        order1.setGmtModified(new Date());  //设置修改订单时间
        return order1;
    }
}
