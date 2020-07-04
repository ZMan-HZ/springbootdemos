package com.zzm.applications.mvc.beans;

import java.io.Serializable;

/**
 * <b>Description</b>  SysRequestPathPermissionRelation
 *
 * @Author Zhenzhen
 * @Since 2020-07-03 周五 14:25
 * @Info SysRequestPathPermissionRelation
 */
public class SysRequestPathPermissionRelation implements Serializable {
    private static final long serialVersionUID = -59197738311147860L;
    //主键id
    private Integer id;
    //请求路径id
    private Integer urlId;
    //权限id
    private Integer permissionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
