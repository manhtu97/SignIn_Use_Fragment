package com.example.admin.bai_tap_3;

import java.io.Serializable;

/**
 * Created by admin on 10/3/2017.
 */

public class Student implements Serializable{
    private String UserName;
    private String Email;
    private String Pass;

    public Student() {
        UserName    = "";
        Email       = "";
        Pass        = "";
    }

    public Student(String userName, String email, String pass) {
        UserName = userName;
        Email = email;
        Pass = pass;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
