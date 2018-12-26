package com.grade.project.grade.mapper;

import java.util.List;

import com.grade.project.grade.model.PlayUser;
import com.grade.project.grade.model.PlayUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface PlayUserMapper {
    int countByExample(PlayUserExample example);

    int deleteByExample(PlayUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(PlayUser record);

    int insertSelective(PlayUser record);

    List<PlayUser> selectByExample(PlayUserExample example);

    PlayUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PlayUser record, @Param("example") PlayUserExample example);

    int updateByExample(@Param("record") PlayUser record, @Param("example") PlayUserExample example);

    int updateByPrimaryKeySelective(PlayUser record);

    int updateByPrimaryKey(PlayUser record);
}