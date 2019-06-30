package Context;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.PgAZHomePage;
import PageFactory.PgAZPreLogin;

public class TestContext {
	 private WebDriver TCDriver ;
	 private PgAZPreLogin objPgAZPreLogin; 
	 private PgAZHomePage objPgAZHomePage;
	
	public TestContext ()
	{
	System.setProperty("webdriver.chrome.driver", "D:\\WebDriverExe\\chromedriver.exe");
	this.TCDriver = new ChromeDriver();
	this.TCDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	this.objPgAZPreLogin = new PgAZPreLogin(TCDriver);
	this.objPgAZHomePage = new PgAZHomePage(TCDriver);
	}

	public WebDriver getTCDriver() {
		return this.TCDriver;
	}
	public PgAZPreLogin getPgAZPreLogin() {
		return this.objPgAZPreLogin;
	}

	public PgAZHomePage getPgAZHomePage() {
		return this.objPgAZHomePage;
	}

}
