package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public LogoutPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10));
    }

    By logoutButton =
            By.xpath("//a[contains(text(),'Logout')]");

    By loginPageHeader =
            By.xpath("//h2[contains(text(),'Login to your account')]");

    public void clickLogout() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        logoutButton))
                .click();
    }

    public boolean isLogoutSuccessful() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            loginPageHeader));

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}