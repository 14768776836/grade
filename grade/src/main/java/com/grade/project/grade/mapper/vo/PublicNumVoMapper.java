package com.grade.project.grade.mapper.vo;

import com.grade.project.grade.model.vo.PublicNumVo;

import java.util.List;

public interface PublicNumVoMapper {

    List<PublicNumVo> getPublicNumList(Integer userId);
}
