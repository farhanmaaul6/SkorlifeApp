package com.skorlife;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.skorlife.screens.LoginFlow;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;

public class LoginFlowTest extends ExtentReports {
    AndroidDriver driver ;
    LoginFlow loginFlow;

    @BeforeClass
    public void setupClass() throws MalformedURLException {
        driver = DriverSingleton.getDriver();
        loginFlow = new LoginFlow(driver);
    }


    @Test(priority = 1)
    public void setSignInUsingRegisteredNumber() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Sign In Using a Registered Phone Number");
        test.info("Taps Skor Apps on Mobile");
        String setNotifScreenshot = Screenshot.captureScreenshot(driver, "Enable_Notifications");
        test.pass("Enable Notifications",
                MediaEntityBuilder.createScreenCaptureFromPath(setNotifScreenshot).build());
        loginFlow.setNotif();
        Thread.sleep(2000);
        String setLocationScreenshot = Screenshot.captureScreenshot(driver, "Enable_Location");
        test.pass("Enable Location",
                MediaEntityBuilder.createScreenCaptureFromPath(setLocationScreenshot).build());
        loginFlow.setLocation();
        Thread.sleep(12000);
        String setAnimation = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
        test.pass("Waiting for All Animations",
                MediaEntityBuilder.createScreenCaptureFromPath(setAnimation).build());
        loginFlow.clickInputNo();
        String clickInputNoScreenshot = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
        test.pass("Tap Phone Number Input Field",
                MediaEntityBuilder.createScreenCaptureFromPath(clickInputNoScreenshot).build());
        loginFlow.enterPhoneNo();
        String enterPhoneNoScreenshot = Screenshot.captureScreenshot(driver, "User_Enter_a_Phone_Number");
        test.pass("User Enter a Phone Number",
                MediaEntityBuilder.createScreenCaptureFromPath(enterPhoneNoScreenshot).build());
        loginFlow.lanjutkanButton();
        String lanjutkanButtonScreenshot = Screenshot.captureScreenshot(driver, "Click_Lanjutkan_Button");
        test.pass("Click Lanjutkan Button",
                MediaEntityBuilder.createScreenCaptureFromPath(lanjutkanButtonScreenshot).build());
        String succesfullyLogintoDashboardPage = Screenshot.captureScreenshot(driver, "PIN_code_Page");
        test.pass("Succesfully navigate to PIN Code Page",
                MediaEntityBuilder.createScreenCaptureFromPath(succesfullyLogintoDashboardPage).build());
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }

    @Test(priority = 2)
    public void enterValidPinCode() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] User Enter A Valid PIN Code");
        test.info("Taps Skor Apps on Mobile");
        Thread.sleep(4000);
        String backOnPin = Screenshot.captureScreenshot(driver, "Back_to_Animations_Page");
        test.pass("Back To Animations Page", MediaEntityBuilder.createScreenCaptureFromPath(backOnPin).build());
        loginFlow.setBackOnPin();
        Thread.sleep(12000);
        String setAnimation = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
        test.pass("Waiting for All Animations",
                MediaEntityBuilder.createScreenCaptureFromPath(setAnimation).build());
        loginFlow.clickInputNo();
        String clickInputNoScreenshot = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
        test.pass("Tap Phone Number Input Field",
                MediaEntityBuilder.createScreenCaptureFromPath(clickInputNoScreenshot).build());
        loginFlow.enterPhoneNo();
        String enterPhoneNoScreenshot = Screenshot.captureScreenshot(driver, "User_Enter_a_Phone_Number");
        test.pass("User Enter a Phone Number",
                MediaEntityBuilder.createScreenCaptureFromPath(enterPhoneNoScreenshot).build());
        loginFlow.lanjutkanButton();
        String lanjutkanButtonScreenshot = Screenshot.captureScreenshot(driver, "Click_Lanjutkan_Button");
        test.pass("Click Lanjutkan Button",
                MediaEntityBuilder.createScreenCaptureFromPath(lanjutkanButtonScreenshot).build());
        test.info("User Enter a Valid PIN");
        loginFlow.clickButtonOne();
        String clickButtonOneScreenshot = Screenshot.captureScreenshot(driver, "Tap_1");
        test.pass("Tap 1",
                MediaEntityBuilder.createScreenCaptureFromPath(clickButtonOneScreenshot).build());
        loginFlow.clickButtonTwo();
        String clickButtonTwoScreenshot = Screenshot.captureScreenshot(driver, "Tap_2");
        test.pass("Tap 2",
                MediaEntityBuilder.createScreenCaptureFromPath(clickButtonTwoScreenshot).build());
        loginFlow.clickButtonThree();
        String clickButtonThreeScreenshot = Screenshot.captureScreenshot(driver, "Tap_3");
        test.pass("Tap 3",
                MediaEntityBuilder.createScreenCaptureFromPath(clickButtonThreeScreenshot).build());
        Thread.sleep(3000);
        String succesfullyLogintoDashboardPage = Screenshot.captureScreenshot(driver, "Dashboard_Page");
        test.pass("Succesfully Login to Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(succesfullyLogintoDashboardPage).build());
    }



