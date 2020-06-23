package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
    @Test(description = "Search test")
    public void searchDataTest() {
        homePage.openHomePage();
        homePage.enterSearchWord("angular");
//        Assert.assertTrue(coursesPage.checkThatCurrentUrlContainsText().contains("ref=home"));
        coursesPage.checkSearchResultsText();
        Assert.assertTrue(coursesPage.checkSearchResultsText().contains("angular"));
        coursesPage.checkHeaderSearchFieldText();
        Assert.assertFalse(coursesPage.checkHeaderSearchFieldText().contains("angular"));
        coursesPage.getFirstCourseTitle();
        Assert.assertTrue(coursesPage.getFirstCourseTitle().contains("Angular"));
    }
}
