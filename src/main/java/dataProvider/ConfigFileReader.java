package dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;



public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "src//configs//configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties file not found at" + propertyFilePath);

		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverpath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in Configuration.properties file");
	}
	public String geturl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in Configuration.properties file");
	}
	public String browser() {
		String browser = properties.getProperty("browser");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("browser not specified in Configuration.properties file");
	}
	public long getimplicitwait() {
		String implicitwait = properties.getProperty("implicitwait");
		if (implicitwait != null)
			return Long.parseLong(implicitwait);
		else
			throw new RuntimeException("implicitwait not specified in Configuration.properties file");
	}
	public String getenvironment() {
		String environment = properties.getProperty("environment");
		if (environment != null)
			return environment;
		else
			throw new RuntimeException("environment not specified in Configuration.properties file");
	}
	public boolean getwindowMaximize() {
		String windowMaximize = properties.getProperty("windowMaximize");
		if (windowMaximize != null)
			return Boolean.parseBoolean(windowMaximize);
		else
			throw new RuntimeException("windowMaximize not specified in Configuration.properties file");
	}
}
