package com.zzm.applications.service.mapper;

import com.zzm.applications.beans.LoginUserInfo;

import java.util.Map;

/**
 * <b>Description</b>  LoginMapper
 *
 * @Author Zhenzhen
 * @Since 2020-07-01 周三 21:45
 * @Info LoginMapper
 */

public interface LoginMapper {

    public void verifyLogin(Map<String,String> paramsMap);

}
