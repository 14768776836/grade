package com.grade.project.grade.model.vo;

import java.util.Date;

/**
 * 公众号列表详细数据
 */
public class PublicNumVo {
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户昵称(微信)
     */
    private String wxUserName;

    /**
     * 公众号名称
     */
    private String gzName;
    /**
     * 认证时间
     */
    private Date bindTime;
    /**
     * 状态  0：失效  1：正常
     */
    private int status;

    /**
     * 上级用户id
     */
    private Integer parentUserId;

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
        this.gzName = gzName;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getWxUserName() {
        return wxUserName;
    }

    public void setWxUserName(String wxUserName) {
        this.wxUserName = wxUserName;
    }

    public Integer getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(Integer parentUserId) {
        this.parentUserId = parentUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
