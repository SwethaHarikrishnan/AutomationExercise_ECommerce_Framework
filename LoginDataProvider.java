package com.dataproviders;

import org.testng.annotations.DataProvider;

import com.utilities.ExcelUtils;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {

        String filePath =
                "src/test/resources/testdata/LoginData.xlsx";

        return ExcelUtils.getExcelData(
                filePath,
                "Sheet1");
    }
}