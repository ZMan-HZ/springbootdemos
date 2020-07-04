package com.zzm.applications.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <b>Description</b>  SysUserDetailService
 *
 * @Author Zhenzhen
 * @Since 2020-07-02 周四 09:46
 * @Info SysUserDetailService
 */
//@Service
public class SysUserDetailService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserDetailService.class);

//    @Autowired
//    private AccountMapper loginMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("用户的用户名: {}", username);
        // TODO 根据用户名，查找到对应的密码，与权限

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        User user = new User(username, "123456",AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}
