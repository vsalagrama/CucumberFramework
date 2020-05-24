package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Dryrun/Sample.feature", glue = { "stepDefinitions" }, 

plugin = {
		 "json:target/cucumber.json"}, monochrome = true, strict = true)



//"html:target/site/cucumber-pretty"

public class TestRunner {
	public static String filename;
//	@BeforeClass
//	public static void setup() {
//		ExtentProperties extent = ExtentProperties.INSTANCE;
//		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		filename = "target/cucumber-reports/" + "report" + dateName +".html";
//		extent.setReportPath(filename);
//		
//	}
	

//	@AfterClass
//	public static void writeExtentReport() {
//		String configFile = "src/configs/extent-config.xml";
//		Reporter.loadXMLConfig(new File(configFile).getAbsoluteFile());
//		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//	}

}