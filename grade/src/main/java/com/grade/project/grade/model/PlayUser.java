package com.grade.project.grade.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Slf4j
public class PlayUser {
    private String id;

    private String language;

    private String username;

    private String password;

    private String secureconf;

    private String email;

    private String firstname;

    private String midname;

    private String lastname;

    private String jobtitle;

    private String department;

    private String gender;

    private String birthday;

    private String nickname;

    private String userType;

    private String rulename;

    private String searchprojectid;

    private String orgi;

    private String creater;

    private Date createtime;

    private String memo;

    private Date updatetime;

    private String mobile;

    private Date passupdatetime;

    private String sign;

    private Byte del;

    private Byte login;

    private Byte online;

    private Byte headimg;

    private Byte secquestion;

    private String playerlevel;

    private Integer experience;

    private String uname;

    private Byte musteditpassword;

    private String province;

    private String city;

    private Integer fans;

    private Integer follows;

    private Integer integral;

    private Date lastlogintime;

    private String status;

    private Date deactivetime;

    private String title;

    private Byte datastatus;

    private String token;

    private Integer cards;

    private Integer goldcoins;

    private Integer diamonds;

    private String openid;

    private String payopenid;

    private String unionid;

    private String qqid;

    private String country;

    private String region;

    private String isp;

    private String ostype;

    private Byte disabled;

    private String useragent;

    private String browser;

    private String playertype;

    private String headimgurl;

    private String invitationcode;

    private String pinvitationcode;

    private BigDecimal trtProfit;

    private BigDecimal ppAmount;

}