package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private String https;
    private Object body;
    private CharSequence t;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@data-purpose='header-signup' and contains(text(),'Sign Up') or contains(@href,'signup-popup')]")
    private WebElement signUpBtn;
    @FindBy(xpath = "//*[@data-purpose='header-login' or contains(text(),'Log in')]")
    private WebElement loginBtn;
    @FindAll({
            @FindBy(xpath = "//*[@id='u55-search-form-autocomplete--4']"),
            @FindBy(xpath = "//*[@placeholder='Search for anything']")
    })
    private WebElement homeSearchField;

    @FindBy(xpath = "//*[@class='udi udi-explore' or @class='udlite-text-sm header--dropdown-button-text--2jtIM'and contains(text(),'Categories')]")
    private WebElement categoriesMenu;
    @FindBy(xpath = "(//ul[contains(@class,'dropdown-menu__list dropdown-menu__list--level-one') or contains(@class,'list-menu--section')])[1]")
    private List<WebElement> listOfCategories;
    @FindBy(xpath = "//div[contains(@class,'header--gap-xxs--2u1SO list-menu--list-menu--1IWp4') or @class='user-avatar__inner fx-c']")
    private WebElement profileIcon;
    @FindBy(xpath = "//*[@class='udlite-text-xs user-profile-dropdown--email--x0zzy' or @class='a11 text-midnight-lighter ellipsis']")
    private WebElement profileEmail;
    @FindBy(xpath = "//*[@data-purpose='header' or @class='c_header__inner']//a[.='Udemy for Business']")
    private WebElement udemyForBusinessLink;
    @FindBy(xpath = "//*[@data-purpose='header' or @class='c_header__inner']//a[.='Teach on Udemy']")
    private WebElement teachOnUdemyLink;


    By signUpBtnLocator = By.xpath("//*[@data-purpose='header-signup' and contains(text(),'Sign Up') or contains(@href,'signup-popup')]");
    By loginBtnLocator = By.xpath("//*[@data-purpose='header-login' or contains(text(),'Log in')]");
    By homeSearchFieldLocator = By.xpath("//input[@id='search-field-home' or @placeholder='Search for anything']");
    By categoriesMenuLocator = By.xpath("//*[@class='udi udi-explore' or @class='udlite-text-sm header--dropdown-button-text--2jtIM'and contains(text(),'Categories')]");
    By listOfCategoriesLocator = By.xpath("(//ul[contains(@class,'dropdown-menu__list dropdown-menu__list--level-one') or contains(@class,'list-menu--section')])[1]");
    By profileIconLocator = By.xpath("//div[contains(@class,'header--gap-xxs--2u1SO list-menu--list-menu--1IWp4') or @class='user-avatar__inner fx-c']");
    By profileEmailLocator = By.xpath("//*[@class='udlite-text-xs user-profile-dropdown--email--x0zzy' or @class='a11 text-midnight-lighter ellipsis']");
    By udemyForBusinessLinkLocator = By.xpath("//*[@data-purpose='header' or @class='c_header_inner']//a[.='Udemy for Business']");
    By teachOnUdemyLinkLocator = By.xpath("//*[@data-purpose='header' or @class='c_header__inner']//a[.='Teach on Udemy']");


    public void openHomePage() {
        driver.get("https://www.udemy.com/");
    }

    public void openRegistrationPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpBtnLocator));
        signUpBtn.click();
    }

    public void openLoginPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtnLocator));
        loginBtn.click();
    }

    public HomePage enterSearchWord(String searchWord) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeSearchFieldLocator));
        homeSearchField.sendKeys(searchWord);
        homeSearchField.submit();
        return this;
    }

    public void openCategoriesList() {
        categoriesMenu.click();
    }

    public List<String> checkListOfCategories() {
        List<WebElement> categoriesList = driver.findElements(listOfCategoriesLocator);
        List<String> listOfCategoriesNames = new ArrayList<String>();
        for (WebElement namesOfCategory : categoriesList) {
            listOfCategoriesNames.add(namesOfCategory.getText());
        }
        return listOfCategoriesNames;
    }

    public String getUserEmailFromProfile() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileIconLocator));
        actions.moveToElement(profileIcon).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(profileEmailLocator));
        WebElement profileEmailInDropdown = driver.findElement(profileEmailLocator);
        return profileEmailInDropdown.getText();
    }

    public void clickUdemyForBusinessLink() {
        wait.until(ExpectedConditions.elementToBeClickable(udemyForBusinessLink));
        udemyForBusinessLink.click();
    }

    public void moveToTheBusinessTab() {
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void clickTeachOnUdemyLink() {
        wait.until(ExpectedConditions.elementToBeClickable(teachOnUdemyLink));
        teachOnUdemyLink.click();
    }


//    public boolean checkUdemyForBusinessLinkIsDisplay(){
//        try {
//            return new WebDriverWait(driver, 2)
//                    .until(ExpectedConditions.visibilityOfElementLocated(udemyForBusinessLinkLocator)).isDisplayed();
//        }catch (TimeoutException e){
//            return false;
//        }
//
//    }

}
