package com.skorlife;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.skorlife.screens.*;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ProfileScreenTest {
    AndroidDriver driver;
    PermissionScreen permissionScreen;
    LoginScreen loginScreen;
    PinScreen pinScreen;
    DashboardScreen dashboardScreen;
    ProfileScreen profileScreen;
    OtpScreen otpScreen;

    @BeforeClass
    public void setupProfileTest() throws MalformedURLException {
        driver = DriverSingleton.getDriver();

        permissionScreen = new PermissionScreen(driver);
        loginScreen = new LoginScreen(driver);
        pinScreen = new PinScreen(driver);
        dashboardScreen = new DashboardScreen(driver);
        profileScreen = new ProfileScreen(driver);
        otpScreen = new OtpScreen(driver);
    }


    @Test(priority = 1)
    public void informasiPribadi() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("32. [POSITIVE] Tap Halaman Informasi Pribadi on Profile Screen");
        Thread.sleep(2000);
        pinScreen.setBtnBackToLogin();
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
        dashboardScreen.setBtnProfilePage();
        Thread.sleep(2000);
        String btnProfilePageSs = Screenshot.captureScreenshot(driver, "Tap Profile Page ");
        test.pass("Tap Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(btnProfilePageSs).build());
        profileScreen.setBtnInformasiPribadi();
        Thread.sleep(2000);
        String btnInformasiPribadiSs = Screenshot.captureScreenshot(driver, "Tap Informasi Pribadi Page ");
        test.pass("Tap Informasi Pribadi Page", MediaEntityBuilder.createScreenCaptureFromPath(btnInformasiPribadiSs).build());
    }

    @Test(priority = 2)
    public void riwayatPembayaran() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("33. [POSITIVE] Tap Halaman Riwayat Pembayaran on Profile Screen");
        profileScreen.setBtnBack();
        String userOnProfilePage = Screenshot.captureScreenshot(driver, "User_On_Profile_Page");
        test.info("User On Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnProfilePage).build());
        profileScreen.setBtnRiwayatPembayaran();
        Thread.sleep(2000);
        String btnRiwayatPembayaranSs = Screenshot.captureScreenshot(driver, "Tap Riwayat Pembayaran Button");
        test.pass("Riwayat Pembayaran Page Openened", MediaEntityBuilder.createScreenCaptureFromPath(btnRiwayatPembayaranSs).build());
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void laporanKredit() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("34. [POSITIVE] Tap Halaman Informasi Pribadi on Profile Screen");
        profileScreen.setBtnBack();
        Thread.sleep(2000);
        String userOnProfilePage = Screenshot.captureScreenshot(driver, "User_On_Profile_Page");
        test.info("User On Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnProfilePage).build());
        profileScreen.setBtnLaporanKredit();
        Thread.sleep(2000);
        String btnLaporanKredit = Screenshot.captureScreenshot(driver, "Tap Laporan Kredit Page ");
        test.pass("Laporan Kredit Page Opened", MediaEntityBuilder.createScreenCaptureFromPath(btnLaporanKredit).build());
    }

    @Test(priority = 4)
    public void emailTambahan() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("35. [POSITIVE] Tap Halaman Email Tambahan on Profile Screen");
        profileScreen.setDismiss();
        String userOnProfilePage = Screenshot.captureScreenshot(driver, "User_On_Profile_Page");
        test.info("User On Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnProfilePage).build());
        profileScreen.setBtnEmailTambahan();
        Thread.sleep(2000);
        String btnEmailTambahanSs = Screenshot.captureScreenshot(driver, "Tap Email Tambahan Button");
        test.pass("Tambah Email Page Openened", MediaEntityBuilder.createScreenCaptureFromPath(btnEmailTambahanSs).build());
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void resetPin() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("36. [POSITIVE] Tap Halaman Reset PIN on Profile Screen");
        profileScreen.setBtnBack();
        String userOnProfilePage = Screenshot.captureScreenshot(driver, "User_On_Profile_Page");
        test.info("User On Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnProfilePage).build());
        profileScreen.setBtnResetPin();
        Thread.sleep(2000);
        String btnResetPinSs = Screenshot.captureScreenshot(driver, "Tap Reset PIN Button");
        test.pass("Tap Reset PIN Button", MediaEntityBuilder.createScreenCaptureFromPath(btnResetPinSs).build());
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void hubungiSkorlife() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("37. [POSITIVE] Tap Halaman Hubungi Skorlife on Profile Screen");
        otpScreen.setBtnBack();
        String userOnDashboardPage = Screenshot.captureScreenshot(driver, "User_On_Dashboard_Page");
        test.info("User On Dashboard Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnDashboardPage).build());
        Thread.sleep(2000);
        dashboardScreen.setBtnProfilePage();
        String btnProfilePageSs = Screenshot.captureScreenshot(driver, "Tap Profile Page ");
        test.pass("Tap Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(btnProfilePageSs).build());
        profileScreen.setBtnHubungiSkorlife();
        Thread.sleep(2000);
        String btnHubungiSkorlife = Screenshot.captureScreenshot(driver, "Tap Hubungi Skorlife Button");
        test.pass("Tap Hubungi Skorlife Button", MediaEntityBuilder.createScreenCaptureFromPath(btnHubungiSkorlife).build());
    }

    @Test(priority = 7)
    public void faq() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("38. [POSITIVE] Tap Halaman Faq on Profile Screen");
        profileScreen.setDismiss();
        String userOnProfilePage = Screenshot.captureScreenshot(driver, "User_On_Profile_Page");
        test.info("User On Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnProfilePage).build());
        profileScreen.setBtnFaq();
        Thread.sleep(4000);
        String btnFaqSs = Screenshot.captureScreenshot(driver, "Tap Faq Page");
        test.pass("Faq Page Openened", MediaEntityBuilder.createScreenCaptureFromPath(btnFaqSs).build());
        driver.terminateApp("com.skorlife.score");
        driver.activateApp("com.skorlife.score");
    }

    @Test(priority = 8)
    public void kebijakanPrivasi() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("39. [POSITIVE] Tap Halaman Kebijakan Privasi on Profile Screen");
        Thread.sleep(4000);String userOnPinPage = Screenshot.captureScreenshot(driver, "User_On_Pin_Page");
        test.info("User On PIN Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnPinPage).build());
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
        Thread.sleep(3000);
        String succesfullyLogintoDashboardPage = Screenshot.captureScreenshot(driver, "Dashboard_Page");
        test.pass("Succesfully Login to Dashboard Page",
                MediaEntityBuilder.createScreenCaptureFromPath(succesfullyLogintoDashboardPage).build());
        dashboardScreen.setBtnProfilePage();
        Thread.sleep(2000);
        String btnProfilePageSs = Screenshot.captureScreenshot(driver, "Tap Profile Page ");
        test.pass("Profile Page Openened", MediaEntityBuilder.createScreenCaptureFromPath(btnProfilePageSs).build());
        profileScreen.swipeLogout("up");
        Thread.sleep(2000);
        String btnSwipeUp = Screenshot.captureScreenshot(driver, "Scroll Up Profile Page ");
        test.pass("Scroll Up Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(btnSwipeUp).build());
        profileScreen.setTxtBtnKebijakanPrivasi();
        Thread.sleep(2000);
        String btnKebijakanPrivasiSs = Screenshot.captureScreenshot(driver, "Tap Kebijakan Privasi Button ");
        test.pass("Kebijakan Privasi Page Openened", MediaEntityBuilder.createScreenCaptureFromPath(btnKebijakanPrivasiSs).build());
    }

    @Test(priority = 9)
    public void KetentuanPenggunaan() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("40. [POSITIVE] Tap Halaman Ketentuan Penggunaan on Profile Screen");
        profileScreen.setBtnBack();
        String userOnProfilePage = Screenshot.captureScreenshot(driver, "User_On_Profile_Page");
        test.info("User On Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnProfilePage).build());
        profileScreen.setTxtBtnKetentuanPenggunaan();
        Thread.sleep(2000);
        String btnKetentuanPenggunaan = Screenshot.captureScreenshot(driver, "Tap Ketentuan Penggunaan Button ");
        test.pass("Ketentuan Penggunaan Page Openened", MediaEntityBuilder.createScreenCaptureFromPath(btnKetentuanPenggunaan).build());
    }

    @Test(priority = 10)
    public void KebijakanKeamanan() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("41. [POSITIVE] Tap Halaman Kebijakan Keamanan on Profile Screen");
        profileScreen.setBtnBack();
        String userOnProfilePage = Screenshot.captureScreenshot(driver, "User_On_Profile_Page");
        test.info("User On Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnProfilePage).build());
        profileScreen.setTxtBtnKebijakanKeamanan();
        Thread.sleep(2000);
        String btnKebijakanKeamanan = Screenshot.captureScreenshot(driver, "Tap Kebijakan Keamanan Button ");
        test.pass("Kebijakan Keamanan Page Openened", MediaEntityBuilder.createScreenCaptureFromPath(btnKebijakanKeamanan).build());
        profileScreen.setBtnBack();
        Thread.sleep(2000);
        String backToProfile = Screenshot.captureScreenshot(driver, "Tap Back Button ");
        test.pass("Profile Page Openened", MediaEntityBuilder.createScreenCaptureFromPath(backToProfile).build());
    }

    @Test(priority = 11)
    public void Logout() throws InterruptedException {
        ExtentTest test = ExtentReports.getExtent().createTest("42. [POSITIVE] User Logout");
        String userOnProfilePage = Screenshot.captureScreenshot(driver, "User_On_Profile_Page");
        test.info("User On Profile Page", MediaEntityBuilder.createScreenCaptureFromPath(userOnProfilePage).build());
        profileScreen.setBtnLogout();
        Thread.sleep(2000);
        String btnKebijakanKeamanan = Screenshot.captureScreenshot(driver, "Tap Logout");
        test.pass("User Logout and direct to Login Page", MediaEntityBuilder.createScreenCaptureFromPath(btnKebijakanKeamanan).build());

    }






}
