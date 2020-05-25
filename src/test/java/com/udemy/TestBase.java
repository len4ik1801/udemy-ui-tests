package com.udemy;

import com.udemy.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class TestBase {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    RegistrationPopup registrationPopup;
    HomePageForLoginedUser homePageForLoginedUser;
    LoginPopup loginPopup;
    CoursesPage coursesPage;


    @BeforeMethod(description = "Open browser")
    public void openBrowser(){
        File chromeDriver = new File("src/main/resources/chromedriver");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        driver = new ChromeDriver(chromeService);
         wait= new WebDriverWait(driver, 5);
         homePage = new HomePage(driver,wait);
         registrationPopup =  new RegistrationPopup(driver,wait);
         homePageForLoginedUser = new HomePageForLoginedUser(driver,wait);
         loginPopup = new LoginPopup(driver,wait);
         coursesPage = new CoursesPage(driver,wait);



    }

    @AfterMethod(description = "Close browser")
    public void closeBrowser(){
        driver.quit();
    }
}
