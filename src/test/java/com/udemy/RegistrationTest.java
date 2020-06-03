package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemy.testdata.UserData.newUser;
import static constants.HomeMenuConst.SIGN_UP_POPUP_TITLE;


public class RegistrationTest extends TestBase {


    @Test(description = "Registration with valid credentials")
    public void registrationWithValidCredentials() {
        homePage.openHomePage();
        homePage.openRegistrationPopup();
        Assert.assertEquals(registrationPopup.getPopupTitle(), SIGN_UP_POPUP_TITLE);
        registrationPopup.enterFullName(newUser.getName())
        .enterEmail(newUser.getEmail())
        .enterPassword(newUser.getPassword())
        .fillCheckBox()
        .clickSignUpBtn();
        Assert.assertEquals(homePageForLoginedUser.getNameSymbol(), "L");
    }

}