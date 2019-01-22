package com.grade.project.grade.controller.wx;

import com.github.pagehelper.PageInfo;
import com.grade.project.grade.mapper.MchPayOrderMapper;
import com.grade.project.grade.model.MchPayOrder;
import com.grade.project.grade.model.MchPayOrderExample;
import com.grade.project.grade.service.MchPayOrderService;
import com.grade.project.grade.util.StatusUtils;
import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import org.apache.ibatis.annotations.Param;
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
    @Autowired
    MchPayOrderMapper mchPayOrderMapper;


    /**
     * 通过总代理用户id未获取订单列表
     *
     * @param userId 总代理用户id
     * @return
     */
    @RequestMapping("/getOrderList")
    @ResponseBody
    public Map<String, Object> getOrderList(@RequestParam Integer userId, @RequestParam Integer pageNum) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("success", true);
        dataMap.put("orders", mchPayOrderService.getOrderList(userId, pageNum));
        return dataMap;
    }

    /**
     * 通过总代理用户id和订单的支付状态获取订单列表
     *
     * @param userId    总代理用户id
     * @param payStatus 订单支付状态 0:已支付  其余 ：未支付或者支付失败（大于0）
     * @return
     */
    @RequestMapping("/getSpecificOrderList")
    @ResponseBody
    public Map<String, Object> getSpecificOrderList(@RequestParam Integer userId, @RequestParam Integer payStatus, @RequestParam Integer pageNum) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("success", true);
        dataMap.put("orders", mchPayOrderService.getSpecificOrderList(userId, payStatus, pageNum));
        return dataMap;
    }

    /**
     * 总代理给该分支下选中的用户（直属下级-->后续给认证的所有的该支线下的订单打款）打款
     *
     * @param userId 总代理的id
     * @param orders 直属下级的订单号集合
     * @return
     */
    @RequestMapping("/pay")
    @ResponseBody
    public Map pay(HttpServletRequest request, @RequestParam Integer userId, @RequestParam List<Integer> orders) {
        Map<String, Object> dataMap = new HashMap<>();
        mchPayOrderService.pay(request, userId, orders);
        dataMap.put("success",true);
        dataMap.put("msg","操作成功");
        return dataMap;
    }

    /**
     * 总代理获取所有未支付的已经进行过认证的订单
     * @param userId
     * @param pageNum
     * @return
     */
    @RequestMapping("/getAllUnPayOrders")
    @ResponseBody
    public Map getAllUnPayOrders(@RequestParam Integer userId,@RequestParam Integer pageNum){

        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("success",true);
        dataMap.put("orders",mchPayOrderService.getAllUnPayOrders(userId,pageNum));
        return dataMap;
    }


    /**
     * /order/getCollectionRecord
     * 收款记录
     * @param userId    用户id
     * @return
     */
    @RequestMapping("/getCollectionRecord")
    @ResponseBody
    public Map getCollectionRecord(@RequestParam Integer userId,@RequestParam Integer pageNum){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("success",true);
        dataMap.put("orders",mchPayOrderService.getCollectionRecord(userId,pageNum));
        return dataMap;
    }

}
