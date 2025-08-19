package com.skorlife.screens.dashboard;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.skorlife.screens.login.LoginScreen;
import com.skorlife.screens.utils.PinScreen;
import com.skorlife.screens.utils.Screenshot;

import java.time.Duration;
import java.util.Collections;


public class DashboardScreen {
    AndroidDriver driver;
    LoginScreen loginScreen;
    PinScreen pinScreen;
    ExtentTest test;


    //Tab Bar
    private By tbCard = AppiumBy.xpath("//android.view.View[@content-desc=\"Kartu\"]");
    private By tbLoan = AppiumBy.xpath("//android.view.View[@content-desc=\"Pinjaman\"]");
    private By tbOther = AppiumBy.xpath("//android.view.View[@content-desc=\"Lainnya\"]");
    private By tbForYou = AppiumBy.xpath("//android.view.View[@content-desc=\"Rekomendasi\"]");

    private By txtHeader = AppiumBy.xpath("//android.view.View[@content-desc=\"Berdasarkan kebutuhan dan skor kredit. Bangun riwayat kredit yang sehat.\"]");
    private By kolStatus = AppiumBy.xpath("//android.view.View[@content-desc=\"KOL 1\n" +
            "Lancar\"]");
    private By btnCloseKolStatus = AppiumBy.xpath("//android.view.View[@content-desc=\"Scrim\"]");
    private By btnCreditScore = AppiumBy.xpath("//android.view.View[@content-desc=\"490\n" +
            "Risiko Tinggi\"]");
    private By btnCloseCreditScore = AppiumBy.xpath("//android.view.View[@content-desc=\"Scrim\"]");
    private By btnDismissCreditScore = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Dismiss\"]");
    private By txtBtnTotalLoan = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"TOTAL PINJAMAN\n" +
            "Rp1.350.678\"]");
    private By btnCloseTotalLoan = AppiumBy.xpath("//android.view.View[@content-desc=\"Total Pinjaman\"]/android.view.View[2]");
    private By txtBtnActiveStatus = AppiumBy.xpath("//android.view.View[@content-desc=\"0 hari\"]");
    private By btnCloseActiveStatus = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Oke, tutup\"]");
    private By txtBtnSubmission = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Tidak ada pengajuan pinjaman baru atas namamu.\"]");
    private By btnCloseSubmission = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Oke, tutup\"]");
    private By btnPelajariLebihLanjut = AppiumBy.xpath("//android.view.View[@content-desc=\"Pelajari lebih lanjut\"]");
    private By btnBeranda = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Beranda\"]");
    private By txtLearnSkorlife = AppiumBy.xpath("//android.view.View[@content-desc=\"Apa itu Fintech? Memahami Revolusi di Dunia Keuangan\n" +
            "Skorlife di Paylater\n" +
            "5 min read\"]");


    public DashboardScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setTbForYou() {
        driver.findElement(tbForYou).click();
    }

    public void setTbCard() {
        driver.findElement(tbCard).click();
    }

    public void setTbLoan() {
        driver.findElement(tbLoan).click();
    }

    public void setTbOther() {
        driver.findElement(tbOther).click();
    }

    public void setKolStatus() {
        driver.findElement(kolStatus).click();
    }

    public void setBtnCloseKolStatus() {
        driver.findElement(btnCloseKolStatus).click();
    }

    public void setBtnCreditScore() {
        driver.findElement(btnCreditScore).click();
    }

    public void setBtnCloseCreditScore() {
        driver.findElement(btnCloseCreditScore).click();
    }

    public void setTxtBtnTotalLoan() {
        driver.findElement(txtBtnTotalLoan).click();
    }

    public void setBtnCloseTotalLoan() {
        driver.findElement(btnCloseTotalLoan).click();
    }

    public void setTxtBtn30Hari() {
        driver.findElement(txtBtnActiveStatus).click();
        String screenshotPath = Screenshot.captureScreenshot(driver, "Clicked_30_Hari_Button");
        test.pass("Clicked 30 Hari Button",
                com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
   
    }

    public void setBtnCloseActiveStatus() {
        driver.findElement(btnCloseActiveStatus).click();
        String screenshotPath = Screenshot.captureScreenshot(driver, "Closed_Active_Status");
        test.info("Closed Active Status", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public void setTxtBtnSubmission(){
        driver.findElement(txtBtnSubmission).click();
    }

    public void setBtnCloseSubmission() {
        driver.findElement(btnCloseSubmission).click();
    }


    public void setBtnPelajariLebihLanjut() {
        driver.findElement(btnPelajariLebihLanjut).click();
    }

    public void setBtnBeranda() {
        driver.findElement(btnBeranda).click();
    }

    public void swipeTxtHeader(String direction) {
        WebElement itemElement = driver.findElement(txtHeader);
        Rectangle rectangle = itemElement.getRect();

        int elementX = rectangle.getX();
        int elementY = rectangle.getY();
        int elementWidth = rectangle.getWidth();
        int elementHeight = rectangle.getHeight();

        // titik awal jari kita mau ada di tengah
        int startX = elementX + (elementWidth / 2);
        int startY = elementY + (elementHeight / 2);
        int endX = startX;
        int endY = startY;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 0);

        int swipeDistance = 3000;

        switch (direction.toLowerCase()) {
            case "up":
                endY = startY - swipeDistance;
                break;
            case "down":
                endY = startY + swipeDistance;
                break;
            case "left":
                endX = startX - swipeDistance;
                break;
            case "right":
                endX = startX + swipeDistance;
                break;
            default:
                endX = startX - swipeDistance;
        }

        // titik sentuh awal ibu jari
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));

        // pergeseran ibu jari sampai ke titik akhir
        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(2000),
                PointerInput.Origin.viewport(),
                endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        // eksekusi
        driver.perform(Collections.singletonList(swipe));
    }

    public void swipeBtnDismiss(String direction) {
        WebElement itemElement = driver.findElement(btnDismissCreditScore);
        Rectangle rectangle = itemElement.getRect();

        int elementX = rectangle.getX();
        int elementY = rectangle.getY();
        int elementWidth = rectangle.getWidth();
        int elementHeight = rectangle.getHeight();

        // titik awal jari kita mau ada di tengah
        int startX = elementX + (elementWidth / 2);
        int startY = elementY + (elementHeight / 2);
        int endX = startX;
        int endY = startY;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 0);

        int swipeDistance = 3000;

        switch (direction.toLowerCase()) {
            case "up":
                endY = startY - swipeDistance;
                break;
            case "down":
                endY = startY + swipeDistance;
                break;
            case "left":
                endX = startX - swipeDistance;
                break;
            case "right":
                endX = startX + swipeDistance;
                break;
            default:
                endX = startX - swipeDistance;
        }

        // titik sentuh awal ibu jari
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));

        // pergeseran ibu jari sampai ke titik akhir
        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(2000),
                PointerInput.Origin.viewport(),
                endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        // eksekusi
        driver.perform(Collections.singletonList(swipe));
    }

    public void setTxtLearnSkorlife() throws InterruptedException {
        driver.findElement(txtLearnSkorlife).click();
    }

    public void login() throws InterruptedException {
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
        
    }



}
