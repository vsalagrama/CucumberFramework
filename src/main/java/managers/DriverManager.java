package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverManager {
	private WebDriver driver;
	private static String driverType;
	private static String environmentType;
	ConfigFileReader config = new ConfigFileReader();
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public DriverManager() {
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
			System.setProperty("webdriver.chrome.silentOutput", "true");
			WebDriverManager.chromedriver().setup();			
			driver = new ChromeDriver();

		} else if (driverType.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (driverType.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (driverType.equalsIgnoreCase("EDGE")) {
			WebDriverManager.edgedriver().setup();
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
		//driver.quit();
	}
}
