package com.grade.project.grade.controller;

import com.grade.project.grade.config.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    /**
     * 登录页面
     * @return
     */
    public String index(){
        logger.info("进入首页");
        return "index";
    }
}
