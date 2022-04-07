package com.dhanush.Course_Registration_Service.Filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhanush.Course_Registration_Service.Service.MyUserDetailsService;
import com.dhanush.Course_Registration_Service.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class RequestFilter extends OncePerRequestFilter{

    @Autowired
    JwtUtils jwtUtil;

    @Autowired
    MyUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                String jwt=request.getHeader("Authorization");
                String userName=null;

                if(jwt!=null){
                    userName=jwtUtil.extractUserName(jwt);
                }
                if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                    UserDetails userDetails=userDetailsService.loadUserByUsername(userName);
                    if(jwtUtil.validateToken(jwt, userDetails)){
                        UsernamePasswordAuthenticationToken userNamePasswordAuthToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                        userNamePasswordAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthToken);
                    }
                }
                filterChain.doFilter(request, response);
        
    }
    
}
