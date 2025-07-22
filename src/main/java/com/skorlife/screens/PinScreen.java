package com.skorlife.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumExecutionMethod;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PinScreen {
    AndroidDriver driver;

    private By btnOne = AppiumBy.accessibilityId("1");
    private By btnTwo = AppiumBy.accessibilityId("2");
    private By btnThree = AppiumBy.accessibilityId("3");
    private By btnFour = AppiumBy.accessibilityId("4");
    private By btnFive = AppiumBy.accessibilityId("5");
    private By btnSix = AppiumBy.accessibilityId("6");
    private By btnSeven = AppiumBy.accessibilityId("7");
    private By btnEight = AppiumBy.accessibilityId("8");
    private By btnNine = AppiumBy.accessibilityId("9");
        private By btnBackToLogin = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View");

    public PinScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setBtnOne() {
        driver.findElement(btnOne).click();
        driver.findElement(btnOne).click();
    }

    public void setBtnTwo() {
        driver.findElement(btnTwo).click();
        driver.findElement(btnTwo).click();
    }

    public void setBtnThree() {
        driver.findElement(btnThree).click();
        driver.findElement(btnThree).click();
    }

    public void setBtnFour() {
        driver.findElement(btnFour).click();
        driver.findElement(btnFour).click();
    }

    public void setBtnFive() {
        driver.findElement(btnFive).click();
        driver.findElement(btnFive).click();
    }

    public void setBtnSix() {
        driver.findElement(btnSix).click();
        driver.findElement(btnSix).click();
    }

    public void setBtnSeven() {
        driver.findElement(btnSeven).click();
        driver.findElement(btnSeven).click();
    }

    public void setBtnEight() {
        driver.findElement(btnEight).click();
        driver.findElement(btnEight).click();
    }

    public void setBtnNine() {
        driver.findElement(btnNine).click();
        driver.findElement(btnNine).click();
    }

    public void setBtnBackToLogin() {
        driver.findElement(btnBackToLogin).click();
    }


}
