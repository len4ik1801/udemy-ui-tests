package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPopup {
    private WebDriver driver;
    private WebDriverWait wait;
    public RegistrationPopup(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=' loginbox-v4__header loginbox-v4__header--signup']")
            private WebElement signUpPopUpTitle;
    @FindBy(id = "id_fullname")
            private WebElement fullNameFld;
    @FindBy(id = "email--1")
            private WebElement emailField;
    @FindBy(id = "password")
            private WebElement passwordField;
    @FindBy(xpath = "//span[@class='checkbox-label']")
            private WebElement checkBoxYes;
    @FindBy(id = "submit-id-submit")
            private WebElement signUpBtn;

    By signUpPopUpTitleLocator = By.xpath("//div[@class=' loginbox-v4__header loginbox-v4__header--signup']");
    By fullNameFldLocator = By.id("id_fullname");
    By emailFieldLocator = By.id("email--1");
    By passwordFieldLocator = By.id("password");
    By checkBoxYesLocator = By.xpath("//span[@class='checkbox-label']");
    By signUpBtnLocator = By.id("submit-id-submit");

    public String getPopupTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopUpTitleLocator));
        return signUpPopUpTitle.getText();
    }
    public RegistrationPopup enterFullName(String fullName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameFldLocator));
        fullNameFld.sendKeys( fullName);
        return this;
    }
    public RegistrationPopup enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        emailField.sendKeys(email);
        return this;
    }
    public RegistrationPopup enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        passwordField.sendKeys(password);
        return this;
    }
    public RegistrationPopup fillCheckBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxYesLocator));
        checkBoxYes.click();
        return this;
    }
    public void clickSignUpBtn(){
        signUpBtn.click();
    }
}
