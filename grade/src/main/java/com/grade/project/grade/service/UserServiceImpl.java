package com.grade.project.grade.service;

import com.grade.project.grade.mapper.UserMapper;
import com.grade.project.grade.model.User;
import com.grade.project.grade.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUsers(String username,String pswd) {
        UserExample userExample = new UserExample();
        pswd = DigestUtils.md5DigestAsHex(pswd.getBytes());//密码进行加密
        userExample.createCriteria().andUsernameEqualTo(username).andLoginPswdEqualTo(pswd);
        List<User> user = userMapper.selectByExample(userExample);
        return user;
    }
}
