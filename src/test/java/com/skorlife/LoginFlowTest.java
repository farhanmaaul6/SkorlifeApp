package com.skorlife;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.skorlife.screens.*;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;

public class LoginFlowTest extends ExtentReports {
    AndroidDriver driver ;
    PermissionScreen permissionScreen;
    LoginScreen loginScreen;
    PinScreen pinScreen;
    DashboardScreen dashboardScreen;
    ProfileScreen profileScreen;

    @BeforeClass
    public void setupClass() throws MalformedURLException {
        driver = DriverSingleton.getDriver();

        permissionScreen = new PermissionScreen(driver);
        loginScreen = new LoginScreen(driver);
        pinScreen = new PinScreen(driver);
        dashboardScreen = new DashboardScreen(driver);
        profileScreen = new ProfileScreen(driver);
    }


    @Test(priority = 1)
    public void setSignInUsingRegisteredNumber() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] Sign In Using a Registered Phone Number.");
        test.info("Taps Skor Apps on Mobile");
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
//        driver.terminateApp("com.skorlife.score");
//        driver.activateApp("com.skorlife.score");
    }

//    @Test(priority = 2)
//    public void SignInUsingaPhoneNumberWithanInvalidProviderCode() throws InterruptedException {
//        ExtentTest test = ExtentReports.getExtent().createTest("[NEGATIVE] Sign In Using a Phone Number With an Invalid Provider Code.");
//        test.info("User on PIN Page");
//        Thread.sleep(4000);
//        String backOnPin = Screenshot.captureScreenshot(driver, "Back_to_Animations_Page");
//        test.pass("Back To Animations Page", MediaEntityBuilder.createScreenCaptureFromPath(backOnPin).build());
//        pinScreen.setBtnBackToLogin();
//        Thread.sleep(12000);
//        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
//        test.pass("Waiting for All Animations",
//                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
//        loginScreen.setBtnInputNumber();
//        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
//        test.pass("Tap Phone Number Input Field",
//                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
//        loginScreen.setBtnInvalidEnterNumber();
//        String btnInvalidEnterNumberSs = Screenshot.captureScreenshot(driver, "Enter Invalid Number");
//        test.pass("Enter Invalid Phone Number", MediaEntityBuilder.createScreenCaptureFromPath(btnInvalidEnterNumberSs).build());
//        Thread.sleep(2000);
//        String errorNotificationSs = Screenshot.captureScreenshot(driver, "Invalid Provider Code Error Notifications");
//        test.pass("Invalid Provider Code Error Notifications",
//                MediaEntityBuilder.createScreenCaptureFromPath(errorNotificationSs).build());
//        driver.terminateApp("com.skorlife.score");
//        driver.activateApp("com.skorlife.score");
//    }
//
//    @Test(priority = 3)
//    public void SignInWithanInvalidPhoneNumberLessThanTendigits() throws InterruptedException {
//        ExtentTest test = ExtentReports.getExtent().createTest("[NEGATIVE] Sign In Using a Phone Number Less Than 10 Digits.");
//        test.info("User on PIN Page");
//        Thread.sleep(4000);
//        String backOnPin = Screenshot.captureScreenshot(driver, "Back_to_Animations_Page");
//        test.pass("Back To Animations Page", MediaEntityBuilder.createScreenCaptureFromPath(backOnPin).build());
//        pinScreen.setBtnBackToLogin();
//        Thread.sleep(12000);
//        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
//        test.pass("Waiting for All Animations",
//                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
//        loginScreen.setBtnInputNumber();
//        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
//        test.pass("Tap Phone Number Input Field",
//                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
//        loginScreen.setBtnLessEnterNumber();
//        String btnInvalidEnterNumberSs = Screenshot.captureScreenshot(driver, "Enter_Number_Less_Than_Ten_Digits");
//        test.pass("Enter Number Less Than Ten Digits", MediaEntityBuilder.createScreenCaptureFromPath(btnInvalidEnterNumberSs).build());
//        Thread.sleep(2000);
//        String errorNotificationSs = Screenshot.captureScreenshot(driver, "Phone Number Less Than 10 Digits Error Notifications");
//        test.pass("Phone Number Less Than 10 Digits Error Notifications",
//                MediaEntityBuilder.createScreenCaptureFromPath(errorNotificationSs).build());
//        driver.terminateApp("com.skorlife.score");
//        driver.activateApp("com.skorlife.score");
//    }
//
//    @Test(priority = 4)
//    public void SignInWithanInvalidPhoneNumberMoreThanTendigits() throws InterruptedException {
//        ExtentTest test = ExtentReports.getExtent().createTest("[NEGATIVE] Sign In Using a Phone Number More Than 13 Digits.");
//        test.info("User on PIN Page");
//        Thread.sleep(4000);
//        String backOnPin = Screenshot.captureScreenshot(driver, "Back_to_Animations_Page");
//        test.pass("Back To Animations Page", MediaEntityBuilder.createScreenCaptureFromPath(backOnPin).build());
//        pinScreen.setBtnBackToLogin();
//        Thread.sleep(12000);
//        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
//        test.pass("Waiting for All Animations",
//                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
//        loginScreen.setBtnInputNumber();
//        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
//        test.pass("Tap Phone Number Input Field",
//                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
//        loginScreen.setBtnMoreEnterNumber();
//        String btnInvalidEnterNumberSs = Screenshot.captureScreenshot(driver, "Enter Number More Than Ten Digits");
//        test.pass("Enter Number More Than Ten Digits", MediaEntityBuilder.createScreenCaptureFromPath(btnInvalidEnterNumberSs).build());
//        Thread.sleep(2000);
//        String errorNotificationSs = Screenshot.captureScreenshot(driver, "Enter Number More Than Ten Digit Error Notifications");
//        test.pass("Enter Number More Than Ten Digit Error Notifications",
//                MediaEntityBuilder.createScreenCaptureFromPath(errorNotificationSs).build());
//        driver.terminateApp("com.skorlife.score");
//        driver.activateApp("com.skorlife.score");
//    }
//
//    @Test(priority = 5)
//    public void SignInWithInvalidPinCode() throws InterruptedException {
//        ExtentTest test = ExtentReports.getExtent().createTest("[NEGATIVE] Sign In With Invalid PIN Code.");
//        test.info("User on PIN Page");
//        Thread.sleep(4000);
//        String backOnPin = Screenshot.captureScreenshot(driver, "Back_to_Animations_Page");
//        test.pass("Back To Animations Page", MediaEntityBuilder.createScreenCaptureFromPath(backOnPin).build());
//        pinScreen.setBtnBackToLogin();
//        Thread.sleep(12000);
//        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
//        test.pass("Waiting for All Animations",
//                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
//        loginScreen.setBtnInputNumber();
//        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
//        test.pass("Tap Phone Number Input Field",
//                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
//        loginScreen.setBtnValidEnterNumber();
//        String btnPhoneNumberSs = Screenshot.captureScreenshot(driver, "User_Enter_a_Phone_Number");
//        test.pass("User Enter a Phone Number",
//                MediaEntityBuilder.createScreenCaptureFromPath(btnPhoneNumberSs).build());
//        loginScreen.setBtnLanjutkan();
//        String btnLanjutkanSs = Screenshot.captureScreenshot(driver, "Click_Lanjutkan_Button");
//        test.pass("Click Lanjutkan Button",
//                MediaEntityBuilder.createScreenCaptureFromPath(btnLanjutkanSs).build());
//        pinScreen.setBtnTwo();
//        String setBtnTwoSs = Screenshot.captureScreenshot(driver, "Tap_2");
//        test.pass("Tap 2",
//                MediaEntityBuilder.createScreenCaptureFromPath(setBtnTwoSs).build());
//        pinScreen.setBtnSeven();
//        String setBtnSevenSs = Screenshot.captureScreenshot(driver, "Tap_7");
//        test.pass("Tap 7",
//                MediaEntityBuilder.createScreenCaptureFromPath(setBtnSevenSs).build());
//        pinScreen.setBtnSix();
//        String setBtnSixSs = Screenshot.captureScreenshot(driver, "Tap_6");
//        test.pass("Tap 6",
//                MediaEntityBuilder.createScreenCaptureFromPath(setBtnSixSs).build());
//        Thread.sleep(2000);
//        String errorNotificationSs = Screenshot.captureScreenshot(driver, "Invalid PIN Code Error Notifications");
//        test.pass("Invalid PIN Code Error Notifications",
//                MediaEntityBuilder.createScreenCaptureFromPath(errorNotificationSs).build());
//        driver.terminateApp("com.skorlife.score");
//        driver.activateApp("com.skorlife.score");
//    }
//
//    @Test(priority = 6)
//    public void SignInWithInvalidPinCodeMoreThanThreeTimes() throws InterruptedException {
//        ExtentTest test = ExtentReports.getExtent().createTest("[NEGATIVE] Sign In With Invalid PIN Code With More Than 3 Times.");
//        test.info("User on PIN Page");
//        Thread.sleep(4000);
//        String backOnPin = Screenshot.captureScreenshot(driver, "Back_to_Animations_Page");
//        test.pass("Back To Animations Page", MediaEntityBuilder.createScreenCaptureFromPath(backOnPin).build());
//        pinScreen.setBtnBackToLogin();
//        Thread.sleep(12000);
//        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
//        test.pass("Waiting for All Animations",
//                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
//        loginScreen.setBtnInputNumber();
//        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
//        test.pass("Tap Phone Number Input Field",
//                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
//        loginScreen.setBtnValidEnterNumber();
//        String btnPhoneNumberSs = Screenshot.captureScreenshot(driver, "User_Enter_a_Phone_Number");
//        test.pass("User Enter a Phone Number",
//                MediaEntityBuilder.createScreenCaptureFromPath(btnPhoneNumberSs).build());
//        loginScreen.setBtnLanjutkan();
//        String btnLanjutkanSs = Screenshot.captureScreenshot(driver, "Click_Lanjutkan_Button");
//        test.pass("Click Lanjutkan Button",
//                MediaEntityBuilder.createScreenCaptureFromPath(btnLanjutkanSs).build());
//        pinScreen.setBtnTwo();
//        pinScreen.setBtnEight();
//        pinScreen.setBtnNine();
//        String setOneTimes = Screenshot.captureScreenshot(driver, "First Error Message");
//        test.pass("First Error Message",
//                MediaEntityBuilder.createScreenCaptureFromPath(setOneTimes).build());
//        pinScreen.setBtnNine();
//        pinScreen.setBtnOne();
//        pinScreen.setBtnFive();
//        String seTwoTimes = Screenshot.captureScreenshot(driver, "Second Error Message");
//        test.pass("Second Error Message",
//                MediaEntityBuilder.createScreenCaptureFromPath(seTwoTimes).build());
//        pinScreen.setBtnTwo();
//        pinScreen.setBtnThree();
//        pinScreen.setBtnFour();
//        String setThreeTimes = Screenshot.captureScreenshot(driver, "Third Error Message");
//        test.pass("Second Error Message",
//                MediaEntityBuilder.createScreenCaptureFromPath(setThreeTimes).build());
//        Thread.sleep(2000);
//        String errorNotificationSs = Screenshot.captureScreenshot(driver, "Block User Notifications");
//        test.pass("Block User Notifications",
//                MediaEntityBuilder.createScreenCaptureFromPath(errorNotificationSs).build());
//        driver.terminateApp("com.skorlife.score");
//        driver.activateApp("com.skorlife.score");
//    }
//
//    @Test(priority = 7)
//    public void LinkToKetentuanLayanan() throws InterruptedException {
//        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] User Link to Ketentuan Layanan.");
//        test.info("User on PIN Page");
//        Thread.sleep(4000);
//        String backOnPin = Screenshot.captureScreenshot(driver, "Back_to_Animations_Page");
//        test.pass("Back To Animations Page", MediaEntityBuilder.createScreenCaptureFromPath(backOnPin).build());
//        pinScreen.setBtnBackToLogin();
//        Thread.sleep(12000);
//        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
//        test.pass("Waiting for All Animations",
//                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
//        loginScreen.setBtnInputNumber();
//        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
//        test.pass("Tap Phone Number Input Field",
//                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
//        loginScreen.setTxtBtnKetentuanLayanan();
//        String txtKetentuanLayananSs = Screenshot.captureScreenshot(driver,"Move_to_Ketentuan_Layanan_Page");
//        test.pass("Tap Ketentuan Layanan TextButton", MediaEntityBuilder.createScreenCaptureFromPath(txtKetentuanLayananSs).build());
//        Thread.sleep(2000);
//        driver.terminateApp("com.skorlife.score");
//        driver.activateApp("com.skorlife.score");
//    }
//    @Test(priority = 8)
//    public void LinkToKebijakanPrivasi() throws InterruptedException {
//        ExtentTest test = ExtentReports.getExtent().createTest("[POSITIVE] User Link to Kebijakan Privasi.");
//        test.info("User on PIN Page");
//        Thread.sleep(4000);
//        String backOnPin = Screenshot.captureScreenshot(driver, "Back_to_Animations_Page");
//        test.pass("Back To Animations Page", MediaEntityBuilder.createScreenCaptureFromPath(backOnPin).build());
//        pinScreen.setBtnBackToLogin();
//        Thread.sleep(12000);
//        String setAnimationSs = Screenshot.captureScreenshot(driver, "Waiting_For_All_Animations");
//        test.pass("Waiting for All Animations",
//                MediaEntityBuilder.createScreenCaptureFromPath(setAnimationSs).build());
//        loginScreen.setBtnInputNumber();
//        String btnInputNumberSs = Screenshot.captureScreenshot(driver, "Tap_Phone_Number_Input_Field");
//        test.pass("Tap Phone Number Input Field",
//                MediaEntityBuilder.createScreenCaptureFromPath(btnInputNumberSs).build());
//        loginScreen.setTxtBtnKetentuanLayanan();
//        String txtKetentuanLayananSs = Screenshot.captureScreenshot(driver,"Move_to_Kebijakan_Privasi_Page");
//        test.pass("Tap Kebijakan Privasi TextButton", MediaEntityBuilder.createScreenCaptureFromPath(txtKetentuanLayananSs).build());
//        Thread.sleep(2000);
//        driver.terminateApp("com.skorlife.score");
//        driver.activateApp("com.skorlife.score");
//    }





//    --------- DONT DELETE CODE BELOW !!! -------
//    //---------- Check Status KOL ----------
//        try {
//        WebElement statusKolElement = driver.findElement(By.xpath("//android.view.View[@content-desc='Scrim']"));
//
//        if (statusKolElement.isDisplayed()) {
//            String screenshotPath = Screenshot.captureScreenshot(driver, "StatusKOL_Muncul");
//            test.pass("Status KOL muncul",
//                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//            dashboardScreen.setKolStatus();
//        } else {
//            String screenshotPath = Screenshot.captureScreenshot(driver, "StatusKOL_TidakMuncul");
//            test.fail("Status KOL tidak muncul",
//                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//        }
//    } catch (NoSuchElementException e) {
//        String screenshotPath = Screenshot.captureScreenshot(driver, "StatusKOL_NotFound");
//        test.fail("Status KOL tidak ditemukan",
//                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//    }


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

