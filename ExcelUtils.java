package com.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getExcelData(
            String filePath,
            String sheetName) {

        Object[][] data = null;

        try {

            FileInputStream fis = new FileInputStream(filePath);

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {

                workbook.close();
                fis.close();

                throw new RuntimeException(
                        "Sheet Not Found: " + sheetName);
            }

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            data = new Object[rowCount][colCount];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= rowCount; i++) {

                Row row = sheet.getRow(i);

                for (int j = 0; j < colCount; j++) {

                    if (row == null) {

                        data[i - 1][j] = "";
                        continue;
                    }

                    Cell cell = row.getCell(j);

                    if (cell == null) {

                        data[i - 1][j] = "";

                    } else {

                        data[i - 1][j] =
                                formatter.formatCellValue(cell);
                    }
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(
                    "Error Reading Excel File: "
                            + e.getMessage());
        }

        return data;
    }
}