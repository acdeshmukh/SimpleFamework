package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PgAZPreLogin {
	WebDriver PgDriver;
	
	public PgAZPreLogin(WebDriver TCDriver){
		PgDriver = TCDriver;
		PageFactory.initElements(PgDriver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Hello')]/parent::a")
	public WebElement linkHelloSignin;
	
	@FindBy(xpath = "//div[@id='nav-al-signin']//span[@class='nav-action-inner' and  contains(text(),'Sign in')]")
	public WebElement btnSignin;
	
	@FindBy(xpath = "//input[@type='email']")
	public WebElement ipLoginID;
	
	@FindBy(id = "continue")
	public WebElement btnContinue;
	
	@FindBy(xpath = "//h1[contains(text(),'Login')]")
	public WebElement tlLoginPage;
	
	@FindBy(id = "ap_password")
	public WebElement ipPassword;
	
	@FindBy(id = "signInSubmit")
	public WebElement btnLogin;
}
