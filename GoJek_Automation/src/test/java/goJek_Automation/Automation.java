package goJek_Automation;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

import excelSheet.ExcelPojo;
import excelSheet.Excel_File;
import pages.Elements;
import pages.Operation;
import webDriverCode.WebDriverPojo;
import webDriverCode.WebDriverUtil;

public class Automation extends WebDriverUtil {
	
	public WebDriver driver;    
	public NgWebDriver ngDriver;
	String cc_No1, expiry_Date1, cvv1, otp1, cc_No2, expiry_Date2, cvv2, otp2;
	Operation oo=new Operation();       
	Excel_File excel=new Excel_File();
	Path currentDir = Paths.get(System.getProperty("user.dir"));
	Path Excel_Path = Paths.get(currentDir.toString(), "src", "test", "resources", "Excel", "Excel_Data.xlsx"); 
	
	
	/*Excel file call for fetching data from excel*/
	@BeforeTest
	public void excel_cal() throws Exception{
		Excel_File.setExcelFile(Excel_Path.toString(), "CC_Data");
		
	}
	
	/*Successful Payment with Credit card*/
	@Test
	public void TestCase1() throws Exception{
		
		/*webDriver call*/
		driver=WebDriverPojo.getDriver();
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		ngDriver.waitForAngularRequestsToFinish();
		
		/*Credit card 1 data */
		cc_No1 = Excel_File.getCellData(1, 0);
		expiry_Date1 = Excel_File.getCellData(1, 1);
		cvv1 = Excel_File.getCellData(1, 2);
		otp1 = Excel_File.getCellData(1, 3);
		
		ExcelPojo.setCc_No(cc_No1);
		ExcelPojo.setExpiry_Date(expiry_Date1);
		ExcelPojo.setCvv(cvv1);
		ExcelPojo.setOtp(otp1);
		
		/*Page factory elements call*/
		Elements ee=PageFactory.initElements(driver, Elements.class);
		oo.checkout_Flow(driver, ngDriver, ExcelPojo.getCc_No(), ExcelPojo.getCvv(), ExcelPojo.getExpiry_Date(), ExcelPojo.getOtp());
		Thread.sleep(3000);
				
	}
	
	/*Faild Payment with Credit card*/
	@Test
	public void TestCase2() throws Exception{
		
		/*webDriver call*/
		driver=WebDriverPojo.getDriver();
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		ngDriver.waitForAngularRequestsToFinish();
		
		/*Credit card 2 data */
		cc_No2 = Excel_File.getCellData(2, 0);
		expiry_Date2 = Excel_File.getCellData(2, 1);
		cvv2 = Excel_File.getCellData(2, 2);
		otp2 = Excel_File.getCellData(2, 3);
		
		ExcelPojo.setCc_No(cc_No2);
		ExcelPojo.setExpiry_Date(expiry_Date2);
		ExcelPojo.setCvv(cvv2);
		ExcelPojo.setOtp(otp2);	
		
		/*Page factory elements call*/
		Elements ee=PageFactory.initElements(driver, Elements.class);
		oo.checkout_Flow(driver, ngDriver, ExcelPojo.getCc_No(), ExcelPojo.getCvv(), ExcelPojo.getExpiry_Date(), ExcelPojo.getOtp());
		Thread.sleep(3000);
				
	}

}
