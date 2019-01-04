package com.grade.project.grade.service;

import com.grade.project.grade.mapper.UserMapper;
import com.grade.project.grade.mapper.vo.PublicNumVoMapper;
import com.grade.project.grade.model.User;
import com.grade.project.grade.model.UserExample;
import com.grade.project.grade.model.vo.PublicNumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PublicNumVoMapper publicNumVoMapper;

    @Override
    public User selectUsers(String username,String pswd) {
        UserExample userExample = new UserExample();
        pswd = DigestUtils.md5DigestAsHex(pswd.getBytes());//密码进行加密
        userExample.createCriteria().andUsernameEqualTo(username).andLoginPswdEqualTo(pswd);
        List<User> user = userMapper.selectByExample(userExample);
        if(user.size() > 0){
            return user.get(0);
        }
        return null;
    }

    @Override
    public User findUserByIdParentData(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);//查询当前用户信息，获取上级邀请码
        UserExample userExample = new UserExample();
        //根据当前用户的上级邀请码查询所属上级
        userExample.createCriteria().andExtensionCodeEqualTo(user.getParentCode());
        User userParent = userMapper.selectByExample(userExample).get(0);
        return userParent;
    }

    @Override
    public List<PublicNumVo> findNotBindPublicNum(Integer userId) {
        User userParent = findUserByIdParentData(userId);
        for(int i = 0;i < 10; i++){
            int status = userParent.getUserStatus();
            if(status == 1){
                break;
            }else{
                UserExample userExample = new UserExample();
                userExample.createCriteria().andExtensionCodeEqualTo(userParent.getParentCode());
                userParent = userMapper.selectByExample(userExample).get(0);
            }
        }
        //查询当前用户是否有未授权认证过的公众号列表
        List<PublicNumVo> noBindPublicNumList = publicNumVoMapper.getNoBindPublicNumList(userParent.getId(),userId);
        return noBindPublicNumList;
    }
}
