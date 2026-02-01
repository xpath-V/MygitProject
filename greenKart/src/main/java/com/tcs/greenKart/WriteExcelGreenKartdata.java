package com.tcs.greenKart;

import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteExcelGreenKartdata {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
       driver.manage().window().maximize();
       Workbook workbook = new XSSFWorkbook();
//       Sheet sheet = workbook.createSheet("Vegetables");
       Sheet sheet = workbook.createSheet("VegetablesNames");
       Row header = sheet.createRow(0);
       header.createCell(0).setCellValue("Vegetable Name");
       header.createCell(1).setCellValue("Price");
       List<WebElement> names = driver.findElements(By.xpath("//h4[@class='product-name']"));
       List<WebElement> prices = driver.findElements(By.xpath("//p[@class='product-price']"));
/*
 * 
       int rowCount = 1;
       int count = Math.min(names.size(), prices.size());
       for (int i = 0; i < count; i++) {
           Row row = sheet.createRow(rowCount++);
           row.createCell(0).setCellValue(names.get(i).getText());
           row.createCell(1).setCellValue(prices.get(i).getText());
       }*/
      
    // Start writing data from row 1 because row 0 is used for headers
       int rowCount = 1;
       // Get the smaller size between names list and prices list
       // This avoids IndexOutOfBoundsException if sizes are different
       int count = Math.min(names.size(), prices.size());
       // Loop through each vegetable safely
       for (int i = 0; i < count; i++) {
           // Create a new row in the Excel sheet
           // rowCount++ means:
           // - use current rowCount value
           // - then increment it for the next iteration
           Row row = sheet.createRow(rowCount++);
           // Create first column (index 0)
           // Store vegetable name text from the web page
           row.createCell(0).setCellValue(
               names.get(i).getText()  // get vegetable name at index i
           );
           // Create second column (index 1)
           // Store vegetable price text from the web page
           row.createCell(1).setCellValue(
               prices.get(i).getText() // get price at index i
           );
       }
       FileOutputStream fos = new FileOutputStream(
           "C:\\Users\\Vandana Sharma\\eclipse-workspace\\greenKart\\src\\main\\java\\ExcelRead\\WriteExcelGreenkartdata.xlsx");
       workbook.write(fos);
       fos.close();
       workbook.close();
       driver.quit();
       System.out.println("Excel file created successfully!");
   }

}
