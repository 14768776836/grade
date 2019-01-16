package com.grade.project.grade.mapper.vo;

import com.grade.project.grade.model.vo.PublicPayOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
public interface PublicPayOrderVoMapper {

    List<PublicPayOrderVo> getChildrenOrders(@Param("parentCode") String parentCode, @Param("time") String time, @Param("appId") String appId);

    /**
     * 通过支付状态获取当前总代理下的一级代理的订单
     * @param parentCode    总代理推广码
     * @param payStatus     支付状态
     * @param appId         总代理当前可用的商户appId
     * @return
     */
    List<PublicPayOrderVo> getSpecificOrderList(@Param("parentCode") String parentCode,@Param("payStatus") Integer payStatus,@Param("appId") String appId);

    /**
     * 获取当前用户下的所有的已认证过的用户在特定的时间内产生的订单
     * @param parentCode    当前用户的推广码
     * @param time          指定的时间
     * @param appId         总代理当前可用的商户sppId
     * @return
     */
    List<PublicPayOrderVo> selectUnderCertification(@Param("parentCode") String parentCode,@Param("time") String time,@Param("appId") String appId);
}
