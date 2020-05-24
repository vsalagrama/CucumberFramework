package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import dataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.DriverManager;
import pageObjects.HomePage;
import pageObjects.Results;
import utilities.MyScreenRecorder;

import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.utils.FileUtil;
import com.cucumber.listener.Reporter;


public class Steps {
	public static WebDriver driver;
	private Scenario scenario;
	HomePage home;
	Results res;
	PageObjectManager pageObjectManager;
	ConfigFileReader config = new ConfigFileReader();
	DriverManager webDriverManager;

	@Before
	public void setup(Scenario scenario) {
		this.scenario = scenario;
	}
	@Before
	public void startRecording() {
		String RecordVideo = FileReaderManager.getInstance().getConfigReader().RecordVideo();
		if(RecordVideo.equalsIgnoreCase("yes")) {
			try {
				MyScreenRecorder.startRecording("Record");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	@After
	public void stopRecording() throws Exception {
		MyScreenRecorder.stopRecording();
	}
	@After
	public void tearDown() throws IOException {
		if(scenario.isFailed()) {
			get_screenshot();
		}
	}
	
	@Given("open the url")
	public void open_the_url() {
		webDriverManager = new DriverManager();
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
	public void get_screenshot() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(src);
		String Base64StringofScreenshot = "date:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);		
		scenario.attach(fileContent, "image/png", "Screenshot");
		System.out.println("Screenshot taken");
		//Reporter.addScreenCaptureFromPath(Base64StringofScreenshot);
		
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
