package com.dhanush.Course_Registration_Service.Controllers;

import javax.servlet.http.HttpSession;

import com.dhanush.Course_Registration_Service.Entity.UserEntity;
import com.dhanush.Course_Registration_Service.Model.LoginData;
import com.dhanush.Course_Registration_Service.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    
    @Autowired
    UserRepo userRepo;

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
    public String goToHome(LoginData loginData){
        //for testing 
        if(loginData.getUserName()!=null && loginData.getUserName().equals(loginData.getPassword())){
            return "invalidUser.jsp";
        }
        return "home.jsp";
    }

    @RequestMapping("/showdetails")
    @ResponseBody
    public String showDetails(Authentication auth){
        String info;
        UserEntity user=userRepo.findUserBymailid(auth.getName());
        info="First Name: "+user.getFname()+"\nLast Name: "+user.getLname()+"\nEmail id: "+user.getMailid()+"\nPhone No. "+user.getPhno();
        return info;
    }

}
