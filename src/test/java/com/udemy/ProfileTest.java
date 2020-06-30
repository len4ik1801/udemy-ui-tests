package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemy.testdata.UserData.createdUser;
import static com.udemy.testdata.UserData.premiumUser;

public class ProfileTest extends TestBase{
    @Test(description = "Change profile data")
    public void checkProfileDataAfterEdit(){
        homePage.openHomePage();
        homePage.openLoginPopup();
        driver.manage().addCookie(premiumUser.getCookie());
        driver.navigate().refresh();
        pause(4000);
        homePage.navigateToProfileSettings();
        homePage.enterLastNameInProfile("Sokur")
                .clickSaveBtnInProfile();
        Assert.assertEquals(homePage.getLastNameFromProfile(), "Lena111 Sokur");
    }
}
