package com.grade.project.grade.model;

import java.math.BigDecimal;
import java.util.Date;

public class MchPayOrder {
    private Integer id;

    private String orderNum;

    private Integer userId;

    private String wxUserName;

    private String parentCode;

    private String generalAgentCode;

    private BigDecimal payPrice;

    private String payMsg;

    private Integer payStatus;

    // 订单状态 0：正常 1：删除
    private Integer isDel;

    private Date gmtCreate;

    private Date gmtModified;

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

    public String getGeneralAgentCode() {
        return generalAgentCode;
    }

    public void setGeneralAgentCode(String generalAgentCode) {
        this.generalAgentCode = generalAgentCode == null ? null : generalAgentCode.trim();
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