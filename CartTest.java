package com.tests.ui;
import com.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.CartPage;
import com.pages.ProductPage;

public class CartTest extends BaseTest {

    @Test(priority = 4)
    public void verifyCartFlow() {

        ProductPage productPage =
                new ProductPage(driver);

        CartPage cartPage =
                new CartPage(driver);

        System.out.println(
                "Executing Cart Flow");

        productPage.clickCart();

        Assert.assertTrue(
                cartPage.isCartPageDisplayed(),
                "Cart Page Not Opened");

        Assert.assertTrue(
                cartPage.isCartNotEmpty(),
                "Cart Is Empty");

        System.out.println(
                "Products Present In Cart");

       

        cartPage.clickProceedToCheckout();


        System.out.println(
                "Proceed To Checkout Successful");
    }
}