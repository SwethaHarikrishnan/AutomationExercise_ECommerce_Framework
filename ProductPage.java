package com.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(5));
    }

    By productsMenu =
            By.xpath("//a[@href='/products']");

    By searchBox =
            By.id("search_product");

    By searchButton =
            By.id("submit_search");

    By searchedProductsTitle =
            By.xpath("//h2[contains(text(),'Searched Products')]");

    By continueShoppingButton =
            By.xpath("//button[contains(text(),'Continue Shopping')]");

    By cartButton =
            By.xpath("//a[contains(text(),'Cart')]");

    public void clickProducts() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        productsMenu))
                .click();
    }

    public void searchProduct(String productName) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        searchBox));

        driver.findElement(searchBox)
                .clear();

        driver.findElement(searchBox)
                .sendKeys(productName);

        driver.findElement(searchButton)
                .click();
    }

    public boolean isSearchResultDisplayed() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            searchedProductsTitle));

            return true;

        } catch (Exception e) {

            return false;
        }
    }
    public void addThreeDresses() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        for (int i = 1; i <= 3; i++) {

            By addButtonLocator =
                    By.xpath(
                            "(//div[@class='product-image-wrapper']//a[contains(text(),'Add to cart')])[" + i + "]");

            WebElement addButton =
                    wait.until(
                            ExpectedConditions.presenceOfElementLocated(
                                    addButtonLocator));

            js.executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    addButton);

            js.executeScript(
                    "arguments[0].click();",
                    addButton);

            // Verify Added popup

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//h4[contains(text(),'Added!')]")));

            System.out.println(
                    "Product Added : " + i);

            if (i < 3) {

                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                continueShoppingButton))
                        .click();
            }
            else {

                By viewCart =
                        By.xpath("//u[contains(text(),'View Cart')]");

                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                viewCart))
                        .click();
            }
        }
    }
    
    public void clickCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        cartButton))
                .click();
    }
}