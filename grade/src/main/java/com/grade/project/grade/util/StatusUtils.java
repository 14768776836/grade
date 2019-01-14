package com.grade.project.grade.util;

/**
 * 状态
 */
public class StatusUtils {

    /**
     * 每页查询的数量
     */
    public final static Integer PAGE_SIZE = 10;

    //订单状态
    /**
     * 成功
     */
    public final static Integer ORDER_STATUS_0 = 0;

    /**
     * 未绑定公众号
     */
    public final static Integer ORDER_STATUS_1 = 1;

    /**
     * 数据丢失
     */
    public final static Integer ORDER_STATUS_2 = 2;

    /**
     * 其他异常错误信息
     */
    public final static Integer ORDER_STATUS_3 = 3;

    /**
     * 账单未支付状态
     */
    public final static Integer ORDER_STATUS_4 = 4;


    //删除状态
    /**
     * 未删除
     */
    public final static Integer IS_DEL_0 = 0;

    /**
     * 已删除
     */
    public final static Integer IS_DEL_1 = 1;

    //信息正确   错误提示信息
    /**
     * 操作成功
     */
    public final static String SUCCESS_MSG = "操作成功";

    /**
     * 操作失败
     */
    public final static String ERROR_MSG = "操作失败";

    /**
     * 网络异常
     */
    public final static String NETWORK_EXCEPTION_MSG = "网络异常";

    /**
     * 错误信息异常提示  查询失败
     */
    public final static String FIND_ERROR_MSG_EXCEPTION = "查询失败";

    /**
     * 错误信息异常提示  设置失败
     */
    public final static String SETTING_ERROR_MSG_EXCEPTION = "设置失败";

    /**
     * 错误信息异常提示  修改失败
     */
    public final static String EDIT_ERROR_MSG_EXCEPTION = "修改失败";

    /**
     * 错误信息异常提示  删除失败
     */
    public final static String DEL_ERROR_MSG_EXCEPTION = "删除失败";

    /**
     * 错误信息异常提示  参数错误
     */
    public final static String DATA_ERROR_MSG_EXCEPTION = "参数错误";
}
