package com.dhanush.Course_Registration_Service.Model;

import java.util.Collection;
import java.util.Collections;

import com.dhanush.Course_Registration_Service.Entity.UserEntity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{

    private UserEntity userEntity;

    public MyUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        //return Collections.singleton(new SimpleGrantedAuthority("USER"));
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userEntity.getMailid();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
