package com.zzm.applications.config;

import com.zzm.applications.component.WebLocaleResolver;
import com.zzm.applications.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <b>Description</b>  WebMvcConfig
 *
 * @Author Zhenzhen
 * @Since 2020-06-21 周日 11:07
 * @Info WebMvcConfig
 */
//之前版本是extends WebMvcConfigureerAdapter
@Configuration
public class SpringbootWebMvcConfiguration implements WebMvcConfigurer {

    //此接口在新版的springboot上已找不到
//    public EmbeddedServletContainerCustomizer  servletContainerCustomizer(){
//        return  new EmbeddedServletContainerCustomizer(){
//
//        }
//    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*registry.addViewController("/").setViewName("index.html");
        registry.addViewController("/login.html").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/dashboard.html").setViewName("dashboard");*/
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("login.html", "index.html");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new WebLocaleResolver();
    }

}
