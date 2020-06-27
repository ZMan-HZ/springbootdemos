package com.zzm.applications.controller;

import com.zzm.applications.exception.UserNonExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    //    @PostMapping(value = "/dashboard")
    @RequestMapping("/dashboard")
    public String login(String inputEmail, String inputPassword, Map<String, Object> map, HttpSession session) {
        String result;
        logger.info("inputEmail=" + inputEmail + ", inputPassword=" + inputPassword);
        if (!StringUtils.isEmptyOrWhitespace(inputEmail)) {
            session.setAttribute("loginUser", inputEmail);
            //防止表单重复提交，进行重定向
            result = "redirect:/dashboard.html";
        } else {
            map.put("tips", "Invalid username/password!");
            result = "redirect:login.html";
        }
        return result;
    }
}
