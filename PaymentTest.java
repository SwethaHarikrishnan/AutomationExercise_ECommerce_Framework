package com.tests.ui;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.dataproviders.PaymentDataProvider;
import com.pages.PaymentPage;
import com.utilities.WaitUtils;

public class PaymentTest extends BaseTest {

    @Test(
            priority = 6,
            dataProvider = "paymentData",
            dataProviderClass = PaymentDataProvider.class)
    public void verifyPaymentFlow(

            String tcId,
            String nameOnCard,
            String cardNumber,
            String cvc,
            String expiryMonth,
            String expiryYear,
            String expectedResult) {

        PaymentPage paymentPage =
                new PaymentPage(driver);

        System.out.println(
                "\n=================================");

        System.out.println(
                "Executing Test Case : "
                        + tcId);

        System.out.println(
                "=================================");

        Assert.assertTrue(
                paymentPage.isPaymentPageDisplayed(),
                "Payment Page Not Displayed");

        paymentPage.enterPaymentDetails(
                nameOnCard,
                cardNumber,
                cvc,
                expiryMonth,
                expiryYear);

        paymentPage.clickPayAndConfirmOrder();

        if (expectedResult.equalsIgnoreCase("SUCCESS")) {

            Assert.assertTrue(
                    paymentPage.isOrderPlacedDisplayed(),
                    "Order Not Placed");

            System.out.println(
                    tcId + " Payment Successful");
           

            paymentPage.clickContinue();

            System.out.println(
                    "Continue Button Clicked Successfully");

            Assert.assertTrue(
                    paymentPage.isHomePageDisplayed(),
                    "Home Page Not Displayed");

            System.out.println(
                    "Navigated To Home Page Successfully");
        }
    }
}