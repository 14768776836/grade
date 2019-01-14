package com.grade.project.grade.model;

import java.math.BigDecimal;
import java.util.Date;

public class ShopHistory {
    private Integer id;

    private String shOrder;

    private Integer shUserid;

    private Integer hpid;

    private Integer shid;

    private String shName;

    private BigDecimal shPrice;

    private BigDecimal shPay;

    private Integer isPay;

    private Date shEnd;

    private Date gmtCreate;

    private Date gmtModifed;

    private Integer isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShOrder() {
        return shOrder;
    }

    public void setShOrder(String shOrder) {
        this.shOrder = shOrder == null ? null : shOrder.trim();
    }

    public Integer getShUserid() {
        return shUserid;
    }

    public void setShUserid(Integer shUserid) {
        this.shUserid = shUserid;
    }

    public Integer getHpid() {
        return hpid;
    }

    public void setHpid(Integer hpid) {
        this.hpid = hpid;
    }

    public Integer getShid() {
        return shid;
    }

    public void setShid(Integer shid) {
        this.shid = shid;
    }

    public String getShName() {
        return shName;
    }

    public void setShName(String shName) {
        this.shName = shName == null ? null : shName.trim();
    }

    public BigDecimal getShPrice() {
        return shPrice;
    }

    public void setShPrice(BigDecimal shPrice) {
        this.shPrice = shPrice;
    }

    public BigDecimal getShPay() {
        return shPay;
    }

    public void setShPay(BigDecimal shPay) {
        this.shPay = shPay;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Date getShEnd() {
        return shEnd;
    }

    public void setShEnd(Date shEnd) {
        this.shEnd = shEnd;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModifed() {
        return gmtModifed;
    }

    public void setGmtModifed(Date gmtModifed) {
        this.gmtModifed = gmtModifed;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}