package com.udemy.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    public HomePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

//    By registrationBtnLocator = By.xpath("//div[@class='header--gap-xs--1q0SU']/a/span[contains(text(),'Sign up')]");//new design
    By signUpBtnLocator = By.xpath("//button[@data-purpose='header-signup']");//old design
    By loginBtnLocator = By.xpath("//button[@data-purpose='header-login']");
    By searchFldHomeLocator = By.xpath("//input[@placeholder='Search for anything']");//new design
    By homeSearchFieldLocator = By.xpath("//input[@id='search-field-home']"); //old design
    By searchBtnLocator = By.xpath("//button[@type='submit'][1]");//new design
    By searchHomeBtnLocator = By.xpath("//button[@data-purpose='home-search-button']");//old design
    By categoriesDropDownLink = By.xpath("//span[@class='udlite-text-sm header--dropdown-button-text--2jtIM'and contains(text(),'Categories')]");//new design
    By categoriesMenu = By.xpath("//span[@class='udi udi-explore']");//old design
    By categoriesListLocator = By.xpath("//div[@class='js-browse-nav-level-one browse-nav--nav--1WzbY']/ul/li");//new design
    By listOfCategoriesLocator = By.xpath("//ul[@class='dropdown-menu__list dropdown-menu__list--level-one']/li");//ol design


    public void openHomePage(){
        driver.get("https://www.udemy.com/");
    }

    public void openRegistrationPopup(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpBtnLocator));
        WebElement registrationBtn = driver.findElement(signUpBtnLocator);
        registrationBtn.click();
    }
    public void openLoginPopup(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtnLocator));
        WebElement loginBtn = driver.findElement(loginBtnLocator);
        loginBtn.click();
    }
    public HomePage enterSearchWord(String searchWord){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeSearchFieldLocator));
        WebElement searchFld = driver.findElement(homeSearchFieldLocator);
        searchFld.sendKeys(searchWord);
        return this;
    }
    public void clickSearchBtn(){
        WebElement searchBtn = driver.findElement(searchHomeBtnLocator);
        searchBtn.click();
    }
    public void openCategoriesList(){
        WebElement categoriesDropDownIcon = driver.findElement(categoriesMenu);
        categoriesDropDownIcon.click();
    }
    public List<String> checkListOfCategories(){
        List<WebElement> categoriesList = driver.findElements(listOfCategoriesLocator);
        List<String> listOfCategoriesNames = new ArrayList<String>();
        for (WebElement namesOfCategory : categoriesList){
            listOfCategoriesNames.add(namesOfCategory.getText());
        }
        return listOfCategoriesNames;
    }


}
