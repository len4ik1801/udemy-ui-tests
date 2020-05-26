package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CoursesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CoursesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By searchResultsLocator = By.xpath("//h1[@class='udlite-heading-xxl']");
    By searchAutoCompleteLocator = By.xpath("//input[@class='udlite-text-input udlite-text-input-small udlite-text-sm udlite-search-form-autocomplete-input js-header-search-field']");
    By firstItemSearchResultsLocator = By.xpath("(//div[@class='course-card--main-content--3xEIw']/div)[1]");


    public boolean checkThatCurrentUrlContainsText() {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
       return driver.getCurrentUrl().contains("ref=home");
    }

    public String checkSearchResultsText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsLocator));
        WebElement searchResultText = driver.findElement(searchResultsLocator);
        return searchResultText.getText();
    }

    public String headerSearchFieldText() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchAutoCompleteLocator));
        WebElement searchFieldText = driver.findElement(searchAutoCompleteLocator);
        return searchFieldText.getText();
    }
    public String checkFirstResultsHaveAngularText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemSearchResultsLocator));
        WebElement searchResultsFirstItem = driver.findElement(firstItemSearchResultsLocator);
        return searchResultsFirstItem.getText();

    }


}
