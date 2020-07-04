package com.zzm.applications.service;

/**
 * <b>Description</b>  LoginService
 *
 * @Author Zhenzhen
 * @Since 2020-07-01 周三 21:44
 * @Info LoginService
 */

import com.zzm.applications.mvc.beans.LoginUserInfo;
import com.zzm.applications.service.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccountService {


    @Autowired
    private AccountMapper accountMapper;

    public Map<String, String> verifyLoginInfo2(Map<String,String> paramsMap) throws Exception{
//        return paramsMap.get("password");
        return accountMapper.verifyLogin2(paramsMap);
    }
    public LoginUserInfo verifyLoginInfo(LoginUserInfo loginUserInfo) {
        return accountMapper.verifyLogin(loginUserInfo);
    }

}
