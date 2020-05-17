package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Random;



public class RegistrationTest extends TestBase {

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



        driver.get("https://www.udemy.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationBtnLocator));
        WebElement registrationBtn = driver.findElement(registrationBtnLocator);
        registrationBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopUpTitleLocator));
        WebElement signUpPopUpTitle = driver.findElement(signUpPopUpTitleLocator);
        Assert.assertEquals(signUpPopUpTitle.getText(), "Sign Up and Start Learning!");

        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameFldLocator));
        WebElement fullNameFld = driver.findElement(fullNameFldLocator);
        fullNameFld.sendKeys( "lena" + System.currentTimeMillis());

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys("lena"+ System.currentTimeMillis() + "@appcreative.net");

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys("Udemy123Ud");

        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxYesLocator));
        WebElement checkBoxYes = driver.findElement(checkBoxYesLocator);
        checkBoxYes.click();


        WebElement signUpBtn = driver.findElement(signUpBtnLocator);
        wait.until(ExpectedConditions.elementToBeClickable(signUpBtnLocator));
        signUpBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(myCoursesLinkLocator));
        WebElement myCoursesLink = driver.findElement(myCoursesLinkLocator);
        Assert.assertEquals(myCoursesLink.getText(), "My courses");


    }
    private void pause(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}