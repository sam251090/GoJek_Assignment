package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Elements {

	/*element define using locator and Page Factory*/
	@FindBy(how = How.XPATH, using = "//*[@class='btn buy']")
	public WebElement buy_Now_Button;
	
	@FindBy(how = How.XPATH, using = "//*[@class='cart-checkout']")
	public WebElement checkout_Button;

}
