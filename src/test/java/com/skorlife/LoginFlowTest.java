package com.skorlife;

import com.skorlife.screens.LoginFlow;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginFlowTest {
    AndroidDriver driver ;
    UiAutomator2Options options;
    LoginFlow loginFlow;

    @BeforeClass
    public void setup() throws MalformedURLException {
        options = new UiAutomator2Options();
        options.setCapability("platformName","Android");
        options.setCapability("appium:deviceName","Xiaomi_Note_11");
        options.setCapability("appium:appPackage","com.skorlife.score");
        options.setCapability("appium:appActivity",".MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.hideKeyboard();

        loginFlow = new LoginFlow(driver);
    }

    @Test
    public void setLoginFlow () throws InterruptedException{
        loginFlow.setNotif();
        loginFlow.setLoc();
        loginFlow.clickInputNo();
        loginFlow.enterPhoneNo();
        loginFlow.lanjutkanButton();
        loginFlow.clickButtonOne();
        loginFlow.clickButtonOne();
        loginFlow.clickButtonTwo();
        loginFlow.clickButtonTwo();
        loginFlow.clickButtonThree();
        loginFlow.clickButtonThree();
        Thread.sleep(4000);
        loginFlow.clickProfilePage();
        loginFlow.clickUpdateInfo();
        loginFlow.clickSimpanInfo();
        loginFlow.clickPreviousButton();
        loginFlow.clickCredit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickLoan();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickOthers();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickForYou();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.clickLogoutButton();
        loginFlow.swipe("left");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickPinjaman();
//        loginFlow.swipeGoro("left");
    }

//    @Test (priority = 2)
//    public void clickSetLocTest () {
//        loginFlow.setLoc();
//    }

//    @Test (priority = 3)
//    public void clickSetCobaLagiTest () {
//        loginFlow.setCobaLagi();
//    }

//    @Test(priority = 3)
//    public void inputNoClick() {
//        loginFlow.clickInputNo();
//    }
//
//    @Test(priority = 4)
//    public void clickEnterNoTest() {
//        loginFlow.enterPhoneNo();
//    }
//
//    @Test(priority = 5)
//    public void clickLanjutkanButtontest() {
//        loginFlow.lanjutkanButton();
//    }
//
//    @Test(priority = 6)
//    public void clickButtonOneTest() {
//        loginFlow.clickButtonOne();
//        loginFlow.clickButtonOne();
//    }
//
//    @Test(priority = 7)
//    public void clickButtonTwoTest() {
//        loginFlow.clickButtonTwo();
//        loginFlow.clickButtonTwo();
//    }
//
//    @Test(priority = 8)
//    public void clickButtonThreeTest() {
//        loginFlow.clickButtonThree();
//        loginFlow.clickButtonThree();
//    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}

