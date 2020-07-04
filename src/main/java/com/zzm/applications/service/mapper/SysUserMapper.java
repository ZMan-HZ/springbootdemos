package com.zzm.applications.service.mapper;

import com.zzm.applications.mvc.beans.SysPermission;
import com.zzm.applications.mvc.beans.SysUser;

import java.util.List;

public interface SysUserMapper {

    public SysUser selectByName(String userName);
    List<SysPermission> selectListByUser(Integer userId);
}
