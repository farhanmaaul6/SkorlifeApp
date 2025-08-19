package com.skorlife;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.skorlife.screens.*;
import com.skorlife.screens.dashboard.DashboardScreen;
import com.skorlife.screens.inbox.InboxScreen;
import com.skorlife.screens.login.LoginScreen;
import com.skorlife.screens.permission.PermissionScreen;
import com.skorlife.screens.pinjaman.PinjamanScreen;
import com.skorlife.screens.profile.ProfileScreen;
import com.skorlife.screens.referral.ReferralScreen;
import com.skorlife.screens.skorcard.SkorcardScreen;
import com.skorlife.screens.utils.PinScreen;
import com.skorlife.screens.utils.Screenshot;

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
    InboxScreen inboxScreen;
    SkorcardScreen skorcardScreen;
    ReferralScreen referralScreen;
    ProfileScreen profileScreen;

    @BeforeClass
    public void setupDashboardTest() throws MalformedURLException {
        driver = DriverSingleton.getDriver();

        permissionScreen = new PermissionScreen(driver);
        loginScreen = new LoginScreen(driver);
        dashboardScreen = new DashboardScreen(driver);
        pinScreen = new PinScreen(driver);
        pinjamanScreen = new PinjamanScreen(driver);
        inboxScreen = new InboxScreen(driver);
        profileScreen = new ProfileScreen(driver);
        referralScreen = new ReferralScreen(driver);
        skorcardScreen = new SkorcardScreen(driver);
    }


    @Test(priority = 1)
    public void showDetailKol() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("9. [POSITIVE] Show Detail KOL");
        Thread.sleep(2000);
        String userOnLoginPage = Screenshot.captureScreenshot(driver, "User_On_Login_Page");
        test.info("User On Login Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnLoginPage).build());
        loginScreen.setBtnInputNumber();
        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
        test.pass("Tap Phone Number Input Field",
                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
        loginScreen.setBtnNewValidEnterNumber();
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
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"KOL 1\nLancar\"]"));
            dashboardScreen.setKolStatus();
            String setKolStatusSs = Screenshot.captureScreenshot(driver, "KOL_Status_Displayed");
            test.pass("KOL Status Displayed",
                    MediaEntityBuilder.createScreenCaptureFromPath(setKolStatusSs).build());
        } catch (NoSuchElementException e) {
            String setKolStatusSs = Screenshot.captureScreenshot(driver, "KOL_Status_Not_Found");
            test.fail("KOL_Status_Not_Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(setKolStatusSs).build());
        }

        Thread.sleep(2000);

        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Scrim\"]"));
            dashboardScreen.setBtnCloseKolStatus();
            String btnCloseKolStatusSs = Screenshot.captureScreenshot(driver,"Oke_Tutup_Button_is_Displayed");
            test.pass("Tap Oke Tutup Button", MediaEntityBuilder.createScreenCaptureFromPath(btnCloseKolStatusSs).build());
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup_Not_Found");
            test.fail("Oke tutup Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void showDetailUserCreditScore() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("10. [POSITIVE] Show Detail Credit Score");
        Thread.sleep(3000);
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"490\n" +
                    "Risiko Tinggi\"]"));
            dashboardScreen.setBtnCreditScore();
            String setBtnCreditScoreSs = Screenshot.captureScreenshot(driver,"Credit_Score_Displayed");
            test.pass("Credit Score Displayed",MediaEntityBuilder.createScreenCaptureFromPath(setBtnCreditScoreSs).build());
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Credit_Score_Not_Found");
            test.fail("Credit Score Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);

        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Dismiss\"]"));
            dashboardScreen.swipeBtnDismiss("down");
            Thread.sleep(3000);
            String swipeBtnDismissSs = Screenshot.captureScreenshot(driver, "Oke_Tutup");
            test.pass("Tap Oke Tutup",
                    MediaEntityBuilder.createScreenCaptureFromPath(swipeBtnDismissSs).build());
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup_Not_Found");
            test.fail("Oke tutup Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void displayUserTotalLoan() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("11. [POSITIVE] Display User Total Loan");
        Thread.sleep(2000);
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"TOTAL PINJAMAN\n" +
                    "Rp1.350.678\"]"));
            dashboardScreen.setTxtBtnTotalLoan();
            String setTxtBtnTotalLoanSs = Screenshot.captureScreenshot(driver,"Total_Loan_is_Displayed");
            test.pass("Total Loan is Displayed",
                    MediaEntityBuilder.createScreenCaptureFromPath(setTxtBtnTotalLoanSs).build());
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Total_Loan_Not_Found");
            test.fail("Total Loan Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Total Pinjaman\"]/android.view.View[2]"));
            dashboardScreen.setBtnCloseTotalLoan();
            String btnCloseTotalLoanSs = Screenshot.captureScreenshot(driver,"Back_To_Dashboard_Page");
            test.pass("Back To Dashboard Page",
                    MediaEntityBuilder.createScreenCaptureFromPath(btnCloseTotalLoanSs).build());
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Back Button Not Found");
            test.fail("Back Button Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
    }


    @Test(priority = 4)
    public void displayActiveDate() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("12. [POSITIVE] Display Active Date Information");
        Thread.sleep(2000);
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"26 hari\"]"));
            dashboardScreen.setTxtBtn30Hari();
            String setTxtBtnHariSs = Screenshot.captureScreenshot(driver, "Show_Active_Date_Status");
            test.pass("Show Active Date Status",
                    MediaEntityBuilder.createScreenCaptureFromPath(setTxtBtnHariSs).build());
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Active_Date_Status_Not_Found");
            test.fail("Active Date Status Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Oke, tutup\"]"));
            dashboardScreen.setBtnCloseActiveStatus();
            String btnCloseActiveStatusSs = Screenshot.captureScreenshot(driver, "Oke_Tutup");
            test.pass("Tap Oke Tutup",
                    MediaEntityBuilder.createScreenCaptureFromPath(btnCloseActiveStatusSs).build());
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Oke_Tutup_Not_Found");
            test.fail("Oke tutup Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
    }

    @Test(priority = 5)
    public void noLoanSubmission() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("13. [POSITIVE] Show Submission Status");
        Thread.sleep(2000);
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Tidak ada pengajuan pinjaman baru atas namamu.\"]"));
            dashboardScreen.setTxtBtnSubmission();
            String setTxtBtnSubmissionSs = Screenshot.captureScreenshot(driver, "Show_Submission_Status");
            test.pass("Show Submission Status",
                    MediaEntityBuilder.createScreenCaptureFromPath(setTxtBtnSubmissionSs).build());
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Submission_Status_Not_Found");
            test.fail("Submission Status Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Oke, tutup\"]"));
            dashboardScreen.setBtnCloseSubmission();
            String btnCloseSubmissionSs = Screenshot.captureScreenshot(driver, "Close_Submission_Status");
            test.pass("Close Submission Status",
                    MediaEntityBuilder.createScreenCaptureFromPath(btnCloseSubmissionSs).build());
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Close_Submission_Status_Not_Found");
            test.fail("Close Submission Status is Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
    }

    @Test(priority = 6)
    public void displayPelajariLebihLanjut() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("14. [POSITIVE] Display Pelajari Lebih Lanjut Lanjut Button");
        Thread.sleep(2000);
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Pelajari lebih lanjut\"]"));
            dashboardScreen.setBtnPelajariLebihLanjut();
            String setBtnPelajariLebihLanjutSs = Screenshot.captureScreenshot(driver, "Tap_Pelajari_Lebih_Lanjut_Status");
            test.pass("Tap Pelajari Lebih Lanjut Button",
                    MediaEntityBuilder.createScreenCaptureFromPath(setBtnPelajariLebihLanjutSs).build());
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Submission_Status_Not_Found");
            test.fail("Pelajari Lebih Lanjut Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
        try {
            WebElement statusKolElement = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Beranda\"]"));
            dashboardScreen.setBtnBeranda();
            String btnBerandaSs = Screenshot.captureScreenshot(driver, "Tap_Beranda_Navigation_Bottom_Bar");
            test.pass("Tap Beranda Navigation Bottom Bar",
                    MediaEntityBuilder.createScreenCaptureFromPath(btnBerandaSs).build());
        } catch (NoSuchElementException e) {
            String screenshotPath = Screenshot.captureScreenshot(driver, "Beranda_Navigaton_Bar_Not_Found");
            test.fail("Beranda Navigation Bottom Bar Not Found",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        Thread.sleep(1000);
    }

    @Test(priority = 7)
    public void showCardTabBar() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("15. [POSITIVE] Show Card Tab Bar");
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
        ExtentTest test = ExtentReportsManager.getExtent().createTest("16. [POSITIVE] Show Loan Tab Bar");
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
        ExtentTest test = ExtentReportsManager.getExtent().createTest("17. [POSITIVE] Show Other Tab Bar");
        String userOnLoanTabBar = Screenshot.captureScreenshot(driver,"User_On_Loan_Tab_Bar");
        test.info("User On Loan Tab Bar", MediaEntityBuilder.createScreenCaptureFromPath(userOnLoanTabBar).build());
        dashboardScreen.setTbOther();
        String showOtherTabBar = Screenshot.captureScreenshot(driver,"User_Tap_Other_Tab_Bar");
        test.pass("User Tap Other Tap Bar", MediaEntityBuilder.createScreenCaptureFromPath(showOtherTabBar).build());
        Thread.sleep(1000);
    }

    @Test(priority = 10)
    public void showForYouTabBar() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("18. [POSITIVE] Show For You Tab Bar");
        String userOnOtherTabBar = Screenshot.captureScreenshot(driver,"User_On_Other_Tab_Bar");
        test.info("User On Other Tab Bar", MediaEntityBuilder.createScreenCaptureFromPath(userOnOtherTabBar).build());
        dashboardScreen.setTbForYou();
        String showForYouTabBar = Screenshot.captureScreenshot(driver,"User_Tap_For_You_Tab_Bar");
        test.pass("User Tap For You Tap Bar", MediaEntityBuilder.createScreenCaptureFromPath(showForYouTabBar).build());
        Thread.sleep(1000);
    }

    @Test(priority = 11)
    public void showReferralPage() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("19. [POSITIVE] Show Referral Page");
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Screen", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        referralScreen.setBtnReferral();
        Thread.sleep(2000);
        String showReferralPageSs = Screenshot.captureScreenshot(driver,"User_Tap_Referral_Page");
        test.pass("User Tap Referral Page", MediaEntityBuilder.createScreenCaptureFromPath(showReferralPageSs).build());
        Thread.sleep(2000);
        referralScreen.setBtnBackOnReferral();
        Thread.sleep(2000);
    }


    @Test (priority = 12)
    public void showReportFromInbox() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("20. [POSITIVE] Show Report Tab Bar from Inbox Page");
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Screen", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        inboxScreen.setBtnInbox();
        Thread.sleep(2000);
        String showInboxPageSs = Screenshot.captureScreenshot(driver,"User_Tap_Inbox_Page");
        test.pass("User Tap Inbox Page", MediaEntityBuilder.createScreenCaptureFromPath(showInboxPageSs).build());
        inboxScreen.setTvReport();
        Thread.sleep(2000);
        String showReportTabViewSs = Screenshot.captureScreenshot(driver,"User_Tap_Report_TabView");
        test.pass("User Tap Report Tab View", MediaEntityBuilder.createScreenCaptureFromPath(showReportTabViewSs).build());
