package homePage;

import java.io.FileReader;
import java.security.PublicKey;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.StaticInitializerCoercer;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homeKartPage {

	static WebDriver driver;
	static Properties prop;

	public homeKartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h4[contains(text(),'Cauliflower - 1 Kg')]/..//div[@class='product-action']//button")
	public WebElement addItem;

	@FindBy(xpath = "//div[@class='product-action']/button[@type='button']")
	public WebElement addclcikElement;

	@FindBy(xpath = "//div[@class='product']/h4")
	public WebElement itemName;

	@FindBy(xpath = "//div[@class='products']//div[@class='product']")
	public List<WebElement> itemList;

	@FindBy(xpath = "//img[@class=\" \"]")
	public WebElement cartbutton;

	@FindBy(xpath = "//a[@class=\"increment\"]/..//a[text()=" + "]")
	public WebElement addItemssize;
	
	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	public WebElement checkoutButton;
	
	@FindBy(xpath = "//div[@class='promoWrapper']/..//button[contains(text(),'Place Order')]")
	public WebElement placeOrderButton;

	public void addToCart() {

		addItem.click();
	}
	// div[@class='product-action']/button[@type='button']

	public void addITems(String item1, String item2, String item3) {
//		String nameString=itemName.getText();
		for (int i = 0; i < itemList.size(); i++) {
			String nameString1 = itemList.get(i).findElement(By.xpath(".//h4")).getText();
			if (nameString1.equalsIgnoreCase(item1) || nameString1.equalsIgnoreCase(item2)
					|| nameString1.equalsIgnoreCase(item3)) {
				itemList.get(i).findElement(By.xpath(".//div[@class='product-action']/button[@type='button']")).click();

			}

		}

	}

	public void dynamicAdd(String [] productNameStrings){ 
		
		int arrSize=productNameStrings.length;
		for(int i=0;i<arrSize;i++) { 
        
		WebElement addElement=driver.findElement(By.xpath(
	"//h4[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"+productNameStrings[i].toLowerCase()+"')]/..//div[@class='product-action']//button"));
		addElement.click();

		 

		}
		}
//		}
//}
	public void selectRandomproduct(String[] values) {
		for(String val:values) {
			WebElement addTocartElement=driver.findElement(By.xpath("//h4[contains(text(),'"+val+" - 1 Kg')]/..//div[@class='product-action']//button"));
			addTocartElement.click();
			
		}
		
	}

	public void openKart() {
		cartbutton.click();

	}
	public void checkOut() {
		checkoutButton.click();

	}
	public void placeOrder() {
		placeOrderButton.click();
	}
	

	public void plusItemsize() {
		String itemString = "Cauliflower - 1 Kg";
		for (int i = 0; i < itemList.size(); i++) {
			String nameString1 = itemList.get(i).findElement(By.xpath(".//h4")).getText();
			if (nameString1.equalsIgnoreCase(itemString)) {
				itemList.get(i).findElement(By.xpath(".//a")).click();
				itemList.get(i).findElement(By.xpath(".//div[@class='product-action']/button[@type='button']")).click();

			}

		}

	}
	public static void selectProduct(String[] productnames) {
		int arrSize=productnames.length;
		for(int i=0;i<arrSize;i++) { 
        
		WebElement addElement=driver.findElement(By.xpath(
	"//h4[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"+productnames[i].toLowerCase()+"')]/..//div[@class='product-action']//button"));
		addElement.click();

		 

		}
		}
	    
//		String [] productNames= {prop.getProperty("productName1"),prop.getProperty("productName2")};
//		public  void selectProduct(List<String[]> productNames) {
//			
//
//		    for (int i = 0; i < productNames.size(); i++) {
//
//		        // Extract product name from String[]
//		        String productName = productNames.get(i)[0].toLowerCase();
//
//		        WebElement addElement = driver.findElement(By.xpath(
//		            "//h4[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"
//		            + productName +
//		            "')]/..//div[@class='product-action']//button"
//		        ));
//
//		        addElement.click();
//		    }
//		}
	public void selectProduct(List<String> productNames) {

	    for (String productName : productNames) {

	        String lowerCaseName = productName.toLowerCase();

	        WebElement addElement = driver.findElement(By.xpath(
	                "//h4[contains(translate(text()," +
	                "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" +
	                lowerCaseName +
	                "')]/..//div[@class='product-action']//button"
	        ));

	        addElement.click();
	    }
	}

		
		

	
}
