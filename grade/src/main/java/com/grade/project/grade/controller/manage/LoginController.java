package com.grade.project.grade.controller.manage;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    /**
     * login/login
     * 登录
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "static/login";
    }

    /**
     * login/index
     * 登录
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "static/index";
    }

    /**
     * 校验用户名密码是否正确
     * login/goLoginCode
     * @param username
     * @param pswd
     * @return
     */
    @RequestMapping(value = "/goLoginCode")
    @ResponseBody
    public Map<String, Object> goLoginCode(String username, String pswd){
        Map<String, Object> dataMap = new HashMap<>();
        if(StringUtils.isBlank(username) || StringUtils.isBlank(pswd)){
            dataMap.put("msg","用户名或密码不能为空！");
            dataMap.put("success",false);
        }else{
            dataMap.put("success",true);
        }
        return dataMap;
    }
}
