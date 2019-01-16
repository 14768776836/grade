package com.grade.project.grade.service;

import com.github.pagehelper.PageInfo;
import com.grade.project.grade.model.vo.PublicPayOrderVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 订单service
 */
public interface MchPayOrderService {

    PageInfo<PublicPayOrderVo> getOrderList(Integer id, Integer pageNum);

    PageInfo<PublicPayOrderVo> getSpecificOrderList(Integer userId, Integer payStatus, Integer pageNum);

    void pay(HttpServletRequest request,Integer userId, List<Integer> orders);
}
