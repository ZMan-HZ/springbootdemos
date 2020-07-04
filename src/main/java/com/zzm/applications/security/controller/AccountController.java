package com.zzm.applications.security.controller;

import com.zzm.applications.mvc.beans.LoginUserInfo;
import com.zzm.applications.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@CrossOrigin(origins = {"http://localhost:8088"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.HEAD})
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @PostMapping("/login2")
    public String verifyLogin(@RequestBody LoginUserInfo loginData) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("username", loginData.getUsername());
        params.put("email", null);
        Map<String, String> resultMap = new HashMap<>();
        accountService.verifyLoginInfo2(params);
        String result = null;
        if (loginData.getPassword().equals(params.get("password"))) {
            result = "true";
        } else {
            result = "false";
        }
        return result;
    }

    @PostMapping("/login")
    public String doLogin(@RequestBody LoginUserInfo loginData) {
        if (StringUtils.trimAllWhitespace(loginData.getUsername()).isEmpty()) {
            logger.error("login username is null or space:" + loginData.getUsername());
            return "false";
        }
        Map<String, String> params = new HashMap<>();
        params.put("username", loginData.getUsername());
        params.put("email", loginData.getUsername());
        String result = null;
        try {
            accountService.verifyLoginInfo2(params);
        } catch (Exception e) {
            logger.error("User Credential Error, Or User not exist");
            result = "false";
        }
        if (loginData.getPassword().equals(params.get("password"))) {
            result = "true";
        } else {
            result = "false";
        }
        logger.info("login user: " + loginData.getUsername() + ", password authorize: " + result);
        return result;
    }


}
