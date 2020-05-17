package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Random;



public class RegistrationTest {

    @Test(description = "Registration with valid credentials")
    public void registrationWithValidCredentials() {
        By registrationBtnLocator = By.xpath("//button[@data-purpose='header-signup']");
        By signUpPopUpTitleLocator = By.xpath("//div[@class=' loginbox-v4__header loginbox-v4__header--signup']");
        By fullNameFldLocator = By.id("id_fullname");
        By emailFieldLocator = By.id("email--1");
        By passwordFieldLocator = By.id("password");
        By checkBoxYesLocator = By.xpath("//span[@class='checkbox-label']");
        By signUpBtnLocator = By.id("submit-id-submit");
        By myCoursesLinkLocator = By.xpath("//a[@data-purpose='my-courses']");

        File chromeDriver = new File("src/main/resources/chromedriver");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        WebDriver driver = new ChromeDriver(chromeService);

        driver.get("https://www.udemy.com/");
        pause(4000);

        WebElement registrationBtn = driver.findElement(registrationBtnLocator);
        registrationBtn.click();
        pause(2000);

        WebElement signUpPopUpTitle = driver.findElement(signUpPopUpTitleLocator);
        Assert.assertEquals(signUpPopUpTitle.getText(), "Sign Up and Start Learning!");
        pause(2000);

        WebElement fullNameFld = driver.findElement(fullNameFldLocator);
        fullNameFld.sendKeys( "lena" + System.currentTimeMillis());
        pause(2000);

        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys("lena"+ System.currentTimeMillis() + "@appcreative.net");
        pause(2000);

        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys("Udemy123Ud");
        pause(2000);

        WebElement checkBoxYes = driver.findElement(checkBoxYesLocator);
        checkBoxYes.click();
        pause(3000);

        WebElement signUpBtn = driver.findElement(signUpBtnLocator);
        signUpBtn.click();
        pause(3000);

        WebElement myCoursesLink = driver.findElement(myCoursesLinkLocator);
        Assert.assertEquals(myCoursesLink.getText(), "My courses");
        pause(3000);
        driver.quit();
    }
    private void pause(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}