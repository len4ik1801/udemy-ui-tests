package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CoursesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By searchResultsLocator = By.xpath("//h1[@class='udlite-heading-xxl']");
    By searchAutoCompleteLocator = By.xpath("//input[@value = 'Angular']");
    By firstItemSearchResultsLocator = By.xpath("//div[contains(text(),'Angular - The Complete Guide (2020 Edition)')]/ancestor::div[@class='popover--popover--t3rNO popover--popover-hover--14ngr']");


    public CoursesPage checkCurrentUrl() {
        driver.getCurrentUrl().contains("ref=home");
        return this;
    }

    public String checkSearchResultsText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsLocator));
        WebElement searchResultText = driver.findElement(searchResultsLocator);
        return searchResultText.getText();
    }

    public String headerSearchFieldText() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchAutoCompleteLocator));
        WebElement searchFieldText = driver.findElement(searchAutoCompleteLocator);
        return searchFieldText.getAttribute("value");
    }
    public String checkFirstResultsHaveAngularText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemSearchResultsLocator));
        WebElement searchResultsFirstItem = driver.findElement(firstItemSearchResultsLocator);
        return searchResultsFirstItem.getText();

    }


}
