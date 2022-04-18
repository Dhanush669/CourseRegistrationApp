package com.dhanush.Course_Registration_Service.Controllers;

import javax.servlet.http.HttpSession;

import com.dhanush.Course_Registration_Service.Entity.UserEntity;
import com.dhanush.Course_Registration_Service.Model.AuthenticationResponse;
import com.dhanush.Course_Registration_Service.Model.LoginData;
import com.dhanush.Course_Registration_Service.Repository.UserRepo;
import com.dhanush.Course_Registration_Service.Service.MyUserDetailsService;
import com.dhanush.Course_Registration_Service.utils.JwtUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    
    
    LoginData loginData=new LoginData();
    
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    MyUserDetailsService myUserDetailsService;
    
    String jwt;
    
    @GetMapping("/authenticate")
    public String authenticate(){
        return "login.jsp";
    }

    //@RequestMapping(value="/userlogin",method=RequestMethod.POST)
    @PostMapping("/userlogin")
    public ResponseEntity<?> logInValidation(@RequestParam(name="userName") String userName, @RequestParam(name="password") String password)throws Exception{
        loginData.setUserName(userName);
        loginData.setPassword(password);
        
        
        UserDetails ud=myUserDetailsService.loadUserByUsername(userName);
        try{
        authManager.authenticate(new UsernamePasswordAuthenticationToken(ud.getUsername(),password));
        }
        catch(BadCredentialsException e){
            throw new Exception("Bad Credentials",e);   
        }
        jwt=jwtUtils.generateJwt(ud);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @RequestMapping("/register")
    public String courseRegistration(){
        return "register.jsp";
    }

    @PostMapping("/registrationdone")
    public ModelAndView successfullRegistration(UserEntity entity){
        ModelAndView modelAndView=new ModelAndView();
        
       
        if(userRepo.findUserBymailid(entity.getMailid())!=null){
            
            modelAndView.addObject("exception", "This email id is already registered");
            modelAndView.setViewName("register.jsp");
            return modelAndView;
        }
        
        BCryptPasswordEncoder bCrypt=new BCryptPasswordEncoder();
        entity.setPassword(bCrypt.encode(entity.getPassword()));
        
        userRepo.save(entity);
        
        modelAndView.addObject("exception","");
        modelAndView.setViewName("successfullRegistration.jsp");
        return modelAndView;
        
    }

    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String goToHome(){
        return "home.jsp";
    }
    
    @GetMapping("/courses")
    public String displayCourses(){
        return "courses.jsp";
    }

//    @RequestMapping("/showdetails")
//    @ResponseBody
//    public String showDetails() {
//        String info;
////        UserEntity uEntity=userRepo.findUserBymailid(loginData.getName());
//        info="First Name: "+uEntity.getFname()+" Last Name: "+uEntity.getLname()+" Email id: "+uEntity.getMailid()+" phno: "+uEntity.getPhno();
//        return info;
//    }

}
