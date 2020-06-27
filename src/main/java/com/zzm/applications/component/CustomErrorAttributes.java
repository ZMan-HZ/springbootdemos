package com.zzm.applications.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * <b>Description</b>  CustomErrorAttributes
 *
 * @Author Zhenzhen
 * @Since 2020-06-24 周三 22:14
 * @Info CustomErrorAttributes
 */
//注入容器
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    //返回的map就是json和页面获取的所有信息
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("customeKey", "customeErrorMessage");
        //拿到在com.zzm.applications.controller.UserNonExistExceptionHandler.handleExceptionWithMessage中添加的信息,可在页面上取出来
        Map<String, Object> mapException = (Map<String, Object>) webRequest.getAttribute("NonExistException",0);
        map.put("NonExistException",mapException);
        return map;
    }
}
