package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @FindBy(xpath = "//*[@class='dropdown--ufb zero-state dropdown--open-on-hover dropdown' or @class='header--gap-sm--2PR4A header--try-ufb--1kzro udlite-popover-open popover--popover--t3rNO popover--popover-hover--14ngr']")
    private WebElement udemyForBusinessLink;
    @FindBy(xpath = "//*[@class='dropdown--open-on-hover dropdown--instructor zero-state dropdown--open-on-hover dropdown' or  contains(@id,'u100-popover-trigger--50')]")
    private WebElement teachOnUdemyLink;


    By signUpBtnLocator = By.xpath("//*[@data-purpose='header-signup' and contains(text(),'Sign Up') or contains(@href,'signup-popup')]");
    By loginBtnLocator = By.xpath("//*[@data-purpose='header-login' or contains(text(),'Log in')]");
    By homeSearchFieldLocator = By.xpath("//input[@id='search-field-home' or @placeholder='Search for anything']");
    By categoriesMenuLocator = By.xpath("//*[@class='udi udi-explore' or @class='udlite-text-sm header--dropdown-button-text--2jtIM'and contains(text(),'Categories')]");
    By listOfCategoriesLocator = By.xpath("(//ul[contains(@class,'dropdown-menu__list dropdown-menu__list--level-one') or contains(@class,'list-menu--section')])[1]");
    By profileIconLocator = By.xpath("//div[contains(@class,'header--gap-xxs--2u1SO list-menu--list-menu--1IWp4') or @class='user-avatar__inner fx-c']");
    By profileEmailLocator = By.xpath("//*[@class='udlite-text-xs user-profile-dropdown--email--x0zzy' or @class='a11 text-midnight-lighter ellipsis']");
    By udemyForBusinessLinkLocator = By.xpath("//*[@class='dropdown--ufb zero-state dropdown--open-on-hover dropdown' or @class='header--gap-sm--2PR4A header--try-ufb--1kzro udlite-popover-open popover--popover--t3rNO popover--popover-hover--14ngr']");
    By teachOnUdemyLinkLocator = By.xpath("//*[@class='dropdown--open-on-hover dropdown--instructor zero-state dropdown--open-on-hover dropdown' or  contains(@id,'u100-popover-trigger--50')]");


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
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileIconLocator));
        actions.moveToElement(profileIcon).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileEmailLocator));
        WebElement profileEmailInDropdown = driver.findElement(profileEmailLocator);
        return profileEmailInDropdown.getText();
    }

    public void clickUdemyForBusinessLink() {
        wait.until(ExpectedConditions.elementToBeClickable(udemyForBusinessLink));
        udemyForBusinessLink.click();
    }

    public void moveToTheBusinessTab() {
        Actions action = new Actions(driver);
        action.keyDown(Keys.COMMAND).sendKeys(Keys.TAB).build().perform();

    }
    public void clickTeachOnUdemyLink(){
        wait.until(ExpectedConditions.elementToBeClickable(teachOnUdemyLink));
        teachOnUdemyLink.click();
    }
    public void moveToTheTeachTab() {
        Actions action = new Actions(driver);
        action.keyDown(Keys.COMMAND).sendKeys(Keys.TAB).build().perform();

    }




}
