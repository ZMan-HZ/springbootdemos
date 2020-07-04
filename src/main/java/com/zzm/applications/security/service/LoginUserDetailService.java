package com.zzm.applications.security.service;

import com.zzm.applications.service.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <b>Description</b>  LoginUserDetailService
 *
 * @Author Zhenzhen
 * @Since 2020-07-02 周四 09:46
 * @Info LoginUserDetailService
 */
//@Service
public class LoginUserDetailService implements UserDetailsService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
