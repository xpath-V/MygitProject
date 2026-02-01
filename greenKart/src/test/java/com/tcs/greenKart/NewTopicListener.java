package com.tcs.greenKart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(TestListener.class)
public class NewTopicListener {
	WebDriver driver;
	SoftAssert sAssert;
	@BeforeMethod
	public void launchBrower() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
	
	}
	@Test 
	public void LoginwithValid() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		 sAssert.assertTrue(
		            driver.getCurrentUrl().contains("inventory"),
		            "Login should be successful"
		        );
		
		
	}
	@Test (enabled= false)
	public void Loginwith_InValid() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("error_user");
		driver.findElement(By.id("login-button")).click();
		
		 // This assertion is intentionally wrong to FAIL the test
        sAssert.assertTrue(
            driver.getCurrentUrl().contains("inventory"),
            "Login should fail but assertion expects success"
        );
		
		
	}
		// ⏭️ SKIP TEST
    @Test(enabled = false)
    public void LoginTestSkipped() {
        throw new SkipException("Skipping this test intentionally");
    }
    
	@AfterMethod
	public void close() {
		driver.close();
	}

}
