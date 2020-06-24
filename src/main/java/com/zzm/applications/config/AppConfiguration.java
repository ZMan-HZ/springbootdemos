package com.zzm.applications.config;

import com.zzm.applications.component.WebLocaleResolver;
import com.zzm.applications.service.AppService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

/**
 * <b>Description</b>  AppConfiguration
 *
 * @Author Zhenzhen
 * @Since 2020-06-20 周六 15:45
 * @Info AppConfiguration
 */

/**
 * @Configuration tell spring, this is a configure class
 */

@Configuration
public class AppConfiguration {

    //    @Bean // 也可以使用@Serivece注入
//    public AppService appService(){
//        return new AppService();
//    }
}
