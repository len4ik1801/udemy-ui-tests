package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPopup {
    private WebDriver driver;
    private WebDriverWait wait;
    public RegistrationPopup(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By signUpPopUpTitleLocator = By.xpath("//div[@class=' loginbox-v4__header loginbox-v4__header--signup']");
    By fullNameFldLocator = By.id("id_fullname");
    By emailFieldLocator = By.id("email--1");
    By passwordFieldLocator = By.id("password");
    By checkBoxYesLocator = By.xpath("//span[@class='checkbox-label']");
    By signUpBtnLocator = By.id("submit-id-submit");

    public String getPopupTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopUpTitleLocator));
        WebElement signUpPopUpTitle = driver.findElement(signUpPopUpTitleLocator);
        return signUpPopUpTitle.getText();
    }
    public RegistrationPopup enterFullName(String fullName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameFldLocator));
        WebElement fullNameFld = driver.findElement(fullNameFldLocator);
        fullNameFld.sendKeys( fullName);
        return this;
    }
    public RegistrationPopup enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys(email);
        return this;
    }
    public RegistrationPopup enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(password);
        return this;
    }
    public RegistrationPopup fillCheckBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxYesLocator));
        WebElement checkBoxYes = driver.findElement(checkBoxYesLocator);
        checkBoxYes.click();
        return this;
    }
    public void clickSignUpBtn(){
        WebElement signUpBtn = driver.findElement(signUpBtnLocator);
        wait.until(ExpectedConditions.elementToBeClickable(signUpBtnLocator));
        signUpBtn.click();
    }
}
