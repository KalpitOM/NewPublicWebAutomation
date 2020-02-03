package com.npw.testscripts.ra;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.om.framework.lib.Utilities;

public class TC_01_TD 
{
	private static Map<String,String> objData;
	@Test
	public static void testdata() throws IOException
	{
		
		objData = Utilities.readTestData("TestData\\HotelData.xls", "HotelBookingSheet", "TC_01_TD");
		
		
		System.out.println(objData.get("FirstName"));
		
		System.out.println(objData.get("LastName"));
		
	}

}
