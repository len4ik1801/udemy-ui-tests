package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CoursesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CoursesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h1[@class='udlite-heading-xxl']")
    private WebElement searchResults;
    @FindBy(xpath = "//input[@class='udlite-text-input udlite-text-input-small udlite-text-sm udlite-search-form-autocomplete-input js-header-search-field']")
    private WebElement searchAutoComplete;
    @FindBy(xpath = "(//div[contains(text(),'Angular - The Complete Guide (2020 Edition)')]/ancestor::div[@class='popover--popover--t3rNO popover--popover-hover--14ngr']")
    private WebElement firstItemSearchResults;

    By searchResultsLocator = By.xpath("//h1[@class='udlite-heading-xxl']");
    By searchAutoCompleteLocator = By.xpath("//input[@class='udlite-text-input udlite-text-input-small udlite-text-sm udlite-search-form-autocomplete-input js-header-search-field']");
    By firstItemSearchResultsLocator = By.xpath("//div[contains(text(),'Angular - The Complete Guide (2020 Edition)')]/ancestor::div[@class='popover--popover--t3rNO popover--popover-hover--14ngr']");


    public String checkThatCurrentUrlContainsText() {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        return driver.getCurrentUrl();
    }

    public String checkSearchResultsText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsLocator));
        return searchResults.getText();
    }

    public String checkHeaderSearchFieldText() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchAutoCompleteLocator));
        return searchAutoComplete.getText();
    }
    public String getFirstCourseTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemSearchResultsLocator));
        return firstItemSearchResults.getText();

    }


}
