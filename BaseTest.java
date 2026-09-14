package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.utilities.ScreenshotUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://automationexercise.com/");
    }

    @AfterMethod
    public void captureScreenshot(ITestResult result) {

        String status =
                result.getStatus() == ITestResult.SUCCESS
                ? "SUCCESS"
                : "FAILURE";

        ScreenshotUtils.captureScreenshot(
                driver,
                result.getName() + "_" + status);
    }

    @AfterSuite
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}