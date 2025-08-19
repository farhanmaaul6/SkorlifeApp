package com.skorlife;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidManager {
    static AndroidDriver driver;
  static DesiredCapabilities capabilities;

    public static AndroidDriver buildDriver(String deviceName, String url) throws MalformedURLException {
         capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("appium:deviceName",deviceName);
    capabilities.setCapability("appium:appPackage","com.skorlife.score");
    capabilities.setCapability("appium:automationName", "UiAutomator2");
    capabilities.setCapability("appium:appActivity",".MainActivity");
    // capabilities.setCapability("appium:appActivity", ConfigReader.get("appium.appActivity"));

    // return new AndroidDriver(new URL(ConfigReader.get("appium.host") + ":" + ConfigReader.get("appium.port")),
    //     capabilities);

        // UiAutomator2Options options = new UiAutomator2Options();

        // options.setCapability("platformName","Android");
        // options.setCapability("appium:deviceName",deviceName);

        // options.setCapability("appium:appPackage","com.skorlife.score");
        // options.setCapability("appium:appActivity",".MainActivity");

        AndroidDriver driver = new AndroidDriver(new URL(url), capabilities);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // driver.hideKeyboard();

        return driver;
    }
}
