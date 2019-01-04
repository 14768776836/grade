package com.grade.project.grade.service;

import com.grade.project.grade.model.GradeRunPercent;

public interface RunPercentService {

    /**
     * 根据总代理用户id查询设置的分销比例数据
     * @param userId
     * @return
     */
    GradeRunPercent findDataByUserId(Integer userId);

    /**
     * 新增分销比例数据
     * @param gradeRunPercent
     * @return
     */
    int addRunPercent(GradeRunPercent gradeRunPercent);

    /**
     * 修改分销比例数据
     * @param gradeRunPercent
     * @return
     */
    int updateRun(GradeRunPercent gradeRunPercent);

    /**
     * 删除分销比例数据
     * @param gradeRunPercent
     * @return
     */
    int updIsDel(GradeRunPercent gradeRunPercent);
}
