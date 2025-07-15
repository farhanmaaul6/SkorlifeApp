package com.skorlife;

import com.aventstack.extentreports.ExtentTest;
import com.skorlife.screens.PinjamanScreen;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class PinjamanTest extends ExtentReports{
    AndroidDriver driver ;
    PinjamanScreen pinjamanScreen;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = DriverSingleton.getDriver();
        pinjamanScreen = new PinjamanScreen(driver);
    }

    @Test(priority = 1)
    public void PinjamanTestPage() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("Pinjaman Page Test");
        Thread.sleep(4000);
        pinjamanScreen.clickPinjaman();
        test.pass("Click Pinjaman");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickPaylater();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickKta();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickKkb();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickKpr();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickPinjamanLain();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        pinjamanScreen.clickCollection();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

}
