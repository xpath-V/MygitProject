package practiceConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClicks {
	static WebDriver driver;
	public static void main (String[]args) {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons");
		
//		WebElement doubleClickElement= driver.findElement(By.id("doubleClickBtn"));
//		Actions action = new Actions(driver);
//		action.doubleClick(doubleClickElement).build().perform();
		
		
		WebElement rightClickElement= driver.findElement(By.id("rightClickBtn"));
		Actions action = new Actions(driver);
	
		action.contextClick(rightClickElement).build().perform();
	}

}
