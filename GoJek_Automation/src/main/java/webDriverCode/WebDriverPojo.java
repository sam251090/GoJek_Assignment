package webDriverCode;

import org.openqa.selenium.WebDriver;

    /*Getter setter for Webdriver object*/
public class WebDriverPojo {
	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		WebDriverPojo.driver = driver;
	}
	

}
