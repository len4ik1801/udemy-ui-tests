package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;




public class RegistrationTest extends TestBase {


    @Test(description = "Registration with valid credentials")
    public void registrationWithValidCredentials() {
        homePage.openHomePage();
        homePage.openRegistrationPopup();
        Assert.assertEquals(registrationPopup.getPopupTitle(), "Sign Up and Start Learning!");
        registrationPopup
                .enterFullName("lena" + System.currentTimeMillis())
        .enterEmail("lena"+ System.currentTimeMillis() + "@appcreative.net")
        .enterPassword("Udemy123Ud")
        .fillCheckBox()
        .clickSignUpBtn();
        homePageForLoginedUser.getMyCoursesLinkTitle();
        Assert.assertEquals(homePageForLoginedUser.getMyCoursesLinkTitle(), "My courses");
    }

}