package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TeachOnUdemyPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public TeachOnUdemyPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//h1[@class='text-shadow' or contains(text(),'Make a global impact')]")
    private WebElement teachPageText;

    By teachPageTextLocator = By.xpath("//h1[@class='text-shadow' or contains(text(),'Make a global impact')]");

    public String getTeachPageText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(teachPageTextLocator));
        return teachPageText.getText();
    }
    public String checkThatCurrentUrlContainsText() {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        return driver.getCurrentUrl();
    }
}
