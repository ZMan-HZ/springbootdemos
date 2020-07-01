package com.zzm.applications.beans;

import java.util.Date;

/**
 * <b>Description</b>  LoginUserInfo
 *
 * @Author Zhenzhen
 * @Since 2020-07-01 周三 21:47
 * @Info LoginUserInfo
 */
public class LoginUserInfo {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String verifyKey;
    private Date signUpDate;
    private Date lastLoginTime;

    public LoginUserInfo() {
    }

    public LoginUserInfo(String username, String email, String verifyKey) {
        this.username = username;
        this.email = email;
        this.verifyKey = verifyKey;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getVerifyKey() {
        return this.verifyKey;
    }

    public Date getSignUpDate() {
        return this.signUpDate;
    }

    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setVerifyKey(String verifyKey) {
        this.verifyKey = verifyKey;
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = signUpDate;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "LoginUserInfo(username=" + this.getUsername() + ", password=" + this.getPassword() == null ? "null" : "******" + ", phone=" + this.getPhone() + ", verifyKey=" + this.getVerifyKey() + ", signUpDate=" + this.getSignUpDate() + ", lastLoginTime=" + this.getLastLoginTime() + ")";
    }


}
