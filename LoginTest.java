package com.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.dataproviders.LoginDataProvider;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ScreenshotUtils;

public class LoginTest extends BaseTest {

	@Test(
			priority = 2,
			dataProvider = "loginData",
			dataProviderClass = LoginDataProvider.class)
    public void verifyLogin(
            String tcId,
            String email,
            String password,
            String expectedResult) {

        try {

            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);

            System.out.println("\n=================================");
            System.out.println("Executing Test Case : " + tcId);
            System.out.println("=================================");

            homePage.clickSignupLogin();

            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLogin();

            boolean actualResult =
                    loginPage.isLoginSuccessful();

            if ("SUCCESS".equalsIgnoreCase(expectedResult)) {

                Assert.assertTrue(
                        actualResult,
                        tcId + " Login pass");

                ScreenshotUtils.captureScreenshot(
                        driver,
                        tcId + "_SUCCESS");

                System.out.println(
                        tcId + " Positive Validation Passed");

            } else {

                Assert.assertFalse(
                        actualResult,
                        tcId + " Negative Validation Failed");

                ScreenshotUtils.captureScreenshot(
                        driver,
                        tcId + "_FAILURE");

                System.out.println(
                        tcId + " Negative Validation Passed");
            }

        } catch (Exception e) {

            ScreenshotUtils.captureScreenshot(
                    driver,
                    tcId + "_EXCEPTION");

            Assert.fail(
                    tcId + " Exception Occurred : "
                            + e.getMessage());
        }
    }
}