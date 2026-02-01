package com.tcs.greenKart;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {
		
        String excel = "C:\\Users\\Vandana Sharma\\eclipse-workspace\\greenKart\\src\\main\\java\\ExcelRead\\Untitled spreadsheet.xlsx";

		// Create a FileInputStream to read the Excel file
		FileInputStream fis = new FileInputStream(excel);

		// Create XSSFWorkbook object to access the Excel workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Get the sheet named "sheet1" from the workbook
		XSSFSheet sheet = workbook.getSheet("sheet2");

		// Get the index of the last row (row count - 1)
		int rows = sheet.getLastRowNum();
		System.out.println(rows);

		// Get total number of cells (columns) in the first row
		int col = sheet.getRow(0).getLastCellNum();
		System.out.println(col);

		// Loop through each row (from first row to last row)
		for (int i = 0; i <= rows; i++) {

		    // Get the current row
		    XSSFRow row = sheet.getRow(i);

		    // If row is empty (null), skip it
		    if (row == null) continue;

		    // Loop through each cell in the current row
		    for (int j = 0; j < col; j++) {

		        // Get the current cell
		        XSSFCell cell = row.getCell(j);

		        // If cell is empty (null), skip it
		        if (cell == null) continue;

		        // Print the cell value (works for String, Numeric, etc.)
		        System.out.print(cell.toString() + " | ");
		    }

		    // Move to the next line after finishing one row
		    System.out.println();
		}

		// Close the workbook to free memory
		workbook.close();

		// Close the FileInputStream
		fis.close();

	}

	}


