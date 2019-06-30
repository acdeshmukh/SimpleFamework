package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PgAZHomePage {
	WebDriver PgDriver;
	
	public PgAZHomePage(WebDriver TCDriver){
		PgDriver = TCDriver;
		PageFactory.initElements(PgDriver, this);
	}
	
	@FindBy(id = "twotabsearchtextbox")
	public WebElement ipProductSearchBox;
		
	@FindBy(xpath ="//input[@class='nav-input' and @value='Go']")
	public WebElement btnSearch;
	
	@FindBy(xpath ="//span[@class ='a-color-state a-text-bold']")
	public WebElement txtPostSearch;
	
	@FindBy(xpath ="//div[@class='a-section a-spacing-medium']//span[@data-a-color='price']/span[@class='a-offscreen']")
	public List <WebElement> txtPriceOfProducts;
	
			
}
