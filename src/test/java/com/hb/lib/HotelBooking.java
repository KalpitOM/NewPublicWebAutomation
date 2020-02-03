package com.hb.lib;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.hb.locators.Locators;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Elements;

public class HotelBooking extends BaseTest{

	private static boolean bStatus=true;

	/*******************************************************************************
	Function Name 					: createAppHotelBooking
	Description						: This  method will create a new booking on Hotel booking page and confirms if the record is created 
	Parameters						: Hash map read from excelsheet for input data
	User info or parameter data		:

	Created By						: Kalpit Jadhav
	Created On						: 22 Jan 2020
	 * @throws InterruptedException 

	 ******************************************************************************/
	public static boolean createAppHotelBooking(Map<String,String> objCrtApp) throws InterruptedException
	{
		//Enter First Name
		bStatus=Elements.enterText(By.id("firstname"), objCrtApp.get("Firstname"));
		if(!bStatus) return bStatus;
		//Enter Surname
		bStatus=Elements.enterText(By.id("lastname"), objCrtApp.get("Surname"));
		if(!bStatus) return bStatus;
		//Enter Price
		bStatus=Elements.enterText(By.id("totalprice"), objCrtApp.get("Price"));
		if(!bStatus) return bStatus;
		//Select Deposit paid
		bStatus=Elements.selectOptionByVisibleText(By.id("depositpaid"), objCrtApp.get("DepositPaid"));
		if(!bStatus) return bStatus;
		//Enter Checkin date directly without opening calender
		bStatus=Elements.enterText(By.id("checkin"), objCrtApp.get("Checkin"));
		if(!bStatus) return bStatus;
		//Enter Checkout date directly without opening calender
		bStatus=Elements.enterText(By.id("checkout"), objCrtApp.get("Checkout"));
		if(!bStatus) return bStatus;
		//Click save to submit booking
		bStatus=Elements.clickElement(By.xpath(Locators.hotelBook.btnSave("Save")));
		if(!bStatus) return bStatus;
		Thread.sleep(10000);
		//verify if the the record is saved or not
		if(getRowNumBookedRecord(objCrtApp.get("Firstname"), objCrtApp.get("Surname"))!=0) {
			return true;
		}
		else
		{
			return false;
		}
	}

	/*******************************************************************************
	Function Name 					: createAndDeleteApp
	Description						: This  method will create a new booking ,
	 								  and then it will delete that record.
	 								  And then it will verify if the record is not present in the list	
	Parameters						: Hash map read from excelsheet for input data
	User info or parameter data		:

	Created By						: Kalpit Jadhav
	Created On						: 22 Jan 2020
	 * @throws InterruptedException 

	 ******************************************************************************/
	public static boolean createAndDeleteApp(Map<String,String>objCrtDelApp) throws InterruptedException {
		//Create record and save and verify if it is present
		bStatus=createAppHotelBooking(objCrtDelApp);
		if(!bStatus) return bStatus;
		//Verify if the record is present and delete it
		bStatus=deleteRecord(objCrtDelApp.get("Firstname"), objCrtDelApp.get("Surname"));
		return bStatus;

	}

	/*******************************************************************************
	Function Name 					: getRowNumBookedRecord
	Description						: This  method will search for booked ticket record using first 
									  Name and surname
	Parameters						: First Name, Surname
	Returns							: It returns the row number of the most recent record created

	Created By						: Kalpit Jadhav
	Created On						: 22 Jan 2020
	 * @throws InterruptedException 

	 ******************************************************************************/
	public static int getRowNumBookedRecord(String expFName, String expSurName) {
		int iRow=0;

		List<WebElement> numOfRows;
		String actualFName;
		String actualSurName;
		try {
			numOfRows=driver.findElements(By.xpath(Locators.hotelBook.numOfRows()));

			for(iRow=numOfRows.size();iRow>=2;iRow--) {
				actualFName=driver.findElement(By.xpath(Locators.hotelBook.columnFrstName(iRow))).getText();
				actualSurName=driver.findElement(By.xpath(Locators.hotelBook.columnSurName(iRow))).getText();
				if(actualFName.contains(expFName)) {
					if(actualSurName.contains(expSurName)) {
						return iRow;
					}
				}
			}
		}
		catch(Exception e) {

		}
		return 0;
	}

	/*******************************************************************************
	Function Name 					: deleteRecord
	Description						: This  method will delete Most recent record matching first name and surname 
	Parameters						: First Name, Surname
	Returns							:It returns true for success and false for failure

	Created By						: Kalpit Jadhav
	Created On						: 22 Jan 2020
	 * @throws InterruptedException 

	 ******************************************************************************/
	public static boolean deleteRecord(String expFName, String expSurName) {
		// get row number of the first record match  with  Name + surname 
		int getRowNum=getRowNumBookedRecord(expFName, expSurName);
		//if record exists, delete it
		if(getRowNum!=0) {
			bStatus=Elements.clickElement(By.xpath(Locators.hotelBook.columnDelete(getRowNum)));
			if (!bStatus) return bStatus;
		}
		return true;
	}

}
