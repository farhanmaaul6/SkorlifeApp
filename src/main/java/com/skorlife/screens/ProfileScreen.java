package com.skorlife.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import sun.java2d.cmm.Profile;

import java.time.Duration;
import java.util.Collections;

public class ProfileScreen {
    AndroidDriver driver;

    private By txtBtnUpdate = AppiumBy.accessibilityId("Update Info");
    private By txtBtnSimpan= AppiumBy.accessibilityId("Simpan");
    private By btnBack = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button");
    private By btnLogout = AppiumBy.xpath("//android.view.View[@content-desc=\"Keluar\"]");
    private By txtUserInformation = AppiumBy.xpath("//android.view.View[@content-desc=\"Informasi Personal\"]");


    public ProfileScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setTxtBtnUpdate() {
        driver.findElement(txtBtnUpdate).click();
    }

    public void setTxtBtnSimpan() {
        driver.findElement(txtBtnSimpan).click();
    }

    public void setBtnBack() {
        driver.findElement(btnBack).click();
    }

    public void swipeLogout(String direction) {
        WebElement itemElement = driver.findElement(txtUserInformation);
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
