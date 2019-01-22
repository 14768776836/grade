package com.grade.project.grade.model.vo;

import com.grade.project.grade.model.MchPayOrder;

public class PublicPayOrderVo extends MchPayOrder {

    private String appId;
    // 是否已认证 0：已认证  1 ：未认证
    private Integer isCertification;
    //授权后此用户对应公众号的唯一标识
    private String openId;

    public String getAppId() { return appId; }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(Integer isCertification) {
        this.isCertification = isCertification;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}