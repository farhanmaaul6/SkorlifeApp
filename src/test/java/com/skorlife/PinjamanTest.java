package com.skorlife;

import com.aventstack.extentreports.ExtentTest;
import com.skorlife.screens.LoginFlow;
import com.skorlife.screens.PinjamanScreen;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class PinjamanTest extends ExtentReports{
    AndroidDriver driver ;
    PinjamanScreen pinjamanScreen;
    LoginFlow loginFlow;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = DriverSingleton.getDriver();
        pinjamanScreen = new PinjamanScreen(driver);
        loginFlow = new LoginFlow(driver);
    }

    @Test(priority = 1)
    public void PinjamanTestPage() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("Pinjaman Page Test");
        Thread.sleep(4000);
        pinjamanScreen.clickPinjaman();
        test.pass("Click Pinjaman");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickPaylater();
        test.pass("Click Paylater");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickKta();
        test.pass("Click Kta");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickKkb();
        test.pass("Click Kkb");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickKpr();
        test.pass("Click Kpr");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickPinjamanLain();
        test.pass("Click Pinjaman Lain");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickCollection();
        test.pass("Click Collection");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.setBeranda();
        test.pass("Click Beranda");
        loginFlow.clickProfilePage();
        test.pass("Click Profile Page");
        loginFlow.swipeLogout("Up");
        test.pass("Scroll Down Page");
        loginFlow.clickLogoutButton();
        test.pass("Click Logout Button");
    }

}
