package com.dhanush.Course_Registration_Service.Controllers;

import javax.servlet.http.HttpSession;

import com.dhanush.Course_Registration_Service.Entity.UserEntity;
import com.dhanush.Course_Registration_Service.Repository.UserRepo;
import com.dhanush.Course_Registration_Service.Service.MyUserDetailsService;
import com.dhanush.Course_Registration_Service.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @RequestMapping("/userlogin")
    public String logInValidation(){
        System.out.println("hey iam log in");
        return "login.jsp";
    }

    @RequestMapping("/register")
    public String courseRegistration(UserEntity entity){
        return "register.jsp";
    }

    @RequestMapping("/registrationdone")
    public String successfullRegistration(UserEntity entity,HttpSession session){
        if(entity.getFname()==null && entity.getLname()==null && entity.getMailid()==null && entity.getPassword()==null && entity.getConfirmpassword()==null){
            session.setAttribute("name", "some fields are missing");
            return "register.jsp";
        }
        if(!entity.getPassword().equals(entity.getConfirmpassword())){
            session.setAttribute("name", "passwords doesn't match");
            return "register.jsp";
        }
        
        BCryptPasswordEncoder bCrypt=new BCryptPasswordEncoder();
        entity.setPassword(bCrypt.encode(entity.getPassword()));
        
        userRepo.save(entity);
        return "successfullRegistration.jsp";
        
    }

    @RequestMapping("/home")
    public String goToHome(){
        System.out.println("asdfsadf");
        return "home.jsp";
    }

    @RequestMapping("/showdetails")
    @ResponseBody
    public String showDetails(Authentication loginData) throws Exception{
        String jwt;
        UserDetails ud=myUserDetailsService.loadUserByUsername(loginData.getName());
        System.out.println(ud.getUsername());
        try{
        authManager.authenticate(new UsernamePasswordAuthenticationToken(ud.getUsername(),ud.getPassword()));
        }
        catch(BadCredentialsException e){
            System.out.println(ud.getUsername()+"sadfsad");
            throw new Exception("Bad Credentials",e);
            
        }
        jwt=jwtUtils.generateJwt(ud);
        return jwt;
    }

}
