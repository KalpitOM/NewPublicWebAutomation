package com.npw.locators.RA;

import com.sun.jna.platform.win32.LMAccess.LOCALGROUP_INFO_0;

public class Locators 
{
	public static String sXpath = "";


	public static class NavigationMenu
	{
		public static String getHeaderMenu(String sAppMenuItem)
		{
			//sXpath = "//div[contains(@class,'container-desktop')]//a[@href='/"+sAppMenuItem+"' or text()='"+sAppMenuItem+"']";
			//sXpath="//div[@class='om-main-navigation-col-2 main-navigation-items-desktop']/om-main-navigation-menu/ul/li/a[@href='/"+sAppMenuItem+"']";
			sXpath="//div[contains(@class,'container-desktop')]//a[text()='"+sAppMenuItem +"']";
			//sXpath="//div[contains(@class,'container-desktop')]//li[@class='active']//a[text()='"+sAppMenuItem+"']";
			//div[contains(@class,'container-desktop')]//a[text()='Wealth']
			//div[contains(@class,'container-desktop')]//a[text()='personal']
			return sXpath;
		}

		public static String subHeaderHover(String sHoverMenu)
		{
			//sXpath="//div[contains(@class, 'desktop desktop-scroll-nav')]//a[@href=\"/personal/solutions\" and contains(text(), 'Our  ')]";
			sXpath="//div[contains(@class,'container-desktop')]//li[@class='active']//a[text()='"+sHoverMenu+"']";
			return sXpath;
		}

	}

	public static class RaApp
	{
		public static String selectRaPlan(String sRaPlaneName)
		{
			sXpath="//div[contains(@class,'comparison-table-desktop-container')]//a[contains(@href, '"+sRaPlaneName+"')] ";
			//div[contains(@class,'comparison-table-desktop-container')]//a[contains(@href, '/retirement-ann')] 
			return sXpath;
		}

		public static String btnContinue(String btnContinue)
		{
			sXpath="//*[text()='"+btnContinue+"']";
			return sXpath;
		}

		public static String btnBackToHome(String btnBackHome)
		{
			sXpath="//*[contains(text(), '"+btnBackHome+"')]";
			return sXpath;
		}


		public static String inputText(String Stext)
		{
			
			sXpath="//input[((@type='text') and (preceding-sibling::span[text()='"+Stext+"'] or @placeholder='"+Stext+"')) or "
					+ "ancestor::om-input-field[contains(@preset,'"+Stext+"') or contains(@placeholder,'"+Stext+"')]]";

			return sXpath;
		}

		public static String clickDropDown(String sText)
		{
			
			sXpath="//select//option[contains(text(),'"+sText+"')]//..//..//div[@class='om-dropdown-field']";
			return sXpath;
		}

		public static String dropDown(String sText)
		{
			
			sXpath="//ul[@class='dropdown-options-list']//li[text()='"+sText+"']";
			return sXpath;
		}

		public static String subHeaderTitle(String sSubHeaderTtl)
		{
			sXpath="//*[contains(text(), '"+sSubHeaderTtl+"')]";
			return sXpath;
		}

		public static String subHeaderTitle2(String sSubHeaderTtl)
		{
			
			sXpath="//strong[contains(text(),'"+sSubHeaderTtl+"')]";
			return sXpath;
		}

		public static String checkBoxInvestmentPage(String Stext)
		{
			
			sXpath="//h4[contains(text(),'"+Stext+"')]/ancestor::div[@class='product-info-accordion']//om-check-box";
			return sXpath;
		}

		public static String radioBtnInvestmentPage(String Stext)
		{
			sXpath="//om-radio-button[contains(@radio-button-text,'"+Stext+"')]";
			return sXpath;
		}

		public static String enterSplitPercentage(String sText)
		{
			sXpath="//h6[@class='medium' and contains(text(),'"+sText+"')]//..//..//..//om-input-field[@suffix=\"%\"]//input[contains(@class,'om-input-field')]";
			return sXpath;
		}

		public static String dropDownPersonalDtls(String sFieldName, String sValue)
		{
			sXpath="//span[contains(text(),'"+sFieldName+"')]//..//ul[@class='dropdown-options-list']//li[text()='"+sValue+"']";
			return sXpath;
		}

		public static String checkBoxPaymentDetails(String Stext)
		{
			
			sXpath="//om-check-box[contains(@text,'"+Stext+"')]//span[@class='om-checkbox-icon']";
			return sXpath;
		}
		public static String allLinksHomePage()
		{
			sXpath="//a[contains(@href,'co.za')]";
			return sXpath;
		}

	}




	public static class GapApp {


		public static String btnContinueOrPrevious(String btnContinueOrPrevious)
		{
			return RaApp.btnBackToHome(btnContinueOrPrevious);

		}

		public static String inputText(String Stext) {
			sXpath="//input[((@type='text') and (preceding-sibling::span[text()='"+Stext+"'] or @placeholder='"+Stext+"'))]";
			return sXpath;
		}

		public static String radioBtn(String stext) {
			// TODO Auto-generated method stub
			return RaApp.radioBtnInvestmentPage(stext);	
		}

		public static String clickDropDown(String sText)
		{

			return RaApp.clickDropDown(sText);
		}

		public static String selectDropDownValue(String sText)
		{
			return RaApp.dropDown(sText);
		}

		public static String selectCheckBox(String sText) {
			sXpath="//span[contains(text(),'"+sText+"')]//..//preceding-sibling::om-check-box//span[@class='om-checkbox-icon']";
			return sXpath;
		}

		public static String getSuccessMsg() {
			sXpath="//div[@slot='content']//strong[contains(text(),'Application')]//..//following-sibling::h6";
			return sXpath;
		}
		
		public static String subHeaderTitle(String sSubHeaderTtl)
		{
			
			return RaApp.subHeaderTitle(sSubHeaderTtl);
		}
		
		public static String ShadowDom(String sText) {
			
			sXpath= "//strong[contains(text(),'"+sText+"')]//ancestor::div[@class='toggle-heading-wrapper']//following-sibling::div[@class=('form-fields-wrapper' or 'toggle-wrapper')]//om-toggle-switch | //strong[contains(text(),'"+sText+"')]//..//following::om-toggle-switch[1]";
			return sXpath;
			
		}

	}





}
