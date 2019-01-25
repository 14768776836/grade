package com.grade.project.grade.controller.manage;

import com.github.pagehelper.PageInfo;
import com.grade.project.grade.model.User;
import com.grade.project.grade.service.UserService;
import com.grade.project.grade.util.StatusUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/allGrade")
public class AllGradeController {
    private static final Logger logger = LoggerFactory.getLogger(AllGradeController.class);
    @Autowired
    private UserService userService;

    /**
     * allGrade/getAllGradeList
     * 分页查询所有总代理列表数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllGradeList")
    public Map getAllGradeList(Integer pageNum, Integer status, String startTime, String endTime, String name) {
        Map<String, Object> dataMap = new HashMap<>();
        try {
            PageInfo<User> allGradeList = userService.getAllGradeList(pageNum, status, startTime, endTime, name);
            dataMap.put("list", allGradeList);
            dataMap.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success", false);
            dataMap.put("msg", "请重新登录！");
        }
        return dataMap;
    }

    /**
     * allGrade/operateUserGrade
     * 分页查询所有总代理列表数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/operateUserGrade")
    public Map operateUserGrade(Integer userId, Integer status, BigDecimal percent) {
        Map<String, Object> dataMap = new HashMap<>();
        try {
            int result = userService.operateUserGrade(userId, status,percent);
            if (result == 1) {
                dataMap.put("success", true);
            } else {
                dataMap.put("msg", StatusUtils.EDIT_ERROR_MSG_EXCEPTION);
                dataMap.put("success", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success", false);
            dataMap.put("msg", StatusUtils.EDIT_ERROR_MSG_EXCEPTION);
        }
        return dataMap;
    }

    /**
     * allGrade/getAllGradeCount
     * 查询总代理总人数
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllGradeCount")
    public Map getAllGradeCount() {
        Map<String, Object> dataMap = new HashMap<>();
        try {
            dataMap.put("count", userService.getAllGradeCount());
            dataMap.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success", false);
            dataMap.put("msg", StatusUtils.EDIT_ERROR_MSG_EXCEPTION);
        }
        return dataMap;
    }

}
