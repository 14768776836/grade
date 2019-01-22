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


    List<PublicPayOrderVo> getAllUnPayOrders(@Param("appId") String appId);

    /**
     * 获取当前用户下的所有的已认证过的用户在特定的时间内产生的订单
     * @param time          指定的时间
     * @param appId         总代理当前可用的商户sppId
     * @return
     */
    List<PublicPayOrderVo> selectUnderCertification(@Param("time") String time,@Param("endTime") String endTime,@Param("appId") String appId);

    /**
     * 通过订单id和总代理可用的商户appId以及时间获取一条数据
     * @param orderId   订单id
     * @param appId     总代理设置的可用的appId
     * @return
     */
    PublicPayOrderVo selectOneByOrderId(@Param("orderId") Integer orderId,@Param("appId")String appId);

    /**
     * 调用存储过程，存储数据以供下面的查询
     * @param parentCode    //当前一级代理的推广码
     */
    void getChildPeng(@Param("parentCode") String parentCode);
}
