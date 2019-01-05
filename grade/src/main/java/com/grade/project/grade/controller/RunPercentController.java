package com.grade.project.grade.controller;

import com.alibaba.fastjson.JSONObject;
import com.grade.project.grade.model.GradeRunPercent;
import com.grade.project.grade.service.RunPercentService;
import com.grade.project.grade.util.StatusUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 分润比例设置
 */
@RestController
@RequestMapping(value = "/runPercent")
public class RunPercentController {

    @Autowired
    private RunPercentService runPercentService;

    /**
     * runPercent/findDataByUserId
     * 根据总代理用户ID获取设置过的分润比例数据
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findDataByUserId")
    @ResponseBody
    public JSONObject findDataByUserId(Integer userId){
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            dataMap.put("gradeRunPercent", runPercentService.findDataByUserId(userId));
            dataMap.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", StatusUtils.FIND_ERROR_MSG_EXCEPTION);
        }
        return (JSONObject) JSONObject.toJSON(dataMap);
    }

    /**
     * runPercent/addRunPercent
     * 新增分润比例数据
     * @param gradeRunPercent
     * @return
     */
    @RequestMapping(value = "/addRunPercent")
    @ResponseBody
    public JSONObject addRunPercent(GradeRunPercent gradeRunPercent){
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            int result = runPercentService.addRunPercent(gradeRunPercent);
            if(result == 1){
                dataMap.put("msg", StatusUtils.SUCCESS_MSG);
                dataMap.put("success",true);
            }else{
                dataMap.put("success",false);
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
     *
     * 修改分润比例数据
     * @param gradeRunPercent
     * @return
     */
    @RequestMapping(value = "/updateRun")
    @ResponseBody
    public JSONObject updateRun(GradeRunPercent gradeRunPercent){
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            int result = runPercentService.updateRun(gradeRunPercent);
            if(result == 1){
                dataMap.put("msg", StatusUtils.SUCCESS_MSG);
                dataMap.put("success",true);
            }else{
                dataMap.put("success",false);
                dataMap.put("msg", StatusUtils.EDIT_ERROR_MSG_EXCEPTION);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("msg", StatusUtils.EDIT_ERROR_MSG_EXCEPTION);
        }
        return (JSONObject) JSONObject.toJSON(dataMap);
    }

    /**
     * runPercent/updIsDel
     * 删除分润数据
     * @param gradeRunPercent
     * @return
     */
    @RequestMapping(value = "/updIsDel")
    @ResponseBody
    public JSONObject updIsDel(GradeRunPercent gradeRunPercent){
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            int result = runPercentService.updIsDel(gradeRunPercent);
            if(result == 1){
                dataMap.put("msg", StatusUtils.SUCCESS_MSG);
                dataMap.put("success",true);
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


}
