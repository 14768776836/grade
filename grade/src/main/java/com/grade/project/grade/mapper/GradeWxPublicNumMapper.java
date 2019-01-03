package com.grade.project.grade.mapper;

import com.grade.project.grade.model.GradeWxPublicNum;
import com.grade.project.grade.model.GradeWxPublicNumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeWxPublicNumMapper {
    int countByExample(GradeWxPublicNumExample example);

    int deleteByExample(GradeWxPublicNumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GradeWxPublicNum record);

    int insertSelective(GradeWxPublicNum record);

    List<GradeWxPublicNum> selectByExample(GradeWxPublicNumExample example);

    GradeWxPublicNum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GradeWxPublicNum record, @Param("example") GradeWxPublicNumExample example);

    int updateByExample(@Param("record") GradeWxPublicNum record, @Param("example") GradeWxPublicNumExample example);

    int updateByPrimaryKeySelective(GradeWxPublicNum record);

    int updateByPrimaryKey(GradeWxPublicNum record);
}