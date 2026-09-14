package com.pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    public PaymentPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10));
    }

    By nameOnCard =
            By.name("name_on_card");

    By cardNumber =
            By.name("card_number");

    By cvc =
            By.name("cvc");

    By expiryMonth =
            By.name("expiry_month");

    By expiryYear =
            By.name("expiry_year");

    By payAndConfirmOrderButton =
            By.id("submit");

    By orderPlacedMessage =
            By.xpath("//b[contains(text(),'Order Placed!')]");

    By continueButton =
            By.xpath("//a[contains(text(),'Continue')]");

    public boolean isPaymentPageDisplayed() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            nameOnCard));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public void enterPaymentDetails(
            String name,
            String cardNo,
            String cvcNo,
            String month,
            String year) {

        driver.findElement(nameOnCard)
                .clear();
        driver.findElement(nameOnCard)
                .sendKeys(name);

        driver.findElement(cardNumber)
                .clear();
        driver.findElement(cardNumber)
                .sendKeys(cardNo);

        driver.findElement(cvc)
                .clear();
        driver.findElement(cvc)
                .sendKeys(cvcNo);

        driver.findElement(expiryMonth)
                .clear();
        driver.findElement(expiryMonth)
                .sendKeys(month);

        driver.findElement(expiryYear)
                .clear();
        driver.findElement(expiryYear)
                .sendKeys(year);
    }

    public void clickPayAndConfirmOrder() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        payAndConfirmOrderButton))
                .click();
    }

    public boolean isOrderPlacedDisplayed() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            orderPlacedMessage));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public void clickContinue() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        continueButton))
                .click();
    }

    public boolean isHomePageDisplayed() {

        return driver.getCurrentUrl()
                .equals("https://automationexercise.com/");
    }
}