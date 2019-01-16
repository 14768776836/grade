package com.grade.project.grade.model.vo;

import com.grade.project.grade.model.MchPayOrder;

public class PublicPayOrderVo extends MchPayOrder {

    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    // 是否已认证 0：已认证  1 ：未认证
    private Integer isCertification;

    public Integer getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(Integer isCertification) {
        this.isCertification = isCertification;
    }
}