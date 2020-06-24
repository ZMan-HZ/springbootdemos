package com.zzm.applications.controller;

/**
 * <b>Description</b>  ExceptionHandler
 *
 * @Author Zhenzhen
 * @Since 2020-06-24 周三 21:44
 * @Info ExceptionHandler
 */

import com.sun.tools.corba.se.idl.constExpr.GreaterEqual;
import com.zzm.applications.controller.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotExistExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> handleExceptionJson(Exception e) {
        // 方式1， 浏览返回json数据，没有自适应
        Map<String, Object> map = new HashMap<>();
        map.put("code", "error code message!");
        map.put("message", e.getMessage());
        return map;
    }
    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 方式2， 传入自己的状态码,否则就不会进入错误页面，没有携带定制错误信息
        request.setAttribute("javax.servlet.error.status.code",500);
        map.put("code", "error code message!");
        map.put("message", e.getMessage());
        return "forward:/error";
    }
    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public String handleExceptionWithMessage(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 方式3， 参考 CustomErrorAttributes 类
        request.setAttribute("javax.servlet.error.status.code",500);
        map.put("code", "error code message!");
        map.put("message", e.getMessage());
        request.setAttribute("exception",map);
        return "forward:/error";
    }

}
