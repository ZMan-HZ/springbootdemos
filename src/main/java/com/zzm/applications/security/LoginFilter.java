package com.zzm.applications.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>Description</b>  LoginFilter   Security默认只接收key/value的形式获取用户登陆信息，此类可以实现覆盖，使用jason传递参数
 *
 * @Author Zhenzhen
 * @Since 2020-07-02 周四 11:16
 * @Info LoginFilter
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        UsernamePasswordAuthenticationToken authRequest =null;
        //判断传递参数的形式
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE) || request.getContentType().equals(MediaType.APPLICATION_JSON)) {

            Map<String, String> loginData = new HashMap<>();
            String verifyCode = String.valueOf(request.getSession().getAttribute("verifyCode"));
            try {
                loginData = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                String code = loginData.get("code");
                CheckAndVerify(code, verifyCode);

            }
            String username = loginData.get(getUsernameParameter());
            String password = loginData.get(getPasswordParameter());

            if (username == null) {
                username = "";
            }
            if (password == null) {
                password = "";
            }
            username = username.trim();

            authRequest = new UsernamePasswordAuthenticationToken(username, password);

            // Allow subclasses to set the "details" property
            setDetails(request, authRequest);

            return this.getAuthenticationManager().authenticate(authRequest);
        } else {
            return this.getAuthenticationManager().authenticate(authRequest);

        }

    }

    private boolean CheckAndVerify(String code, String verifyCode) {

        return false;
    }
}
