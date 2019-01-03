package com.grade.project.grade.model;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private Integer telno;

    private String extensionCode;

    private String parentCode;

    private String faction;

    private String truename;

    private String loginPswd;

    private String payPswd;

    private BigDecimal noPrice;

    private BigDecimal isPrice;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer userType;

    private Integer userStatus;

    private String token;

    private Integer isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getTelno() {
        return telno;
    }

    public void setTelno(Integer telno) {
        this.telno = telno;
    }

    public String getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode == null ? null : extensionCode.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction == null ? null : faction.trim();
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public String getLoginPswd() {
        return loginPswd;
    }

    public void setLoginPswd(String loginPswd) {
        this.loginPswd = loginPswd == null ? null : loginPswd.trim();
    }

    public String getPayPswd() {
        return payPswd;
    }

    public void setPayPswd(String payPswd) {
        this.payPswd = payPswd == null ? null : payPswd.trim();
    }

    public BigDecimal getNoPrice() {
        return noPrice;
    }

    public void setNoPrice(BigDecimal noPrice) {
        this.noPrice = noPrice;
    }

    public BigDecimal getIsPrice() {
        return isPrice;
    }

    public void setIsPrice(BigDecimal isPrice) {
        this.isPrice = isPrice;
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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}