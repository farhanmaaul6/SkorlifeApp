package com.skorlife.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NotificationScreen {
    AndroidDriver driver;

    //Tab View
    private By tvNotification = AppiumBy.xpath("//android.view.View[@content-desc=\"Notifikasi\n" +
            "Tab 1 of 2\"]");
    private By tvLaporan = AppiumBy.xpath("//android.view.View[@content-desc=\"Laporan\n" +
            "Tab 2 of 2\"]");

    //Back Button
    private By btnBack = AppiumBy.xpath("//android.widget.Button");


    public NotificationScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setTvNotification() {
        driver.findElement(tvNotification).click();
    }

    public void setTvLaporan() {
        driver.findElement(tvLaporan).click();
    }

    public void setBtnBack() {
        driver.findElement(btnBack).click();
    }


}
