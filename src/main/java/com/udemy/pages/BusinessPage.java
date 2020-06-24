package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BusinessPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String mainWindowHandle;


    public BusinessPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2/span[@style='font-weight: 400;' and contains(text(),'See why leading organizations choose Udemy for Business as their destination for employee learning')]")
    private WebElement businessPageText;

    By businessPageTextLocator = By.xpath("//h2/span[@style='font-weight: 400;' and contains(text(),'See why leading organizations choose Udemy for Business as their destination for employee learning')]");

    public String checkThatCurrentUrlContainsText() {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        return driver.getCurrentUrl();
    }

    public String getBusinessPageText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(businessPageTextLocator));
        return businessPageText.getText();
    }

        public void returnToPriviousTab(){
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));

        }

}
