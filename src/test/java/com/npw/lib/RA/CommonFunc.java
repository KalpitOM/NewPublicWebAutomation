package com.npw.lib.RA;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.npw.locators.RA.Locators;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Elements;
import com.om.framework.lib.Messages;
import com.om.framework.lib.Wait;

public class CommonFunc 
{
	private static boolean bStatus;

	public static boolean selectDropDown(String stext)
	{
		//enter investment duration
		//click on the drop down for investment duration
		bStatus = Elements.clickElement(By.xpath(Locators.RaApp.clickDropDown(stext)));
		//bStatus=Elements.selectOptionByValue(By.xpath(Locators.RaApp.dropDown("select")), "Doctor");
		if(!bStatus) return bStatus;
		//Select drop down value for investment duration
		bStatus =  Elements.clickElement(By.xpath(Locators.RaApp.dropDown(stext)));
		if(!bStatus) return bStatus;

		return bStatus;
	}

	public static boolean selectDropDownPersonalDtls(String sFieldName,String sValue)
	{
		//enter investment duration
		//click on the drop down for investment duration
		bStatus = Elements.clickElement(By.xpath("//span[contains(text(),'"+sFieldName+"')]//..//div[@class='om-dropdown-field']"));
		//bStatus=Elements.selectOptionByValue(By.xpath(Locators.RaApp.dropDown("select")), "Doctor");
		if(!bStatus) return bStatus;
		//Select drop down value for investment duration
		bStatus =  Elements.clickElement(By.xpath(Locators.RaApp.dropDownPersonalDtls(sFieldName, sValue)));
		if(!bStatus) return bStatus;

		return bStatus;
	}


	public static boolean scrollToViewElement(By objLocator) throws InterruptedException
	{
		try
		{
			WebElement element = BaseTest.driver.findElement(objLocator);
			((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].scrollIntoView(true);", element);
			return true;
		}

		catch(Exception e)
		{
			Messages.errorMsg= e.getMessage();
			return false;	
		}

	}

	public static boolean enterTextForSplitPercentage(By objLocator,String sValue) throws InterruptedException
	{
		bStatus = Wait.waitForElementVisibility(objLocator, 25);
		if(bStatus)
		{
			CommonFunc.scrollToViewElement(objLocator);
			BaseTest.driver.findElement(objLocator).click();
			//driver.findElement(objLocator).clear();
			BaseTest.driver.findElement(objLocator).sendKeys(sValue);
			System.out.println("The text "+sValue+" has been inputted successfully.");
			return true;
		}
		System.out.println("The text "+sValue+" could not be entered successfully");
		return false;	
	}

	public static boolean selectPlan(Map<String,String> objSelectPlan)
	{
		//Select plan and click 
		bStatus=Elements.clickElement(By.xpath(Locators.RaApp.selectRaPlan(objSelectPlan.get("selectRaPlan"))));//("retirement-annuity/starter")));
		if(!bStatus) return bStatus;

		//click continue to reach app 
		bStatus=Elements.clickElement(By.xpath(Locators.RaApp.btnContinue("Continue")));
		return bStatus;
	}
	
	
	public static int chkBrokenLink(URL url) throws IOException {
		int response=0;
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try
		{
			connection.connect();
			response=connection.getResponseCode();
			connection.disconnect();
			return response;
		}

		catch(Exception e)
		{
			Messages.errorMsg=e.getMessage();
		}
		return response;   
	}
	
	public static boolean findBrokenLinks() throws MalformedURLException, IOException, InterruptedException {
		Thread.sleep(4000);
		List<WebElement> columnHdr = BaseTest.driver.findElements(By.xpath(Locators.RaApp.allLinksHomePage()));
		//List<WebElement> columnHdr = Elements.getWebElements(By.xpath(Locators.RaApp.allLinksHomePage()));
		bStatus=true;
		for(int i=0;i<columnHdr.size();i++) {
			int resp = 0;
			resp=CommonFunc.chkBrokenLink(new URL(columnHdr.get(i).getAttribute("href")));
			if(resp!=200) {
				System.out.println("Expected response code is 200. Response code for URL "+columnHdr.get(i).getAttribute("href")+" is....  "+resp);
				bStatus=false;
			}
		}
		return bStatus;
	}

}
