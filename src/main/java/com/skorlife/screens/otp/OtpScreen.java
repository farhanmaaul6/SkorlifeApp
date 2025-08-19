package com.skorlife.screens.otp;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class OtpScreen {
    AndroidDriver driver;

    private By btnBack = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View");


    public OtpScreen (AndroidDriver driver) {
        this.driver = driver;
    }

    public void setBtnBack() {
        driver.findElement(btnBack).click();
    }

}
