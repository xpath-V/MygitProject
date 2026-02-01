package com.tcs.greenKart;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReadandWriteColorClass {
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		String path = "C:\\Users\\Vandana Sharma\\eclipse-workspace\\greenKart\\src\\main\\java\\ExcelRead\\ReadWriteColorTest.xlsx";
		FileInputStream fis = new FileInputStream(path);
		// excel read
		
		XSSFWorkbook notebook =  new XSSFWorkbook(fis); // notebook
		
		XSSFSheet page = notebook.getSheet("Sheet1");
		
		int rows = page.getLastRowNum();
		int cols = page.getRow(0).getLastCellNum();
		
		///read write & fill color
		
		int feeCol = 1; // fee (column B)
		int monthCol =2; // month (column C)
		int expectedCol = 3; // Expected (column D)
		int actulaCol =4; // actual (column E)
		
		for(int r=1;r<=rows ; r++) {
			XSSFRow row = page.getRow(r);
			 
			XSSFCell feeCell = row.getCell(feeCol);
			XSSFCell monthCell = row.getCell(monthCol);
			XSSFCell expectedCell = row.getCell(expectedCol);
			
			double fee = (feeCell !=null)? feeCell.getNumericCellValue(): 0;
			double month = (monthCell!=null)? monthCell.getNumericCellValue():0;
			double expected =  (expectedCell!=null) ?  expectedCell.getNumericCellValue() :0;
			
			double actual = fee* month;
			
			// write actual value 
			
			XSSFCell actualCell = row.getCell(actulaCol);
			if(actualCell==null)actualCell = row.createCell(actulaCol);
			actualCell.setCellValue(actual);
			
			// color apply
			XSSFCellStyle style = notebook.createCellStyle();
			if(actual==expected) {
				style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			}else {
				style.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
			}
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			actualCell.setCellStyle(style);
			
			// print cell value 
			for(int c=0;c<=cols;c++) {
				XSSFCell cell = row.getCell(c);
				if(cell!=null) {
					 switch(cell.getCellType()) {
					 case STRING:
						 System.out.print(cell.getStringCellValue() +" | " + " \t");
						 break;
					 case NUMERIC:
						 System.out.print(cell.getNumericCellValue() + " | "+ " \t");
						 break;
					 case BOOLEAN:
						 System.out.print(cell.getBooleanCellValue() + " | "+ " \t");
						 break;
					 default:
						 System.out.print("\t");
					 }
					 
				}else {
					System.out.print("\t");
				}
			}
			
			System.out.println("");
		}
		
		fis.close();
		
		FileOutputStream fos = new FileOutputStream(path);
		notebook.write(fos);
		notebook.close();
		fos.close();
		 
		
		
	
		
	}

}
