package com.grade.project.grade.model;

import java.util.Date;

/**
 * 用户绑定过的公众账号
 */
public class GradeAccount {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID（总代理）
     */
    private Integer userId;

    /**
     * 公众账号名称
     */
    private String gzName;

    /**
     * 公众账号APPID dddd
     */
    private String appid;

    /**
     * 公众账号密钥Secrect
     */
    private String appSecrect;

    /**
     * API密钥用户自己设置
     */
    private String apiKey;

    /**
     * 商户ID
     */
    private String mchId;

    /**
     * 状态   是否开启   0：开启   1：关闭
     */
    private Integer status = 0;

    /**
     * 是否删除 0:未删除   1：已删除
     */
    private Integer isDel = 0;

    /**
     * 创建时间
     */
    private Date gmtCreate = new Date();

    /**
     * 修改时间
     */
    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGzName() {
        return gzName;
    }

    public void setGzName(String gzName) {
        this.gzName = gzName == null ? null : gzName.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getAppSecrect() {
        return appSecrect;
    }

    public void setAppSecrect(String appSecrect) {
        this.appSecrect = appSecrect == null ? null : appSecrect.trim();
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}