//        inboxScreen.setBtnFilter();
//        Thread.sleep(2000);
//        String showBtnFilterSs = Screenshot.captureScreenshot(driver,"User_Tap_Filter");
//        test.pass("User Tap Filter", MediaEntityBuilder.createScreenCaptureFromPath(showBtnFilterSs).build());
//        inboxScreen.setBtnCreateTicket();
//        Thread.sleep(2000);
//        String showBtnCreateTicketSs = Screenshot.captureScreenshot(driver,"User_Tap_Create_Ticket_Filter");
//        test.pass("User Tap Create Ticket Filter", MediaEntityBuilder.createScreenCaptureFromPath(showBtnCreateTicketSs).build());
//        inboxScreen.setBtnProcessTicket();
//        Thread.sleep(2000);
//        String showBtnProcessTicketSs = Screenshot.captureScreenshot(driver,"User_Tap_Process_Ticket_Filter");
//        test.pass("User Tap Process Ticket Filter", MediaEntityBuilder.createScreenCaptureFromPath(showBtnProcessTicketSs).build());
//        inboxScreen.setBtnDoneTicket();
//        Thread.sleep(2000);
//        String showBtnDoneTicketSs = Screenshot.captureScreenshot(driver,"User_Tap_Done_Ticket_Filter");
//        test.pass("User Tap Done Ticket Filter", MediaEntityBuilder.createScreenCaptureFromPath(showBtnDoneTicketSs).build());
//        inboxScreen.setBtnCancelTicket();
//        Thread.sleep(2000);
//        String showBtnCancelTicketSs = Screenshot.captureScreenshot(driver,"User_Tap_Cancel_Ticket_Filter");
//        test.pass("User Tap Cancel Ticket Filter", MediaEntityBuilder.createScreenCaptureFromPath(showBtnCancelTicketSs).build());
//        inboxScreen.setBtnAllTicket();
//        Thread.sleep(2000);
//        String showBtnAllTicketSs = Screenshot.captureScreenshot(driver,"User_Tap_All_Ticket_Filter");
//        test.pass("User Tap All Ticket Filter", MediaEntityBuilder.createScreenCaptureFromPath(showBtnAllTicketSs).build());
//        Thread.sleep(2000);
        inboxScreen.setBtnBack();
    }

    @Test (priority = 13)
    public void showNotificationsOnInbox() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("21. [POSITIVE] Show Notifications Tab Bar from Inbox Page");
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Screen", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        inboxScreen.setBtnInbox();
        Thread.sleep(2000);
        String showInboxPageSs = Screenshot.captureScreenshot(driver,"User_Tap_Inbox_Page");
        test.pass("User Tap Inbox Page", MediaEntityBuilder.createScreenCaptureFromPath(showInboxPageSs).build());
        inboxScreen.setTvNotification();
        Thread.sleep(3000);
        String showNotificationsTabView = Screenshot.captureScreenshot(driver,"User_Tap_Notifications_TabView");
        test.pass("User Tap Notifications Tab View", MediaEntityBuilder.createScreenCaptureFromPath(showNotificationsTabView).build());
        inboxScreen.setBtnBack();
    }

    @Test (priority = 14)
    public void showArticleList() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("22. [POSITIVE] Show Article List ");
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Screen", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        dashboardScreen.swipeTxtHeader("up");
        Thread.sleep(3000);
        String showArticleList = Screenshot.captureScreenshot(driver,"User_On_Article_List");
        test.info("User On Article List", MediaEntityBuilder.createScreenCaptureFromPath(showArticleList).build());
        Thread.sleep(2000);
    }
    @Test (priority = 15)
    public void showDetailArticlePage() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("23. [POSITIVE] Show Detail Page of an Article");
        String userOnArticleListSs = Screenshot.captureScreenshot(driver,"User_On_Article_List ");
        test.info("User on Article List", MediaEntityBuilder.createScreenCaptureFromPath(userOnArticleListSs).build());
        dashboardScreen.setTxtLearnSkorlife();
        Thread.sleep(3000);
        String showDetailArticlePageSs = Screenshot.captureScreenshot(driver, "User_Tap_Article_Page");
        test.pass("User Tap Article Page", MediaEntityBuilder.createScreenCaptureFromPath(showDetailArticlePageSs).build());
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }

    @Test (priority = 16)
    public void showPinjamanPage() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("24. [POSITIVE] Show Pinjaman Page");
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
        pinjamanScreen.setBtnPinjaman();
        String setBtnSkorcardSs = Screenshot.captureScreenshot(driver, "Tap_Pinjaman_on_Bottom_Navigation_Bar");
        test.pass("Tap Pinjaman Page On Bottom Navigation Bar", MediaEntityBuilder.createScreenCaptureFromPath(setBtnSkorcardSs).build());
        Thread.sleep(5000);
    }

    @Test (priority = 17)
    public void showSkorcardPage() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("25. [POSITIVE] Show Skorcard Page");
        dashboardScreen.setBtnBeranda();
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Screen", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        skorcardScreen.setBtnSkorcard();
        String setBtnSkorcardSs = Screenshot.captureScreenshot(driver, "Tap_Skorcard_Bottom_Navigation_Bar");
        test.pass("Tap Skorcard Page On Bottom Navigation Bar", MediaEntityBuilder.createScreenCaptureFromPath(setBtnSkorcardSs).build());
        Thread.sleep(3000);
        skorcardScreen.setBtnBack();
        Thread.sleep(2000);
    }

    @Test (priority = 18)
    public void showProfilePage() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("26. [POSITIVE] Show Profile Page");
        String userOnDashboard = Screenshot.captureScreenshot(driver,"User_On_Dashboard_Screen ");
        test.info("User on Dashboard Screen", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboard).build());
        profileScreen.setBtnProfilePage();
        String setBtnProfilePageSs = Screenshot.captureScreenshot(driver, "Tap_Profile_Page");
        test.pass("Tap Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(setBtnProfilePageSs).build());
        Thread.sleep(3000);
    }
    







}
