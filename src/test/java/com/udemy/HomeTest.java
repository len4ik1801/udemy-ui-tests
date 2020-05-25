package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.HomeMenuConst.CATEGORIES_NAMES;

public class HomeTest extends TestBase{

    @Test(description = "CheckCategoriesList")
    public void checkCategoriesList(){
        homePage.openHomePage();
        homePage.openCategoriesList();
        homePage.checkListOfCategories();
        Assert.assertEquals(homePage.checkListOfCategories(),CATEGORIES_NAMES);
    }
}
