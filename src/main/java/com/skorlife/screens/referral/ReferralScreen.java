package com.skorlife.screens.referral;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ReferralScreen {
    AndroidDriver driver;

    private By btnReferral = AppiumBy.xpath("//android.view.View[@content-desc=\"Dapatkan reward\"]");
    private By btnBackOnReferral = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]");
   
    public ReferralScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setBtnReferral() {
        driver.findElement(btnReferral).click();
    }
    public void setBtnBackOnReferral() {
        driver.findElement(btnBackOnReferral).click();
    }

}
