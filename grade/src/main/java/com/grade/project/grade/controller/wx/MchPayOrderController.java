package com.grade.project.grade.controller.wx;

import com.grade.project.grade.service.MchPayOrderService;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单控制层
 */
@Controller
@RequestMapping("/order")
public class MchPayOrderController {

    @Autowired
    MchPayOrderService mchPayOrderService;


    /**
     * 通过总代理用户id未支付获取订单列表
     *
     * @param userId    总代理用户id
     * @return
     */
    @RequestMapping("getOrderList")
    @ResponseBody
    public Map<String, Object> getOrderList(@RequestParam Integer userId,  @RequestParam Integer pageNum) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("success", true);
        dataMap.put("orders", mchPayOrderService.getOrderList(userId, pageNum));
        return dataMap;
    }
    /**
     * 通过总代理用户id和订单的支付状态获取订单列表
     * @param userId    总代理用户id
     * @param payStatus 订单支付状态 0:已支付 4 ：未支付
     * @return
     */
    @RequestMapping("getSpecificOrderList")
    @ResponseBody
    public Map<String, Object> getSpecificOrderList(@RequestParam Integer userId, @RequestParam Integer payStatus, @RequestParam Integer pageNum) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("success", true);
        dataMap.put("orders", mchPayOrderService.getSpecificOrderList(userId, payStatus,pageNum));
        return dataMap;
    }

    /**
     * 总代理给该分支下选中的用户（直属下级-->后续给认证的所有的该支线下的订单打款）打款
     * @param userId        总代理的id
     * @param orders        直属下级的订单号集合
     * @return
     */
    @RequestMapping("/pay")
    @ResponseBody
    public Map pay(HttpServletRequest request, @RequestParam Integer userId, @Param("orders") List<Integer> orders){
        Map<String,Object> dataMap = new HashMap<>();
        mchPayOrderService.pay(request,userId,orders);
        return dataMap;
    }

}
