package com.skorlife.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PinjamanScreen {
    AndroidDriver driver;

    private By btnPinjaman = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Pinjaman\"]");
    private By btnCreditCard = AppiumBy.xpath("//android.view.View[@content-desc=\"Kartu Kredit\n" +
            "Tab 1 of 7\"]");
    private By btnPaylater = AppiumBy.xpath("//android.view.View[@content-desc=\"Paylater\n" +
            "Tab 2 of 7\"]");
    private By btnKta = AppiumBy.xpath("//android.view.View[@content-desc=\"KTA\n" +
            "Tab 3 of 7\"]");
    private By btnKkb = AppiumBy.xpath("//android.view.View[@content-desc=\"KKB\n" +
            "Tab 4 of 7\"]");
    private By btnKpr = AppiumBy.xpath("//android.view.View[@content-desc=\"KPR\n" +
            "Tab 5 of 7\"]");
    private By btnOtherLoan = AppiumBy.xpath("//android.view.View[@content-desc=\"Pinjaman Lain\n" +
            "Tab 6 of 7\"]");
    private By btnCollectius = AppiumBy.xpath("//android.view.View[@content-desc=\"Collectius\n" +
            "Tab 7 of 7\"]");


    public PinjamanScreen (AndroidDriver driver) {
        this.driver = driver;
    }

    public void setBtnPinjaman() {
        driver.findElement(btnPinjaman).click();
    }

    public void setBtnCreditCard() {
        driver.findElement(btnCreditCard).click();
    }

    public void setBtnPaylater() {
        driver.findElement(btnPaylater).click();
    }

    public void setBtnKta() {
        driver.findElement(btnKta).click();
    }

    public void setBtnKkb() {
        driver.findElement(btnKkb).click();
    }

    public void setBtnKpr() {
        driver.findElement(btnKpr).click();
    }

    public void setBtnOtherLoan() {
        driver.findElement(btnOtherLoan).click();
    }

    public void setBtnCollectius() {
        driver.findElement(btnCollectius).click();
    }


}
