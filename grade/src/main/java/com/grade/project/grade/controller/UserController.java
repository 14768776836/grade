package com.grade.project.grade.controller;

import com.grade.project.grade.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userDAO;

    @RequestMapping(value = "/user")
    @ResponseBody
    public Map<String,Object> getUsers(String username) {
        Map<String,Object> dataMap = new HashMap<>();
        try{
            if(StringUtils.isBlank(username)){
                dataMap.put("msg","用户名不能为空！");
                dataMap.put("success","false");
            }else{
                dataMap.put("userList",userDAO.selectUsers(username));
                dataMap.put("success","true");
            }
        }catch(Exception e){
            e.printStackTrace();
            dataMap.put("msg","查询错误");
            dataMap.put("success","false");
        }
        return dataMap;
    }
}