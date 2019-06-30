package PkgStepDefination;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runners.MethodSorters;

import Context.TestContext;
import PageFactory.PgAZHomePage;
import PageFactory.PgAZPreLogin;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StepDefHomePage {
	TestContext testContext;
	PgAZHomePage pgHomePage ;
	WebDriver driver ;
	Actions action ;
	WebDriverWait wait;
	String AppURL= "https://www.amazon.in/", ProductSearch ="Television";
	
public StepDefHomePage(){
	this.testContext = new TestContext();
	this.pgHomePage = testContext.getPgAZHomePage();
	this.driver = testContext.getTCDriver();
	action= new Actions(this.driver);
	wait = new WebDriverWait(this.driver,10);
}
	
	@Test
		public void SearchProduct() throws InterruptedException{
		driver.get(AppURL);
		assertTrue(driver.getTitle().contains("Online Shopping site in India:"));
		wait.until(ExpectedConditions.elementToBeClickable(pgHomePage.ipProductSearchBox));
		pgHomePage.ipProductSearchBox.sendKeys(ProductSearch);
		pgHomePage.btnSearch.click();
		//	assertTrue( pgHomePage.txtPostSearch.getText().equals(ProductSearch));
		
		 
		Thread.sleep(5000);
	}
	
	@After
	public void teardown(){
		System.out.println("Driver Title " + driver.getTitle());
		driver.quit();
	}
}
