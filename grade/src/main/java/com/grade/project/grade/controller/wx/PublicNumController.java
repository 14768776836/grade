package com.grade.project.grade.controller.wx;

import com.grade.project.grade.model.GradeAccount;
import com.grade.project.grade.service.UserService;
import com.grade.project.grade.service.wx.PublicNumService;
import com.grade.project.grade.util.wx.WxConfigUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static com.grade.project.grade.util.CommonUtils.author2Map;

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
     *
     * @return
     */
    @RequestMapping(value = "/getWxLoginOauth2URL")
    @ResponseBody
    public Map getWxLoginOauth2URL(Integer userId) {

        String url = WxConfigUtils.OAUTH2_URL.replace("APPID", WxConfigUtils.WX_APPID).replace("REDIRECT_URL", WxConfigUtils.WX_USER_AUTH);
        return author2Map(userId, url);
    }

    /**
     * wxPublicNum/getWxLoginOauth2URLBoss
     * 总代理校验公众号获取openId等信息
     *
     * @return
     */
    @RequestMapping(value = "/getWxLoginOauth2URLBoss")
    @ResponseBody
    public Map<String, Object> getWxLoginOauth2URLBoss(Integer userId) throws UnsupportedEncodingException {
        String url = WxConfigUtils.OAUTH2_URL.replace("APPID", WxConfigUtils.WX_APPID).replace("REDIRECT_URL", URLEncoder.encode(WxConfigUtils.WX_BOSS_USER_AUTH, "utf-8"));
        return author2Map(userId, url);
    }

    /**
     * wxPublicNum/savePublicNumUser
     * 授权成功后，微信会将code返回到回调的地址
     *
     * @param code         微信返回的code
     * @param gradeAccount 商户信息
     * @return
     */
    @RequestMapping(value = "/savePublicNumUser")
    @ResponseBody
    public Map<String, Object> savePublicNumUser(String code, GradeAccount gradeAccount) {
        Map<String, Object> dataMap = new HashMap<>();
        String result = publicNumService.saveWxUserIfo(code, gradeAccount);//保存微信授权相关信息
        if (!"SUCCESS".equals(result)) {
            dataMap.put("success", false);
            dataMap.put("msg", result);
        } else {
            dataMap.put("success", true);
        }
        return dataMap;
    }

    /**
     * wxPublicNum/getPublicNumList
     * 获取认证过的公众号列表数据
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getPublicNumList")
    @ResponseBody
    public Map<String, Object> getPublicNumList(Integer userId) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("publicNumList", publicNumService.getPublicNumList(userId));//认证过的用户列表
        dataMap.put("notPublicNum", userService.findNotBindPublicNum(userId));//未认证的公众号列表
        dataMap.put("success", true);
        return dataMap;
    }
}
