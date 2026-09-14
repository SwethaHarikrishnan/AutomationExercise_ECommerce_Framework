package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    By nameField =
            By.name("name");

    By emailField =
            By.xpath("//input[@data-qa='signup-email']");

    By signupButton =
            By.xpath("//button[@data-qa='signup-button']");

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }

    public boolean isSignupPageDisplayed() {
        return driver.getPageSource()
                .contains("Enter Account Information");
    }
}