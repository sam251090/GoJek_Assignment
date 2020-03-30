package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngularBinding;
import com.paulhammant.ngwebdriver.NgWebDriver;


public class Operation {

	public void checkout_Flow(WebDriver driver, NgWebDriver ngDriver, String cc_No, String cvv, String expiry_Date, String otp) throws InterruptedException 
	{	
		WebDriverWait wait=new WebDriverWait(driver, 60);
		Thread.sleep(3000);
		WebElement buy_Now_Button=driver.findElement(ByAngularBinding.xpath("//*[@class='btn buy']"));
		wait.until(ExpectedConditions.visibilityOf(buy_Now_Button));
		wait.until(ExpectedConditions.elementToBeClickable(buy_Now_Button));
		buy_Now_Button.click();
		Thread.sleep(2000);
		
		WebElement checkout_Button=driver.findElement(ByAngularBinding.xpath("//*[@class='cart-checkout']"));
		wait.until(ExpectedConditions.visibilityOf(checkout_Button));
		wait.until(ExpectedConditions.elementToBeClickable(checkout_Button));
		checkout_Button.click();
		Thread.sleep(3000);
		
		String framename="snap-midtrans";
	//	driver.switchTo().frame(framename);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framename));
		Thread.sleep(2000);
		
		WebElement continue_Button=driver.findElement(ByAngularBinding.xpath("//*[@class='button-main-content']"));
		wait.until(ExpectedConditions.visibilityOf(continue_Button));
		wait.until(ExpectedConditions.elementToBeClickable(continue_Button));
		continue_Button.click();
		
		
		WebElement cc_Payment_Mode=driver.findElement(ByAngularBinding.xpath("//*[@class='list with-promo']"));
		wait.until(ExpectedConditions.visibilityOf(cc_Payment_Mode));
		cc_Payment_Mode.click();
		Thread.sleep(2000);
		
		/*   fill credit card details  */
		WebElement cc_No_Entry=driver.findElement(ByAngularBinding.name("cardnumber"));
		cc_No_Entry.sendKeys(cc_No);
		
		Actions act = new Actions(driver);

	       act.sendKeys(Keys.TAB).sendKeys(expiry_Date).sendKeys(Keys.TAB).sendKeys(cvv).build().perform();
	       Thread.sleep(2000);
	       
	     /*   checkbox deselecting   */
	    List<WebElement> promos= (List<WebElement>) driver.findElements(ByAngularBinding.name("promo"));
	     
	    for(int i=0; i<promos.size(); i++)
	    {
	     if(promos.get(i).isSelected())
	     {
	         promos.get(i).click();
	     }
	    }
		
		WebElement pay_Now_Button=driver.findElement(ByAngularBinding.xpath("//*[@class='button-main show']"));
		wait.until(ExpectedConditions.visibilityOf(pay_Now_Button));
		pay_Now_Button.click();
		Thread.sleep(3000);
	
	//	driver.switchTo().frame(0);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		Thread.sleep(2000);
		
		//OTP Page
		WebElement otp_entry=driver.findElement(ByAngularBinding.name("PaRes"));
		wait.until(ExpectedConditions.visibilityOf(otp_entry));
		otp_entry.sendKeys(otp);
		
		
		WebElement otp_Confirm_Button=driver.findElement(ByAngularBinding.name("ok"));
		otp_Confirm_Button.click();
		Thread.sleep(2000);
		
		driver.switchTo().frame(0);
	}
	
	public void transaction_Success(WebDriver driver, NgWebDriver ngDriver, String browser) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		if(browser.equalsIgnoreCase("Chrome"))
		{
		String actual=driver.findElement(ByAngularBinding.xpath("//*[contains(text(),'Transaction successful')]")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual, "Transaction successful");
		}
	}
	
	public void transaction_Failed(WebDriver driver, NgWebDriver ngDriver, String browser) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		if(browser.equalsIgnoreCase("chrome"))
		{
		String actual=driver.findElement(ByAngularBinding.xpath("//*[contains(text(),'Transaction failed')]")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual, "Transaction failed");
		}
	}
	
}
