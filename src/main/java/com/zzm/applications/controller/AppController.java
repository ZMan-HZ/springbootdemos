package com.zzm.applications.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * <b>Description</b>  AppController
 *
 * @Author Zhenzhen
 * @Since 2020-06-20 周六 12:45
 * @Info AppController
 */

//@RestController //此注解代替下面两个注解
//@ResponseBody  此注解说明此类中的所有方法返回直接给浏览器
@Controller
public class AppController {

    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        logger.info("Hello Controller!");
        return "Hello, World";
    }

    //此requestmap不要加 @ResponseBody注解，并且返回值应该是对应html的文件名
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        logger.info("success Controller!");
        map.put("hello", "Hello, World!"); //用于页面上的信息
        return "success";
    }

//    @PostMapping(value = "/dashboard")
    @RequestMapping("/dashboard")
    public String login(String inputEmail, String inputPassword, Map<String, Object> map, HttpSession session) {
        String result;
        logger.info("inputEmail=" + inputEmail + ", inputPassword=" + inputPassword);
        if (!StringUtils.isEmptyOrWhitespace(inputEmail) && "123".equals(inputPassword)) {
            session.setAttribute("loginUser",inputEmail);
            //防止表单重复提交，进行重定向
            result = "redirect:/dashboard.html";
        } else {
            map.put("tips", "Invalid username/password!");
            result = "redirect:login.html";
        }
        return result;
    }
}
