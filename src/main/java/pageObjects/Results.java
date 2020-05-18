package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Results {
	
	
	public Results(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='hdtb-msb-vis']/div[4]/a")
	private WebElement ClickVideos;
	
	public void ClickVideos() {
		ClickVideos.click();
		
	}

}
