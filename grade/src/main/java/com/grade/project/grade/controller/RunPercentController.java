package com.grade.project.grade.controller;

import com.grade.project.grade.model.GradeRunPercent;
import com.grade.project.grade.service.RunPercentService;
import com.grade.project.grade.util.StatusUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.grade.project.grade.util.CommonUtils.result2Map;

/**
 * 分润比例设置
 */
@RestController
@RequestMapping(value = "/runPercent")
public class RunPercentController {
    private static final Logger logger = LoggerFactory.getLogger(RunPercentController.class);

    @Autowired
    private RunPercentService runPercentService;

    /**
     * runPercent/findDataByUserId
     * 根据总代理用户ID获取设置过的分润比例数据
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findDataByUserId")
    @ResponseBody
    public Map<String, Object> findDataByUserId(Integer userId) {
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("gradeRunPercent", runPercentService.findDataByUserId(userId));
        dataMap.put("success", true);
        return dataMap;
    }

    /**
     * runPercent/saveRunPercent
     * 保存分润比例数据
     *
     * @param gradeRunPercent
     * @return
     */
    @RequestMapping(value = "/saveRunPercent")
    @ResponseBody
    public Map<String, Object> saveRunPercent(GradeRunPercent gradeRunPercent) {
        logger.info("gradeRunPercent : {}", gradeRunPercent);

        int result = runPercentService.addOrUpdateRunPercent(gradeRunPercent);
        Map<String, Object> dataMap = result2Map(result, StatusUtils.SETTING_ERROR_MSG_EXCEPTION);
        return dataMap;
    }

    /**
     * 暂无调用
     * runPercent/updIsDel
     * 删除分润数据
     *
     * @param gradeRunPercent
     * @return
     */
    @RequestMapping(value = "/updIsDel")
    @ResponseBody
    public Map updIsDel(GradeRunPercent gradeRunPercent) {

        int result = runPercentService.updIsDel(gradeRunPercent);
        Map dataMap = result2Map(result, StatusUtils.DEL_ERROR_MSG_EXCEPTION);

        return dataMap;
    }


}
