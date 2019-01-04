package com.grade.project.grade.service.wx;

import com.grade.project.grade.model.GradeAccount;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

    /**
     * 打款给个人
     * @param request
     * @param gradeAccount   打款信息
     * @param userId   用户id
     * @param amount   打款金额（元）
     * @return
     */
    Map<Object, Object> payMchToUser(HttpServletRequest request, GradeAccount gradeAccount, Integer userId, BigDecimal amount);

}
