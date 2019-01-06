package com.grade.project.grade.model;

import com.grade.project.grade.util.StatusUtils;

import java.util.Date;

/**
 * 用户认证过的公众账号
 */
public class GradeWxPublicNum {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 授权后此用户对应公众号的唯一标识
     */
    private String openId;

    /**
     * 授权成功微信返回的昵称
     */
    private String wxUserName;

    /**
     * 授权成功微信返回的用户头像信息
     */
    private String wxHeadImg;

    /**
     * 公众账号APPID
     */
    private String appid;

    /**
     * 认证过的公众号主键id    grade_account表主键
     */
    private Integer gaId;

    /**
     * 是否删除  0：未删除   1已删除
     */
    private Integer isDel = StatusUtils.IS_DEL_0;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGaId() {
        return gaId;
    }

    public void setGaId(Integer gaId) {
        this.gaId = gaId;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getWxUserName() {
        return wxUserName;
    }

    public void setWxUserName(String wxUserName) {
        this.wxUserName = wxUserName;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getWxHeadImg() {
        return wxHeadImg;
    }

    public void setWxHeadImg(String wxHeadImg) {
        this.wxHeadImg = wxHeadImg;
    }
}