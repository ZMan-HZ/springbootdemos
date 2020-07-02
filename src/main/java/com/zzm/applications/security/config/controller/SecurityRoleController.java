package com.zzm.applications.security.config.controller;

import com.zzm.applications.beans.LoginUserInfo;
import com.zzm.applications.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Description</b>  RoleController
 *
 * @Author Zhenzhen
 * @Since 2020-06-27 周六 21:40
 * @Info RoleController
 */


@RestController
@CrossOrigin(origins = {"http://localhost:8088"}, allowCredentials = "true", allowedHeaders = {"X-Custom-Header"}, maxAge = 3600L, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.HEAD})
public class SecurityRoleController {

    private static final Logger logger = LoggerFactory.getLogger(SecurityRoleController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String verifyLogin(@RequestBody LoginUserInfo loginData) {
        Map<String, String> params = new HashMap<>();
        params.put("username", loginData.getUsername());
        params.put("email", null);
        Map<String, String> resultMap = new HashMap<>();
        loginService.verifyLoginInfo2(params);
        String result = null;
        if (loginData.getPassword().equals(params.get("password"))) {
            result = "true";
        } else {
            result = "false";
        }
        return result;
    }
    @PostMapping("/doLogin")
    public String doLogin(@RequestBody LoginUserInfo loginData) {
        Map<String, String> params = new HashMap<>();
        params.put("username", loginData.getUsername());
        params.put("email", null);
        Map<String, String> resultMap = new HashMap<>();
        loginService.verifyLoginInfo2(params);
        String result = null;
        if (loginData.getPassword().equals(params.get("password"))) {
            result = "true";
        } else {
            result = "false";
        }
        return result;
    }


}
