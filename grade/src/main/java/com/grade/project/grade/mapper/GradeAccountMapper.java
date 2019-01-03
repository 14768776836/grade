package com.grade.project.grade.mapper;

import com.grade.project.grade.model.GradeAccount;
import com.grade.project.grade.model.GradeAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeAccountMapper {
    int countByExample(GradeAccountExample example);

    int deleteByExample(GradeAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GradeAccount record);

    int insertSelective(GradeAccount record);

    List<GradeAccount> selectByExample(GradeAccountExample example);

    GradeAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GradeAccount record, @Param("example") GradeAccountExample example);

    int updateByExample(@Param("record") GradeAccount record, @Param("example") GradeAccountExample example);

    int updateByPrimaryKeySelective(GradeAccount record);

    int updateByPrimaryKey(GradeAccount record);
}