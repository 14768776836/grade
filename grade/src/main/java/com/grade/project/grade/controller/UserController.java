package com.grade.project.grade.controller;

import com.github.pagehelper.PageInfo;
import com.grade.project.grade.model.User;
import com.grade.project.grade.model.vo.PublicNumVo;
import com.grade.project.grade.service.UserService;
import com.grade.project.grade.util.StatusUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * user/userLogin
     * 登录接口
     *
     * @param username 用户名
     * @param pswd     密码
     * @return
     */
    @RequestMapping(value = "/userLogin")
    @ResponseBody
    public Map<String, Object> getUsers(String username, String pswd) {
        Map<String, Object> dataMap = new HashMap<>();
        try {
            if (StringUtils.isBlank(username) || StringUtils.isBlank(pswd)) {
                dataMap.put("msg", "用户名或密码不能为空！");
                dataMap.put("success", false);
            } else {
                User user = userService.selectUsers(username, pswd);
                dataMap.put("user", user);
                if (!StringUtils.isBlank(user.getParentCode())) {
                    dataMap.put("parentUser", userService.findUserByIdParentData(user.getId()));//当前用户所属上级信息
                    List<PublicNumVo> notPublicNumList = userService.findNotBindPublicNum(user.getId());//当前用户是否存在未认证的公众号
                    if (notPublicNumList == null || notPublicNumList.size() == 0) {
                        dataMap.put("notBindPublicNum", false);//当前登录用户手否存在未认证授权过的公众号
                    } else {
                        dataMap.put("notBindPublicNum", true);
                    }
                } else {
                    dataMap.put("parentUser", "");//没有上级，自己就是总代理
                }
                dataMap.put("success", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("msg", StatusUtils.FIND_ERROR_MSG_EXCEPTION);
            dataMap.put("success", false);
        }
        return dataMap;
    }

    /**
     * user/findChildrenList
     * 查询当前用户所有下级玩家数据
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findChildrenList")
    @ResponseBody
    public Map<String, Object> findChildrenList(Integer userId, Integer pageNum) {
        Map<String, Object> dataMap = new HashMap<>();
        try {
            // 查询该玩家的直属下级，不包括二三级
            PageInfo<User> childrenUserList = userService.findChildrenList(userId, pageNum);
            dataMap.put("childrenUserList", childrenUserList);
            dataMap.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success", false);
            dataMap.put("msg", StatusUtils.FIND_ERROR_MSG_EXCEPTION);
        }
        return dataMap;
    }
}