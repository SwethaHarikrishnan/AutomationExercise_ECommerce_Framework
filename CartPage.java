package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10));
    }

    By cartItems =
            By.xpath("//tr[contains(@id,'product')]");

    By proceedToCheckoutButton =
            By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    public boolean isCartPageDisplayed() {

        return driver.getCurrentUrl()
                .contains("view_cart");
    }

    

    public boolean isCartNotEmpty() {

        return driver.findElements(
                By.xpath("//tr[contains(@id,'product')]"))
                .size() > 0;
    }

    public void clickProceedToCheckout() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        proceedToCheckoutButton))
                .click();
    }
}