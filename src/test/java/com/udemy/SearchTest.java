package com.udemy;

import com.udemy.pages.CoursesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
    @Test(description = "Search test")
    public void searchDataTest() {
        homePage.openHomePage();
        homePage.enterSearchWord("Angular");
        homePage.clickSearchBtn();
        Assert.assertTrue(coursesPage.checkThatCurrentUrlContainsText());
        coursesPage.checkSearchResultsText();
        Assert.assertTrue(coursesPage.checkSearchResultsText().contains("angular"));
        coursesPage.headerSearchFieldText();
        Assert.assertFalse(coursesPage.headerSearchFieldText().contains("angular"));
        coursesPage.checkFirstResultsHaveAngularText();
        Assert.assertTrue(coursesPage.checkFirstResultsHaveAngularText().contains("Angular"));
    }
}
