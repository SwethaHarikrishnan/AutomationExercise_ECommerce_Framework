package com.dataproviders;

import org.testng.annotations.DataProvider;

import com.utilities.ExcelUtils;

public class PaymentDataProvider {

    @DataProvider(name = "paymentData")
    public Object[][] getPaymentData()
            throws Exception {

        return ExcelUtils.getExcelData(
                "src/test/resources/testdata/PaymentData.xlsx",
                "Sheet1");
    }
}