//    @Test(priority = 2)
//    public void setProfile () {
//        ExtentTest test = ExtentReports.getExtent().createTest("Profile Page Test");
//        loginFlow.clickProfilePage();
//        test.pass("Click Profile Page");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.clickUpdateInfo();
//        test.pass("Click Update Info");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.clickSimpanInfo();
//        test.pass("Click Simpan Info Update");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.clickPreviousButton();
//        test.pass("Click Previous");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//    }
//
//    @Test(priority = 3)
//    public void dashboardTest() throws InterruptedException {
//        Thread.sleep(5000);
//        ExtentTest test = ExtentReports.getExtent().createTest("Dashboard Functionality Test");
//
//        // ---------- Check Status KOL ----------
//        try {
//            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc='Scrim']"));
//
//            if (statusKolElement.isDisplayed()) {
//                String screenshotPath = Screenshot.captureScreenshot(driver, "StatusKOL_Muncul");
//                test.pass("Status KOL muncul",
//                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//            } else {
//                String screenshotPath = Screenshot.captureScreenshot(driver, "StatusKOL_TidakMuncul");
//                test.fail("Status KOL tidak muncul",
//                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//            }
//        } catch (NoSuchElementException e) {
//            String screenshotPath = Screenshot.captureScreenshot(driver, "StatusKOL_NotFound");
//            test.fail("Status KOL tidak ditemukan",
//                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//        }
//
//        // ---------- Check Total Pinjaman ----------
//        try {
//            WebElement totalPinjamanElement = driver.findElement(
//                    By.xpath("//android.widget.ImageView[contains(@content-desc, 'TOTAL PINJAMAN')]")
//            );
//
//            if (totalPinjamanElement.isDisplayed()) {
//                String screenshotPath = Screenshot.captureScreenshot(driver, "TotalPinjaman_Muncul");
//                test.pass("Total pinjaman muncul",
//                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//            } else {
//                String screenshotPath = Screenshot.captureScreenshot(driver, "TotalPinjaman_TidakMuncul");
//                test.fail("Total pinjaman tidak muncul",
//                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//            }
//        } catch (NoSuchElementException e) {
//            String screenshotPath = Screenshot.captureScreenshot(driver, "TotalPinjaman_NotFound");
//            test.fail("Total pinjaman tidak ditemukan",
//                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//        }
//
//        // ---------- Check Pelajari Lebih Lanjut ----------
//        try {
//            WebElement pelajariLebihLanjut = driver.findElement(
//                    By.xpath("//android.view.View[@content-desc=\"Pelajari lebih lanjut\"]")
//            );
//
//            if (pelajariLebihLanjut.isDisplayed()) {
//                String screenshotPath = Screenshot.captureScreenshot(driver, "PelajariLebihLanjut_Muncul");
//                test.pass("Pelajari lebih lanjut muncul",
//                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//            } else {
//                String screenshotPath = Screenshot.captureScreenshot(driver, "PelajariLebihLanjut_TidakMuncul");
//                test.fail("Pelajari lebih lanjut tidak muncul",
//                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//            }
//        } catch (NoSuchElementException e) {
//            String screenshotPath = Screenshot.captureScreenshot(driver, "PelajariLebihLanjut_NotFound");
//            test.fail("Pelajari lebih lanjut tidak ditemukan",
//                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//        }
//
//        /*loginFlow.setStatusKol();
//        test.pass("Click Status KOL");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.setCloseStatusKolPage();
//        test.pass("Close Status KOL");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.setTotalPinjaman();
//        test.pass("Click Total Pinjaman");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.setBackPinjamanButton();
//        test.pass("Click Close Pengajuan Pinjaman Page");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.setPengajuanPinjaman();
//        test.pass("Click Pengajuan Pinjaman");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.setClosePengajuanPinjamanButton();
//        test.pass("Click Close Pengajuan Pinjaman Page");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.setPelajariLebihLanjutButton();
//        test.pass("Click Pelajari Lebih Lanjut Button");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        */loginFlow.setBeranda();
//        test.pass("Click Beranda");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.clickCredit();
//        test.pass("Click Leadgen Kartu Kredit");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.clickLoan();
//        test.pass("Click Leadgen Pinjaman");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.clickOthers();
//        test.pass("Click Leadgen Lainnya");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.clickForYou();
//        test.pass("Click Leadgen Untuk Kamu");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        loginFlow.setNotifications();
//        test.pass("Click Notifikasi");
//        loginFlow.setNotifikasiInbox();
//        test.pass("Click Notifikasi di Inbox");
//        loginFlow.setLaporanInbox();
//        test.pass("Click Laporan di Inbox");
//        loginFlow.setBackOnInbox();
//        test.pass("Kembali ke Dashboard");
//        loginFlow.swipeHeader("up");
//        test.pass("Swipe Down Page");
//        loginFlow.swipeList("down");
//        test.pass("Swipe Up Page");
//        }

}

