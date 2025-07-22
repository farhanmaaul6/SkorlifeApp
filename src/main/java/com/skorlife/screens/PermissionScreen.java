package com.skorlife.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PermissionScreen {
    AndroidDriver driver ;

    //All Permissions
    private By btnNotification = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
    private By btnLocation = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private By btnCobaLagi = AppiumBy.accessibilityId("Coba lagi");

    public PermissionScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setBtnNotification() {
        driver.findElement(btnNotification).click();
    }

    public void setBtnLocation() {
        driver.findElement(btnLocation).click();
    }

    public void setBtnCobaLagi() {
        driver.findElement(btnCobaLagi).click();
    }




}
