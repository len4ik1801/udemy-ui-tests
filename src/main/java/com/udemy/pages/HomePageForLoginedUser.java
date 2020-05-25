package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageForLoginedUser {
    private WebDriver driver;
    private WebDriverWait wait;
    public HomePageForLoginedUser(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    //By profileIconLocator = By.xpath("//div[@class= 'ud-component--header-v6--user-dropdown-button hidden-xs hidden-xxs']");
    By myCoursesLinkLocator = By.xpath("//a[@data-purpose='my-courses']");

    public String getMyCoursesLinkTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(myCoursesLinkLocator));
        WebElement myCoursesLink = driver.findElement(myCoursesLinkLocator);
        return myCoursesLink.getText();

    }


}
