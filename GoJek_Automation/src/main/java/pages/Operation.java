package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.ByAngularBinding;
import com.paulhammant.ngwebdriver.NgWebDriver;


public class Operation {

	public void checkout_Flow(WebDriver driver, NgWebDriver ngDriver, String cc_No, String cvv, String expiry_Date, String otp) throws InterruptedException 
	{
	/*	WebDriverWait wait=new WebDriverWait(driver, 10);
		Elements ee=PageFactory.initElements(driver, Elements.class);
		
		wait.until(ExpectedConditions.visibilityOf(ee.buy_Now_Button));	
		ee.buy_Now_Button.click();
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOf(ee.checkout_Button));	
		ee.checkout_Button.click();
		
		Thread.sleep(5000);
		*/
		
		
//		driver.findElement(ByAngularBinding.name("//*[@class='btn buy']")).sendKeys("test@gmail.com");
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		
		WebElement buy_Now_Button=driver.findElement(ByAngularBinding.xpath("//*[@class='btn buy']"));
		wait.until(ExpectedConditions.visibilityOf(buy_Now_Button));
		buy_Now_Button.click();
	
		Thread.sleep(2000);
		
		WebElement checkout_Button=driver.findElement(ByAngularBinding.xpath("//*[@class='cart-checkout']"));
		wait.until(ExpectedConditions.visibilityOf(checkout_Button));
		checkout_Button.click();
		
		Thread.sleep(3000);
		
		String framename="snap-midtrans";
		driver.switchTo().frame(framename);
		
		WebElement continue_Button=driver.findElement(ByAngularBinding.xpath("//*[@class='button-main-content']"));
		wait.until(ExpectedConditions.visibilityOf(continue_Button));
		continue_Button.click();
		
		
		WebElement cc_Payment_Mode=driver.findElement(ByAngularBinding.xpath("//*[@class='list with-promo']"));
		wait.until(ExpectedConditions.visibilityOf(cc_Payment_Mode));
		cc_Payment_Mode.click();
		Thread.sleep(2000);
		
		WebElement cc_No_Entry=driver.findElement(ByAngularBinding.name("cardnumber"));
		cc_No_Entry.sendKeys(cc_No);
		
		Actions act = new Actions(driver);

	       act.sendKeys(Keys.TAB).sendKeys(expiry_Date).sendKeys(Keys.TAB).sendKeys(cvv).build().perform();
	       Thread.sleep(2000);
	       
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
		Thread.sleep(2000);
	
		driver.switchTo().frame(0);
		
		WebElement otp_entry=driver.findElement(ByAngularBinding.name("PaRes"));
		wait.until(ExpectedConditions.visibilityOf(otp_entry));
		otp_entry.sendKeys(otp);
		
		
		WebElement otp_Confirm_Button=driver.findElement(ByAngularBinding.name("ok"));
		otp_Confirm_Button.click();
		Thread.sleep(2000);
		
	}
}
