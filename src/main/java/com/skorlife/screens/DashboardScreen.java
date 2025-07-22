package com.skorlife.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class DashboardScreen {
    AndroidDriver driver;
    //App Bar
    private By btnProfilePage = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]");
    private By btnNotifications = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View");
    //Tab Bar
    private By tbCreditCard = AppiumBy.xpath("//android.view.View[@content-desc=\"Kartu\"]");
    private By tbLoan = AppiumBy.xpath("//android.view.View[@content-desc=\"Pinjaman\"]");
    private By tbOther = AppiumBy.xpath("//android.view.View[@content-desc=\"Lainnya\"]");
    private By tbForYou = AppiumBy.xpath("//android.view.View[@content-desc=\"Rekomendasi\"]");
    private By tbPinjaman = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Pinjaman\"]");

    private By txtHeader = AppiumBy.xpath("//android.view.View[@content-desc=\"Berdasarkan kebutuhan dan skor kredit. Bangun riwayat kredit yang sehat.\"]");
    private By kolStatus = AppiumBy.xpath("//android.view.View[@content-desc=\"KOL 1\n" +
            "Lancar\n" +
            "\uD83D\uDD25 1\"]");
    private By pengajuanPinjaman = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Tidak ada pengajuan pinjaman baru atas namamu.\"]");
    private By totalPinjaman = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"TOTAL PINJAMAN\n" +
            "Rp1.530.493\"]");
    private By btnPelajariLebihLanjut = AppiumBy.xpath("//android.view.View[@content-desc=\"Pelajari lebih lanjut\"]");
    private By btnBeranda = AppiumBy.accessibilityId("Beranda");
    private By txtLearnSkorlife = AppiumBy.xpath("//android.view.View[@content-desc=\"Apa itu Fintech? Memahami Revolusi di Dunia Keuangan\n" +
            "Skorlife di Paylater\n" +
            "5 min read\"]");


    public DashboardScreen(AndroidDriver driver) {
        this.driver = driver;
    }
    public void setBtnProfilePage() {
        driver.findElement(btnProfilePage).click();
    }

    public void setBtnNotifications() {
        driver.findElement(btnNotifications).click();
    }

    public void setTbForYou() {
        driver.findElement(tbForYou).click();
    }

    public void setTbPinjaman() {
        driver.findElement(tbPinjaman).click();
    }

    public void setTbCreditCard() {
        driver.findElement(tbCreditCard).click();
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

    public void setTotalPinjaman() {
        driver.findElement(totalPinjaman).click();
    }

    public void setPengajuanPinjaman() {
        driver.findElement(pengajuanPinjaman).click();
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
                Duration.ofMillis(1000),
                PointerInput.Origin.viewport(),
                endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        // eksekusi
        driver.perform(Collections.singletonList(swipe));
    }

    public void swipeList(String direction) {
        WebElement itemElement = driver.findElement(txtLearnSkorlife);
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
                Duration.ofMillis(1000),
                PointerInput.Origin.viewport(),
                endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        // eksekusi
        driver.perform(Collections.singletonList(swipe));
    }



}
