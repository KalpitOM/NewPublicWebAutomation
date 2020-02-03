package com.npw.demo;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.npw.lib.RA.CommonFunc;
import com.om.framework.lib.Messages;
import com.om.framework.lib.UserActions;
import com.om.framework.lib.Wait;

public class ToolSQA {
	private static WebDriverWait wait;
	public static void main(String[] args) {
		List<WebElement> columnHdr;
		List<WebElement> iRow;
		boolean bFlag=false;
		String resp="";
		try {

			System.setProperty("webdriver.chrome.driver", "WebDrivers\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.get("https://new-public-web-qa.nonprod.digitalplatform.oldmutual.co.za/");
			driver.manage().window().maximize();
			//wait= new WebDriverWait(driver, 15);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'co.za')]")));
			Thread.sleep(10000);
			columnHdr=driver.findElements(By.xpath("//a[contains(@href,'co.za')]"));
			for(int i=0;i<columnHdr.size();i++) {
				resp="";
				System.out.println(columnHdr.get(i).getAttribute("href"));

		//		resp=chkBrokenLink(new URL(columnHdr.get(i).getAttribute("href")));
				System.out.println("Response is "+ resp);
			}

			driver.close();
		}

		catch(Exception e) {



		}

	}


	



}
