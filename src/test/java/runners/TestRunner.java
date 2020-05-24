package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Dryrun/Sample.feature", glue = { "stepDefinitions" }, plugin = {
		"html:target/site/cucumber-pretty","json:target/cucumber.json" }, monochrome = true)

public class TestRunner {

//	@AfterClass
//	public static void writeExtentReport() {
//		String configFile = "src/configs/extent-config.xml";
//		Reporter.loadXMLConfig(new File(configFile).getAbsoluteFile());
//		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//	}

}