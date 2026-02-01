package mainKart;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tcs.greenKart.baseKartDriver;
import data.ConfigFileReader;
import homePage.homeKartPage;

public class mainKart extends baseKartDriver {
	
	WebDriver driver;
	homeKartPage hp;
	Properties prop;
@BeforeMethod
	public void DriverCall() {
		
		driver=LaunchBrowser();
		hp=new homeKartPage(driver);
		prop=ConfigFileReader.fileReaderProperties();
		
	}
	@Test(enabled=false)
	public void Cartsitems() {
		hp.addToCart();
	}
	@Test(enabled=false)
	public void threeItems() {
		hp.addITems("Cauliflower - 1 Kg","Tomato - 1 Kg", "Potato - 1 Kg");
		hp.openKart();
		hp.openKart();
		hp.plusItemsize();
		hp.openKart(); 
		hp.checkOut();
		hp.placeOrder();
	} 
     @Test
     public void mainDynamicAdd(){

//    	 List<String> productNames = Arrays.asList(
//    			    prop.getProperty("productName1"),
//    			    prop.getProperty("productName2")
//    			);
    	 List<String> productNames = Arrays.asList(
 		        prop.getProperty("productName1"),
 		        prop.getProperty("productName2")
 		);
//div[@class='promoWrapper']/..//button[contains(text(),'Place Order')]//div[@class='promoWrapper']/..//button[contains(text(),'Place Order')]
 		 hp.selectProduct(productNames);
 		 

    	
    //	 String[] arr= {"Beetroot","Beans","Cucumber"};

//    	 String [] itemsPurchaseStrings= {"Potato","Brocili","Cauliflower"};
// 	  //   hp.selectRandomproduct(arr);
//  	 hp.dynamicAdd(peroductStrings);
//    	 hp.selectProduct(productNames);
     }
}

