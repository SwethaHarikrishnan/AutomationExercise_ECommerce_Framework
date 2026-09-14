package com.utilities;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver,
                                         String testName) {

        try {

            String timestamp = new SimpleDateFormat(
                    "yyyyMMdd_HHmmss").format(new Date());

            String screenshotPath =
                    "src/test/resources/Screenshots/"
                    + testName + "_"
                    + timestamp + ".png";

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File destination = new File(screenshotPath);

            FileUtils.copyFile(source, destination);

            System.out.println(
                    "Screenshot Saved : "
                    + destination.getAbsolutePath());

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}