package com.grade.project.grade.model;

import com.grade.project.grade.util.StatusUtils;
import lombok.Data;

import java.util.Date;

@Data
public class GradeRunPercent {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户邀请码
     */
    private String extensionCode;

    /**
     * 分润级数
     */
    private Integer runLevel;

    /**
     * 分润百分比
     * 数组的长度根据分润级数动态设置
     * [{"level":"1","value":"5"},{"level":"2","value":"7"}]
     */
    private String runPercent;

    /**
     * 是否删除
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

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getExtensionCode() {
//        return extensionCode;
//    }
//
//    public void setExtensionCode(String extensionCode) {
//        this.extensionCode = extensionCode == null ? null : extensionCode.trim();
//    }
//
//    public Integer getRunLevel() {
//        return runLevel;
//    }
//
//    public void setRunLevel(Integer runLevel) {
//        this.runLevel = runLevel;
//    }
//
//    public String getRunPercent() {
//        return runPercent;
//    }
//
//    public void setRunPercent(String runPercent) {
//        this.runPercent = runPercent == null ? null : runPercent.trim();
//    }
//
//    public Integer getIsDel() {
//        return isDel;
//    }
//
//    public void setIsDel(Integer isDel) {
//        this.isDel = isDel;
//    }
//
//    public Date getGmtCreate() {
//        return gmtCreate;
//    }
//
//    public void setGmtCreate(Date gmtCreate) {
//        this.gmtCreate = gmtCreate;
//    }
//
//    public Date getGmtModified() {
//        return gmtModified;
//    }
//
//    public void setGmtModified(Date gmtModified) {
//        this.gmtModified = gmtModified;
//    }
//
//    @Override
//    public String toString() {
//        return "GradeRunPercent{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", extensionCode='" + extensionCode + '\'' +
//                ", runLevel=" + runLevel +
//                ", runPercent='" + runPercent + '\'' +
//                ", isDel=" + isDel +
//                ", gmtCreate=" + gmtCreate +
//                ", gmtModified=" + gmtModified +
//                '}';
//    }
}