package com.skorlife;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.skorlife.screens.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.util.NoSuchElementException;

public class DashboardTest {
    AndroidDriver driver;
    PermissionScreen permissionScreen;
    LoginScreen loginScreen;
    DashboardScreen dashboardScreen;
    PinScreen pinScreen;
    PinjamanScreen pinjamanScreen;


    @BeforeClass
    public void setupDashboardTest() throws MalformedURLException {
        driver = DriverSingleton.getDriver();

        permissionScreen = new PermissionScreen(driver);
        loginScreen = new LoginScreen(driver);
        dashboardScreen = new DashboardScreen(driver);
        pinScreen = new PinScreen(driver);
        pinjamanScreen = new PinjamanScreen(driver);

    }


    @Test(priority = 1)
    public void showDetailKol() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Show Detail KOL");
        Thread.sleep(4000);
        String userOnLoginPage = Screenshot.captureScreenshot(driver, "User_On_Login_Page");
        test.info("User On Login Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnLoginPage).build());
        loginScreen.setBtnInputNumber();
        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
        test.pass("Tap Phone Number Input Field",
                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
        loginScreen.setBtnValidEnterNumber();
        String btnPhoneNumberSs = Screenshot.captureScreenshot(driver, "User_Enter_a_Phone_Number");
        test.pass("User Enter a Phone Number",
                MediaEntityBuilder.createScreenCaptureFromPath(btnPhoneNumberSs).build());
        loginScreen.setBtnLanjutkan();
        String btnLanjutkanSs = Screenshot.captureScreenshot(driver, "Click_Lanjutkan_Button");
        test.pass("Click Lanjutkan Button",
                MediaEntityBuilder.createScreenCaptureFromPath(btnLanjutkanSs).build());
        pinScreen.setBtnOne();
        String setBtnOneSs = Screenshot.captureScreenshot(driver, "Tap_1");
        test.pass("Tap 1",
                MediaEntityBuilder.createScreenCaptureFromPath(setBtnOneSs).build());
        pinScreen.setBtnTwo();
        String setBtnTwoSs = Screenshot.captureScreenshot(driver, "Tap_2");
        test.pass("Tap 2",
                MediaEntityBuilder.createScreenCaptureFromPath(setBtnTwoSs).build());
        pinScreen.setBtnThree();
        String setBtnThreeSs = Screenshot.captureScreenshot(driver, "Tap_3");
        test.pass("Tap 3",
                MediaEntityBuilder.createScreenCaptureFromPath(setBtnThreeSs).build());
        Thread.sleep(5000);
        String succesfullyLogintoDashboardPage = Screenshot.captureScreenshot(driver, "Dashboard_Page");
        test.pass("Succesfully Login to Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(succesfullyLogintoDashboardPage).build());
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"KOL 1\n" +
                    "Lancar\"]"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setKolStatus();
                String screenshotPath = Screenshot.captureScreenshot(driver, "KOL_Status_Displayed");
                test.pass("KOL Status Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                String screenshotPath = Screenshot.captureScreenshot(driver, "KOL_Status_Not_Displayed");
                test.fail("KOL Status Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "KOL_Status_Not_Found");
            test.fail("KOL_Status_Not_Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(2000);
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Scrim\"]"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setBtnCloseKolStatus();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup_Button");
                test.pass("Tap Oke Tutup",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup_Not_Displayed");
                test.fail("Oke Tutup Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup_Not_Found");
            test.fail("Oke tutup Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void showDetailUserCreditScore() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Show Detail Credit Score");
        Thread.sleep(2000);
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"486\n"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setBtnCreditScore();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Credit_Score_Displayed");
                test.pass("Credit Score Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                dashboardScreen.setBtnCreditScore();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Credit_Score_Not_Displayed");
                test.fail("Credit Score Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            dashboardScreen.setBtnCreditScore();
            String screenshotPath = Screenshot.captureScreenshot(driver, "Credit_Score_Not_Found");
            test.fail("Credit Score Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Total Pinjaman\"]/android.view.View[2]" +
                    "Lancar\"]"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setBtnCloseCreditScore();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup");
                test.pass("Tap Oke Tutup",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup_Not_Displayed");
                test.fail("Oke Tutup Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup_Not_Found");
            test.fail("Oke tutup Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void displayUserTotalLoan() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Display User Total Loan");
        Thread.sleep(2000);
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\\\"TOTAL PINJAMAN\\n\" +\n" +
                    "            \"Rp1.350.678\\\"]"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setTxtBtnTotalLoan();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Total_Loan_Displayed");
                test.pass("Total Loan Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                String screenshotPath = Screenshot.captureScreenshot(driver, "Total_Loan_Not_Displayed");
                test.fail("Total Loan Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Total_Loan_Not_Found");
            test.fail("Total Loan Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Total Pinjaman\"]/android.view.View[2]"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setBtnCloseTotalLoan();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Back_To_Dashboard_Page");
                test.pass("Back To Dashboard Page",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                String screenshotPath = Screenshot.captureScreenshot(driver, "Back_Button_Not_Displayed");
                test.fail("Back Button Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Back Button Not Found");
            test.fail("Back Button Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
    }


    @Test(priority = 4)
    public void displayActiveDate() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Display Active Date Information");
        Thread.sleep(2000);
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"31 hari\"]"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setTxtBtn30Hari();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Show_Active_Date_Status");
                test.pass("Show Active Date Status",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                String screenshotPath = Screenshot.captureScreenshot(driver, "Active_Date_Status_Not_Displayed");
                test.fail("Active Date status Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Active_Date_Status_Not_Found");
            test.fail("Active Date Status Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Oke, tutup\"]"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setBtnCloseActiveStatus();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup");
                test.pass("Tap Oke Tutup",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup_Not_Displayed");
                test.fail("Oke Tutup Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup_Not_Found");
            test.fail("Oke tutup Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
    }

    @Test(priority = 5)
    public void noLoanSubmission() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Show Submission Status");
        Thread.sleep(2000);
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Tidak ada pengajuan pinjaman baru atas namamu.\"]"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setTxtBtnSubmission();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Show_Submission_Status");
                test.pass("Show Submission Status",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                String screenshotPath = Screenshot.captureScreenshot(driver, "Submission_Status_Not_Displayed");
                test.fail("Submission status Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Submission_Status_Not_Found");
            test.fail("Submission Status Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Oke, tutup\"]"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setBtnCloseSubmission();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Close_Submission_Status");
                test.pass("Close Submission Status",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                String screenshotPath = Screenshot.captureScreenshot(driver, "Close_Submission_Status_Not_Displayed");
                test.fail("Close Submission status is Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Close_Submission_Status_Not_Found");
            test.fail("Close Submission Status is Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
    }

    @Test(priority = 6)
    public void displayPelajariLebihLanjut() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Display Pelajari Lebih Lanjut Lanjut Button");
        Thread.sleep(2000);
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Pelajari lebih lanjut\"]"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setBtnPelajariLebihLanjut();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Tap_Pelajari_Lebih_Lanjut_Status");
                test.pass("Tap Pelajari Lebih Lanjut Button",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                String screenshotPath = Screenshot.captureScreenshot(driver, "Pelajari_Lebih_Lanjut_Status_Not_Displayed");
                test.fail("Pelajari Lebih Lanjut Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Submission_Status_Not_Found");
            test.fail("Pelajari Lebih Lanjut Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.widget.Button"));

            if (statusKolElement.isDisplayed()) {
                dashboardScreen.setBtnBackOnPinjaman();
                String screenshotPath = Screenshot.captureScreenshot(driver, "Tap_Back_Button_On_Pinjaman_Page");
                test.pass("Tap Back Button On Pinjaman Page",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                String screenshotPath = Screenshot.captureScreenshot(driver, "Tap_Back_Button_On_Pinjaman_Page_Not_Displayed");
                test.fail("Back Button On Pinjaman Page Not Displayed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Back_Button_On_Pinjaman_Page_Not_Found");
            test.fail("Back Button On Pinjaman Page Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
    }

    @Test(priority = 7)
    public void showCardTabBar() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Show Card Tab Bar");
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        dashboardScreen.setTbCard();
        String showCardTabBar = Screenshot.captureScreenshot(driver,"User_Tap_Card_Tab_Bar");
        test.pass("User Tap Card Tab Bar", MediaEntityBuilder.createScreenCaptureFromPath(showCardTabBar).build());
        Thread.sleep(1000);
    }

    @Test(priority = 8)
    public void showLoanTabBar() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Show Loan Tab Bar");
        String userOnCardTabBar = Screenshot.captureScreenshot(driver, "User_On_Card_Tab_Bar");
        test.info("User On Card Tab Bar",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnCardTabBar).build());
        dashboardScreen.setTbLoan();
        String showLoanTabBar = Screenshot.captureScreenshot(driver,"User_Tap_Loan_Tab_Bar");
        test.pass("User Tap Loan Tap Bar", MediaEntityBuilder.createScreenCaptureFromPath(showLoanTabBar).build());
        Thread.sleep(1000);
    }

    @Test(priority = 9)
    public void showOtherTabBar() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Show Other Tab Bar");
        String userOnLoanTabBar = Screenshot.captureScreenshot(driver,"User_On_Loan_Tab_Bar");
        test.info("User On Loan Tab Bar", MediaEntityBuilder.createScreenCaptureFromPath(userOnLoanTabBar).build());
        dashboardScreen.setTbOther();
        String showOtherTabBar = Screenshot.captureScreenshot(driver,"User_Tap_Other_Tab_Bar");
        test.pass("User Tap Other Tap Bar", MediaEntityBuilder.createScreenCaptureFromPath(showOtherTabBar).build());
        Thread.sleep(1000);
    }

    @Test(priority = 10)
    public void showForYouTabBar() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Show For You Tab Bar");
        String userOnOtherTabBar = Screenshot.captureScreenshot(driver,"User_On_Other_Tab_Bar");
        test.info("User On Other Tab Bar", MediaEntityBuilder.createScreenCaptureFromPath(userOnOtherTabBar).build());
        dashboardScreen.setTbForYou();
        String showForYouTabBar = Screenshot.captureScreenshot(driver,"User_Tap_For_You_Tab_Bar");
        test.pass("User Tap For You Tap Bar", MediaEntityBuilder.createScreenCaptureFromPath(showForYouTabBar).build());
        Thread.sleep(1000);
    }








}
