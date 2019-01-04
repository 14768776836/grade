package com.grade.project.grade.controller;

import com.alibaba.fastjson.JSONObject;
import com.grade.project.grade.model.User;
import com.grade.project.grade.model.vo.PublicNumVo;
import com.grade.project.grade.service.UserService;
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
    private UserService userDAO;

    /**
     * user/userLogin
     * 登录接口
     * @param username  用户名
     * @param pswd      密码
     * @return
     */
    @RequestMapping(value = "/userLogin")
    @ResponseBody
    public Map<String,Object> getUsers(String username,String pswd) {
        Map<String,Object> dataMap = new HashMap<>();
        try{
            if(StringUtils.isBlank(username) || StringUtils.isBlank(pswd)){
                dataMap.put("msg","用户名或密码不能为空！");
                dataMap.put("success",false);
            }else{
                User user = userDAO.selectUsers(username,pswd);
                dataMap.put("user",user);
                if(!StringUtils.isBlank(user.getParentCode())){
                    dataMap.put("parentUser",userDAO.findUserByIdParentData(user.getId()));//当前用户所属上级信息
                    List<PublicNumVo> notPublicNumList = userDAO.findNotBindPublicNum(user.getId());//当前用户是否存在未认证的公众号
                    if(notPublicNumList == null){
                        dataMap.put("notBindPublicNum",false);
                    }else{
                        dataMap.put("notBindPublicNum",true);
                    }
                }else{
                    dataMap.put("parentUser","");
                }
                dataMap.put("success",true);
            }
        }catch(Exception e){
            e.printStackTrace();
            dataMap.put("msg","查询错误");
            dataMap.put("success",false);
        }
        return dataMap;
    }

    /**
     * user/findChildrenList
     * 查询当前用户所有下级玩家数据
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findChildrenList")
    @ResponseBody
    public JSONObject findChildrenList(Integer userId){
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            dataMap.put("childrenUserList",userDAO.findChildrenList(userId));
            dataMap.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", "删除失败");
        }
        return (JSONObject) JSONObject.toJSON(dataMap);
    }
}