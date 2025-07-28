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

public class ProfileScreen {
    AndroidDriver driver;

    private By txtBtnUpdate = AppiumBy.accessibilityId("Update Info");
    private By txtBtnSimpan= AppiumBy.accessibilityId("Simpan");
    private By btnBack = AppiumBy.xpath("//android.widget.Button");
    private By btnLogout = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Keluar\"]");
    private By txtAkun = AppiumBy.xpath("//android.view.View[@content-desc=\"AKUN\"]");
    private By btnInformasiPribadi = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Informasi pribadi\"]");
    private By btnRiwayatPembayaran = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Riwayat pembayaran\"]");
    private By btnLaporanKredit = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Laporan kredit (.pdf)\"]");
    private By btnEmailTambahan = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Email tambahan\"]");
    private By btnResetPin = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Reset PIN\"]");
    private By btnHubungiSkorlife = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Hubungi Skorlife\"]");
    private By btnFaq = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"FAQ\"]");
    private By txtBtnKebijakanPrivasi = AppiumBy.xpath("//android.view.View[@content-desc=\"Kebijakan privasi\"]");
    private By txtBtnKetentuanPenggunaan = AppiumBy.xpath("//android.view.View[@content-desc=\"Kententuan penggunaan\"]");
    private By txtBtnKebijakanKeamanan = AppiumBy.xpath("//android.view.View[@content-desc=\"Kebijakan keamanan\"]");
    private By txtBtnHapusAkun = AppiumBy.xpath("//android.view.View[@content-desc=\"Hapus akun\"]");
    private By dismiss = AppiumBy.xpath("//android.view.View[@content-desc=\"Dismiss\"]");



    public ProfileScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setBtnInformasiPribadi() {
        driver.findElement(btnInformasiPribadi).click();
    }

    public void setBtnRiwayatPembayaran() {
        driver.findElement(btnRiwayatPembayaran).click();
    }

    public void setBtnLaporanKredit() {
        driver.findElement(btnLaporanKredit).click();
    }

    public void setBtnEmailTambahan() {
        driver.findElement(btnEmailTambahan).click();
    }

    public void setBtnResetPin() {
        driver.findElement(btnResetPin).click();
    }

    public void setBtnHubungiSkorlife() {
        driver.findElement(btnHubungiSkorlife).click();
    }

    public void setBtnFaq() {
        driver.findElement(btnFaq).click();
    }

    public void setTxtBtnKebijakanPrivasi() {
        driver.findElement(txtBtnKebijakanPrivasi).click();
    }

    public void setTxtBtnKetentuanPenggunaan() {
        driver.findElement(txtBtnKetentuanPenggunaan).click();
    }

    public void setTxtBtnKebijakanKeamanan() {
        driver.findElement(txtBtnKebijakanKeamanan).click();
    }

    public void setTxtBtnHapusAkun() {
        driver.findElement(txtBtnHapusAkun).click();
    }

    public void setBtnBack() {
        driver.findElement(btnBack).click();
    }

    public void setDismiss() {
        driver.findElement(dismiss).click();
    }

//    public void setTxtBtnUpdate() {
//        driver.findElement(txtBtnUpdate).click();
//    }
//
//    public void setTxtBtnSimpan() {
//        driver.findElement(txtBtnSimpan).click();
//    }



    public void swipeLogout(String direction) {
        WebElement itemElement = driver.findElement(txtAkun);
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

    public void setBtnLogout() {
        driver.findElement(btnLogout).click();
    }



}
