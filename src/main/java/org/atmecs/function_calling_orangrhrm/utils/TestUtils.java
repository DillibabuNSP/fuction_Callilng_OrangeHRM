package org.atmecs.function_calling_orangrhrm.utils;

import java.io.IOException;
import java.util.ArrayList;

import org.atmecs.function_calling_orangehrm.base.BasePage;
import org.atmecs.function_calling_orangehrm.constants.Constants;
import org.atmecs.function_calling_orangehrm.constants.FilePathConstants;

import com.atmecs.falcon.automation.util.parser.XlsReader;

/**
 * This class provides utility methods for fetching test data from an Excel
 * file.
 */
public class TestUtils {

	BasePage basePage = new BasePage();

	/**
	 * This method retrieves test data from an Excel file and returns it as an
	 * ArrayList of Object arrays.
	 *
	 * @return An ArrayList of Object arrays containing test data.
	 */

	public ArrayList<Object[]> getDataProvider(String columnName, String password, String reportname,
			String selectioncriteria, String selectinclude, String displayfieldGroup, String displayfield,
			String selectioncriteriaCategory) {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		XlsReader xlsReader = new XlsReader();

		try {
			xlsReader.setPath(FilePathConstants.EXCEL_INPUT_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int rowCount = xlsReader.getRowCount(Constants.SHEET_2);
		System.out.println(rowCount);

		for (int rowNum = 1; rowNum <= rowCount; rowNum++) {

			String validUserName = basePage.verifyColumnName(columnName, rowNum);
			String validPassWord = basePage.verifyColumnName(password, rowNum);

			String reportName = basePage.verifyColumnName(reportname, rowNum);
			String selectionCriteria = basePage.verifyColumnName(selectioncriteria, rowNum);
			String selectInclude = basePage.verifyColumnName(selectinclude, rowNum);
			String displayFieldGroup = basePage.verifyColumnName(displayfieldGroup, rowNum);
			String displayField = basePage.verifyColumnName(displayfield, rowNum);
			String selectionCriteriaCategory = basePage.verifyColumnName(selectioncriteriaCategory, rowNum);

			Object ob[] = { validUserName, validPassWord, reportName, selectionCriteria, selectInclude,
					displayFieldGroup, displayField, selectionCriteriaCategory };
			myData.add(ob);
		}

		return myData;
	}
}
