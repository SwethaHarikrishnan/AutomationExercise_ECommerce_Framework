package com.dataproviders;

import org.testng.annotations.DataProvider;
import com.utilities.ExcelUtils;

public class SignupDataProvider {

    @DataProvider(name = "signupData")
    public Object[][] getSignupData() throws Exception {

        String filePath =
                "src/test/resources/testdata/SignupData.xlsx";

        return ExcelUtils.getExcelData(
                filePath,
                "Sheet1"); 
    }
}