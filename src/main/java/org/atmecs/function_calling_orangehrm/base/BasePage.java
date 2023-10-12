package org.atmecs.function_calling_orangehrm.base;

import java.io.IOException;

import org.atmecs.function_calling_orangehrm.constants.Constants;
import org.atmecs.function_calling_orangehrm.constants.FilePathConstants;
import org.atmecs.function_calling_orangehrm.constants.LogMessages;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

/**
 * The <code>BasePage</code> class provides common methods for initializing and
 * launching the web application. It serves as the foundation for other page
 * classes in the automation framework.
 */
public class BasePage {
	private ReportLogService report = new ReportLogServiceImpl(BasePage.class);
	private XlsReader xlsReader;

	/**
	 * Launches the web application in the specified browser.
	 *
	 * @param browser        The browser instance to use for testing.
	 * @param os             The operating system on which the test is executed.
	 * @param osVersion      The version of the operating system.
	 * @param br             The name of the browser to use (e.g., Chrome, Firefox).
	 * @param browserVersion The version of the browser.
	 */
	public void launchApp(Browser browser, String os, String osVersion, String br, String browserVersion) {
		// Log the opening of the browser
		report.info(LogMessages.OPEN_BROWSER + br);
		// Open the specified URL in the browser
		browser.openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", os, osVersion, br,
				browserVersion);
		report.info("url opened");
		// Maximize the browser window
		report.info(LogMessages.MAXIMIZE_WINDOW);
		browser.maximizeWindow();

	}

	public String verifyColumnName(String text,int rowNum) {
	    xlsReader = new XlsReader();
	    try {
			xlsReader.setPath(FilePathConstants.EXCEL_INPUT_PATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String columnName = xlsReader.getColumnNameFromCellKey(text);

	    if (columnName != null) {
	    	report.info("Column Name: "+text);
			String validUserName = xlsReader.getCellDataByColumnName(Constants.SHEET_2, columnName,
					rowNum);
	        return validUserName; 
	    } else {
	        return "Column name not found."; 
	    }
	}
	

}
