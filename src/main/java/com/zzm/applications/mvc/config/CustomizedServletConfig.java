package com.zzm.applications.mvc.config;

/**
 * <b>Description</b>  ServerConfig //此类用于配置Servlet容器
 *
 * @Author Zhenzhen
 * @Since 2020-06-24 周三 22:42
 * @Info ServerConfig
 */


import com.zzm.applications.mvc.filter.CustomizedFilter;
import com.zzm.applications.mvc.listener.CustomizedListener;
import com.zzm.applications.mvc.servlet.CustomizedServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import java.util.Arrays;


@Configuration
public class CustomizedServletConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean customizedServlet() {
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new CustomizedServlet(), "/customizedServlet");
        //可以注册一些loaduo之类的配置
//        servletServletRegistrationBean.setLoadOnStartup(1);
        return servletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean customizedFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CustomizedFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/customizedServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean customizedListener() {
        ServletListenerRegistrationBean<CustomizedListener> customizedListener = new ServletListenerRegistrationBean<CustomizedListener>(new CustomizedListener());
        return customizedListener;
    }

    //此是用来配置嵌入式的Servlet容器的，接口在新版的springboot上已找不到
//    public EmbeddedServletContainerCustomizer  servletContainerCustomizer(){
//        return  new EmbeddedServletContainerCustomizer(){
//
//        }
//    }
}
