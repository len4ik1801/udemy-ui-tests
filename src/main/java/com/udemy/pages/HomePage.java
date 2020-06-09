package com.udemy.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@data-purpose='header-signup' and contains(text(),'Sign Up')] or //span[contains(text(),'Sign up')]")
    private WebElement signUpBtn;
    @FindBy(xpath = "//button[@data-purpose='header-login']")
            private WebElement loginBtn;
    @FindAll({
            @FindBy(xpath = "//input[@id='search-field-home'])"),
            @FindBy(xpath = "//input[@placeholder='Search for anything']")
    })
            private WebElement homeSearchField;
    @FindBy(xpath = "//button[@data-purpose='home-search-button'] or //button[@type='submit'][1]")
            private WebElement searchHomeBtn;
    @FindBy(xpath = "//span[@class='udi udi-explore'] or //span[@class='udlite-text-sm header--dropdown-button-text--2jtIM'and contains(text(),'Categories')]")
            private WebElement categoriesMenu;
    @FindBy(xpath = "//ul[@class='dropdown-menu__list dropdown-menu__list--level-one']/li or //div[@class='js-browse-nav-level-one browse-nav--nav--1WzbY']/ul/li")
            private List<WebElement> listOfCategories;

    By signUpBtnLocator = By.xpath("//button[@data-purpose='header-signup'] or //span[contains(text(), 'Sign up')]");
    By loginBtnLocator = By.xpath("//button[@data-purpose='header-login']");
    By homeSearchFieldLocator = By.xpath("//input[@id='search-field-home'] or //input[@placeholder='Search for anything']");
    By searchHomeBtnLocator = By.xpath("//button[@data-purpose='home-search-button'] or //button[@type='submit'][1]");
    By categoriesMenuLocator = By.xpath("//span[@class='udi udi-explore'] or //span[@class='udlite-text-sm header--dropdown-button-text--2jtIM'and contains(text(),'Categories')]");
    By listOfCategoriesLocator = By.xpath("//ul[@class='dropdown-menu__list dropdown-menu__list--level-one']/li or //div[@class='js-browse-nav-level-one browse-nav--nav--1WzbY']/ul/li");


    public void openHomePage(){
        driver.get("https://www.udemy.com/");
    }

    public void openRegistrationPopup(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpBtnLocator));
        signUpBtn.click();
    }
    public void openLoginPopup(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtnLocator));
        loginBtn.click();
    }
    public HomePage enterSearchWord(String searchWord){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeSearchFieldLocator));
        homeSearchField.sendKeys(searchWord);
        return this;
    }
    public void clickSearchBtn(){
        searchHomeBtn.click();
    }
    public void openCategoriesList(){
        categoriesMenu.click();
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
