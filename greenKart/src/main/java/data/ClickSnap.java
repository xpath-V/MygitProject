package data;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickSnap {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();


        try {
            driver.get("https://ultimateqa.com/automation-patterns-antipatterns/screen-shot-2019-10-24-at-8-19-56-am/");

            // Intentional failure (wrong locator)
            WebElement element = driver.findElement(By.id("entry-title"));
            element.click();

        } catch (Exception e) {
            System.out.println("Test failed, taking screenshot...");
            takeScreenshot("TestFailure");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void takeScreenshot(String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("./screenshots/" + fileName + ".png");
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	}


