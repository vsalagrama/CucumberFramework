package dryrun;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class testClass {
	private static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venkatesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\Venkatesh\\Downloads\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
		//driver=new InternetExplorerDriver();
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\Venkatesh\\Downloads\\edgedriver_win32\\msedgedriver.exe");
		//driver = new EdgeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.google.co.in");
		
		//driver.quit();

	}

}
