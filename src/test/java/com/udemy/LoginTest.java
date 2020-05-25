package com.udemy;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends TestBase{

    @Test(description ="Login with valid credentials")
    public void loginWithValidCredentials(){
        homePage.openHomePage();
        loginPopup.loginWithCookies();
        Assert.assertEquals(homePageForLoginedUser.getMyCoursesLinkTitle(), "My courses");

    }

}
