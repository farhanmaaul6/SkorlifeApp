package com.skorlife.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginScreen {
    AndroidDriver driver;

    private By btnInputNumber = AppiumBy.xpath("//android.view.View[@content-desc=\"\uD83C\uDDEE\uD83C\uDDE9 +62\n" +
            "Masukkan nomor HP-mu\"]");
    private By btnEnterNumber = AppiumBy.xpath("//android.widget.EditText");
    private By btnLanjutkan = AppiumBy.accessibilityId("Lanjutkan");

    public LoginScreen (AndroidDriver driver) {
        this.driver = driver;
    }

    public void setBtnInputNumber() {
        driver.findElement(btnInputNumber).click();
    }

    public void setBtnValidEnterNumber() {
        driver.findElement(btnEnterNumber).sendKeys("836646464646");
    }

    public void setBtnInvalidEnterNumber() {
        driver.findElement(btnEnterNumber).sendKeys(" ");
    }

    public void setBtnLessEnterNumber() {
        driver.findElement(btnEnterNumber).sendKeys(" ");
    }

    public void setBtnMoreEnterNumber() {
        driver.findElement(btnEnterNumber).sendKeys(" ");
    }

    public void setBtnLanjutkan() {
        driver.findElement(btnLanjutkan).click();
    }



}
