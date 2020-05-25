package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class LoginPopup {

    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPopup(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    By myCoursesLinkLocator = By.xpath("//a[@data-purpose='my-courses']");

     public LoginPopup loginWithCookies(){
         Cookie cookieSessionId = new Cookie.Builder("dj_session_id","caf307objsyvw1ilbqf2xwv5i2hoot2j")
                 .domain("www.udemy.com")
                 .expiresOn(new Date(2020,06,16))
                 .isHttpOnly(true)
                 .isSecure(false)
                 .path("/")
                 .build();
         driver.manage().addCookie(cookieSessionId);
         driver.navigate().refresh();
         wait.until(ExpectedConditions.visibilityOfElementLocated(myCoursesLinkLocator));
         WebElement myCoursesLink = driver.findElement(myCoursesLinkLocator);
         return this;
     }


}
