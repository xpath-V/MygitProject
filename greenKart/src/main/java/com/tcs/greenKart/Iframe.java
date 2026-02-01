package com.tcs.greenKart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.get("https://demoqa.com/frames");
		//// ====freame
		WebElement frame1= driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		
		
		///action 
		WebElement sep =driver.findElement(By.id("sampleHeading"));
		System.out.println(sep.getText());
		
	}
     
}
