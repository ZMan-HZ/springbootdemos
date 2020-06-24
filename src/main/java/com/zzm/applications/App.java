package com.zzm.applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

/**
 *
 */

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class App {

    public static void main(String[] args) {
        //启动springboot
        SpringApplication.run(App.class, args);
    }

}
