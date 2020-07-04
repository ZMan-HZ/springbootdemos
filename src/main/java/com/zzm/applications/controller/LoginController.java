package com.zzm.applications.controller;

import com.zzm.applications.beans.LoginUserInfo;
import com.zzm.applications.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Description</b>  LoginController
 *
 * @Author Zhenzhen
 * @Since 2020-07-01 周三 21:44
 * @Info LoginController
 */

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String verifyLogin(String username, String password) {

        Map<String, String> params = new HashMap<>();
        params.put("username",username);
        params.put("email",null);
        Map<String, String> resultMap = loginService.verifyLoginInfo2(params);
        String result = null;
        if (password.equals(resultMap.get("password"))) {
            result = "success";
        }
        result = "failed";
        return result;
    }

}
