package com.grade.project.grade.controller.manage;

import com.grade.project.grade.mapper.UserMapper;
import com.grade.project.grade.model.User;
import com.grade.project.grade.model.UserExample;
import com.grade.project.grade.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    /**
     * login/login
     * 登录
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    /**
     * login/index
     * 登录
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "/static/index";
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
    public Map<String, Object> goLoginCode(HttpServletRequest request,String username, String pswd){
        Map<String, Object> dataMap = new HashMap<>();
        if(StringUtils.isBlank(username) || StringUtils.isBlank(pswd)){
            dataMap.put("msg","用户名或密码不能为空！");
            dataMap.put("success",false);
        }else{

            if(!"admin".equals(username) || !"123456".equals(pswd)){
                dataMap.put("msg","用户名或密码不正确！");
                dataMap.put("success",false);
            }else {
                request.getSession().setAttribute("user",username);
                dataMap.put("success",true);
            }
        }
        return dataMap;
    }
}
