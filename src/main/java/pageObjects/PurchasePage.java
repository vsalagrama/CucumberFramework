package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {

	public PurchasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "inputName")
	private WebElement FirstName;
	
	@FindBy(how = How.ID, using = "zipCode")
	private WebElement zipCode;
	
	@FindBy(how = How.ID, using = "creditCardNumber")
	private WebElement creditCardNumber;
	
	@FindBy(how = How.ID, using = "rememberMe")
	private WebElement rememberMe;
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@value='Purchase Flight']")
	private WebElement Purchase;
	
	public void enterdetails (String name, String zip, String ccard) {
		FirstName.clear();
		FirstName.sendKeys(name);
		
		zipCode.clear();
		zipCode.sendKeys(zip);
		
		creditCardNumber.clear();
		creditCardNumber.sendKeys(ccard);
		
		rememberMe.click();
	}
	public void Purchase() {
		Purchase.click();
	}
}
