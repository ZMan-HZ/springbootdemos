package com.zzm.applications.service.mapper;

import com.zzm.applications.mvc.beans.LoginUserInfo;

import java.util.Map;

/**
 * <b>Description</b>  AccountMapper
 *
 * @Author Zhenzhen
 * @Since 2020-07-01 周三 21:45
 * @Info AccountMapper
 */

public interface AccountMapper {

    public LoginUserInfo verifyLogin(LoginUserInfo paramsMap);

    public Map<String, String> verifyLogin2(Map<String, String> paramsMap);
}
