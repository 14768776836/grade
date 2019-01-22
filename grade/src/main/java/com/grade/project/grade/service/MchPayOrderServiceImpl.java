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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
        User user = userMapper.selectByPrimaryKey(id);
        String appId = getAppId(id);
        if(appId == null) return new PageInfo<>();

        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();          //年
        int month = localDate.getMonthValue();   //月
        int day = localDate.getDayOfMonth();    //日
        if (day >= 15) day = 15;
        else day = 1;
        String time = LocalDate.of(year, month, day).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        PageHelper.startPage(pageNum, StatusUtils.PAGE_SIZE);
        // 获取最近的一期未打款的订单（总代理的直属下级）
        List<PublicPayOrderVo> list = publicPayOrderVoMapper.getChildrenOrders(user.getExtensionCode(), time, appId);
        PageInfo<PublicPayOrderVo> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public PageInfo<PublicPayOrderVo> getSpecificOrderList(Integer userId, Integer payStatus, Integer pageNum) {
        User user = userMapper.selectByPrimaryKey(userId);
        String appId = getAppId(userId);
        if(appId == null) return new PageInfo<>();
        PageHelper.startPage(pageNum, StatusUtils.PAGE_SIZE);
        // 获取所有的未打款的订单（总代理的直属下级）
        List<PublicPayOrderVo> list = publicPayOrderVoMapper.getSpecificOrderList(user.getExtensionCode(), payStatus, appId);
        PageInfo<PublicPayOrderVo> info = new PageInfo<>(list);
        return info;
    }

    private String getAppId(Integer userId){
        // 获取该总代理设置的有效的打款商户，公众号等
        GradeAccountExample example = new GradeAccountExample();
        example.createCriteria().andStatusEqualTo(StatusUtils.STATUS_1).andIsDelEqualTo(StatusUtils.IS_DEL_0).andUserIdEqualTo(userId);
        List<GradeAccount> accounts = gradeAccountMapper.selectByExample(example);
        if (accounts == null || accounts.size() == 0) return null;
        // 获取设置的唯一的appId
        return accounts.get(0).getAppId();
    }

    @Override
    public PageInfo<PublicPayOrderVo> getAllUnPayOrders(Integer userId, Integer pageNum) {

        // 获取设置的唯一的appId
        String appId = getAppId(userId);
        if(appId == null)return new PageInfo<>();
        PageHelper.startPage(pageNum, StatusUtils.PAGE_SIZE);
        // 获取该总代理分支下的所有未支付的订单
        List<PublicPayOrderVo> list = publicPayOrderVoMapper.getAllUnPayOrders(appId);
        PageInfo<PublicPayOrderVo> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public PageInfo<MchPayOrder> getCollectionRecord(Integer userId, Integer pageNum) {
        MchPayOrderExample example = new MchPayOrderExample();
        example.createCriteria().andPayStatusEqualTo(StatusUtils.ORDER_STATUS_0).andUserIdEqualTo(userId).andIsDelEqualTo(0);
        PageHelper.startPage(pageNum, StatusUtils.PAGE_SIZE);
        List<MchPayOrder> list = mchPayOrderMapper.selectByExample(example);
        PageInfo<MchPayOrder> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public void pay(HttpServletRequest request, Integer userId, List<Integer> orders) {
        // 获取该总代理设置的有效的打款商户，公众号等
        GradeAccountExample example = new GradeAccountExample();
        example.createCriteria().andStatusEqualTo(StatusUtils.STATUS_1).andIsDelEqualTo(StatusUtils.IS_DEL_0).andUserIdEqualTo(userId);
        List<GradeAccount> accounts = gradeAccountMapper.selectByExample(example);
        if (accounts == null || accounts.size() == 0) return;
        GradeAccount gradeAccount = accounts.get(0);
        String desc = "支付成功！";

        for (Integer orderId : orders) {
            MchPayOrder order = mchPayOrderMapper.selectByPrimaryKey(orderId);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = order.getGmtCreate();
            String time = format.format(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            String endTime = format.format(cal.getTime());
            User user = userMapper.selectByPrimaryKey(order.getUserId());

            // 获取当前总代理下的一级代理的vo对象（包含认证信息）
            PublicPayOrderVo publicPayOrderVo = publicPayOrderVoMapper.selectOneByOrderId(orderId, gradeAccount.getAppId());
            // 如果一级代理都没有认证那就不存在打款不打款的了，这里就可以执行下一个一级订单了
            if(publicPayOrderVo == null)continue;
            // 给当前总代理下的一级代理打款
            mchService.payMchToOrder(request, gradeAccount, desc, publicPayOrderVo);
//            mchService.payMchToUser(request, gradeAccount,publicPayOrderVo.getPayPrice(), desc, order.getUserId());
            // 首先调用存储过程,生成一张数据表
            publicPayOrderVoMapper.getChildPeng(user.getExtensionCode());
            // 获取当前一级代理下的所有的认证过的用户产生的订单的数据
            List<PublicPayOrderVo> list = publicPayOrderVoMapper.selectUnderCertification(time, endTime,gradeAccount.getAppId());
            // 分别打款
            for (PublicPayOrderVo vo : list) {
                mchService.payMchToOrder(request, gradeAccount, desc, vo);
            }
        }
    }

    public void payTest( Integer userId, List<Integer> orders) {
        // 获取该总代理设置的有效的打款商户，公众号等
        GradeAccountExample example = new GradeAccountExample();
        example.createCriteria().andStatusEqualTo(StatusUtils.STATUS_1).andIsDelEqualTo(StatusUtils.IS_DEL_0).andUserIdEqualTo(userId);
        List<GradeAccount> accounts = gradeAccountMapper.selectByExample(example);
        if (accounts == null || accounts.size() == 0) return;
        GradeAccount gradeAccount = accounts.get(0);
        String desc = "支付成功！";

        for (Integer orderId : orders) {
            MchPayOrder order = mchPayOrderMapper.selectByPrimaryKey(orderId);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = order.getGmtCreate();
            String time = format.format(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            String endTime = format.format(cal.getTime());
            User user = userMapper.selectByPrimaryKey(order.getUserId());

            // 获取当前总代理下的一级代理的vo对象（包含认证信息）
            PublicPayOrderVo publicPayOrderVo = publicPayOrderVoMapper.selectOneByOrderId(orderId, gradeAccount.getAppId());

            // 给当前总代理下的一级代理打款
//            mchService.payMchToOrder(request, gradeAccount, desc, publicPayOrderVo);
            // 获取当前一级代理下的所有的认证过的用户产生的订单的数据
            publicPayOrderVoMapper.getChildPeng(user.getExtensionCode());
            List<PublicPayOrderVo> list = publicPayOrderVoMapper.selectUnderCertification(time,endTime, gradeAccount.getAppId());
            // 分别打款
            for (PublicPayOrderVo vo : list) {
//                mchService.payMchToOrder(request, gradeAccount, desc, vo);
            }
        }
    }

}
