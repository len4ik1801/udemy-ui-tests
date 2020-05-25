package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage<listOfCategoriesLocator> {
    private WebDriver driver;
    private WebDriverWait wait;
    public HomePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By registrationBtnLocator = By.xpath("//button[@data-purpose='header-signup']");
    By searchFldHomeLocator = By.xpath("//input[@id='search-field-home']");
    By searchBtnLocator = By.xpath("//button[@data-purpose='home-search-button']");
    By categoriesDropDown = By.xpath("//span[@class='udi udi-explore']");
    By listOfCategoriesLocator = By.xpath("//ul[@class='dropdown-menu__list dropdown-menu__list--level-one']/li");


    public void openHomePage(){
        driver.get("https://www.udemy.com/");
    }
    public void openRegistrationPopup(){
        wait.until(ExpectedConditions.elementToBeClickable(registrationBtnLocator));
        WebElement registrationBtn = driver.findElement(registrationBtnLocator);
        registrationBtn.click();
    }
    public HomePage enterSearchWord(String searchWord){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFldHomeLocator));
        WebElement searchFld = driver.findElement(searchFldHomeLocator);
        searchFld.sendKeys(searchWord);
        return this;
    }
    public void clickSearchBtn(){
        WebElement searchBtn = driver.findElement(searchBtnLocator);
        searchBtn.click();
    }
    public void openCategoriesList(){
        WebElement categoriesDropDownIcon = driver.findElement(categoriesDropDown);
        categoriesDropDownIcon.click();
    }
    public List<WebElement> checkListOfCategories(){
        List<WebElement> listOfCategories = driver.findElements(listOfCategoriesLocator);
        for(WebElement categoryNames : listOfCategories){
            categoryNames.getText();
        }
        return listOfCategories;
    }


}
