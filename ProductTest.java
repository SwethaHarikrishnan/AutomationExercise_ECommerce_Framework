package com.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test(priority = 3)
    public void verifyAddProductsToCart() {

        ProductPage productPage =
                new ProductPage(driver);

        System.out.println(
                "Executing Product Flow");

        productPage.clickProducts();

        productPage.searchProduct("Dress");

        Assert.assertTrue(
                productPage.isSearchResultDisplayed(),
                "Products Not Found");

        productPage.addThreeDresses();

        System.out.println(
                " Dresses Added Successfully");
    }
}