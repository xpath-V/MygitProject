package com.tcs.greenKart;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		// Data (no separate object class)
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"User", "Password"});   // Header
        data.add(new String[]{"standard_user", "secret_sauce"});
        data.add(new String[]{"locked_out_user", "secret_sauce"});
        data.add(new String[]{"problem_user", "secret_sauce"});

        // Create workbook & sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");

        int rowNum = 0;

        // Write data to Excel
        for (String[] rowData : data) {
            XSSFRow row = sheet.createRow(rowNum++);
            int colNum = 0;

            for (String cellData : rowData) {
                row.createCell(colNum++).setCellValue(cellData);
            }
        }

        // Write to file
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Vandana Sharma\\eclipse-workspace\\greenKart\\src\\main\\java\\ExcelRead\\write.xlsx");
        workbook.write(fos);

        // Close resources
        fos.close();
        workbook.close();

        System.out.println("Excel written successfully!");
    }
	}



