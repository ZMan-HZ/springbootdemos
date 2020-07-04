package com.zzm.applications.mvc.beans;

import java.util.Date;

/**
 * <b>Description</b>  SysUser
 *
 * @Author Zhenzhen
 * @Since 2020-07-03 周五 14:11
 * @Info SysUser
 */
public class SysUser {

    private int id;
    private String account;
    private String userName;
    private String password;
    private Date lastLoginDate;
    private boolean enabled;
    private boolean notExpired;
    private boolean accountNotLocked;
    private boolean credentialNotExpired;
    private Date createTime;
    private Date updateTime;
    private int createUser;
    private int updateUser;

    public SysUser() {
    }


    public int getId() {
        return this.id;
    }

    public String getAccount() {
        return this.account;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getLastLoginDate() {
        return this.lastLoginDate;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isNotExpired() {
        return this.notExpired;
    }

    public boolean isAccountNotLocked() {
        return this.accountNotLocked;
    }

    public boolean isCredentialNotExpired() {
        return this.credentialNotExpired;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public int getCreateUser() {
        return this.createUser;
    }

    public int getUpdateUser() {
        return this.updateUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled == 1 ? true : false;
    }

    public void setNotExpired(boolean notExpired) {
        this.notExpired = notExpired;
    }

    public void setNotExpired(int notExpired) {
        this.notExpired = notExpired == 1 ? true : false;
    }

    public void setAccountNotLocked(int accountNotLocked) {
        this.accountNotLocked = accountNotLocked == 1 ? true : false;
    }

    public void setCredentialNotExpired(int credentialNotExpired) {
        this.credentialNotExpired = credentialNotExpired == 1 ? true : false;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setCreateUser(int createUser) {
        this.createUser = createUser;
    }

    public void setUpdateUser(int updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "SysUser(id=" + this.getId() + ", account=" + this.getAccount() + ", userName=" + this.getUserName() + ", password=" + this.getPassword() + ", lastLoginDate=" + this.getLastLoginDate() + ", enabled=" + this.isEnabled() + ", notExpired=" + this.isNotExpired() + ", accountNotLocked=" + this.isAccountNotLocked() + ", credentialNotExpired=" + this.isCredentialNotExpired() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ", createUser=" + this.getCreateUser() + ", updateUser=" + this.getUpdateUser() + ")";
    }
}
