package com.npw.testscripts.ra;


import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.npw.lib.RA.CommonFunc;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Elements;

public class TC_05_VerifyNPWLinks extends BaseTest
{
	private static String sHomePage = "";
	private static boolean bStatus;
	private static List<WebElement> allLinks;
	private static List<String> listBadLinks = new ArrayList<String>();
	private static Map<String, List<String>> objMapErrorUrls = new HashMap<String,  List<String>>();
	private static Map<String, List<String>> objListMap = new HashMap<String,  List<String>>();
	private static Map<String, List<String>> objSubListMap = new HashMap<String,  List<String>>();

	@Test
	public static void verifyLinks() throws InterruptedException, IOException, HeadlessException, AWTException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.NANOSECONDS);
		
		Thread.sleep(3000);
		//get all the links on a page
		allLinks = Elements.getWebElements(By.xpath("//a[not(contains(@href,'secure'))]"));
		System.out.println("size of links before removing duplicates: "+allLinks.size());

		try {
			//Remove duplicates
			for(WebElement link:allLinks)
			{
				
				String sLink = link.getAttribute("href");
				List<String> list = new ArrayList<String>();
				
				if(!objListMap.containsKey(sLink) && sLink!=null && sLink.contains("digitalplatform.oldmutual.co.za") && !sLink.contains("object") && !objMapErrorUrls.containsKey(sLink))
				{
					URL url = new URL(sLink);
					int iResponse=CommonFunc.chkBrokenLink(url);
					if (iResponse!=200) {
						System.out.println("Response code of the URL "+sLink+" is... "+iResponse+" Expected response is 200");
						listBadLinks.add("Response code of the URL "+sLink+" is... "+iResponse+" Expected response is 200");
						objMapErrorUrls.put(sLink, list);
					}
					else 
					{
						list.add(sLink);
						objListMap.put(sLink, list);
						System.out.println("Home page links : "+sLink);
					}
					
				}
			}
			System.out.println("size of links after removing duplicates: "+objListMap.size());
		}
		catch(Exception e)
		{

		}
		
		List<String> keyList = new ArrayList<String>(objListMap.keySet());
		for(int i = 0; i < objListMap.size(); i++) 
		{
			String sLink = keyList.get(i);

			try {
				
				driver.navigate().to(sLink);
				List<WebElement> allSubLinks;

				//get all links
				allSubLinks = driver.findElements(By.xpath("//a[not(contains(@href,'secure'))]"));
				if(allSubLinks.isEmpty()) continue;

				//add them to separate map
				for(WebElement subLink:allSubLinks)
				{
					sLink = subLink.getAttribute("href");
					List<String> subList = new ArrayList<String>();

					//check if the link is already there. 
					//also check if the link is external, then ignore it
					if(!objListMap.containsKey(sLink) && !objSubListMap.containsKey(sLink) && sLink!=null && sLink.contains("digitalplatform.oldmutual.co.za") && !sLink.contains("object") && !objMapErrorUrls.containsKey(sLink) )
					{
						URL url = new URL(sLink);
						int iResponse=CommonFunc.chkBrokenLink(url);
						if (iResponse!=200) {
							System.out.println("Response code of the URL "+sLink+" is... "+iResponse+" Expected response is 200");
							listBadLinks.add("Response code of the URL "+sLink+" is... "+iResponse+" Expected response is 200");
							objMapErrorUrls.put(sLink, subList);
						}
						else
						{
							subList.add(sLink);
							objSubListMap.put(sLink, subList);
							System.out.println("sublinks.... "+ sLink);
							if(sLink.contains("qa")) {
								System.out.println("sdsa");
							}
						}
					}
				}
				System.out.println("objSubListMap size is ... "+objSubListMap.size());
			}

			catch(Exception e) {
				System.out.println("LINK UNDER Question is "+sLink+" .....error message is ... "+e.getMessage());
			}

		}

	}

}
