package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemy.testdata.UserData.newUser;


public class RegistrationTest extends TestBase {


    @Test(description = "Registration with valid credentials")
    public void registrationWithValidCredentials() {
        homePage.openHomePage();
        homePage.openRegistrationPopup();
        Assert.assertEquals(registrationPopup.getPopupTitle(), "Sign Up and Start Learning!");
        registrationPopup.enterFullName(newUser.getName())
        .enterEmail(newUser.getEmail())
        .enterPassword(newUser.getPassword())
        .fillCheckBox()
        .clickSignUpBtn();
        homePageForLoginedUser.getNameSymbol();
        Assert.assertEquals(homePageForLoginedUser.getNameSymbol(), "L");
    }

}