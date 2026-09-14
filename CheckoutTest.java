package com.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.CheckoutPage;
import com.utilities.WaitUtils;

public class CheckoutTest extends BaseTest {

    @Test(priority = 5)
    public void verifyCheckoutFlow() {

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        System.out.println(
                "Executing Checkout Flow");

        Assert.assertTrue(
                checkoutPage.isAddressDetailsDisplayed(),
                "Address Details Not Displayed");

        Assert.assertTrue(
                checkoutPage.isReviewOrderDisplayed(),
                "Review Your Order Not Displayed");

        System.out.println(
                "Checkout Page Displayed Successfully");
        
       

        checkoutPage.enterComment(
                "Automation Test Order");

        checkoutPage.clickPlaceOrder();

        Assert.assertTrue(
                checkoutPage.isPaymentPageDisplayed(),
                "Payment Page Not Opened");

        System.out.println(
                "Navigated To Payment Page Successfully");
    }
}