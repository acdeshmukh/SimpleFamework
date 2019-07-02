package PkgStepDefination;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ConfigurationAndData.ConfigFileReader;

import org.junit.runners.MethodSorters;

import Context.TestContext;
import PageFactory.PgAZHomePage;
import PageFactory.PgAZPreLogin;
import ResuableComponents.GenericUtilities;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StepDefHomePage {
	TestContext testContext;
	PgAZHomePage pgHomePage ;
	WebDriver driver ;
	Actions action ;
	WebDriverWait wait;
	//String AppURL= "https://www.amazon.in/", ProductSearch ="Television";
	String AppURL= "https://www.amazon.in/", ProductSearch ="Television";
	TreeMap <String,Integer> mapPrdPric= new TreeMap <String,Integer>();
	
	
public StepDefHomePage(){
	this.testContext = new TestContext();
	this.pgHomePage = testContext.getPgAZHomePage();
	this.driver = testContext.getTCDriver();
	action= new Actions(this.driver);
	wait = new WebDriverWait(this.driver,10);
	
}
	
	@Test
		public void SearchProduct() throws Exception{
		driver.get(this.testContext.objConfigFileReader.getApplicationUrl());
		assertTrue(driver.getTitle().contains("Online Shopping site in India:"));
		wait.until(ExpectedConditions.elementToBeClickable(pgHomePage.ipProductSearchBox));
		pgHomePage.ipProductSearchBox.sendKeys(ProductSearch);
		pgHomePage.btnSearch.click();
		//	assertTrue( pgHomePage.txtPostSearch.getText().equals(ProductSearch));
		GenericUtilities.takeSnapShot(driver, this.testContext.objConfigFileReader.getScreenShot()+"\\Product.jpeg");
		SortProduct();
	
		Thread.sleep(5000);
	}
	
	
	
	public void SortProduct(){
		List<WebElement> PrdPrice = pgHomePage.PriceOfProducts;
		ListIterator<WebElement> itrPrice = PrdPrice.listIterator();
				
		for (WebElement Prd : pgHomePage.NameOfProducts )
		{
			System.out.println("Product Name:" + Prd.getText());
			
			//System.out.println("Product Price:" + itrPrice.next().getAttribute("innerText").replace("₹", "").replace(",", ""));
			mapPrdPric.put(Prd.getText(), Integer.parseInt(itrPrice.next().getAttribute("innerText").replace("₹", "").replace(",", "")));
						
		}
		
		mapPrdPric.descendingKeySet();
		for(Map.Entry m:mapPrdPric.entrySet()){    
		       System.out.println(m.getKey()+"--> "+m.getValue());    
		      }    
	}
	@After
	public void teardown(){
		System.out.println("Driver Title " + driver.getTitle());
		driver.quit();
	}
}
