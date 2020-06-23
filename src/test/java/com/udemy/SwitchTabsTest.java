package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.TabsConst.TEACH_PAGE_TEXT;

public class SwitchTabsTest extends TestBase{


    @Test(description = "Switch tabs test")
    public void switchTabsTest(){
        homePage.openHomePage();
        homePage.clickUdemyForBusinessLink();
        homePage.moveToTheBusinessTab();
        Assert.assertTrue(businessPage.getBusinessPageText().contains("See why leading organizations choose Udemy for Business as their destination for employee learning"));
        Assert.assertTrue(businessPage.checkThatCurrentUrlContainsText().contains("business"));
        pause(4000);
        businessPage.returnToPriviousTab();
        homePage.clickTeachOnUdemyLink();
        Assert.assertEquals(teachOnUdemyPage.getTeachPageText(),TEACH_PAGE_TEXT);
        Assert.assertTrue(teachOnUdemyPage.checkThatCurrentUrlContainsText().contains("teaching"));





    }
}
