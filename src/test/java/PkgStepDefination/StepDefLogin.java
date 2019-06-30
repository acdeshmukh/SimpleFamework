package PkgStepDefination;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Context.TestContext;
import PageFactory.PgAZPreLogin;

public class StepDefLogin {
	TestContext testContext;
	PgAZPreLogin pgPreLogin ;
	WebDriver driver ;
	Actions action ;
	WebDriverWait wait;
	String AppURL= "https://www.amazon.in/", LoginID ="acd1231@rediffmail.com", pwd="";
	
public StepDefLogin(){
	this.testContext = new TestContext();
	this.pgPreLogin = testContext.getPgAZPreLogin();
	this.driver = testContext.getTCDriver();
	action= new Actions(this.driver);
	wait = new WebDriverWait(this.driver,10);
}
	
	@Test
	public void LoginToApp() throws InterruptedException{
		driver.get(AppURL);
		pgPreLogin.linkHelloSignin.click();
		//pgPreLogin.btnSignin.click();
		assertEquals(driver.getTitle(),"Amazon Sign In");
		pgPreLogin.ipLoginID.sendKeys(LoginID);
		pgPreLogin.btnContinue.click();
		wait.until(ExpectedConditions.textToBePresentInElement(pgPreLogin.tlLoginPage, "Login"));
		pgPreLogin.ipPassword.sendKeys(pwd);
		pgPreLogin.btnContinue.click();
		
		/**
		 * Passcode sent on mobile would be function for same to get same from DB,
		 * As no DB access have't drafted code for same
		 * */
		 
		Thread.sleep(5000);
	}
	
	@After
	public void teardown(){
		System.out.println("Driver Title " + driver.getTitle());
		driver.quit();
	}
}
