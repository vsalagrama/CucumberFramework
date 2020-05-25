package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ThankyouPage {

	public ThankyouPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//pre")
	private WebElement JSON;
	
	public void validateJSON() {
		String text = JSON.getText();
		System.out.println(text);
	}
}
