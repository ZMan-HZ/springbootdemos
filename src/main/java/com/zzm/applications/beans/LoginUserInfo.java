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
    private String role;
    private boolean enabled;
    private boolean remember;
    private Date signUpDate;
    private Date lastLoginTime;

    public LoginUserInfo() {
    }

    public LoginUserInfo(String username, String password, String email, String phone, String role, boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.enabled = enabled;
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

    public String getRole() {
        return this.role;
    }

    public boolean isEnabled() {
        return this.enabled;
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

    public void setRole(String role) {
        this.role = role;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == "N" ? false : true;
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = signUpDate;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LoginUserInfo{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password == null ? "null" : "******").append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", verifyKey='").append(verifyKey).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append(", enabled=").append(enabled);
        sb.append(", remember=").append(remember);
        sb.append(", signUpDate=").append(signUpDate);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append('}');
        return sb.toString();
    }
}
