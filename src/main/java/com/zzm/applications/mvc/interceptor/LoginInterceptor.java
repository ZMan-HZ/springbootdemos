package com.zzm.applications.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>Description</b>  LoginInterceptor
 *
 * @Author Zhenzhen
 * @Since 2020-06-21 周日 14:13
 * @Info LoginInterceptor
 */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String user = String.valueOf(session.getAttribute("loginUser"));
        String context = request.getRequestURI();
//        if (StringUtils.isEmptyOrWhitespace(user)/* || context.contains("login") || context.contains("index")*/) {
//            request.setAttribute("tips","Please Sign in!");
//            request.getRequestDispatcher("login.html").forward(request, response);
//        } else {
            return true;
//        }
//        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
