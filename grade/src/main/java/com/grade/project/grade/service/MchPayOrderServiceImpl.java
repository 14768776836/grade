package com.grade.project.grade.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grade.project.grade.mapper.GradeAccountMapper;
import com.grade.project.grade.mapper.MchPayOrderMapper;
import com.grade.project.grade.mapper.UserMapper;
import com.grade.project.grade.mapper.vo.OrderVoMapper;
import com.grade.project.grade.mapper.vo.PublicPayOrderVoMapper;
import com.grade.project.grade.model.*;
import com.grade.project.grade.model.vo.PublicPayOrderVo;
import com.grade.project.grade.service.wx.MchService;
import com.grade.project.grade.util.StatusUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MchPayOrderServiceImpl implements MchPayOrderService {

    @Autowired
    PublicPayOrderVoMapper publicPayOrderVoMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    GradeAccountMapper gradeAccountMapper;
    @Autowired
    MchPayOrderMapper mchPayOrderMapper;
    @Autowired
    MchService mchService;
    @Autowired
    OrderVoMapper orderVoMapper;

    @Override
    public PageInfo<PublicPayOrderVo> getOrderList(Integer id, Integer pageNum) {

        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();          //年
        int month = localDate.getMonthValue();   //月
        int day = localDate.getDayOfMonth();    //日
        if (day >= 15) day = 15;
        else day = 1;
        String time = LocalDate.of(year, month, day).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        User user = userMapper.selectByPrimaryKey(id);
        // 获取该总代理设置的有效的打款商户，公众号等
        GradeAccountExample example = new GradeAccountExample();
        example.createCriteria().andStatusEqualTo(StatusUtils.STATUS_1).andIsDelEqualTo(StatusUtils.IS_DEL_0).andUserIdEqualTo(id);
        List<GradeAccount> accounts = gradeAccountMapper.selectByExample(example);
        if (accounts == null || accounts.size() == 0) return new PageInfo<>();
        // 获取设置的唯一的appId
        String appId = accounts.get(0).getAppid();
        // 获取最近的一期未打款的订单（总代理的直属下级）
        List<PublicPayOrderVo> list = publicPayOrderVoMapper.getChildrenOrders(user.getExtensionCode(), time, appId);
        PageHelper.startPage(pageNum, StatusUtils.PAGE_SIZE);
        PageInfo<PublicPayOrderVo> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public PageInfo<PublicPayOrderVo> getSpecificOrderList(Integer userId, Integer payStatus, Integer pageNum) {

        User user = userMapper.selectByPrimaryKey(userId);
        // 获取该总代理设置的有效的打款商户，公众号等
        GradeAccountExample example = new GradeAccountExample();
        example.createCriteria().andStatusEqualTo(StatusUtils.STATUS_1).andIsDelEqualTo(StatusUtils.IS_DEL_0).andUserIdEqualTo(userId);
        List<GradeAccount> accounts = gradeAccountMapper.selectByExample(example);
        if (accounts == null || accounts.size() == 0) return new PageInfo<>();
        // 获取设置的唯一的appId
        String appId = accounts.get(0).getAppid();
        // 获取最近的一期未打款的订单（总代理的直属下级）
        List<PublicPayOrderVo> list = publicPayOrderVoMapper.getSpecificOrderList(user.getExtensionCode(), payStatus, appId);
        PageHelper.startPage(pageNum, StatusUtils.PAGE_SIZE);
        PageInfo<PublicPayOrderVo> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public void pay(HttpServletRequest request, Integer userId, List<Integer> orders) {
//        User supernior = userMapper.selectByPrimaryKey(userId);
        // 获取该总代理设置的有效的打款商户，公众号等
        GradeAccountExample example = new GradeAccountExample();
        example.createCriteria().andStatusEqualTo(StatusUtils.STATUS_1).andIsDelEqualTo(StatusUtils.IS_DEL_0).andUserIdEqualTo(userId);
        List<GradeAccount> accounts = gradeAccountMapper.selectByExample(example);
        if (accounts == null || accounts.size() == 0) return;
        GradeAccount gradeAccount = accounts.get(0);
        String desc = "支付成功！";

        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();          //年
        int month = localDate.getMonthValue();   //月
        int day = localDate.getDayOfMonth();    //日
        if (day >= 15) day = 15;
        else day = 1;
        String time = LocalDate.of(year, month, day).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        for (Integer orderId : orders) {
            MchPayOrder order = mchPayOrderMapper.selectByPrimaryKey(orderId);
            User user = userMapper.selectByPrimaryKey(order.getUserId());

            // 给当前总代理下的一级代理打款
            mchService.payMchToUser(request, gradeAccount, order.getPayPrice(), desc, order.getUserId());
            // 获取当前一级代理下的所有的认证过的用户产生的订单的数据
            List<PublicPayOrderVo> list = publicPayOrderVoMapper.selectUnderCertification(user.getExtensionCode(),
                    time,gradeAccount.getAppid());
            // 分别打款
            for(PublicPayOrderVo vo : list){
                mchService.payMchToUser(request, gradeAccount, vo.getPayPrice(), desc, vo.getUserId());
            }
        }
    }

}
