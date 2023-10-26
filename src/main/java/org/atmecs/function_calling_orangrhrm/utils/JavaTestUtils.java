package org.atmecs.function_calling_orangrhrm.utils;

import java.util.ArrayList;

import org.atmecs.function_calling_orangehrm.constants.Constants;
import org.atmecs.function_calling_orangehrm.constants.FilePathConstants;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class JavaTestUtils {


	private ReportLogService report = new ReportLogServiceImpl(JavaTestUtils.class);

    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExcel(){
        ArrayList<Object[]> myData= new ArrayList<Object[]>();
        try{
            reader=new Xls_Reader(FilePathConstants.EXCEL_INPUT_PATH);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        
        int Count =reader.getRowCount(Constants.SHEET_2);
        System.out.println("Java Xls_Reader : " + Count);
        for(int rowNum=2; rowNum<=reader.getRowCount(Constants.SHEET_2);rowNum++){
            String userName= reader.getCellData(Constants.SHEET_2,Constants.COLUMN_VALID_USERNAME,rowNum);
            System.out.println(userName);
            String passWord= reader.getCellData(Constants.SHEET_2,Constants.COLUMN_VALID_PASSWORD,rowNum);
            String reportName= reader.getCellData(Constants.SHEET_2,Constants.COLUMN_REPORT_NAME,rowNum);
            String selectionCriteria= reader.getCellData(Constants.SHEET_2,Constants.COLUMN_SELECION_CRITERIA,rowNum);
            String selectionInclude= reader.getCellData(Constants.SHEET_2,Constants.COLUMN_SELECION_INCLUDE,rowNum);
            String dsiplayFieldGroup= reader.getCellData(Constants.SHEET_2,Constants.COLUMN_DISPLAY_FIELD_GROUP,rowNum);
            String displayField= reader.getCellData(Constants.SHEET_2,Constants.COLUMN_DISPLAY_FIELD,rowNum);
            String dispalyField2= reader.getCellData(Constants.SHEET_2,Constants.COLUMN_DISPLAY_FIELD_2,rowNum);
            
            Object ob[]={userName,passWord,reportName,selectionCriteria,selectionInclude,dsiplayFieldGroup,displayField,dispalyField2};
            myData.add(ob);
        }
        System.out.println(myData.toString());
        return myData;
    }
    
    public static void main(String[]args) {
		// TODO Auto-generated method stub
    	JavaTestUtils.getDataFromExcel();
    	
		  
		  
		
	}
}

