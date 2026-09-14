package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver,
                Duration.ofSeconds(5));
    }

    By emailField =
            By.xpath("//input[@data-qa='login-email']");

    By passwordField =
            By.xpath("//input[@data-qa='login-password']");

    By loginButton =
            By.xpath("//button[@data-qa='login-button']");

    By loggedInUser =
            By.xpath("//a[contains(text(),'Logged in as')]");

    public void enterEmail(String email) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        emailField));

        driver.findElement(emailField)
                .clear();

        driver.findElement(emailField)
                .sendKeys(email);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordField)
                .clear();

        driver.findElement(passwordField)
                .sendKeys(password);
    }

    public void clickLogin() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButton));

        driver.findElement(loginButton)
                .click();
    }

    public boolean isLoginSuccessful() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            loggedInUser));

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}