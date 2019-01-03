package com.grade.project.grade.model;

public class UserWithBLOBs extends User {
    private String userimg;

    private String securityQuestion;

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg == null ? null : userimg.trim();
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion == null ? null : securityQuestion.trim();
    }
}