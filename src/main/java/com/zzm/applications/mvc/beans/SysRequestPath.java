package com.zzm.applications.mvc.beans;

import java.io.Serializable;

/**
 * <b>Description</b>  SysRequestPath
 *
 * @Author Zhenzhen
 * @Since 2020-07-03 周五 14:24
 * @Info SysRequestPath
 */
public class SysRequestPath implements Serializable {
    private static final long serialVersionUID = -38398465698914714L;
    //主键id
    private Integer id;
    //请求路径
    private String url;
    //路径描述
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
