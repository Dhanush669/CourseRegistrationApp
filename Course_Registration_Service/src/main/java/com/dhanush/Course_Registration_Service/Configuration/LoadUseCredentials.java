package com.dhanush.Course_Registration_Service.Configuration;

import com.dhanush.Course_Registration_Service.Service.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class LoadUseCredentials extends WebSecurityConfigurerAdapter{

    @Autowired
    MyUserDetailsService userDetailsService;
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/home");
        web.ignoring().antMatchers("/userlogin");
        web.ignoring().antMatchers("/register");
        web.ignoring().antMatchers("/registrationdone");
    }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
	// 		.csrf().disable()
	// 		.authorizeRequests().antMatchers("/login").permitAll()
	// 		.anyRequest().authenticated()
	// 		.and()
	// 		.formLogin()
	// 		.loginPage("/login").permitAll()
	// 		.and()
	// 		.logout().invalidateHttpSession(true)
	// 		.clearAuthentication(true)
	// 		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	// 		.logoutSuccessUrl("/logout-success").permitAll();
    // }

    // @Bean
    // AuthenticationProvider authProvider(){
    //     DaoAuthenticationProvider daoAuthProvider=new DaoAuthenticationProvider();
    //     daoAuthProvider.setUserDetailsService(userDetailsService);
    //     daoAuthProvider.setPasswordEncoder(new BCryptPasswordEncoder());
    //     return daoAuthProvider;
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }




    
    

    
    
    

}
