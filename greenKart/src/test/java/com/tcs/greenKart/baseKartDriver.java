package com.tcs.greenKart;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ConfigFileReader;

public class baseKartDriver {

	static WebDriver driver;
	static Properties prop;

	public static WebDriver LaunchBrowser() {
		
		
		prop=ConfigFileReader.fileReaderProperties();
		String browserName=prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
//        prop=FileReader.fileReaderProperties();
		driver.get(prop.getProperty("url"));
		return driver;

	}
}
