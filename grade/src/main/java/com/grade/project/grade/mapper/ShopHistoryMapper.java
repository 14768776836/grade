package com.grade.project.grade.mapper;

import com.grade.project.grade.model.ShopHistory;
import com.grade.project.grade.model.ShopHistoryExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopHistoryMapper {
    int countByExample(ShopHistoryExample example);

    int deleteByExample(ShopHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopHistory record);

    int insertSelective(ShopHistory record);

    List<ShopHistory> selectByExample(ShopHistoryExample example);

    ShopHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopHistory record, @Param("example") ShopHistoryExample example);

    int updateByExample(@Param("record") ShopHistory record, @Param("example") ShopHistoryExample example);

    int updateByPrimaryKeySelective(ShopHistory record);

    int updateByPrimaryKey(ShopHistory record);

    /**
     * 通过总代理的推广码以及开始结束时间统计期间内的消费总额
     * @param generalAgentCode  总代理推广码
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    BigDecimal sumLevelShop(@Param("generalAgentCode") String generalAgentCode, @Param("startTime")String startTime, @Param("endTime")String endTime);

    BigDecimal sumShopHistory(@Param("userId") Integer userId, @Param("startTime")String startTime, @Param("endTime")String endTime);
}