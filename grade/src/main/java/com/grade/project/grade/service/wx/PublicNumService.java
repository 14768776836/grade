package com.grade.project.grade.service.wx;

import com.grade.project.grade.model.GradeAccount;
import com.grade.project.grade.model.vo.PublicNumVo;

import java.util.List;

public interface PublicNumService {

    /**
     * 查询当前用户认证过的公众号列表
     * @param userId
     * @return
     */
    List<PublicNumVo> getPublicNumList(Integer userId);

    /**
     * 保存用户微信授权的数据
     * @param code
     * @param gradeAccount
     * @return 错误信息  null代表成功
     */
    String saveWxUserIfo(String code, GradeAccount gradeAccount);
}
