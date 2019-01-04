package com.grade.project.grade.model;

import java.math.BigDecimal;
import java.util.Date;

public class MchPayOrder {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 订单编号
     */
    private String orderNum;

    /**
     * 收款人用户id
     */
    private Integer userId;

    /**
     * 收款人对应微信用户昵称
     */
    private String wxUserName;

    /**
     * 当前收款人所属上级邀请码
     */
    private String parentCode;

    /**
     * 收款人收款金额
     */
    private BigDecimal payPrice;

    /**
     * 收款信息
     */
    private String payMsg;

    /**
     * 订单状态
     * 详细状态说明  StatusUtils 订单状态
     */
    private Integer payStatus;

    /**
     * 是否删除
     */
    private Integer isDel = 0;

    /**
     * 创建时间
     */
    private Date gmtCreate = new Date();

    /**
     * 修改时间
     */
    private Date gmtModified = new Date();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWxUserName() {
        return wxUserName;
    }

    public void setWxUserName(String wxUserName) {
        this.wxUserName = wxUserName == null ? null : wxUserName.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public String getPayMsg() {
        return payMsg;
    }

    public void setPayMsg(String payMsg) {
        this.payMsg = payMsg == null ? null : payMsg.trim();
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}