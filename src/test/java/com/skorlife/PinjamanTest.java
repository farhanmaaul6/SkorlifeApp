package com.skorlife;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.skorlife.screens.DashboardScreen;
import com.skorlife.screens.PinjamanScreen;
import com.skorlife.screens.ProfileScreen;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class PinjamanTest extends ExtentReports{
    AndroidDriver driver ;
    PinjamanScreen pinjamanScreen;
    ProfileScreen profileScreen;
    DashboardScreen dashboardScreen;


    @BeforeClass
    public void setupPinjamanTest() throws MalformedURLException {
        driver = DriverSingleton.getDriver();
        pinjamanScreen = new PinjamanScreen(driver);
        profileScreen = new ProfileScreen(driver);
        dashboardScreen = new DashboardScreen(driver);
    }

    @Test(priority = 1)
    public void ShowCardCreditPage() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("25. [POSITIVE] Show Credit Card Page on Pinjaman Page");
        Thread.sleep(2000);
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        pinjamanScreen.setBtnPinjaman();
        Thread.sleep(2000);
        String userOnPinjamanPageSs = Screenshot.captureScreenshot(driver,"User_On_Pinjaman_Page");
        test.pass("User on Pinjaman Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnPinjamanPageSs).build());
        pinjamanScreen.setBtnCreditCard();
        Thread.sleep(2000);
        String userOnCreditCardSs = Screenshot.captureScreenshot(driver,"User_On_Credit_Card_Page");
        test.pass("User on Credit Card Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnCreditCardSs).build());

    }
    @Test(priority = 2)
    public void ShowPaylaterPage() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("26. [POSITIVE] Show Paylater Page on Pinjaman Page");
        Thread.sleep(2000);
        dashboardScreen.setBtnBeranda();
        Thread.sleep(2000);
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        pinjamanScreen.setBtnPinjaman();
        Thread.sleep(2000);
        String userOnPinjamanPageSs = Screenshot.captureScreenshot(driver,"User_On_Pinjaman_Page");
        test.pass("User on Pinjaman Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnPinjamanPageSs).build());
        pinjamanScreen.setBtnPaylater();
        Thread.sleep(2000);
        String userOnPaylaterPageSs = Screenshot.captureScreenshot(driver,"User_On_Paylater_Page");
        test.pass("User on Paylater Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnPaylaterPageSs).build());

    }

    @Test(priority = 3)
    public void ShowKtaPage() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("27. [POSITIVE] Show KTA Page on Pinjaman Page");
        Thread.sleep(2000);
        dashboardScreen.setBtnBeranda();
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        pinjamanScreen.setBtnPinjaman();
        Thread.sleep(2000);
        String userOnPinjamanPageSs = Screenshot.captureScreenshot(driver,"User_On_Pinjaman_Page");
        test.pass("User on Pinjaman Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnPinjamanPageSs).build());
        pinjamanScreen.setBtnKta();
        Thread.sleep(2000);
        String userOnKtaPageSs = Screenshot.captureScreenshot(driver,"User_On_Kta_Page");
        test.pass("User on Kta Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnKtaPageSs).build());

    }

    @Test(priority = 4)
    public void ShowKkbPage() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("28. [POSITIVE] Show KKB Page on Pinjaman Page");
        Thread.sleep(2000);
        dashboardScreen.setBtnBeranda();
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        pinjamanScreen.setBtnPinjaman();
        Thread.sleep(2000);
        String userOnPinjamanPageSs = Screenshot.captureScreenshot(driver,"User_On_Pinjaman_Page");
        test.pass("User on Pinjaman Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnPinjamanPageSs).build());
        pinjamanScreen.setBtnKkb();
        Thread.sleep(2000);
        String userOnKkbPageSs = Screenshot.captureScreenshot(driver,"User_On_Kkb_Page");
        test.pass("User on Kkb Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnKkbPageSs).build());

    }

    @Test(priority = 5)
    public void ShowKprPage() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("29. [POSITIVE] Show KPR Page on Pinjaman Page");
        Thread.sleep(2000);
        dashboardScreen.setBtnBeranda();
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        pinjamanScreen.setBtnPinjaman();
        Thread.sleep(2000);
        String userOnPinjamanPageSs = Screenshot.captureScreenshot(driver,"User_On_Pinjaman_Page");
        test.pass("User on Pinjaman Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnPinjamanPageSs).build());
        pinjamanScreen.setBtnKpr();
        Thread.sleep(2000);
        String userOnKprPageSs = Screenshot.captureScreenshot(driver,"User_On_Kpr_Page");
        test.pass("User on Kpr Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnKprPageSs).build());
    }

    @Test(priority = 6)
    public void ShowOtherLoanPage() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("30. [POSITIVE] Show Other Loan Page on Pinjaman Page");
        Thread.sleep(2000);
        dashboardScreen.setBtnBeranda();
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        pinjamanScreen.setBtnPinjaman();
        Thread.sleep(2000);
        String userOnPinjamanPageSs = Screenshot.captureScreenshot(driver,"User_On_Pinjaman_Page");
        test.pass("User on Pinjaman Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnPinjamanPageSs).build());
        pinjamanScreen.setBtnOtherLoan();
        Thread.sleep(2000);
        String userOnOtherLoanSs = Screenshot.captureScreenshot(driver,"User_On_OtherLoan_Page");
        test.pass("User on Other Loan Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnOtherLoanSs).build());
    }

    @Test(priority = 7)
    public void ShowCollectiusPage() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("31. [POSITIVE] Show Collectius Page on Pinjaman Page");
        Thread.sleep(2000);
        dashboardScreen.setBtnBeranda();
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        pinjamanScreen.setBtnPinjaman();
        Thread.sleep(2000);
        String userOnPinjamanPageSs = Screenshot.captureScreenshot(driver,"User_On_Pinjaman_Page");
        test.pass("User on Pinjaman Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnPinjamanPageSs).build());
        pinjamanScreen.setBtnCollectius();
        Thread.sleep(2000);
        String userOnColleciusSs = Screenshot.captureScreenshot(driver,"User_On_Collecius_Page");
        test.pass("User on Other Loan Page",MediaEntityBuilder.createScreenCaptureFromPath(userOnColleciusSs).build());
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }



}
