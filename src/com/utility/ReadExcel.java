package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.module.CommonUtility;

public class ReadExcel {

	public void readExcel(String filePath,String fileName,String sheetName,WebDriver driver) throws IOException{

		CommonUtility cu=new CommonUtility();
	    File file =    new File(filePath+"\\"+fileName);
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook operationwb = null;
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    if(fileExtensionName.equals(".xlsx")){
	    operationwb = new XSSFWorkbook(inputStream);
	    }
	    else if(fileExtensionName.equals(".xls")){
	    	operationwb = new HSSFWorkbook(inputStream);
	    }
	    
	    
	    Sheet operationsheet = operationwb.getSheet(sheetName);
	    int rowCount = operationsheet.getLastRowNum()-operationsheet.getFirstRowNum();
	    for (int i = 0; i < rowCount+1; i++) {
	        Row row = operationsheet.getRow(i);
	        StringBuffer sb = new StringBuffer("");
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	            sb.append(row.getCell(j).getStringCellValue()+"|| ");
	        }
	        String str = new String(sb);
	        if(str.contains("|| y") || str.contains("|| Y"))
	        {
	        	if (str.contains("registration"))
	        		cu.register(driver);
	        	else 
	        		cu.login();
	        }
	        	
	        System.out.println();
	    } 
	    }
	public String readRegistrationDetails(String filePath,String fileName,String sheetName,WebDriver driver,String TextfieldName) throws IOException
	{
		String value=null;
	    File file =    new File(filePath+"\\"+fileName);
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook operationwb = null;
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    if(fileExtensionName.equals(".xlsx")){
	    operationwb = new XSSFWorkbook(inputStream);
	    }
	    else if(fileExtensionName.equals(".xls")){
	    	operationwb = new HSSFWorkbook(inputStream);
	    }
	    
	    
	    Sheet operationsheet = operationwb.getSheet(sheetName);
	    int rowCount = operationsheet.getLastRowNum()-operationsheet.getFirstRowNum();
	    for (int i = 0; i < rowCount+1; i++) {
	        Row row = operationsheet.getRow(i);
	        for (int j = 0; j < row.getLastCellNum();j++) {
	        	String cellvalueexact=null;
	        	if (row.getCell(j).getCellType()==CellType.NUMERIC)
	        	{
	        		cellvalueexact = row.getCell(j).toString();
	        	}
	        	else
	        		cellvalueexact = row.getCell(j).getStringCellValue();
	          //  System.out.print(row.getCell(j).getStringCellValue());
	            if(cellvalueexact.equalsIgnoreCase(TextfieldName))
	            {
	            	value=row.getCell(j-1).getStringCellValue();
	            	break;
	            }
	        }
	        if(value!=null)
	        {
	        	System.out.println(value);
	        	break;
	        }
	        break;
	    }
	    
	    return value;
	}
	
}