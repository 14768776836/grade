package com.grade.project.grade.service;

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
     * 根据用户id查询当前用户是否存在未授权的公众号
     * @param userId
     * @return
     */
    List<PublicNumVo> findNotBindPublicNum(Integer userId);
}
