package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By signupLoginLink =
            By.xpath("//a[contains(text(),'Signup / Login')]");

    public void clickSignupLogin() {
        driver.findElement(signupLoginLink).click();
    }
}