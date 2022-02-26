package com.framework.initialization;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by tom on 24/02/17.
 */
public class DriverInitalization {

	static Logger log = Logger.getLogger(DriverInitalization.class.getName());

	public static final long DEFAULT_WAIT = 20;
	
	protected static WebDriver driver;

	private static final String OS = System.getProperty("os.name");

	protected static String currentDir = System.getProperty("user.dir");
	
	private static final String BROWSER = "Browser";

	public static WebDriver getLatestDriver() {

		return driver;
	}

	public static WebDriver getDriver(Map<String, String> driverDetails) {
		if (driver != null) {
			return driver;
		}

		log.info("OS is " + OS);
		if (OS.contains("Windows")) {

			
			log.info("Windows >>> " + driverDetails.get(BROWSER));

			switch (driverDetails.get(BROWSER)) {

			case "Firefox":
				log.info("Launching Firefox !!!!");
				System.setProperty("webdriver.gecko.driver",
						currentDir + "\\src\\main\\resources\\Windows\\geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				DesiredCapabilities capabilities = null;
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
				driver = new FirefoxDriver(capabilities);

				break;

			case "Chrome":
				log.info("Launching Chrome");
				System.setProperty("webdriver.chrome.driver",
						currentDir + "\\src\\main\\resources\\Windows\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			default:
				log.info("In Default.. BROWSER Not Supported ");
				break;
			}

		} else if (OS.contains("Linux")) {

			switch (driverDetails.get(BROWSER)) {

			case "Firefox":
				log.info("Launching Firefox !!!");
				System.setProperty("webdriver.gecko.driver", currentDir + "\\src\\main\\resources\\geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				DesiredCapabilities capabilities = null;
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
				driver = new FirefoxDriver(capabilities);
				break;

			case "Chrome":
				log.info("Launching Chrome");
				System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			default:
				log.info("In Default.. BROWSER Not Supported ");
				break;
			}

		}

		driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public static void closeDriver() {
		if (driver != null) {
			try {
				driver.close();
				driver.quit(); 
			} catch (Exception e) { 
				e.printStackTrace();
			} 
			driver = null;
		}
	}
}
