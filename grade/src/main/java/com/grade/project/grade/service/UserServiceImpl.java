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

    @Override
    public User findUserByIdData(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);//查询当前用户信息，获取上级邀请码
        UserExample userExample = new UserExample();
        //根据当前用户的上级邀请码查询所属上级
        userExample.createCriteria().andExtensionCodeEqualTo(user.getParentCode());
        User userParent = userMapper.selectByExample(userExample).get(0);
        //循环查询次数取到总代理的用户信息
        for(int i = 0;i < 10; i++){
            if(userParent.getUserStatus() != 1){
                userExample = new UserExample();
                userExample.createCriteria().andExtensionCodeEqualTo(userParent.getParentCode());
                userParent = userMapper.selectByExample(userExample).get(0);
            }else{
                break;
            }
        }
        //当前用户所属总代理信息
//        userParent
        return null;
    }
}
