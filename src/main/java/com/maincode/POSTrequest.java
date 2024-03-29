package com.maincode;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
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

import java.util.HashMap;


public class POSTrequest {
	
	HashMap map = new HashMap(); 
	
	public Response postAPI() {
		
		map.put("name","kamal");
		map.put("job", "cricket");
		
		Response response = 
		
	
	RestAssured.given()
	   .contentType(ContentType.JSON)
	   .body(map)
	   
	 .when()
	     .post("https://reqres.in/api/users")
	     
	     .then()
	        .extract().response();
	
	return response;
	
	
	
	}

}
