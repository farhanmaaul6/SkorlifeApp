package com.skorlife;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtentReportsManager {

    private static com.aventstack.extentreports.ExtentReports extent;

    @BeforeSuite
    public static void reportSetup() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/surefire-reports/Skorlife_Automation_Test_Report.html");
        spark.config().setReportName("Skorlife Automation Test Report");
        spark.config().setDocumentTitle("Skorlife Automation Test Report");

        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Environment", "Quality Assurance Engineer");
        extent.setSystemInfo("Tester Name", "Farhan");
    }

    @AfterSuite
    public static void tearDown() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static com.aventstack.extentreports.ExtentReports getExtent() {
        return extent;
    }
}

//https://skorlife.com/assets/images/Skorcard_Logo_new.svg