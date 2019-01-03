package com.grade.project.grade.service.wx;

import com.grade.project.grade.model.GradeAccount;

import java.util.List;

public interface MchService {

    /**
     * 根据用户id获取设置过的商户列表
     * @param userId
     * @return
     */
    List<GradeAccount> getMchList(Integer userId);

    /**
     * 保存商户信息
     * @param gradeAccount
     * @return
     */
    int saveMchMessage(GradeAccount gradeAccount);

    /**
     * 删除商户信息
     * @param id
     * @return
     */
    int delMch(Integer id);
}
