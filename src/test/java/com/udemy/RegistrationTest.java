package com.udemy;

import com.udemy.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemy.testdata.UserData.createdUser;
import static com.udemy.testdata.UserData.newUser;
import static constants.PopupConst.SIGN_UP_POPUP_TITLE;


public class RegistrationTest extends TestBase {




    @Test(description = "Registration with valid credentials")
    public void registrationWithValidCredentials() {
        homePage.openHomePage();
        homePage.openRegistrationPopup();
        Assert.assertEquals(registrationPopup.getPopupTitle(), SIGN_UP_POPUP_TITLE);
        registrationPopup
                .enterFullName(newUser.getName())
                .enterEmail(newUser.getEmail())
                .enterPassword(newUser.getPassword())
                .fillCheckBox()
                .clickSignUpBtn();
        pause(4000);
        Assert.assertEquals(homePage.getUserEmailFromProfile(), newUser.getEmail());
    }



}