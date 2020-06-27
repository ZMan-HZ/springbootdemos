package com.zzm.applications;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.bind.annotation.Mapping;

/**
 *
 */
//批量扫描
@MapperScan(value = "com.zzm.applications.service.mapper") //注解版，必须要有
@EnableCaching //开启基于注解的缓存
@EnableJms //开启Jms, 或者@RabbitMQ 其他
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        //启动springboot
        SpringApplication.run(App.class, args);
    }

}
