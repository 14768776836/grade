package com.grade.project.grade.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grade.project.grade.mapper.UserMapper;
import com.grade.project.grade.mapper.vo.PublicNumVoMapper;
import com.grade.project.grade.model.User;
import com.grade.project.grade.model.UserExample;
import com.grade.project.grade.model.UserWithBLOBs;
import com.grade.project.grade.model.vo.PublicNumVo;
import com.grade.project.grade.util.StatusUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PublicNumVoMapper publicNumVoMapper;

    @Override
    public User selectUsers(String username, String pswd) {
        UserExample userExample = new UserExample();
        pswd = DigestUtils.md5DigestAsHex(pswd.getBytes());//密码进行加密
        userExample.createCriteria().andUsernameEqualTo(username).andLoginPswdEqualTo(pswd);
        List<User> user = userMapper.selectByExample(userExample);
        if (user.size() > 0) {
            return user.get(0);
        }
        return null;
    }

    @Override
    public User findUserByIdParentData(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);//查询当前用户信息，获取上级邀请码
        UserExample userExample = new UserExample();
        User userParent = new User();
        if (!StringUtils.isBlank(user.getParentCode())) {
            //根据当前用户的上级邀请码查询所属上级
            userExample.createCriteria().andExtensionCodeEqualTo(user.getParentCode());
            userParent = userMapper.selectByExample(userExample).get(0);
        }
        return userParent;
    }

    @Override
    public PageInfo<User> findChildrenList(Integer userId, Integer pageNum) {
        UserWithBLOBs user = userMapper.selectByPrimaryKey(userId);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andParentCodeEqualTo(user.getExtensionCode()).andIsDelEqualTo(StatusUtils.IS_DEL_0);
        userExample.setOrderByClause(" GMT_CREATE DESC");//时间倒序排序
        PageHelper.startPage(pageNum, StatusUtils.PAGE_SIZE);
        List<User> userList = userMapper.selectByExample(userExample);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public List<PublicNumVo> findNotBindPublicNum(Integer userId) {
        User userParent = findUserByIdParentData(userId);//获取当前用户的直属上级用户
        if (userParent.getId() == null) return new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int status = userParent.getUserStatus();
            //上级用户状态总代理 && 上级用户的上级邀请码为null
            if (status == 1 && StringUtils.isBlank(userParent.getParentCode())) break;

            UserExample userExample = new UserExample();
            userExample.createCriteria().andExtensionCodeEqualTo(userParent.getParentCode());
            userParent = userMapper.selectByExample(userExample).get(0);

        }
        //查询当前用户是否有未授权认证过的公众号列表
        List<PublicNumVo> noBindPublicNumList = publicNumVoMapper.getNoBindPublicNumList(userParent.getId(), userId);
        return noBindPublicNumList;
    }

    @Override
    public PageInfo<User> getAllGradeList(Integer pageNum, Integer status, String startTime, String endTime, String name) {

        PageHelper.startPage(pageNum, StatusUtils.PAGE_SIZE);
        List<User> userList = userMapper.getAllGradeList(status, startTime, endTime, name);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public int operateUserGrade(Integer userId, Integer status, BigDecimal percent) {
        UserWithBLOBs user = new UserWithBLOBs();
        user.setUserStatus(status);//取消总代理资格
        user.setSinglePercent(percent);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(userId);
        return userMapper.updateByExampleSelective(user, userExample);
    }

    @Override
    public int getAllGradeCount() {
        UserExample user = new UserExample();
        user.createCriteria().andUserStatusEqualTo(StatusUtils.USER_STATUS_1).andIsDelEqualTo(StatusUtils.IS_DEL_0);
        return userMapper.countByExample(user);
    }

    @Override
    public int removeUserAllGrade(Integer userId, Integer status) {
        UserWithBLOBs user = new UserWithBLOBs();
        user.setUserStatus(status);//取消总代理资格
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(userId);
        return userMapper.updateByExampleSelective(user, userExample);
    }
}
