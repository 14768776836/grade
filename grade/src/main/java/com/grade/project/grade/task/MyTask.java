package com.grade.project.grade.task;

import com.grade.project.grade.mapper.UserMapper;
import com.grade.project.grade.mapper.vo.OrderVoMapper;
import com.grade.project.grade.model.User;
import com.grade.project.grade.model.UserExample;
import com.grade.project.grade.model.vo.GradeOrderVo;
import com.grade.project.grade.service.MchPayOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.grade.project.grade.util.ApplicationContextProvider.getBean;

/**
 * 定时任务，在每个月的1号和15号的时候生成账单
 */
@Component
@Service
public class MyTask {
    Logger logger = LoggerFactory.getLogger(MyTask.class);

    @Scheduled(cron = "0 0 2 1,15 * ? ")
    public void task() {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        Future future = null;

        LocalDate date = LocalDate.now();
        int year = date.getYear();          //年
        int month = date.getMonthValue();   //月
        int day = date.getDayOfMonth();     //日
        // 获取当前时间的上一个开始计算的时间点
        LocalDate start;
        if (day == 1 && month == 1) {
            start = LocalDate.of(year - 1, 12, 15);
        } else if (day == 1) {
            start = LocalDate.of(year, month - 1, 15);
        } else {
            start = LocalDate.of(year, month, 1);
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String endTime = date.format(format);
        String startTime = start.format(format);

        // 自定义线程池
//        ExecutorService fixedThreadPool=new ThreadPoolExecutor()

        OrderVoMapper orderVoMapper = getBean(OrderVoMapper.class);
        //查询所有有效的商户数据 = 总代理
        List<GradeOrderVo> gradeMchList = orderVoMapper.getIsTrueMchUser();
        for (GradeOrderVo gradeOrderVo : gradeMchList) {
            gradeOrderVo.setStartTime(startTime);
            gradeOrderVo.setEndTime(endTime);
            //查询总代理所有下属子级用户
            List<User> uList = orderVoMapper.getAllChildrenList(gradeOrderVo.getExtensionCode());
            for (User anUList : uList) {
                OrderThread orderThread = new OrderThread(anUList, gradeOrderVo);
                future = fixedThreadPool.submit(orderThread);
            }
        }

        while (future != null && !future.isDone()) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
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
