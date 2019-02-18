package com.grade.project.grade.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping(value = "/")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    /**
     * 登录页面
     * @return
     */
    public String index(HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            return "indexH5.html";
        }else {
            logger.info("进入首页");
            return "index";
        }
    }

}
