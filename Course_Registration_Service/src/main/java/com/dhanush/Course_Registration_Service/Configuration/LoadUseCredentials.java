package com.dhanush.Course_Registration_Service.Configuration;

import com.dhanush.Course_Registration_Service.Service.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class LoadUseCredentials extends WebSecurityConfigurerAdapter{

    @Autowired
    MyUserDetailsService userDetailsService;
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/home");
        web.ignoring().antMatchers("/userlogin");
        web.ignoring().antMatchers("/register");
        web.ignoring().antMatchers("/registrationdone");
        web.ignoring().antMatchers("/h2-console/**");
    }

    

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http.authorizeRequests()
    //     .antMatchers("/h2-console/**").permitAll()
    //     .anyRequest().authenticated();
    // http.headers().frameOptions().sameOrigin();
    // }



    @Bean
    AuthenticationProvider authProvider(){
        DaoAuthenticationProvider daoAuthProvider=new DaoAuthenticationProvider();
        daoAuthProvider.setUserDetailsService(userDetailsService);
        daoAuthProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthProvider;
    }

    
    
    

}
