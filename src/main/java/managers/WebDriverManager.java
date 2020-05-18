package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigFileReader;
import enums.*;

public class WebDriverManager {
	private WebDriver driver;
	private static String driverType;
	private static String environmentType;
	ConfigFileReader config = new ConfigFileReader();
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().browser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getenvironment();
	}

	public WebDriver createDriver() {
		if (environmentType.equalsIgnoreCase("LOCAL")) {
			driver = createLocalDriver();
		}
		if (environmentType.equalsIgnoreCase("REMOTE")) {
			driver = createRemoteDriver();
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {

		throw new RuntimeException("Remote driver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		if (driverType.equalsIgnoreCase("CHROME")) {
			System.setProperty(CHROME_DRIVER_PROPERTY,
					FileReaderManager.getInstance().getConfigReader().getDriverPath());
			driver = new ChromeDriver();

		} else if (driverType.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver",
					FileReaderManager.getInstance().getConfigReader().getDriverPath());
			driver = new InternetExplorerDriver();

		} else if (driverType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					FileReaderManager.getInstance().getConfigReader().getDriverPath());
			driver = new InternetExplorerDriver();
		} else if (driverType.equalsIgnoreCase("EDGE")) {
			System.setProperty("webdriver.edge.driver",
					FileReaderManager.getInstance().getConfigReader().getDriverPath());
			driver = new EdgeDriver();
		}
		// Maximize logic
		if (FileReaderManager.getInstance().getConfigReader().getwindowMaximize())
			driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getimplicitwait(),
				TimeUnit.SECONDS);

		return driver;
	}
	
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
}
