package com.grade.project.grade.task;

import com.grade.project.grade.mapper.MchPayOrderMapper;
import com.grade.project.grade.mapper.ShopHistoryMapper;
import com.grade.project.grade.mapper.UserMapper;
import com.grade.project.grade.mapper.vo.OrderVoMapper;
import com.grade.project.grade.model.User;
import com.grade.project.grade.model.vo.GradeOrderVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.grade.project.grade.task.OrderThread.generateOrder;
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

//        ThreadPoolExecutor

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        Future future = null;

        Map<String,String> map = getTime();
        String startTime = map.get("start");
        String endTime = map.get("end");

        // 自定义线程池
//        ExecutorService fixedThreadPool=new ThreadPoolExecutor()

        OrderVoMapper orderVoMapper = getBean(OrderVoMapper.class);
        ShopHistoryMapper shopHistoryMapper = getBean(ShopHistoryMapper.class);
        UserMapper userMapper = getBean(UserMapper.class);
        MchPayOrderMapper mchPayOrderMapper = getBean(MchPayOrderMapper.class);
        //查询所有有效的商户数据 = 总代理
        List<GradeOrderVo> gradeMchList = orderVoMapper.getIsTrueMchUser();
        for (GradeOrderVo gradeOrderVo : gradeMchList) {
            gradeOrderVo.setStartTime(startTime);
            gradeOrderVo.setEndTime(endTime);

            // 获取总代理的用户数据，并查询该总代理支线下的在规定时间内的充值总额
            User user = userMapper.selectByPrimaryKey(gradeOrderVo.getUserId());
            BigDecimal agenyPrice = shopHistoryMapper.sumLevelShop(user.getExtensionCode(),startTime,endTime);

            // 取出该代理的个人分润比例，在数据库中生成一条未打款记录
            BigDecimal percent = user.getSinglePercent();
            if(agenyPrice.compareTo(new BigDecimal(0)) != 0 && percent.compareTo(new BigDecimal(0)) != 0){
                BigDecimal result = agenyPrice.multiply(percent).divide(new BigDecimal(100));
                mchPayOrderMapper.insertSelective(generateOrder(user, null, result));
            }

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

    private Map<String,String> getTime(){
        Map<String,String> map = new HashMap<>();
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
        map.put("start", start.format(format));
        map.put("end", date.format(format));
        return map;

    }
}
