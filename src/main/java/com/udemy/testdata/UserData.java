package com.udemy.testdata;

import com.udemy.models.User;
import org.openqa.selenium.Cookie;

import java.util.Date;

public interface UserData {

    User newUser = new User()
            .setName("lena" + System.currentTimeMillis())
            .setEmail("lena"+ System.currentTimeMillis() + "@appcreative.net")
            .setPassword("Qwerty123Ud")
            .setUserIcon("L");


    Cookie cookie = new Cookie.Builder("dj_session_id","wn7b3fge8dl9uaw369h5ulrnngqan2cb")
            .domain("www.udemy.com")
            .expiresOn(new Date(2020,07,24))
            .isHttpOnly(true)
            .isSecure(false)
            .path("/")
            .build();

    User createdUser = new User()
            .setCookie(cookie)
            .setEmail("lena233@appcreative.net")
            .setPassword("Udemy123Ud")
            .setName("lena233");

    Cookie cookie2 = new Cookie.Builder("dj_session_id","rbggoemvck0zoohgwp81mrwwjqtth6x9")
            .domain("www.udemy.com")
            .expiresOn(new Date(2020,07,30))
            .isHttpOnly(true)
            .isSecure(false)
            .path("/")
            .build();

    User premiumUser = new User()
            .setCookie(cookie2)
            .setEmail("lena111@appcreative.net")
            .setPassword("Udemy123Ud")
            .setName("lena111");

}
