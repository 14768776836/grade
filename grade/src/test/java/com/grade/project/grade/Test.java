package com.grade.project.grade;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.grade.project.grade.model.Percent;
import jdk.nashorn.internal.runtime.arrays.IntElements;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int a = 11,b = 9;

//        a = a^b;
        System.out.println(b^a);


//        Date date = new Date();
//        System.out.println(date);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.DAY_OF_MONTH,1);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(simpleDateFormat.format(calendar));


//        BigDecimal result = new BigDecimal(0);
//        System.out.println(result.compareTo(new BigDecimal(0)) == 0);
//
//        String text = "[{\"level\":\"1\",\"value\":\"5\"},{\"level\":\"2\",\"value\":\"7\"}]";
//        JSONArray array = JSONArray.parseArray(text);
//        List<Percent> percents = array.toJavaList(Percent.class);
//        percents.forEach(System.out::println);
//        System.out.println(array);
//
//        BigDecimal num = BigDecimal.valueOf(10000.02);

//        BigDecimal result = num.multiply(new BigDecimal(3)).divide(new BigDecimal(100));
////        String res = String.format("%.2f", result);
//        BigDecimal res = result.setScale(5,BigDecimal.ROUND_DOWN);
//        System.out.println(res);


//        LocalDate date = LocalDate.now();
//        System.out.println(date);
//        String dateString = date.toString();
//        if (dateString.endsWith("07")) {
//            System.out.println("4545454");
//            int year = date.getYear();
//            int month = date.getMonthValue();
//            int day = date.getDayOfMonth();
//            System.out.println("年 ：" + year + ",月 : " + month + "日 ： " + day);
//            if (month == 1) {
//                year -= 1;
//                month = 12;
//            }
//            LocalDate befor = LocalDate.of(year, month, day);
//            System.out.println(befor);
//            ZoneId zone = ZoneId.systemDefault();
//            Date oldData = Date.from(befor.atStartOfDay().atZone(zone).toInstant());
//            Date after = Date.from(date.atStartOfDay().atZone(zone).toInstant());
//
//            System.out.println(oldData);
//            System.out.println(after);
//
//        } else if (dateString.endsWith("01")) {
//            int year = date.getYear();
//            int month = date.getMonthValue();
//        }
    }
}
