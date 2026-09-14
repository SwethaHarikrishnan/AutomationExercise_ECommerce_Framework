package com.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.dataproviders.SignupDataProvider;
import com.pages.HomePage;
import com.pages.SignupPage;
import com.utilities.ScreenshotUtils;

public class SignupTest extends BaseTest {

	@Test(
			priority = 1,
			dataProvider = "signupData",
			dataProviderClass = SignupDataProvider.class)
    public void verifySignup(
            String tcId,
            String name,
            String email,
            String password,
            String firstName,
            String lastName,
            String address,
            String country,
            String state,
            String city,
            String zipCode,
            String mobileNumber,
            String expectedResult) {

        try {

            HomePage homePage = new HomePage(driver);
            SignupPage signupPage = new SignupPage(driver);

            System.out.println("\n=================================");
            System.out.println("Executing Test Case : " + tcId);
            System.out.println("=================================");

            homePage.clickSignupLogin();

            signupPage.enterName(name);

            String finalEmail = email;

            

            signupPage.enterEmail(finalEmail);

            signupPage.clickSignup();

            boolean actualResult =
                    signupPage.isSignupPageDisplayed();

            // Positive Validation
            if ("SUCCESS".equalsIgnoreCase(expectedResult)) {

                Assert.assertTrue(
                        actualResult,
                        tcId + " Signup pass");

                ScreenshotUtils.captureScreenshot(
                        driver,
                        tcId + "_SUCCESS");

                System.out.println(
                        tcId + " Positive Validation Passed");
            }

           
            else {

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