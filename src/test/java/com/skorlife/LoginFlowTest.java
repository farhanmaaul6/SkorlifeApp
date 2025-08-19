package com.skorlife;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.skorlife.screens.*;
import com.skorlife.screens.dashboard.DashboardScreen;
import com.skorlife.screens.login.LoginScreen;
import com.skorlife.screens.permission.PermissionScreen;
import com.skorlife.screens.profile.ProfileScreen;
import com.skorlife.screens.utils.PinScreen;
import com.skorlife.screens.utils.Screenshot;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;

public class LoginFlowTest {
    AndroidDriver driver ;
    PermissionScreen permissionScreen;
    LoginScreen loginScreen;
    PinScreen pinScreen;
    DashboardScreen dashboardScreen;
    ProfileScreen profileScreen;

    @BeforeClass
    public void setupLoginTest() throws MalformedURLException {
        driver = DriverSingleton.getDriver();

        permissionScreen = new PermissionScreen(driver);
        loginScreen = new LoginScreen(driver);
        pinScreen = new PinScreen(driver);
        dashboardScreen = new DashboardScreen(driver);
        profileScreen = new ProfileScreen(driver);
    }


    @Test(priority = 1)
    public void setSignInUsingRegisteredNumber() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("1. [POSITIVE] Sign In Using a Registered Phone Number.");
        String userTapSkorApps = Screenshot.captureScreenshot(driver, "Tap_Skor_Apps_For_Mobile");
        test.info("Tap Skor Apps For Mobile",
                MediaEntityBuilder.createScreenCaptureFromPath(userTapSkorApps).build());
        String setCameraSs = Screenshot.captureScreenshot(driver, "Enable_Notifications");
        test.pass("Enable Notifications",
                MediaEntityBuilder.createScreenCaptureFromPath(setCameraSs).build());
        permissionScreen.setBtnCamera();
        Thread.sleep(2000);
        String setNotificationSs = Screenshot.captureScreenshot(driver, "Enable_Notifications");
        test.pass("Enable Notifications",
                MediaEntityBuilder.createScreenCaptureFromPath(setNotificationSs).build());
        permissionScreen.setBtnNotification();
        Thread.sleep(2000);
        String setLocationSs = Screenshot.captureScreenshot(driver, "Enable_Location");
        test.pass("Enable Location",
                MediaEntityBuilder.createScreenCaptureFromPath(setLocationSs).build());
        permissionScreen.setBtnLocation();
        Thread.sleep(12000);
        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
        test.pass("Waiting for All Animations",
                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
        loginScreen.setBtnInputNumber();
        Thread.sleep(2000);
        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
        test.pass("Tap Phone Number Input Field",
                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
        loginScreen.setBtnValidEnterNumber();
        Thread.sleep(2000);
        String btnPhoneNumberSs = Screenshot.captureScreenshot(driver, "User_Enter_a_Phone_Number");
        test.pass("User Enter a Phone Number",
                MediaEntityBuilder.createScreenCaptureFromPath(btnPhoneNumberSs).build());
        loginScreen.setBtnLanjutkan();
        Thread.sleep(2000);
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
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }

    @Test(priority = 2)
    public void SignInUsingaPhoneNumberWithanInvalidProviderCode() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("2. [NEGATIVE] Sign In Using a Phone Number With an Invalid Provider Code.");
        Thread.sleep(4000);
        String userOnPinPage = Screenshot.captureScreenshot(driver, "User_On_Pin_Page");
        test.info("User On PIN Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnPinPage).build());
        Thread.sleep(5000);
        String backOnPin = Screenshot.captureScreenshot(driver, "Back_to_Animations_Page");
        test.pass("Back To Animations Page", MediaEntityBuilder.createScreenCaptureFromPath(backOnPin).build());
        pinScreen.setBtnBackToLogin();
        Thread.sleep(12000);
        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
        test.pass("Waiting for All Animations",
                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
        loginScreen.setBtnInputNumber();
        Thread.sleep(2000);
        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
        test.pass("Tap Phone Number Input Field",
                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
        loginScreen.setBtnInvalidEnterNumber();
        String btnInvalidEnterNumberSs = Screenshot.captureScreenshot(driver, "Enter Invalid Number");
        test.pass("Enter Invalid Phone Number", MediaEntityBuilder.createScreenCaptureFromPath(btnInvalidEnterNumberSs).build());
        Thread.sleep(2000);
        String errorNotificationSs = Screenshot.captureScreenshot(driver, "Invalid Provider Code Error Notifications");
        test.pass("Invalid Provider Code Error Notifications",
                MediaEntityBuilder.createScreenCaptureFromPath(errorNotificationSs).build());
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }

    @Test(priority = 3)
    public void SignInWithanInvalidPhoneNumberLessThanTendigits() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("3. [NEGATIVE] Sign In Using a Phone Number Less Than 10 Digits.");
        Thread.sleep(4000);
        String userOnLoginPage = Screenshot.captureScreenshot(driver, "User_On_Login_Page");
        test.info("User On Login Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnLoginPage).build());
        Thread.sleep(5000);
        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
        test.pass("Waiting for All Animations",
                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
        loginScreen.setBtnInputNumber();
        Thread.sleep(2000);
        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
        test.pass("Tap Phone Number Input Field",
                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
        loginScreen.setBtnLessEnterNumber();
        String btnInvalidEnterNumberSs = Screenshot.captureScreenshot(driver, "Enter_Number_Less_Than_Ten_Digits");
        test.pass("Enter Number Less Than Ten Digits", MediaEntityBuilder.createScreenCaptureFromPath(btnInvalidEnterNumberSs).build());
        Thread.sleep(2000);
        String errorNotificationSs = Screenshot.captureScreenshot(driver, "Phone Number Less Than 10 Digits Error Notifications");
        test.pass("Phone Number Less Than 10 Digits Error Notifications",
                MediaEntityBuilder.createScreenCaptureFromPath(errorNotificationSs).build());
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }

    @Test(priority = 4)
    public void SignInWithanInvalidPhoneNumberMoreThanTendigits() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("4. [NEGATIVE] Sign In Using a Phone Number More Than 13 Digits.");
        Thread.sleep(3000);
        String userOnLoginPage = Screenshot.captureScreenshot(driver, "User_On_Login_Page");
        test.info("User On Login Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnLoginPage).build());
        Thread.sleep(4000);
        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
        test.pass("Waiting for All Animations",
                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
        loginScreen.setBtnInputNumber();
        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
        test.pass("Tap Phone Number Input Field",
                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
        loginScreen.setBtnMoreEnterNumber();
        String btnInvalidEnterNumberSs = Screenshot.captureScreenshot(driver, "Enter Number More Than Ten Digits");
        test.pass("Enter Number More Than Ten Digits", MediaEntityBuilder.createScreenCaptureFromPath(btnInvalidEnterNumberSs).build());
        Thread.sleep(2000);
        String errorNotificationSs = Screenshot.captureScreenshot(driver, "Enter Number More Than Ten Digit Error Notifications");
        test.pass("Enter Number More Than Ten Digit Error Notifications",
                MediaEntityBuilder.createScreenCaptureFromPath(errorNotificationSs).build());
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }

    @Test(priority = 5)
    public void SignInWithInvalidPinCode() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("5. [NEGATIVE] Sign In With Invalid PIN Code.");
        Thread.sleep(3000);
        String userOnLoginPage = Screenshot.captureScreenshot(driver, "User_On_Login_Page");
        test.info("User On Login Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnLoginPage).build());
        Thread.sleep(4000);
        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
        test.pass("Waiting for All Animations",
                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
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
        pinScreen.setBtnTwo();
        String setBtnTwoSs = Screenshot.captureScreenshot(driver, "Tap_2");
        test.pass("Tap 2",
                MediaEntityBuilder.createScreenCaptureFromPath(setBtnTwoSs).build());
        pinScreen.setBtnSeven();
        String setBtnSevenSs = Screenshot.captureScreenshot(driver, "Tap_7");
        test.pass("Tap 7",
                MediaEntityBuilder.createScreenCaptureFromPath(setBtnSevenSs).build());
        pinScreen.setBtnSix();
        String setBtnSixSs = Screenshot.captureScreenshot(driver, "Tap_6");
        test.pass("Tap 6",
                MediaEntityBuilder.createScreenCaptureFromPath(setBtnSixSs).build());
        Thread.sleep(2000);
        String errorNotificationSs = Screenshot.captureScreenshot(driver, "Invalid PIN Code Error Notifications");
        test.pass("Invalid PIN Code Error Notifications",
                MediaEntityBuilder.createScreenCaptureFromPath(errorNotificationSs).build());
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }

    @Test(priority = 6)
    public void SignInWithInvalidPinCodeMoreThanThreeTimes() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("6. [NEGATIVE] Sign In With Invalid PIN Code With More Than 3 Times.");
        Thread.sleep(3000);
        pinScreen.setBtnBackToLogin();
        Thread.sleep(2000);
        String userOnLoginPage = Screenshot.captureScreenshot(driver, "User_On_Login_Page");
        test.info("User On Login Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnLoginPage).build());
        Thread.sleep(4000);
        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
        test.pass("Waiting for All Animations",
                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
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
        pinScreen.setBtnNine();
        pinScreen.setBtnOne();
        pinScreen.setBtnFive();
        String seTwoTimes = Screenshot.captureScreenshot(driver, "Second Error Message");
        test.pass("Second Error Message",
                MediaEntityBuilder.createScreenCaptureFromPath(seTwoTimes).build());
        Thread.sleep(5000);
        pinScreen.setBtnTwo();
        pinScreen.setBtnThree();
        pinScreen.setBtnFour();
        String setThreeTimes = Screenshot.captureScreenshot(driver, "Third Error Message");
        test.pass("Third Error Message",
                MediaEntityBuilder.createScreenCaptureFromPath(setThreeTimes).build());
        Thread.sleep(7000);
        String errorNotificationSs = Screenshot.captureScreenshot(driver, "Block User Notifications");
        test.pass("Block User Notifications",
                MediaEntityBuilder.createScreenCaptureFromPath(errorNotificationSs).build());
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }

    @Test(priority = 7)
    public void LinkToKetentuanLayanan() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("7. [POSITIVE] User Link to Ketentuan Layanan.");
        Thread.sleep(3000);
        pinScreen.setBtnBackToLogin();
        String userOnLoginPage = Screenshot.captureScreenshot(driver, "User_On_Login_Page");
        test.info("User On Login Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnLoginPage).build());
        Thread.sleep(4000);
        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
        test.pass("Waiting for All Animations",
                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
        loginScreen.setBtnInputNumber();
        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
        test.pass("Tap Phone Number Input Field",
                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
        Thread.sleep(4000);
        loginScreen.setTxtBtnKetentuanLayanan();
        String txtKetentuanLayananSs = Screenshot.captureScreenshot(driver,"Move_to_Ketentuan_Layanan_Page");
        test.pass("Tap Ketentuan Layanan TextButton", MediaEntityBuilder.createScreenCaptureFromPath(txtKetentuanLayananSs).build());
        Thread.sleep(5000);
        driver.terminateApp("com.android.chrome");
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }
    @Test(priority = 8)
    public void LinkToKebijakanPrivasi() throws InterruptedException {
        ExtentTest test = ExtentReportsManager.getExtent().createTest("8. [POSITIVE] User Link to Kebijakan Privasi.");
        Thread.sleep(3000);
        String userOnLoginPage = Screenshot.captureScreenshot(driver, "User_On_Login_Page");
        test.info("User On Login Page",
                MediaEntityBuilder.createScreenCaptureFromPath(userOnLoginPage).build());
        Thread.sleep(4000);
        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
        test.pass("Waiting for All Animations",
                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
        loginScreen.setBtnInputNumber();
        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
        test.pass("Tap Phone Number Input Field",
                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
        Thread.sleep(4000);
        loginScreen.setTxtBtnKebijakanPrivasi();
        String txtKetentuanLayananSs = Screenshot.captureScreenshot(driver,"Move_to_Kebijakan_Privasi_Page");
        test.pass("Tap Kebijakan Privasi TextButton", MediaEntityBuilder.createScreenCaptureFromPath(txtKetentuanLayananSs).build());
        Thread.sleep(5000);
        driver.terminateApp("com.android.chrome");
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }



}

