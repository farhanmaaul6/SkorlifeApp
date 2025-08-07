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
    private By txtBtnKetentuanLayanan = AppiumBy.xpath("//android.view.View[@content-desc=\"Ketentuan Layanan \"]");
    private By txtBtnKebijakanPrivasi = AppiumBy.xpath("//android.view.View[@content-desc=\"Kebijakan Privasi \"]");


    public LoginScreen (AndroidDriver driver) {
        this.driver = driver;
    }

    public void setBtnInputNumber() {
        driver.findElement(btnInputNumber).click();
    }

    public void setBtnValidEnterNumber() {
        driver.findElement(btnEnterNumber).sendKeys("87880624699");
    }

    public void setBtnNewValidEnterNumber() {
        driver.findElement(btnEnterNumber).sendKeys("888333666999");
    }

    public void setBtnInvalidEnterNumber() {
        driver.findElement(btnEnterNumber).sendKeys("56545465465");
    }

    public void setBtnLessEnterNumber() {
        driver.findElement(btnEnterNumber).sendKeys("8172837");
    }

    public void setBtnMoreEnterNumber() {
        driver.findElement(btnEnterNumber).sendKeys("880808080880808");
    }

    public void setBtnLanjutkan() {
        driver.findElement(btnLanjutkan).click();
    }

    public void setTxtBtnKetentuanLayanan() {
        driver.findElement(txtBtnKetentuanLayanan).click();
    }

    public void setTxtBtnKebijakanPrivasi() {
        driver.findElement(txtBtnKebijakanPrivasi).click();
    }



}
