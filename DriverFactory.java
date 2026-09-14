package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initializeDriver() {

        String browser =
                ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options =
                    new ChromeOptions();

            boolean headless =
                    ConfigReader.getBoolean("headless");

            if (headless) {
                options.addArguments("--headless=new");
            }

            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");

            driver.set(
                    new ChromeDriver(options)
            );

        } else {

            throw new RuntimeException(
                    "Unsupported browser: " + browser
            );
        }

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds( ConfigReader.getInt( "implicitWait")) );
                                
                        
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
               
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        if (getDriver() != null) {

            getDriver().quit();

            driver.remove();
        }
    }
}