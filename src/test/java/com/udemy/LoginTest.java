package com.udemy;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;


public class LoginTest extends TestBase{
    @Test(description ="Login with valid credentials")
    public void loginWithValidCredentials(){
        By profileIconLocator = By.xpath("//div[@class= 'ud-component--header-v6--user-dropdown-button hidden-xs hidden-xxs']");
        driver.get("https://www.udemy.com/");

        Cookie cookieSessionId = new Cookie.Builder("dj_session_id","caf307objsyvw1ilbqf2xwv5i2hoot2j")
                .domain("www.udemy.com")
                .expiresOn(new Date(2020,06,16))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/www.udemy.com")
                .build();
        driver.manage().addCookie(cookieSessionId);
        driver.get(driver.getCurrentUrl());

        wait.until(ExpectedConditions.visibilityOfElementLocated(profileIconLocator));
        WebElement profileIcon = driver.findElement(profileIconLocator);
        Assert.assertEquals(profileIcon.isDisplayed(), profileIcon);
    }

}