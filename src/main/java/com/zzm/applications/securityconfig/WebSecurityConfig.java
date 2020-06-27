package com.zzm.applications.securityconfig;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <b>Description</b>  WebSecurityConfiguration  起初为了解决与 Druid的csrf的冲突
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 01:15
 * @Info WebSecurityConfiguration
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
//                .antMatchers("/hello").hasRole("USER")
                .and()
                //.csrf().disable() //关闭CSRF
                .csrf().ignoringAntMatchers("/druid/*");
        System.out.println("***********************来了！！");
        //开启登陆功能
        http.formLogin().usernameParameter("_userName").passwordParameter("_password").loginPage("/index.html");//定制登陆页
        //1. /login 来到登陆页。
        //2。 登陆失败，去。/login?error表示失败
        //3。
        //4。默认post形式的 /login代表处理登陆。
        //5。一旦定制login page，那么 login page 的post  请求就是登陆

        //开启logout
        http.logout().logoutSuccessUrl("/");//注销成功后去首页
        //1.访问logout，清除session

        //开启记住我功能
        http.rememberMe().rememberMeParameter("remember");// 定制checkbox的name
        //登陆成功后 ，将cookie发给浏览器，点击注销后，会删除cookies
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("user1").password("password1").roles("USER2");

    }
}
