package webDriverCode;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverUtil {
	static WebDriver driver;
	static String URL= "https://demo.midtrans.com/";
	static Path currentDir = Paths.get(System.getProperty("user.dir"));
	static Path chromedriverfilePath = Paths.get(currentDir.toString(), "src", "test", "resources", "Driver", "chromedriver.exe");
	static Path chromedriverfilePath_mac = Paths.get(currentDir.toString(), "src", "test", "resources", "Driver", "chromedriver");
	@BeforeMethod
	public static WebDriver webDriverLaunch() throws MalformedURLException
	{
		String os=System.getProperty("os.name").toLowerCase();		// Reading OS
		
		try {
			if(os.contains("mac"))
			{
	System.setProperty("webdriver.chrome.driver",chromedriverfilePath_mac.toString());		// Reading chrome driver for mac
			System.out.println("macbook");
			}
			else 
			{
				System.setProperty("webdriver.chrome.driver",chromedriverfilePath.toString());		// Reading chrome driver for window
				System.out.println("Windowsssss");
			}
	driver = new ChromeDriver();
	driver.get(URL);					// Launching chrome browser with URL
	driver.manage().window().maximize();  // Maximizing browser screen
	WebDriverPojo.setDriver(driver);
	}
	catch(Exception e){
	    System.out.println(e);}
	return driver;
	}
	
	@AfterMethod()
	public static void webDriverTearDown() throws InterruptedException
	{
		driver.close();	// closing current accessing window
		driver.quit();	// Closing all opened windows
	}
}
