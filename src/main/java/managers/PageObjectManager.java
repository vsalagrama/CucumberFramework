package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.Results;

public class PageObjectManager {
	private WebDriver driver;
	private HomePage home;
	private Results res;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	public HomePage getHomePage() {
		return (home == null) ? home = new HomePage(driver) : home;
		
	}
	public Results getResults() {
		return (res == null) ? res = new Results(driver) : res;
		
	}
}
