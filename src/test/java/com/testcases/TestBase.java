package com.testcases;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.Assert;

public class TestBase {
	
	
	public static RequestSpecification httpRequest;
	public static Response response;
		
	public Logger logger;
	
	@BeforeClass
	public void setup(){
		
		logger=Logger.getLogger("RegressionTesting");//added Logger
		PropertyConfigurator.configure("log4j.properties"); //added logger
		logger.setLevel(Level.DEBUG);
		
	}
	
// url - http://jsonplaceholder.typicode.com/photos/1

}
