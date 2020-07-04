package com.zzm.applications.mvc.beans;

import java.io.Serializable;

/**
 * <b>Description</b>  SysPermission
 *
 * @Author Zhenzhen
 * @Since 2020-07-03 周五 14:23
 * @Info SysPermission
 */
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -71969734644822184L;
    //主键id
    private Integer id;
    //权限code
    private String permissionCode;
    //权限名
    private String permissionName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

}
