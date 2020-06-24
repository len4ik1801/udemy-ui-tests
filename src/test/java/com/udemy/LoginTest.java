package com.udemy;
import com.udemy.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemy.testdata.UserData.createdUser;


public class LoginTest extends TestBase{



    @Test(description ="Login with valid credentials")
    public void loginWithValidCredentials(){
        homePage.openHomePage();
        driver.manage().addCookie(createdUser.getCookie());
        driver.navigate().refresh();
       pause(4000);
        Assert.assertEquals(homePage.getUserEmailFromProfile(), createdUser.getEmail());
    }

}
