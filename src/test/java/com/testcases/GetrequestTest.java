package com.testcases;

import com.maincode.GETrequest;

import org.testng.Assert;
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

import java.util.List;

public class GetrequestTest extends TestBase{
	
	GETrequest obj1 = new GETrequest();
	
	
	@Test
	public void howEachFormatLooksLike() {
		
		logger.info("*************Method 1 ****************");
		
		String content = obj1.getSinglePhotoAPI_Response().getBody().asString();
		System.out.println("The String content of an API response will look like ***" + content);
		System.out.println("The Response raw format content of an API response will look like ***" + obj1.getSinglePhotoAPI_Response());
		System.out.println("The JSON converted prettify format from a response format will look like" + obj1.getSinglePhotoAPI_Response().getBody().jsonPath().prettify());
	JsonPath jpath = new JsonPath(content);
	 System.out.println("The JSON format from a string convert will look lik " + jpath);
}
	
	
	
	@Test
	public void testSinglePhoto_String() {
		
		logger.info("*************Method 2 ****************");
		
		String content = obj1.getSinglePhotoAPI_String();
		JsonPath jpath = new JsonPath(content);
		String url = jpath.getString("url");
		Assert.assertEquals(url,"https://via.placeholder.com/600/92c952");	
		System.out.println("The whole response string is " + content);
		
	}
	
	@Test
	public void testSinglePhoto_Response() {
		
		logger.info("*************Method 3 ****************");
		Response content = obj1.getSinglePhotoAPI_Response();
		Assert.assertEquals(content.getBody().jsonPath().get("title"),"accusamus beatae ad facilis cum similique qui sunt");
		Assert.assertEquals(content.getStatusCode(), 200);
		System.out.println("The prettified json response is " + content.getBody().jsonPath().prettify());
		
				
	}
	
	@Test
	public void testSinglePhoto_ResponseToString() {
		
		logger.info("*************Method 4 ****************");
		
		String content = obj1.getSinglePhotoAPI_Response().getBody().asString();
		Assert.assertTrue(content!=null);
		
				
	}
	
	@Test
	public void pathParamSinglePhoto_ResponseTest() {
		
		logger.info("*************Method 5 ****************");
		Response content = obj1.getSinglePhotoAPI_Response();
		Assert.assertEquals(content.getStatusCode(), 200);

}
	
	
	@Test
	public void queryParamSinglePhoto_ResponseTest() {
		
		logger.info("*************Method 6 ****************");
		Response content = obj1.queryParamSinglePhoto_Response();
		Assert.assertEquals(content.getStatusCode(), 200);

}
	
//	@Test
//	public void getHeadersTest() {
//		
//		logger.info("*************Method 7 ****************");
//		Headers header = obj1.getHeaders().getHeaders();
//		for(Header h:header) {
//			
//		System.out.println("Key Value    " + h.getName()+ "Value is   "+ h.getValue());
//		
//		}
//	}	
	@Test
	public void getListTest() {
		
		logger.info("*************Method 8 ****************");
		JsonPath jpath = new JsonPath(obj1.getList());
		List ls = jpath.get("id");
		System.out.println("The list size for id is " + ls.size());
		Assert.assertTrue(ls!=null);
		
	}
		
		
		
		
		
		
	
	
	
}