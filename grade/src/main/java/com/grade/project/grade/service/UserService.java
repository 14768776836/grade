package com.grade.project.grade.service;

import com.grade.project.grade.model.User;

import java.util.List;

public interface UserService {
    List<User> selectUsers(String username,String pswd);

    /**
     * 获取登陆用户所属总代理信息
     * @param userId
     * @return
     */
    User findUserByIdData(Integer userId);
}
