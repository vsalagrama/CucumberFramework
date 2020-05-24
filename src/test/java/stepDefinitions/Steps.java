package stepDefinitions;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;


import dataProvider.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.Results;

public class Steps {
	public static WebDriver driver;
	HomePage home;
	Results res;
	PageObjectManager pageObjectManager;
	ConfigFileReader config = new ConfigFileReader();
	WebDriverManager webDriverManager;

	@Given("open the url")
	public void open_the_url() {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.createDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getimplicitwait(),
				TimeUnit.SECONDS);
		driver.get(FileReaderManager.getInstance().getConfigReader().geturl());

	}

	@When("type {string} into searchbar")
	public void type_into(String string) {
		// Write code here that turns the phrase above into concrete actions
		pageObjectManager = new PageObjectManager(driver);
		home = pageObjectManager.getHomePage();
		home.enter_text(string);
	}

	@When("click Submit")
	public void click_Submit() {
		home.Submit();

	}

	@Then("get screenshot")
	public void get_screenshot() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("click Videos")
	public void click_Videos() {
		// Write code here that turns the phrase above into concrete actions
		res = pageObjectManager.getResults();
		res.ClickVideos();
	}

	@Then("close")
	public void close() {
		webDriverManager.closeDriver();
	}

}
