package com.zzm.applications.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * <b>Description</b>  DruidDataSourceConfiguration 为了使用配置文件中的连接池属性。
 * 如果不使用druid数据源，可不配置此类
 *
 * @Author Zhenzhen
 * @Since 2020-06-25 周四 23:36
 * @Info DruidDataSourceConfiguration
 */

@Configuration
public class DruidDataSourceConfiguration {


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //配置监控
    //1。配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> druid = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*"); //此处一定不能写错
        Map<String, String> initParam = new HashMap<>();
        initParam.put("loginUsername", "druid");
        initParam.put("loginPassword", "druid");
        initParam.put("allow", "127.0.0.1"); //不写或者为null的时候，就是所有
       initParam.put("deny","192.168.100.1");
        druid.setInitParameters(initParam);
        return druid;
    }

    //2。配置一个监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParam = new HashMap<>();
        initParam.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,*.jsp,/druid/*,/download/*");
        filterRegistrationBean.setInitParameters(initParam);
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }

}
