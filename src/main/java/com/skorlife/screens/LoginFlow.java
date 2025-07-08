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
//    private By goroGoro = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"GORO\n" +
//            "Partner GORO untuk investasi\"]");
    private By creditCard = AppiumBy.accessibilityId("Credit card");
    private By loan = AppiumBy.accessibilityId("Loan");
    private By other = AppiumBy.xpath("//android.view.View[@content-desc=\"Others\"]/android.widget.ImageView");
    private By forYou = AppiumBy.accessibilityId("For you");
    private By header = AppiumBy.xpath("//android.view.View[@content-desc=\"Rekomendasi untukmu\"]");
    private By pinjaman = AppiumBy.accessibilityId("Pinjaman");


    public LoginFlow(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setNotif() {
        driver.findElement(notif).click();
    }

    public void setLoc() {
        driver.findElement(loc).click();
    }

//    public void setCobaLagi() {
//        driver.findElement(cobaLagi).click();
//    }

    public void clickInputNo() {
        driver.findElement(inputNo).click();
    }

    public void enterPhoneNo() {
        driver.findElement(enterNo).sendKeys("8111222333");
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

    public void swipe(String direction) {
        WebElement itemElement = driver.findElement(pasHouses);
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

        int swipeDistance = 300;

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

        // jempol kita nyentuh layar di titik awal
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // jempol mesti geser ke titik akhir
        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(1000),
                PointerInput.Origin.viewport(),
                endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // niatin buat jalanin
        driver.perform(Collections.singletonList(swipe));
    }

//    public void swipeUp(String direction) {
//        WebElement itemElement = driver.findElement(header);
//        Rectangle rectangle = itemElement.getRect();
//
//        int elementX = rectangle.getX();
//        int elementY = rectangle.getY();
//        int elementWidth = rectangle.getWidth();
//        int elementHeight = rectangle.getHeight();
//
//        // titik awal jari kita pengen ada di tengah
//        int startX = elementX + (elementWidth / 2);
//        int startY = elementY + (elementHeight / 2);
//        int endX = startX;
//        int endY = startY;
//
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
//        Sequence swipe = new Sequence(finger, 0);
//
//        int swipeDistance = 900;
//
//        switch (direction.toLowerCase()) {
//            case "up":
//                endY = startY - swipeDistance;
//                break;
//            case "down":
//                endY = startY + swipeDistance;
//                break;
//            case "left":
//                endX = startX - swipeDistance;
//                break;
//            case "right":
//                endX = startX + swipeDistance;
//                break;
//            default:
//                endX = startX - swipeDistance;
//        }
//
//        // jempol kita nyentuh layar di titik awal
//        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), startX, startY));
//        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//
//        // jempol mesti geser ke titik akhir
//        swipe.addAction(finger.createPointerMove(
//                Duration.ofMillis(1000),
//                PointerInput.Origin.viewport(),
//                endX, endY));
//        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//        // niatin buat jalanin
//        driver.perform(Collections.singletonList(swipe));
//    }

    public void clickCredit() {
        driver.findElement(creditCard).click();
    }

    public void clickLoan() {
        driver.findElement(loan).click();
    }

    public void clickOthers() {
        driver.findElement(other).click();
    }

}
