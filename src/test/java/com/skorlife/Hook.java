package com.skorlife;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class Hook {
    @BeforeSuite
    @Parameters({ "url", "deviceName" })
    public void setup(String url, String deviceName) throws MalformedURLException {
        DriverSingleton.getDriver(deviceName, url);
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        DriverSingleton.exit();
    }
}
