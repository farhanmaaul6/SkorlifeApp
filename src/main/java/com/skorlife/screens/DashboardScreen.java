package com.skorlife.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumExecutionMethod;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import sun.net.ApplicationProxy;

import java.time.Duration;
import java.util.Collections;

public class DashboardScreen {
    AndroidDriver driver;
    //App Bar
    private By btnProfilePage = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]");
    private By btnInbox = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View");
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
    private By txtBtnActiveStatus = AppiumBy.xpath("//android.view.View[@content-desc=\"31 hari\"]");
    private By btnCloseActiveStatus = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Oke, tutup\"]");
    private By txtBtnSubmission = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Tidak ada pengajuan pinjaman baru atas namamu.\"]");
    private By btnCloseSubmission = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Oke, tutup\"]");
    private By btnPelajariLebihLanjut = AppiumBy.xpath("//android.view.View[@content-desc=\"Pelajari lebih lanjut\"]");
    private By btnBackOnPinjaman = AppiumBy.xpath("//android.widget.Button");
    private By btnBeranda = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Beranda\"]");
    private By txtLearnSkorlife = AppiumBy.xpath("//android.view.View[@content-desc=\"Apa itu Fintech? Memahami Revolusi di Dunia Keuangan\n" +
            "Skorlife di Paylater\n" +
            "5 min read\"]");


    public DashboardScreen(AndroidDriver driver) {
        this.driver = driver;
    }
    public void setBtnProfilePage() {
        driver.findElement(btnProfilePage).click();
    }

    public void setBtnInbox() {
        driver.findElement(btnInbox).click();
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
    }

    public void setBtnCloseActiveStatus() {
        driver.findElement(btnCloseActiveStatus).click();
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



}
