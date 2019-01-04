package com.grade.project.grade.mapper;

import com.grade.project.grade.model.GradeRunPercent;
import com.grade.project.grade.model.GradeRunPercentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeRunPercentMapper {
    int countByExample(GradeRunPercentExample example);

    int deleteByExample(GradeRunPercentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GradeRunPercent record);

    int insertSelective(GradeRunPercent record);

    List<GradeRunPercent> selectByExample(GradeRunPercentExample example);

    GradeRunPercent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GradeRunPercent record, @Param("example") GradeRunPercentExample example);

    int updateByExample(@Param("record") GradeRunPercent record, @Param("example") GradeRunPercentExample example);

    int updateByPrimaryKeySelective(GradeRunPercent record);

    int updateByPrimaryKey(GradeRunPercent record);
}