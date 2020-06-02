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
    By popupTitleLocator = By.xpath("//div[@class='loginbox-v4__header']");
    By emailFieldLocator = By.xpath("//input[@name='email']");
    By passwordFldLocator = By.xpath("//input[@name='password']");
    By loginBtnLocator = By.xpath("//input[@name='submit']");
    By profileIconLocator = By.xpath("//span[text()='L']");

     public LoginPopup loginWithCookies(){
         Cookie cookieSessionId = new Cookie.Builder("dj_session_id","mtvlzd1bs3o7j1qrghclqlgx310pw02v")
                 .domain("www.udemy.com")
                 .expiresOn(new Date(2020,07,02))
                 .isHttpOnly(true)
                 .isSecure(false)
                 .path("/")
                 .build();
         driver.manage().addCookie(cookieSessionId);
         driver.navigate().refresh();
 //        wait.until(ExpectedConditions.visibilityOfElementLocated(profileIconLocator));
 //        WebElement profileIcon = driver.findElement(profileIconLocator);
         return this;
     }
     public String getPopupTitle(){
         wait.until(ExpectedConditions.visibilityOfElementLocated(popupTitleLocator));
         WebElement popUpTitle = driver.findElement(popupTitleLocator);
         return popUpTitle.getText();
     }
     public LoginPopup enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        WebElement emailFld = driver.findElement(emailFieldLocator);
        emailFld.sendKeys(email);
        return this;
    }
    public LoginPopup enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFldLocator));
        WebElement passwordFld = driver.findElement(passwordFldLocator);
        passwordFld.sendKeys(password);
        return this;
    }
    public LoginPopup clickLoginBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtnLocator));
        WebElement loginBtn = driver.findElement(loginBtnLocator);
        loginBtn.click();
        return this;
    }




}
