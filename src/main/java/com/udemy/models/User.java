package com.udemy.models;

import org.openqa.selenium.Cookie;

public class User {
    private String name;
    private String email;
    private String password;
    private String UserIcon;
    private Cookie cookie;

    public User(){}


    public User setName(String name){
        this.name = name;
        return this;
    }
    public User setCookie(Cookie cookie){
        this.cookie = cookie;
        return this;
    }
    public User setEmail(String email){
        this.email = email;
        return this;
    }
    public User setPassword(String password){
        this.password = password;
        return this;
    }
    public User setUserIcon(String newUserIcon){
        this.UserIcon = newUserIcon;
        return this;
    }
    public Cookie getCookie(){return cookie;}
    public String getUserLbl(){return UserIcon;}
    public String getName(){return name;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
}
