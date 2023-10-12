/**
 * This is the main test script for automating actions in the OrangeHRM application.
 * It includes test methods to perform various actions such as launching the application,
 * logging in, and interacting with different pages in the application.
 *
 * The test data required for these actions is provided through data providers.
 */
package org.atmecs.fuction_calling_orangehrm.testscript;

import java.util.ArrayList;
import java.util.Iterator;

import org.atmecs.fuction_calling_orangehrm.testsuite.SampleTestSuiteBase;
import org.atmecs.function_calling.orangehrm.pages.DashboardPage;
import org.atmecs.function_calling.orangehrm.pages.PIMPage;
import org.atmecs.function_calling_orangehrm.base.BasePage;
import org.atmecs.function_calling_orangehrm.constants.Constants;
import org.atmecs.function_calling_orangrhrm.utils.TestUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRMTestScript extends SampleTestSuiteBase {

	BasePage basePage;
	PIMPage pimPage;
	DashboardPage dashboardPage;
	private TestUtils testUtils;

	/**
	 * Data provider for test data.
	 *
	 * @return An iterator of test data.
	 */
	@DataProvider(name = "getData")
	public Iterator<Object[]> getTestDataFromSheet2() {
		testUtils = new TestUtils();
		ArrayList<Object[]> testData = testUtils.getDataProvider(Constants.COLUMN_VALID_USERNAME,
				Constants.COLUMN_VALID_PASSWORD, Constants.COLUMN_REPORT_NAME, Constants.COLUMN_SELECION_CRITERIA,
				Constants.COLUMN_SELECION_INCLUDE, Constants.COLUMN_DISPLAY_FIELD_GROUP, Constants.COLUMN_DISPLAY_FIELD,
				Constants.COLUMN_DISPLAY_FIELD_2);
		return testData.iterator();
	}

	/**
	 * Test method to launch the application.
	 *
	 * @param os             The operating system.
	 * @param osVersion      The operating system version.
	 * @param br             The browser.
	 * @param browserVersion The browser version.
	 */
	@Test
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void launchApp(String os, String osVersion, String br, String browserVersion) {
		// Launch the application
		basePage = new BasePage();
		basePage.launchApp(browser, os, osVersion, br, browserVersion);
	}

	@Test(priority = 1, dataProvider = "getData", dependsOnMethods = "launchApp")
	@Parameters({ "validUserName", "validPassWord", "reportName", "selectionCriteria", "selectInclude",
			"displayFieldGroup", "displayField", "selectionCriteriaCategory" })
	public void pimTabActions(String validUserName, String validPassWord, String reportName, String selectionCriteria,
			String selectInclude, String displayFieldGroup, String displayField, String selectionCriteriaCategory)
			throws InterruptedException {
		dashboardPage = new DashboardPage();
		pimPage = new PIMPage();

		dashboardPage.entervalidLoginCredentials(browser, validUserName, validPassWord);
		dashboardPage.clickPIMTab(browser);

		pimPage.clickReports(browser);
		pimPage.clickAdd(browser);
		pimPage.enterReportName(browser, reportName);
		pimPage.selectionCriteria(browser, selectionCriteria);
		pimPage.selectInclude(browser, selectInclude);
		pimPage.selectDisplayFieldGroup(browser, displayFieldGroup);
		pimPage.selectDisplayField(browser, displayField);
		pimPage.selectionCriteriaCategroy(browser, selectionCriteriaCategory);
		pimPage.clickSave(browser);

		pimPage.clickReports(browser);
		pimPage.clickReportNameTextField(browser, reportName);
		pimPage.clickSearch(browser);
		pimPage.getTextOfRecords(browser, reportName);
		pimPage.clickEdit(browser);
		pimPage.selectDisplayFieldGroupInEdit(browser, displayFieldGroup);
		pimPage.selectionCriteriaCategroyInEdit(browser, selectionCriteriaCategory);
		pimPage.clickSave(browser);

		pimPage.clickReports(browser);
		pimPage.clickReportNameTextField(browser, reportName);
		pimPage.clickSearch(browser);
		pimPage.getTextOfRecords(browser, reportName);
		pimPage.clickDelete(browser);
		pimPage.getTextOfDeleteRecords(browser, reportName);

	}

}
