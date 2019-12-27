package com.testcases;

import org.testng.annotations.Test;

import com.utilities.TestBase;
import com.utilities.XLUtils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.HashMap;

public class PostDataProviderTest extends TestBase{
	
   HashMap map = new HashMap(); 

   
	@Test(dataProvider="empdataprovider")
	public void postAPI(String ename, String ejob) {
		
		map.put("name",ename);
		map.put("job", ejob);
		
		Response response = 
		
	
	RestAssured.given()
	   .contentType(ContentType.JSON)
	   .body(map)
	   
	 .when()
	     .post("https://reqres.in/api/users")
	     
	     .then()
	        .extract().response();
	
		Assert.assertEquals(response.getStatusCode(), 201);	
	   System.out.println(response.getBody().jsonPath().prettify());
	}


}
