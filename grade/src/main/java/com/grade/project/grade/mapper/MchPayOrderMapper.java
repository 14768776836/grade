package com.grade.project.grade.mapper;

import com.grade.project.grade.model.MchPayOrder;
import com.grade.project.grade.model.MchPayOrderExample;
import java.util.List;

import com.grade.project.grade.model.User;
import org.apache.ibatis.annotations.Param;

public interface MchPayOrderMapper {
    int countByExample(MchPayOrderExample example);

    int deleteByExample(MchPayOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MchPayOrder record);

    int insertSelective(MchPayOrder record);

    List<MchPayOrder> selectByExample(MchPayOrderExample example);

    MchPayOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MchPayOrder record, @Param("example") MchPayOrderExample example);

    int updateByExample(@Param("record") MchPayOrder record, @Param("example") MchPayOrderExample example);

    int updateByPrimaryKeySelective(MchPayOrder record);

    int updateByPrimaryKey(MchPayOrder record);


    List<MchPayOrder> getAllUnders(@Param("parentCode") String parentCode,@Param("time") String time);
}