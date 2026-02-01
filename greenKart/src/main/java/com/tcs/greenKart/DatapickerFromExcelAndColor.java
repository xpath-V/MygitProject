package com.tcs.greenKart;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatapickerFromExcelAndColor {

	public static void main(String[] args) throws IOException {
		
		 WebDriver driver= new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		  String pathString="C:\\Users\\Vandana Sharma\\eclipse-workspace\\greenKart\\src\\main\\java\\ExcelRead\\GreenkartExceldataFetch.xlsx";
		// TODO Auto-generated method stub
         FileInputStream files= new FileInputStream(pathString);
         
         XSSFWorkbook workbook = new XSSFWorkbook(files);
         XSSFSheet sheet = workbook.getSheet("Sheet1");
         
         int rows =sheet.getLastRowNum();
         for(int r=1;r<=rows; r++) {
        	 Row row = sheet.getRow(r);
        	 String item_Name = row.getCell(0).toString().trim();
        	 System.out.println(item_Name);
        	 
        	int quantity=(int)row.getCell(1).getNumericCellValue();
        	 System.out.println(quantity);
        	 
        	 WebElement getPricElement= driver.findElement(By.xpath("//h4[contains(text(),'" + item_Name + " - 1 Kg')]/..//p"));
        	 System.out.println(getPricElement.getText());
        	 
        	 WebElement plusElement = driver.findElement(By.xpath("//h4[contains(text(),'" + item_Name + " - 1 Kg')]/..//div[@class='stepper-input']/a[@class='increment']"));
        	 
        	 
        	 for(int q=0;q<quantity-1;q++) {
        		 plusElement.click();
        		 	 
        	 }
        	 
        	 WebElement addTocartButtonElement=driver.findElement(By.xpath("//h4[contains(text(),'" + item_Name + " - 1 Kg')]/..//div[@class='product-action']/button"));
        	 addTocartButtonElement.click();
        	 
        	
        	 
        	 
         }
//         int quantityCol=1;
//         int priceperItemCol=2;
//         XSSFCell quantityCoumnCell=row.getCell(quantityCol)
//         int expectedcol=3;
//    	 double expectedPrice = quantity* priceperitem;
//    	 XSSFCell expectedColumn=row.getCell(expectedcol).setCellValue(rows);
//         
          
         }

}