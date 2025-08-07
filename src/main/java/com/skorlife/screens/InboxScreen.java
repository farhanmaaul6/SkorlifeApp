package com.skorlife.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class InboxScreen {
    AndroidDriver driver;

    //Tab View
    private By tvNotification = AppiumBy.xpath("//android.view.View[@content-desc=\"Notifikasi\n" +
            "Tab 1 of 2\"]");
    private By tvReport = AppiumBy.xpath("//android.view.View[@content-desc=\"Laporan\n" +
            "Tab 2 of 2\"]");

    //Back Button
    private By btnBack = AppiumBy.xpath("//android.widget.Button");

    //Filter
    private By btnFilter = AppiumBy.xpath("//android.widget.EditText/android.widget.Button");
    private By btnAllTicket = AppiumBy.accessibilityId("Semua");
    private By btnCreateTicket = AppiumBy.accessibilityId("Tiket Dibuat");
    private By btnProcessTicket = AppiumBy.accessibilityId("Tiket Diproses");
    private By btnDoneTicket = AppiumBy.accessibilityId("Tiket Selesai");
    private By btnCancelTicket = AppiumBy.accessibilityId("Tiket Dibatalkan");


    public InboxScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setTvNotification() {
        driver.findElement(tvNotification).click();
    }

    public void setTvReport() {
        driver.findElement(tvReport).click();
    }

    public void setBtnBack() {
        driver.findElement(btnBack).click();
    }

    public void setBtnFilter() {
        driver.findElement(btnFilter).click();
    }

    public void setBtnAllTicket() {
        driver.findElement(btnAllTicket).click();
    }

    public void setBtnCreateTicket() {
        driver.findElement(btnCreateTicket).click();
    }

    public void setBtnProcessTicket() {
        driver.findElement(btnProcessTicket).click();
    }

    public void setBtnDoneTicket() {
        driver.findElement(btnDoneTicket).click();
    }

    public void setBtnCancelTicket() {
        driver.findElement(btnCancelTicket).click();
    }



}
