package com.grade.project.grade.controller.wx;

import com.alibaba.fastjson.JSONObject;
import com.grade.project.grade.service.wx.PublicNumService;
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
    /**
     * wxPublicNum/getWxLoginOauth2URL
     * 普通用户认证微信公众号
     * @param appId
     * @return
     */
    @RequestMapping(value = "/getWxLoginOauth2URL")
    @ResponseBody
    public JSONObject getWxLoginOauth2URL(String appId,Integer userId){
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            String url = WxConfigUtils.OAUTH2_URL.replace("APPID",appId).replace("REDIRECT_URL",WxConfigUtils.WX_USER_AUTH);
            dataMap.put("url",url);
            dataMap.put("userId",userId);
            dataMap.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", "获取认证信息失败！");
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
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            dataMap.put("publicNumList",publicNumService.getPublicNumList(userId));
            dataMap.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", "获取公众号数据错误！");
        }
        return (JSONObject) JSONObject.toJSON(dataMap);
    }
}
