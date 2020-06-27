package com.zzm.applications.exception.handler;

import com.zzm.applications.exception.UserNonExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;

/**
 * <b>Description</b>  UserNonExistExceptionHandler
 *
 * @Author Zhenzhen
 * @Since 2020-06-25 周四 09:21
 * @Info UserNonExistExceptionHandler
 */

@ControllerAdvice
public class UserNonExistExceptionHandler {

    //浏览器跟客户端返回的都是Json数据
    //跟以下方法不能同时存在,只能存在一个
    /*@ResponseBody
    @ExceptionHandler(UserNonExistException.class)
    public Map<String, Object> handleExceptions(Exception e) {
        // 方式1， 浏览返回json数据，没有自适应
        Map<String, Object> map = new HashMap<>();
        map.put("code", "User is not Exist!");
        map.put("message", e.getMessage());
        return map;
    }
*/
    /*
    @ExceptionHandler(UserNonExistException.class)
    public String handleExceptionNoJson(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 方式2， 传入自己的状态码,否则就不会进入错误页面，没有携带定制错误信息
        //奇怪的时500时，5xx.html不起作用,因此添加了500.html
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE,500);
        map.put("code", "error code message!");
        map.put("message", e.getMessage());
        return "forward:/error";
    }*/
    @ExceptionHandler(UserNonExistException.class)
    public String handleExceptionWithMessage(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 方式3， 参考 CustomErrorAttributes 类
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE,500);
        map.put("code", "error code message!");
        map.put("message", e.getMessage());
        request.setAttribute("NonExistException",map);
        return "forward:/error";
    }



}
