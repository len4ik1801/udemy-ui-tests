package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class LoginPopup {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPopup(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='loginbox-v4__header']")
            private WebElement popupTitle;
    @FindBy(xpath = "//input[@name='email']")
            private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
            private WebElement passwordFld;
    @FindBy(xpath = "//input[@name='submit']")
            private WebElement loginBtn;
    @FindBy(xpath = "//span[text()='L']")
            private WebElement profileIcon;

    By popupTitleLocator = By.xpath("//div[@class='loginbox-v4__header' or contains(text(),' Log In to Your Udemy Account!')]");
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
         return popupTitle.getText();
     }
     public LoginPopup enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        emailField.sendKeys(email);
        return this;
    }
    public LoginPopup enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFldLocator));
        passwordFld.sendKeys(password);
        return this;
    }
    public LoginPopup clickLoginBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtnLocator));
        loginBtn.click();
        return this;
    }




}
