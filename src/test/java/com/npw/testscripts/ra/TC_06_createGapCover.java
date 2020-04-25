package com.npw.testscripts.ra;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.npw.lib.RA.Gap;
import com.om.framework.basetest.BaseTest;
import com.om.framework.reporting.Reporting;

public class TC_06_createGapCover extends BaseTest {

	private static boolean bStatus=false;
	private static String TestCaseName="TC_06_createGapCover";
	

	@Test
	public static void createGapCoverApp() throws HeadlessException, IOException, AWTException {
		
		Reporting.Functionality = "Gap";
		Reporting.Testcasename = TestCaseName;
		
		//Create GAP application
		bStatus=Gap.createGapCoverApp();
		if (!bStatus) 
			Reporting.logResults("Fail", "Submit Gap Application to Call center", "Not able to submit Gap application");
		else
			Reporting.logResults("Pass", "Submit Gap Application to Call center", "Successfully submitted GAP application to call center");
	}



}
