package com.grade.project.grade.model.vo;

import com.grade.project.grade.model.GradeAccount;

public class GradeOrderVo extends GradeAccount{

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
     * 订单结算开始时间
     */
    private String startTime;

    /**
     * 订单结算开始时间
     */
    private String endTime;

    public String getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode;
    }

    public Integer getRunLevel() {
        return runLevel;
    }

    public void setRunLevel(Integer runLevel) {
        this.runLevel = runLevel;
    }

    public String getRunPercent() {
        return runPercent;
    }

    public void setRunPercent(String runPercent) {
        this.runPercent = runPercent;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
