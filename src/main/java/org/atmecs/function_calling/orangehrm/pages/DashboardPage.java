package org.atmecs.function_calling.orangehrm.pages;

import org.atmecs.function_calling_orangehrm.constants.Constants;
import org.atmecs.function_calling_orangehrm.constants.FilePathConstants;
import org.atmecs.function_calling_orangehrm.helper.MethodHelper;
import org.atmecs.function_calling_orangehrm.pagekeys.DashBoardPageKeys;
import org.atmecs.function_calling_orangehrm.pagekeys.LoginPageKeys;
import org.atmecs.function_calling_orangrhrm.utils.PropertyParser;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class DashboardPage {
	private ReportLogService report = new ReportLogServiceImpl(DashboardPage.class);
	PropertyParser loginPageProperty;
	MethodHelper methodHelper = new MethodHelper();
	private PropertyParser dashBoardProperty;

	public DashboardPage() {
		loginPageProperty = new PropertyParser(FilePathConstants.LOGIN_PAGE_PATH);
		dashBoardProperty= new PropertyParser(FilePathConstants.DASHBOARD_PAGE_PATH);
	}

	public void entervalidLoginCredentials(Browser browser, String userName, String passWord)
			throws InterruptedException {

		report.info("Entering valid credentials");
		String userNameXpath = loginPageProperty.getPropertyValue(LoginPageKeys.USER_NAME);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, userNameXpath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, userNameXpath, userName);
		Thread.sleep(3000);

		String passWordXpath = loginPageProperty.getPropertyValue(LoginPageKeys.PASS_WORD);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, passWordXpath, Constants.TIME_OUTS);
		browser.getTextField().enterTextField(LocatorType.XPATH, passWordXpath, passWord);
		Thread.sleep(3000);
		String loginButtonXpath = loginPageProperty.getPropertyValue(LoginPageKeys.LOGIN_BUTTON);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, loginButtonXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, loginButtonXpath);
		
	}
	
	public void clickPIMTab(Browser browser) throws InterruptedException {
		report.info("Clicking on PIM Tab");
		String pimTabXpath = dashBoardProperty.getPropertyValue(DashBoardPageKeys.PIM_TAB);
		browser.getWait().waitForElementPresence(LocatorType.XPATH, pimTabXpath, Constants.TIME_OUTS);
		browser.getClick().performClick(LocatorType.XPATH, pimTabXpath);
		
	}
	
	
}
