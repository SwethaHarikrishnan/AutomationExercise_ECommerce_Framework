package com.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LogoutPage;

public class LogoutTest extends BaseTest {

    @Test(priority = 7)
    public void verifyLogoutFlow() {

        LogoutPage logoutPage =
                new LogoutPage(driver);

        System.out.println(
                "Executing Logout Flow");

        logoutPage.clickLogout();

        Assert.assertTrue(
                logoutPage.isLogoutSuccessful(),
                "Logout success");

        System.out.println(
                "Logout Successful");

        System.out.println(
                "User Navigated To Login Page");
    }
}