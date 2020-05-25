package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BlazeHome {
	public BlazeHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "fromPort")
	private WebElement fromPort;

	@FindBy(how = How.NAME, using = "toPort")
	private WebElement toPort;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement submit;

	@FindBy(how = How.XPATH, using = "(//input[@type='submit'])[3]")
	private WebElement chooseFlight;

	public void select_src(String Src) {
		Select selectFromDropdown = new Select(fromPort);
		selectFromDropdown.selectByValue(Src);
	}

	public void select_desti(String Src) {
		Select selectFromDropdown = new Select(toPort);
		selectFromDropdown.selectByValue(Src);
	}

	public void FindFlights() {
		submit.click();
	}

	public void choose_flight() {
		chooseFlight.click();
	}

}
