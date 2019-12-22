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
	
	HashMap<String,String> map = new HashMap<String,String>(); 
	
	public Response postAPI() {
		
		//map.put("id", "19");
		map.put("title","Addossbe");
		map.put("author", "Mssaxy");
		
		
		Response response = 
		
	
	RestAssured.given()
	   .contentType(ContentType.JSON)
	   
	 .when()
	     .post("http://localhost:3000/posts")
	     
	     .then()
	        .extract().response();
	
	return response;
	
	
	
	}

}
