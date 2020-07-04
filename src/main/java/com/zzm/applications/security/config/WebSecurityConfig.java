package com.zzm.applications.security.config;

import com.zzm.applications.security.service.SysUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <b>Description</b>  WebSecurityConfiguration  起初为了解决与 Druid的csrf的冲突
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 01:15
 * @Info WebSecurityConfiguration
 */

@Configuration
@EnableWebSecurity //此注解已包含@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .anyRequest().authenticated()
                .and()
                //.formLogin().and()
                .httpBasic();
    }


    /*@Autowired
    private SysUserDetailService sysUserDetailService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    *//*   @Bean
       public LoginFilter loginFilter() throws Exception {
           LoginFilter loginFilter = new LoginFilter();
           loginFilter.setFilterProcessesUrl("/doLogin");
           loginFilter.setAuthenticationManager(authenticationManagerBean());
           //需要设置回调
           loginFilter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
               @Override
               public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
               }
           });
           loginFilter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
               @Override
               public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

               }
           });

           return loginFilter;
       }
   *//*
    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/login", "/css/**", "/js/**", "/img/**", "/images/**", "/fonts/", "/favicon.ico");
        //添加不需要拦截的页面
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .and()
                .csrf().ignoringAntMatchers("/druid/*");
        //.csrf().disable() //关闭CSRF
        System.out.println("***********************来了！！");
        //开启登陆功能
//        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/login");//定制登陆页
        //1. /login 来到登陆页。
        //2。 登陆失败，去。/login?error表示失败
        //3。
        //4。默认post形式的 /login代表处理登陆。
        //5。一旦定制login page，那么 login page 的post  请求就是登陆

        //开启logout
//        http.logout().logoutSuccessUrl("/");//注销成功后去首页
        //1.访问logout，清除session

        //开启记住我功能
//        http.rememberMe().rememberMeParameter("remember");// 定制checkbox的name
        //登陆成功后 ，将cookie发给浏览器，点击注销后，会删除cookies
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
 *//*       auth.inMemoryAuthentication()
                .withUser("user").password("123").roles("USER")
                .and()
                .withUser("user1").password("password1").roles("USER2");

        auth.jdbcAuthentication().authoritiesByUsernameQuery("").dataSource(dataSource)
                .withUser("").password("").roles("");*//*
//        auth.userDetailsService(sysUserDetailService);

    }*/


}
