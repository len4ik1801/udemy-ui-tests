package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;


public class HomePageForLoginedUser {
    private WebDriver driver;
    private WebDriverWait wait;
    public HomePageForLoginedUser(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='L']")
            private WebElement profileIcon;
    By profileIconLocator = By.xpath("//span[text()='L']");


    public String getNameSymbol(){
        wait.until(ExpectedConditions.elementToBeClickable(profileIconLocator));
        Actions action = new Actions (driver);
        return profileIcon.getText();
    }



}
