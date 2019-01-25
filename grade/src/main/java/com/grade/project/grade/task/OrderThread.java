package com.grade.project.grade.task;

import com.grade.project.grade.mapper.MchPayOrderMapper;
import com.grade.project.grade.mapper.vo.OrderVoMapper;
import com.grade.project.grade.model.MchPayOrder;
import com.grade.project.grade.model.User;
import com.grade.project.grade.model.vo.GradeOrderVo;
import com.grade.project.grade.util.StatusUtils;
import com.grade.project.grade.util.wx.PayCommonUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.grade.project.grade.util.ApplicationContextProvider.getBean;

public class OrderThread implements Runnable {

    Logger logger = LoggerFactory.getLogger(OrderThread.class);
    private User user;//获取利润金额的邀请码
    private GradeOrderVo gradeOrderVo;//获取总代设置的分润数据


    public OrderThread(User user, GradeOrderVo gradeOrderVo) {
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
        for (int i = 0; i < gradeOrderVo.getRunLevel(); i++) {
            if (userChildrenList == null || userChildrenList.size() <= 0) continue;
            userChildrenList = orderVoMapper.getChildrenList(userChildrenList);
            if (userChildrenList == null || userChildrenList.size() <= 0) continue;
            BigDecimal price = orderVoMapper.countChildrenPay(userChildrenList, gradeOrderVo.getStartTime(), gradeOrderVo.getEndTime());//获取充值总金额
            if (price == null) {
                continue;
            }
            JSONArray jsonArray = JSONArray.fromObject(gradeOrderVo.getRunPercent());
            BigDecimal runB = new BigDecimal(String.valueOf(((JSONObject) jsonArray.get(i)).get("value")));
            //当前级数的分润 = price(当前下级用户充值总额) x 分润级数对应的比例
            BigDecimal d = price.multiply(runB.divide(new BigDecimal("100")));
            countPirce = countPirce.add(d);
        }
        // 应当获取的利润小数点后取两位
        countPirce = countPirce.setScale(2, BigDecimal.ROUND_DOWN);
        if (countPirce.compareTo(new BigDecimal(0)) != 0) {
            mchPayOrderMapper.insertSelective(generateOrder(user, gradeOrderVo.getExtensionCode(), countPirce));
        }
    }

    /**
     * 通过上级以及该分支的总代理、打款金额生成订单
     *
     * @param user          生成订单的用户
     * @param extensionCode 总代理的推广码
     * @param res           分成数额
     * @return
     */
    public static MchPayOrder generateOrder(User user, String extensionCode, BigDecimal res) {
        MchPayOrder order = new MchPayOrder();
        order.setOrderNum(PayCommonUtil.getOrderIdByUUId());   //设置订单号
        // 账单未支付状态
        order.setPayStatus(StatusUtils.ORDER_STATUS_4);
        order.setUserId(user.getId());       //设置用户id
        order.setParentCode(user.getParentCode());  //设置直属上级推广码
        order.setGeneralAgentCode(extensionCode);    //设置本支线总代理的推广码
        order.setPayPrice(res);    //设置打款金额
        order.setWxUserName(user.getUsername()); //设置用户昵称
        order.setGmtCreate(new Date());    //设置创建订单时间
        order.setGmtModified(new Date());  //设置修改订单时间
        return order;
    }
}
