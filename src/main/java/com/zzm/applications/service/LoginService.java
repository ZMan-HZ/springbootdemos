package com.zzm.applications.service;

/**
 * <b>Description</b>  LoginService
 *
 * @Author Zhenzhen
 * @Since 2020-07-01 周三 21:44
 * @Info LoginService
 */

import com.zzm.applications.beans.LoginUserInfo;
import com.zzm.applications.service.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {


    @Autowired
    private LoginMapper loginMapper;

    public Map<String, String> verifyLoginInfo2(Map<String,String> paramsMap) {
//        return paramsMap.get("password");
        return loginMapper.verifyLogin2(paramsMap);
    }
    public LoginUserInfo verifyLoginInfo(LoginUserInfo loginUserInfo) {
        return loginMapper.verifyLogin(loginUserInfo);
    }

}
