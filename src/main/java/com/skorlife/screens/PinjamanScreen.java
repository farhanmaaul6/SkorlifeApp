package com.skorlife.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PinjamanScreen {
    AndroidDriver driver;

    private By Pinjaman = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Pinjaman\"]");
    private By paylater = AppiumBy.xpath("//android.view.View[@content-desc=\"Paylater\"]");
    private By kta = AppiumBy.xpath("//android.view.View[@content-desc=\"Paylater\"]");
    private By kkb = AppiumBy.xpath("//android.view.View[@content-desc=\"KKB\"]");
    private By kpr = AppiumBy.xpath("//android.view.View[@content-desc=\"KPR\"]");
    private By pinjamanLain = AppiumBy.xpath("//android.view.View[@content-desc=\"Pinjaman Lain\"]");
    private By collections = AppiumBy.xpath("//android.view.View[@content-desc=\"Collectius\"]");


    public PinjamanScreen (AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickPinjaman() {
        driver.findElement(Pinjaman).click();
    }

    public void clickPaylater() {
        driver.findElement(paylater).click();
    }

    public void clickKta() {
        driver.findElement(kta).click();
    }

    public void clickKkb() {
        driver.findElement(kkb).click();
    }

    public void clickKpr() {
        driver.findElement(kpr).click();
    }

    public void clickPinjamanLain() {
        driver.findElement(pinjamanLain).click();
    }

    public void clickCollection() {
        driver.findElement(collections).click();
    }


}
