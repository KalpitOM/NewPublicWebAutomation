package com.hb.locators;

public class Locators {
	public static String sXpath = "";

	public static class hotelBook{

		public static String btnSave(String sSave)
		{
			sXpath="//input[contains(@value,'"+sSave+"')]";
			return sXpath;
		}

		public static String numOfRows()
		{
			sXpath="//div[@id='bookings']//div[@class='row']";
			return sXpath;
		}

		public static String columnFrstName(int iRow)
		{
			sXpath="//div[@id='bookings']//div[@class='row']["+iRow+"]//div[1]//p";
			return sXpath;
		}

		public static String columnSurName(int iRow)
		{
			sXpath="//div[@id='bookings']//div[@class='row']["+iRow+"]//div[2]//p";
			return sXpath;
		}

		public static String columnDelete(int iRow)
		{
			sXpath="//div[@id='bookings']//div[@class='row']["+iRow+"]//input[@value='Delete']";
			return sXpath;
		}
	}

}
