package com.skorlife;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.skorlife.screens.LoginFlow;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginFlowTest extends ExtentReports {
    AndroidDriver driver ;
    LoginFlow loginFlow;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = DriverSingleton.getDriver();
        loginFlow = new LoginFlow(driver);
    }

    @Test(priority = 1)
    public void setLogin () throws InterruptedException{
        ExtentTest test = ExtentReports.getExtent().createTest("Login Test");
        test.info("Starting login test");
        loginFlow.setNotif();
        test.pass("Enable Notifications");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.setLoc();
        test.pass("Enable Location");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickInputNo();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.enterPhoneNo();
        String screenshotPath = Screenshot.captureScreenshot(driver, "Enter Number");
        test.pass("Screenshot after opening after enter number",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.lanjutkanButton();
        test.pass("Click Lanjutkan Button");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickButtonOne();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickButtonOne();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickButtonTwo();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickButtonTwo();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickButtonThree();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickButtonThree();
        test.pass("Enter PIN");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void setProfile () {
        ExtentTest test = ExtentReports.getExtent().createTest("Profile Page Test");
        loginFlow.clickProfilePage();
        test.pass("Click Profile Page");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickUpdateInfo();
        test.pass("Click Update Info");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickSimpanInfo();
        test.pass("Click Simpan Info Update");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickPreviousButton();
        test.pass("Click Previous");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test(priority = 3)
    public void dashboardTest () throws InterruptedException {
        Thread.sleep(5000);
        ExtentTest test = ExtentReports.getExtent().createTest("Dashboard Functionality Test");
        loginFlow.setStatusKol();
        test.pass("Click Status KOL");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.setCloseStatusKolPage();
        test.pass("Close Status KOL");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.setTotalPinjaman();
        test.pass("Click Total Pinjaman");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.setBackPinjamanButton();
        test.pass("Click Close Pengajuan Pinjaman Page");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.setPengajuanPinjaman();
        test.pass("Click Pengajuan Pinjaman");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.setClosePengajuanPinjamanButton();
        test.pass("Click Close Pengajuan Pinjaman Page");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.setPelajariLebihLanjutButton();
        test.pass("Click Pelajari Lebih Lanjut Button");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.setBeranda();
        test.pass("Click Beranda");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickCredit();
        test.pass("Click Leadgen Kartu Kredit");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickLoan();
        test.pass("Click Leadgen Pinjaman");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickOthers();
        test.pass("Click Leadgen Lainnya");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.clickForYou();
        test.pass("Click Leadgen Untuk Kamu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginFlow.swipeHeader("up");
        test.pass("Swipe Down Page");
        loginFlow.swipeList("down");
        test.pass("Swipe Up Page");
        }

}

