package com.skorlife;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtentReports {

    private static com.aventstack.extentreports.ExtentReports extent;

    @BeforeSuite
    public void reportSetup() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-report.html");
        spark.config().setReportName("Skorlife Test Report");
        spark.config().setDocumentTitle("Automation Results");

        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Environment", "Quality Assurance");
        extent.setSystemInfo("Tester Name", "Your Name");
    }

    @AfterSuite
    public void tearDown() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static com.aventstack.extentreports.ExtentReports getExtent() {
        return extent;
    }
}
