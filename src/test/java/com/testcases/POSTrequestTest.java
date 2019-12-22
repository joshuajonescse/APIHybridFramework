package com.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.maincode.POSTrequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class POSTrequestTest extends TestBase {
	
	POSTrequest obj1 = new POSTrequest();
	
     @Test
	public void postAPITest() {
    	 
    		logger.info("*************Method 1 in Post  ****************");
				
		Assert.assertEquals(obj1.postAPI().getStatusCode(), 201);
	//Assert.assertEquals(obj1.postAPI().getBody().jsonPath().get("author"),"Mssaxy");
		
	}

}
