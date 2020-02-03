package com.npw.demo;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.util.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hb.lib.HotelBooking;
import com.npw.lib.RA.NavigateTo;
import com.npw.lib.RA.RA;
import com.npw.locators.RA.Locators;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Elements;
import com.om.framework.lib.Messages;
import com.om.framework.lib.UserActions;
import com.om.framework.lib.Wait;
import com.om.framework.reporting.Reporting;



@Test
public class TC_02_RA_Regression extends BaseTest{
	
	private static boolean bStatus;

	
	public static void RA_Regression() throws InterruptedException, HeadlessException, IOException, AWTException 
	{
		//int B=HotelBooking.getRowNumBookedRecord("R", "H");
		HotelBooking.deleteRecord("First", "Last");
		//System.out.println(B);
	}
	

}
