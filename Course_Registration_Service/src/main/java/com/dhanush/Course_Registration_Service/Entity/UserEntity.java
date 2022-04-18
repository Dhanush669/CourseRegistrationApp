package com.dhanush.Course_Registration_Service.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity(name="UserDetails")
public class UserEntity {
    private String fname,lname;
    String password;
    String mailid;
    @Transient
    private String confirmpassword;
    
    long phno;
    @Id
    @GeneratedValue
    private int id;

    

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    public long getPhno() {
        return phno;
    }

    public void setPhno(long phno) {
        this.phno = phno;
    }

    
    
}
