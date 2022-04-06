package com.dhanush.Course_Registration_Service.Service;

import java.util.ArrayList;

import com.dhanush.Course_Registration_Service.Entity.UserEntity;
import com.dhanush.Course_Registration_Service.Model.MyUserDetails;
import com.dhanush.Course_Registration_Service.Repository.UserRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{


    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String mailid) throws UsernameNotFoundException {
        UserEntity userEntity=userRepo.findUserBymailid(mailid);
        if(userEntity==null){
            throw new UsernameNotFoundException("invalid email id");
        }
        // MyUserDetails userDetails=new MyUserDetails(userEntity);
        User user =new User(userEntity.getMailid(),userEntity.getPassword(),new ArrayList<>());
        System.out.println(userEntity.getPassword());
        return user;
    }
    
}
