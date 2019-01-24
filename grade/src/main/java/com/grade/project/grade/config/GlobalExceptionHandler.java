package com.grade.project.grade.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局未捕获的异常处理(就是不要写重复的try catch代码了)
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    Map<String, Object> dataMap = new HashMap<>();

    @ExceptionHandler()
    @ResponseBody
    Map<String, Object> handlerException(Exception e) {
        dataMap.put("success", false);
        dataMap.put("msg", "操作失败！");
        e.printStackTrace();
        logger.info("发生了异常 详细信息是：" + e.getMessage());
        return dataMap;
    }

}
