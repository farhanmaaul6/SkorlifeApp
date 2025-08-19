package com.skorlife.screens.permission;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PermissionScreen {
    AndroidDriver driver ;

    //All Permissions
    private By btnCamera = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]");
    private By btnNotification = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]");
    private By btnLocation = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]");
    private By btnCobaLagi = AppiumBy.accessibilityId("Coba lagi");

    public PermissionScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setBtnCamera() {
        driver.findElement(btnCamera).click();
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
