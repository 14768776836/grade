package com.grade.project.grade.controller.wx;

import com.alibaba.fastjson.JSONObject;
import com.grade.project.grade.model.GradeAccount;
import com.grade.project.grade.service.wx.MchService;
import com.grade.project.grade.util.StatusUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/wxMch")
public class MchController {

    @Autowired
    private MchService mchService;

    /**
     * wxMch/getMchList
     * 查询设置过的商户列表
     * @param userId  总代理用户id
     * @return
     */
    @RequestMapping(value = "/getMchList")
    @ResponseBody
    public JSONObject getMchList(Integer userId){
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            if(userId != null && userId > 0){
                dataMap.put("mchList",mchService.getMchList(userId));
                dataMap.put("success",true);
            }else{
                dataMap.put("success",false);
                dataMap.put("msg", StatusUtils.DATA_ERROR_MSG_EXCEPTION);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", StatusUtils.FIND_ERROR_MSG_EXCEPTION);
        }
        return (JSONObject) JSONObject.toJSON(dataMap);
    }

    /**
     * wxMch/addMch
     * 添加商户/公众号等信息
     * @param gradeAccount  商户相关信息
     * @return
     */
    @RequestMapping(value = "/addMch")
    @ResponseBody
    public JSONObject addMch(GradeAccount gradeAccount){
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            int result = mchService.saveMchMessage(gradeAccount);
            if(result == 1){
                dataMap.put("success",true);
                dataMap.put("msg", StatusUtils.SUCCESS_MSG);
            }else{
                dataMap.put("success",true);
                dataMap.put("msg", StatusUtils.SETTING_ERROR_MSG_EXCEPTION);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", StatusUtils.SETTING_ERROR_MSG_EXCEPTION);
        }
        return (JSONObject) JSONObject.toJSON(dataMap);
    }

    /**
     * wxMch/delMch
     * 删除商户/公众号等信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delMch")
    @ResponseBody
    public JSONObject delMch(Integer id){
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            int result = mchService.delMch(id);
            if(result == 1){
                dataMap.put("success",true);
                dataMap.put("msg", StatusUtils.SUCCESS_MSG);
            }else{
                dataMap.put("success",false);
                dataMap.put("msg", StatusUtils.DEL_ERROR_MSG_EXCEPTION);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", StatusUtils.DEL_ERROR_MSG_EXCEPTION);
        }
        return (JSONObject) JSONObject.toJSON(dataMap);
    }

    /**
     * wxMch/codeMchNum
     * 总代理校验商户是否设置成功
     * @param request
     * @param gradeAccount   转账商户信息及公众号信息
     * @param userId         收款人用户id
     * @return
     */
    @RequestMapping(value = "/codeMchNum")
    @ResponseBody
    public JSONObject codeMchNum(HttpServletRequest request,GradeAccount gradeAccount,Integer userId){
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            BigDecimal amount = new BigDecimal("1.00");
            String desc = "商户可使用";
            dataMap = mchService.payMchToUser(request,gradeAccount,userId,amount,desc);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", StatusUtils.ERROR_MSG);
        }
        return (JSONObject) JSONObject.toJSON(dataMap);
    }

}
