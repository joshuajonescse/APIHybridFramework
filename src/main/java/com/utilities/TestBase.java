package com.utilities;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import io.restassured.response.Response;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;




import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
		
	public Logger logger;
	
	XLUtils obb = new XLUtils();
	
	@BeforeClass
	public void setup(){
		
		logger=Logger.getLogger("RegressionTesting");//added Logger
		PropertyConfigurator.configure("log4j.properties"); //added logger
		logger.setLevel(Level.DEBUG);
		
	}
	
	//The below method is to use data provider directly from the code 
//	@DataProvider (name = "empdataprovider")
//        public	String [][] empData() {
//		String empData[][] = {{"Ramu","driver"},{"Bob","police"}};
//		return empData;
//	}
	
	@DataProvider (name = "empdataprovider")
    public	String [][] empData() throws IOException {
		
		String path = System.getProperty("user.dir") + "/data.xlsx";
	int rowcount = 	XLUtils.getRowCount(path, "Sheet1");
	int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
	
	String empData[][] = new String[rowcount][colcount];
	
	for (int i = 1;i<=rowcount;i++) {
		for (int j = 0;j<colcount;j++) {
			empData[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);
		}
	}
	
	return empData;
}
	
	
	
}
