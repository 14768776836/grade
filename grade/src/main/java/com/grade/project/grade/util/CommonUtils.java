package com.grade.project.grade.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据不同的结果以及错误信息返回数据
 */
public class CommonUtils {
    public static Map<String,Object> result2Map(int result, String msg){
        Map<String,Object> dataMap = new HashMap<>();
        if(result == 1){
            dataMap.put("success",true);
            dataMap.put("msg",StatusUtils.SUCCESS_MSG);
        }else {
            dataMap.put("success",false);
            dataMap.put("msg",msg);
        }
        return dataMap;
    }

    public static Map<String,Object> author2Map(int userId, String url){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("url",url);
        dataMap.put("userId",userId);
        dataMap.put("success",true);

        return dataMap;
    }
}
