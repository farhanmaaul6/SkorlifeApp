package com.skorlife;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidManager {
    public static AndroidDriver buildDriver(String deviceName, String url) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("platformName","Android");
        options.setCapability("appium:deviceName","Xiaomi_Note_11");
        options.setCapability("appium:appPackage","com.skorlife.score");
        options.setCapability("appium:appActivity",".MainActivity");

        AndroidDriver driver = new AndroidDriver(new URL(url), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.hideKeyboard();

        return driver;
    }
}
