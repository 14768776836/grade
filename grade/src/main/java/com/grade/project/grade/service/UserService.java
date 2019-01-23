package com.grade.project.grade.service;

import com.github.pagehelper.PageInfo;
import com.grade.project.grade.model.User;
import com.grade.project.grade.model.vo.PublicNumVo;

import java.util.List;

public interface UserService {
    /**
     * 登录接口
     * @param username
     * @param pswd
     * @return
     */
    User selectUsers(String username,String pswd);

    /**
     * 获取登陆用户所属总代理信息
     * @param userId
     * @return
     */
    User findUserByIdParentData(Integer userId);

    /**
     * 分页查询所有下级用户
     * @param userId  用户id
     * @param pageNum 页数
     * @return
     */
    PageInfo<User> findChildrenList(Integer userId,Integer pageNum);

    /**
     * 根据用户id查询当前用户是否存在未授权的公众号
     * @param userId
     * @return
     */
    List<PublicNumVo> findNotBindPublicNum(Integer userId);

    /**
     * 分页查询所有总代理列表数据
     * @param pageNum
     * @return
     */
    PageInfo<User> getAllGradeList(Integer pageNum,Integer status);

    /**
     * 取消用户总代理资格
     * @param userId
     * @return
     */
    int removeUserAllGrade(Integer userId,Integer status);

    /**
     * 查询总代理总人数
     * @return
     */
    int getAllGradeCount();
}
