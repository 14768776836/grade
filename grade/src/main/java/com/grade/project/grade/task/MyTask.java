package com.grade.project.grade.task;

import com.alibaba.fastjson.JSONArray;
import com.grade.project.grade.mapper.MchPayOrderMapper;
import com.grade.project.grade.mapper.ShopHistoryMapper;
import com.grade.project.grade.mapper.UserMapper;
import com.grade.project.grade.model.*;
import com.grade.project.grade.service.RunPercentService;
import com.grade.project.grade.util.StatusUtils;
import com.grade.project.grade.util.wx.PayCommonUtil;
import com.grade.project.grade.util.wx.WxConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static com.grade.project.grade.util.ApplicationContextProvider.getBean;

/**
 * 定时任务，在每个月的1号和15号的时候生成账单
 */
@Component
@Service
public class MyTask {
    Logger logger = LoggerFactory.getLogger(MyTask.class);

    @Scheduled(cron = "0 0 3 1,15 * ? ")
    public void task() {
        ShopHistoryMapper shopHistoryMapper = getBean(ShopHistoryMapper.class);
        UserMapper userMapper = getBean(UserMapper.class);
        RunPercentService runPercentService = getBean(RunPercentService.class);
        MchPayOrderMapper mchPayOrderMapper = getBean(MchPayOrderMapper.class);

        LocalDate date = LocalDate.now();
        int year = date.getYear();          //年
        int month = date.getMonthValue();   //月
        int day = date.getDayOfMonth();     //日
        // 获取当前时间的上一个开始计算的时间点
        LocalDate startTime;
        if (day == 1 && month == 1) {
            startTime = LocalDate.of(year - 1, 12, 15);
        } else if (day == 1) {
            startTime = LocalDate.of(year, month - 1, 15);
        } else {
            startTime = LocalDate.of(year, month, 1);
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String endTime = date.format(format);
        // 获取所有的总代理的集合
        UserExample example = new UserExample();
        example.createCriteria().andParentCodeEqualTo(null).andUserStatusEqualTo(0);
        List<User> list = userMapper.selectByExample(example);

        if (list != null && list.size() > 0) {
            for (User user : list) {
                // 获取该总代理的下级在该时间段内的所有的消费的总额
                BigDecimal sum = shopHistoryMapper.sumLevelShop(user.getExtensionCode(), startTime.toString(), endTime);
                // 总代理获取的分成
                BigDecimal result = getResultRun(sum, WxConfigUtils.GENERAL_AGENT_RUN);
                // 产生订单，存入数据库
                mchPayOrderMapper.insertSelective(generateOrder(user, user.getExtensionCode(), result));
                // 获取该总代理的分润表
                GradeRunPercent runPercent = runPercentService.findDataByUserId(user.getId());
                String run = runPercent.getRunPercent();
                if (run == null) return;

                JSONArray array = JSONArray.parseArray(run);
                List<Percent> percents = array.toJavaList(Percent.class);

                // 这里是总代理的直属下级集合
                List<User> users = getSubordinate(user);

//                for(User user1 : users){
//                    recursive(user1,user.getExtensionCode(),percents,startTime.toString(),endTime);
//                }
//                for (int i = arr.size(); i > 0; ) {
//                    i--;
//                    for (User u1 : users) {
//                        List<User> users1 = getSubordinate(u1);
//                        BigDecimal b1 = BigDecimal.valueOf(0);
//                        for (User u2 : users1) {
//                            b1.add(shopHistoryMapper.sumShopHistory(u2.getId(), startTime.toString(), endTime));
//
//                            // 二级代理
//                            List<User> users2 = getSubordinate(u2);
//                            BigDecimal b2 = BigDecimal.valueOf(0);
//                            for (User u3 : users2) {
//                                b2.add(shopHistoryMapper.sumShopHistory(u3.getId(), startTime.toString(), endTime));
//
//                            }
//                            // 一级代理的分成数据
//                            mchPayOrderMapper.insertSelective(generateOrder(u2, user, getResultRun(b2, v2)));
//                        }
//                        // 一级代理的分成数据
//                        mchPayOrderMapper.insertSelective(generateOrder(u1, user, getResultRun(b1, v1)));
//                    }
//                }
            }
        }
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

    /**
     * 通过下级消费的总金额以及分润比例获取实际应得的分成
     *
     * @param sum 消费总额
     * @param run 分成比例
     * @return
     */
    private BigDecimal getResultRun(BigDecimal sum, Integer run) {
        BigDecimal res = sum.multiply(new BigDecimal(run)).divide(new BigDecimal(100));
        return res.setScale(2, BigDecimal.ROUND_DOWN);
    }

    /**
     * 获取直接的下级列表
     *
     * @param user 用户
     * @return
     */
    public List<User> getSubordinate(User user) {
        UserMapper userMapper = getBean(UserMapper.class);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andParentCodeEqualTo(user.getExtensionCode());
        return userMapper.selectByExample(userExample);
    }

    /**
     * 递归获取各级玩家的收益并产生账单
     *
     * @param superior     产生账单的用户
     * @param generalAgent 总代理的推广码
     * @param percents     分成比例
     * @param startTime    开始时间
     * @param endTime      结束时间
     */
//    private void recursive(User superior, String generalAgent , List<Percent> percents,String startTime,String endTime) {
//        ShopHistoryMapper shopHistoryMapper = getBean(ShopHistoryMapper.class);
//        MchPayOrderMapper mchPayOrderMapper = getBean(MchPayOrderMapper.class);
//        for(int i = 0 ; i < percents.size() ; i ++){
//            Percent percent = percents.get(i);
//            List<User> users = getSubordinate(superior);
//            BigDecimal result = new BigDecimal(0);
//            for(User user : users){
//                result.add(shopHistoryMapper.sumShopHistory(user.getId(), startTime , endTime));
////                List<User> users1 = getSubordinate(user);
//
//
//                if(i+1 >= percents.size()) break;
//                recursive(user,generalAgent,percents,startTime,endTime);
//            }
//            logger.info("user :{} level :{} count :{}",superior.getId(),percent.getLevel(),result);
//            mchPayOrderMapper.insertSelective(generateOrder(superior, generalAgent, getResultRun(result, percent.getValue())));
//        }
//    }
    public void recursive(User superior, String generalAgent, List<Percent> percents, String startTime, String endTime) {
        ShopHistoryMapper shopHistoryMapper = getBean(ShopHistoryMapper.class);
        MchPayOrderMapper mchPayOrderMapper = getBean(MchPayOrderMapper.class);

        for(Percent percent : percents){
            List<User> users = getSubordinate(superior);
            BigDecimal result = new BigDecimal(0);
            for(User user : users){
                BigDecimal d = shopHistoryMapper.sumShopHistory(user.getId(),startTime,endTime);
                result = result.add(d == null ? new BigDecimal(0) : d);
                recursive(user, generalAgent, percents, startTime, endTime);
            }
            logger.info("user :{} level :{} count :{}", superior.getId(), percent.getLevel(), result);
            if (result.compareTo(new BigDecimal(0)) == 0) continue;
            mchPayOrderMapper.insertSelective(generateOrder(superior, generalAgent, getResultRun(result, percent.getValue())));
        }
//        for (int i = 0; i < percents.size(); ) {
//            Percent percent = percents.get(i);
//            i++; if (i > percents.size()) break;
//            List<User> users = getSubordinate(superior);
//            BigDecimal result = new BigDecimal(0);
//            for (User user : users) {
//                BigDecimal d = shopHistoryMapper.sumShopHistory(user.getId(), startTime, endTime);
//                result = result.add(d == null ? new BigDecimal(0) : d);
//                logger.info("result :{}", result);
//                recursive(user.getId(), generalAgent, percents, startTime, endTime);
//            }
//            logger.info("user :{} level :{} count :{}", superior.getId(), percent.getLevel(), result);
//            if (result.compareTo(new BigDecimal(0)) == 0) continue;
//            mchPayOrderMapper.insertSelective(generateOrder(superior, generalAgent, getResultRun(result, percent.getValue())));
//        }
    }
}
