package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10));
    }

    By addressDetailsTitle =
            By.xpath("//h2[contains(text(),'Address Details')]");

    By reviewOrderTitle =
            By.xpath("//h2[contains(text(),'Review Your Order')]");

    By commentBox =
            By.name("message");

    By placeOrderButton =
            By.xpath("//a[contains(text(),'Place Order')]");

    public boolean isAddressDetailsDisplayed() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            addressDetailsTitle));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isReviewOrderDisplayed() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            reviewOrderTitle));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public void enterComment(String comment) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        commentBox))
                .sendKeys(comment);

        System.out.println(
                "Comment Entered Successfully");
    }

    public void clickPlaceOrder() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        placeOrderButton))
                .click();

        System.out.println(
                "Place Order Successful");
    }

    public boolean isPaymentPageDisplayed() {

        return driver.getCurrentUrl()
                .contains("payment");
    }
}