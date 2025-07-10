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

public class LoginFlow {
    private AndroidDriver driver;
    private By notif = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
    private By loc = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private By cobaLagi = AppiumBy.accessibilityId("Coba lagi");
    private By inputNo = AppiumBy.xpath("//android.view.View[@content-desc=\"\uD83C\uDDEE\uD83C\uDDE9 +62\n" +
            "Masukkan nomor HP-mu\"]");
    private By enterNo = AppiumBy.xpath("//android.widget.EditText");
    private By lanjutkan = AppiumBy.accessibilityId("Lanjutkan");
    private By buttonOne = AppiumBy.accessibilityId("1");
    private By buttonTwo = AppiumBy.accessibilityId("2");
    private By buttonThree = AppiumBy.accessibilityId("3");
    private By profilePage = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]");
    private By UpdateInfo = AppiumBy.accessibilityId("Update Info");
    private By simpanInfo = AppiumBy.accessibilityId("Simpan");
    private By previousButton = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button");
    private By logOutButton = AppiumBy.xpath("//android.widget.Button");
    private By pasHouses = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Pashouses\n" +
            "Kunjungi properti impianmu\"]");
    private By goroGoro = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"GORO\n" +
            "Partner GORO untuk investasi\"]");
    private By creditCard = AppiumBy.xpath("//android.view.View[@content-desc=\"KARTU KREDIT\"]");
    private By loan = AppiumBy.xpath("//android.view.View[@content-desc=\"PINJAMAN\"]");
    private By other = AppiumBy.xpath("//android.view.View[@content-desc=\"LAINNYA\"]");
    private By forYou = AppiumBy.xpath("//android.view.View[@content-desc=\"UNTUK ANDA\"]");
    private By header = AppiumBy.xpath("//android.view.View[@content-desc=\"Rekomendasi untukmu\"]");
    private By pinjaman = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Pinjaman\"]");
    private By statusKol = AppiumBy.xpath("//android.view.View[@content-desc=\"KOL 1\n" +
            "Lancar\n" +
            "\uD83D\uDD25 1\"]");
    private By closeStatusKolPage = AppiumBy.xpath("//android.view.View[@content-desc=\"Scrim\"]");
    private By totalPinjaman = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"TOTAL PINJAMAN\n" +
            "Rp1.530.493\"]");
    private By backPinjamanButton = AppiumBy.xpath("//android.view.View[@content-desc=\"Total Pinjaman\"]/android.view.View[2]");
    private By pengajuanPinjaman = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Tidak ada pengajuan pinjaman baru atas namamu.\"]");
    private By closePengajuanPinjamanButton = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Oke, tutup\"]");
    private By pelajariLebihLanjutButton = AppiumBy.xpath("//android.view.View[@content-desc=\"Pelajari lebih lanjut\"]");
    private By beranda = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Beranda\"]");
    private By learnSkorlife = AppiumBy.xpath("//android.view.View[@content-desc=\"LEARN WITH SKORLIFE\"]");

    public LoginFlow(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setNotif() {
        driver.findElement(notif).click();
    }

    public void setLoc() {
        driver.findElement(loc).click();
    }

    public void clickInputNo() {
        driver.findElement(inputNo).click();
    }

    public void enterPhoneNo() {
        driver.findElement(enterNo).sendKeys("81284929984");
    }

    public void lanjutkanButton() {
        driver.findElement(lanjutkan).click();
    }

    public void clickButtonOne() {
        driver.findElement(buttonOne).click();
    }

    public void clickButtonTwo() {
        driver.findElement(buttonTwo).click();
    }

    public void clickButtonThree() {
        driver.findElement(buttonThree).click();
    }

    public void clickProfilePage() {
        driver.findElement(profilePage).click();
    }

    public void clickUpdateInfo() {
        driver.findElement(UpdateInfo).click();
    }

    public void clickSimpanInfo() {
        driver.findElement(simpanInfo).click();
    }

    public void clickPreviousButton() {
        driver.findElement(previousButton).click();
    }

    public void clickForYou() {
        driver.findElement(forYou).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logOutButton).click();
    }

    public void clickPinjaman() {
        driver.findElement(pinjaman).click();
    }

    public void swipeHeader(String direction) {
        WebElement itemElement = driver.findElement(header);
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

    public void clickCredit() {
        driver.findElement(creditCard).click();
    }

    public void clickLoan() {
        driver.findElement(loan).click();
    }

    public void clickOthers() {
        driver.findElement(other).click();
    }

    public void setStatusKol() {
        driver.findElement(statusKol).click();
    }

    public void setCloseStatusKolPage() {
        driver.findElement(closeStatusKolPage).click();
    }

    public void setTotalPinjaman() {
        driver.findElement(totalPinjaman).click();
    }

    public void setBackPinjamanButton() {
        driver.findElement(backPinjamanButton).click();
    }

    public void setPengajuanPinjaman() {
        driver.findElement(pengajuanPinjaman).click();
    }

    public void setClosePengajuanPinjamanButton() {
        driver.findElement(closePengajuanPinjamanButton).click();
    }

    public void setPelajariLebihLanjutButton() {
        driver.findElement(pelajariLebihLanjutButton).click();
    }

    public void setBeranda() {
        driver.findElement(beranda).click();
    }

    public void swipeList(String direction) {
        WebElement itemElement = driver.findElement(learnSkorlife);
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
