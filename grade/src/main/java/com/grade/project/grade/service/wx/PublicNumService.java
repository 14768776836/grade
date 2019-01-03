package com.grade.project.grade.service.wx;

import com.grade.project.grade.model.vo.PublicNumVo;

import java.util.List;

public interface PublicNumService {

    /**
     * 查询当前用户认证过的公众号列表
     * @param userId
     * @return
     */
    List<PublicNumVo> getPublicNumList(Integer userId);
}
