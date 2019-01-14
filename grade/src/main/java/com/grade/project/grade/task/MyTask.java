package com.grade.project.grade.task;

import com.alibaba.fastjson.JSONArray;
import com.grade.project.grade.mapper.*;
import com.grade.project.grade.mapper.vo.OrderVoMapper;
import com.grade.project.grade.model.*;
import com.grade.project.grade.model.vo.GradeOrderVo;
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
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        OrderVoMapper orderVoMapper = getBean(OrderVoMapper.class);
        UserMapper userMapper = getBean(UserMapper.class);
        //查询所有有效的商户数据 = 总代理
        List<GradeOrderVo> gradeMchList = orderVoMapper.getIsTrueMchUser();
        for(GradeOrderVo gradeOrderVo : gradeMchList){
            //查询总代理所有下属子级用户
            List<User> uList = orderVoMapper.getAllChildrenList(gradeOrderVo.getExtensionCode());
            for(int i = 0; i <uList.size(); i++){
                OrderThread orderThread = new OrderThread(uList.get(i),gradeOrderVo);
                Thread thread = new Thread(orderThread,i+"order");
                thread.start();
            }
        }
        //测试  要删除的
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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




}
