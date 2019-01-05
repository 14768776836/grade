package com.grade.project.grade.controller.wx;

import com.alibaba.fastjson.JSONObject;
import com.grade.project.grade.service.UserService;
import com.grade.project.grade.service.wx.PublicNumService;
import com.grade.project.grade.util.StatusUtils;
import com.grade.project.grade.util.wx.WxConfigUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 公众号
 */
@RestController
@RequestMapping(value = "/wxPublicNum")
public class PublicNumController {

    @Autowired
    private PublicNumService publicNumService;
    @Autowired
    private UserService userService;
    /**
     * wxPublicNum/getWxLoginOauth2URL
     * 普通用户认证微信公众号
     * @param appId
     * @return
     */
    @RequestMapping(value = "/getWxLoginOauth2URL")
    @ResponseBody
    public JSONObject getWxLoginOauth2URL(String appId,Integer userId){
        Map<Object, Object> dataMap = new HashMap<>();
        try {
            String url = WxConfigUtils.OAUTH2_URL.replace("APPID",appId).replace("REDIRECT_URL",WxConfigUtils.WX_USER_AUTH);
            dataMap.put("url",url);
            dataMap.put("userId",userId);
            dataMap.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", StatusUtils.ERROR_MSG);
        }
        return (JSONObject) JSONObject.toJSON(dataMap);
    }

    /**
     * wxPublicNum/getWxLoginOauth2URLBoss
     * 总代理校验公众号获取openId等信息
     * @param appId
     * @return
     */
    @RequestMapping(value = "/getWxLoginOauth2URLBoss")
    @ResponseBody
    public JSONObject getWxLoginOauth2URLBoss(String appId,Integer userId){
        Map<Object, Object> dataMap = new HashMap<>();
        try {
            String url = WxConfigUtils.OAUTH2_URL.replace("APPID",appId).replace("REDIRECT_URL",WxConfigUtils.WX_BOSS_USER_AUTH);
            dataMap.put("url",url);
            dataMap.put("userId",userId);
            dataMap.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", StatusUtils.ERROR_MSG);
        }
        return (JSONObject) JSONObject.toJSON(dataMap);
    }

    /**
     * wxPublicNum/getPublicNumList
     * 获取认证过的公众号列表数据
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getPublicNumList")
    @ResponseBody
    public JSONObject getPublicNumList(Integer userId){
        Map<Object, Object> dataMap = new HashMap<>();
        try {
            dataMap.put("publicNumList",publicNumService.getPublicNumList(userId));//认证过的用户列表
            dataMap.put("notPublicNum",userService.findNotBindPublicNum(userId));//未认证的公众号列表
            dataMap.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", StatusUtils.FIND_ERROR_MSG_EXCEPTION);
        }
        return (JSONObject) JSONObject.toJSON(dataMap);
    }
}
