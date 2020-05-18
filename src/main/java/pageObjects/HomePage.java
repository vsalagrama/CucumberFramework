package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "q")
	private WebElement SearchBox;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='submit' and @value='Google Search'])[2]")
	private WebElement Submit;

	public void enter_text(String value) {
		SearchBox.sendKeys(value);
	}
	
	public void Submit() {
		Submit.click();
		}
	}
