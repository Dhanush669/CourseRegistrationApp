package com.dhanush.Course_Registration_Service.Controllers;

import javax.servlet.http.HttpSession;

import com.dhanush.Course_Registration_Service.Entity.UserEntity;
import com.dhanush.Course_Registration_Service.Model.AuthenticationResponse;
import com.dhanush.Course_Registration_Service.Model.LoginData;
import com.dhanush.Course_Registration_Service.Repository.UserRepo;
import com.dhanush.Course_Registration_Service.Service.MyUserDetailsService;
import com.dhanush.Course_Registration_Service.utils.JwtUtils;


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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value="/userlogin",method=RequestMethod.POST)
    public ResponseEntity<?> logInValidation(@RequestBody LoginData loginData)throws Exception{
        String jwt;
        UserDetails ud=myUserDetailsService.loadUserByUsername(loginData.getUserName());
        
        try{
        authManager.authenticate(new UsernamePasswordAuthenticationToken(ud.getUsername(),loginData.getPassword()));
        }
        catch(BadCredentialsException e){
            System.out.println(ud.getUsername()+" adsfsda");
            throw new Exception("Bad Credentials",e);
            
        }
        jwt=jwtUtils.generateJwt(ud);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @RequestMapping("/register")
    public String courseRegistration(){
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
        System.out.println("asdfsadf adfldasjfjsldajfkljsa;kldfj;klsajd");
        return "home.jsp";
    }

    @RequestMapping("/showdetails")
    @ResponseBody
    public String showDetails(Authentication loginData) {
        String info;
        UserEntity uEntity=userRepo.findUserBymailid(loginData.getName());
        info="First Name: "+uEntity.getFname()+" Last Name: "+uEntity.getLname()+" Enail id: "+uEntity.getMailid()+" phno: "+uEntity.getPhno();
        return info;
    }

}
