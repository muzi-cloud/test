package com.itheima.sercurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpringSecurityUserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       List<GrantedAuthority> list = new ArrayList<>();
       list.add(new SimpleGrantedAuthority("add"));
       list.add(new SimpleGrantedAuthority("delete"));
       list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
       UserDetails user = new User("admin",encoder.encode("admin"),list);
       return user;
    }
}
