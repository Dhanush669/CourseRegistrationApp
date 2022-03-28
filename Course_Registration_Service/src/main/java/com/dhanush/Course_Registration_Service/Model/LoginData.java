package com.dhanush.Course_Registration_Service.Model;

public class LoginData {
    private String userName , password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public String equals(LoginData loginData){
    //     return "User Name "+loginData.getUserName()+" Password "+loginData.getPassword();
    // }
    

}
