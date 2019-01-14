package com.grade.project.grade;

import com.alibaba.fastjson.JSONArray;
import com.grade.project.grade.mapper.GradeRunPercentMapper;
import com.grade.project.grade.mapper.ShopHistoryMapper;
import com.grade.project.grade.model.Percent;
import com.grade.project.grade.model.User;
import com.grade.project.grade.task.MyTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeApplicationTests {

    @Autowired
    GradeRunPercentMapper gradeRunPercentMapper;

    @Autowired
    ShopHistoryMapper shopHistoryMapper;

    @Test
    public void contextLoads() {
//        GradeRunPercent gradeRunPercent = gradeRunPercentMapper.selectByPrimaryKey(11);
//        String runPercent = gradeRunPercent.getRunPercent();
//        System.out.println(runPercent);
//        JSONArray arr = JSONArray.parseArray(runPercent);
//        for(Object object : arr){
//            System.out.println(object);
//            JSONObject jsonObject = (JSONObject) object;
//            Integer level = jsonObject.getInteger("level");
//            Integer value = jsonObject.getIntValue("value");
//            System.out.println("level : " + level + ", value : " +value);
//
//        }
//        BigDecimal sun = shopHistoryMapper.sumLevelShop("ID15PSNDZM", "2018-12-29", "2019-01-01");
//        System.out.println(sun);

        MyTask myTask = new MyTask();
        String text = "[{\"level\":\"1\",\"value\":\"5\"},{\"level\":\"2\",\"value\":\"7\"}]";
        JSONArray array = JSONArray.parseArray(text);
        List<Percent> percents = array.toJavaList(Percent.class);

        User user = new User();
        user.setId(40);
        user.setExtensionCode("ID40JNPNGL");
        myTask.recursive(user,"ID10XWLKUQ",percents,"2018-12-01","2018-12-15");

    }

}

