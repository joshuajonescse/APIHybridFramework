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

import java.util.List;
import java.util.Map;

import io.restassured.response.Response;
import org.testng.Assert;


public class GETrequest {
	
	
	public String getSinglePhotoAPI_String() {
		
		String myResponse = 
				
		RestAssured.given()
		
		.when()
		    .get("http://jsonplaceholder.typicode.com/photos/1")
		 .then()
		    .extract().asString();
		
		return myResponse;
		
	}
	
	public Response getSinglePhotoAPI_Response() {
	
		Response response =
				
				RestAssured.given()
				
				.when()
				    .get("http://jsonplaceholder.typicode.com/photos/1")
				 .then()
				    .extract().response();
		
		return response;			
		
	}

	
	public Response pathParamSinglePhoto_Response() {
		
		Response response = 
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.with()
		  .pathParams("post","1")
		    			    	
		.when()
		   .get("http://jsonplaceholder.typicode.com/photos/{post}")
		   
		 .then()
		   .extract().response();
		
		return response;
		   		
}

	
	public Response queryParamSinglePhoto_Response() {
	
		Response response = 
	
		RestAssured.given()
		.contentType(ContentType.JSON)
		.with()
		  .queryParams("id",1)
		    			    	
		.when()
		   .get("http://jsonplaceholder.typicode.com/photos/")
		   
		 .then()
		    .extract().response();
		
		return response;
		
	
}
	
	
	public String pathParamSinglePhoto_String() {
		
		String response = 
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.with()
		  .pathParams("post","1")
		    			    	
		.when()
		   .get("http://jsonplaceholder.typicode.com/photos/{post}")
		   
		 .then()
		   .extract().asString();
		
		return response;
		   		
}

	
	public String queryParamSinglePhoto_String() {
	
		String response = 
	
		RestAssured.given()
		.contentType(ContentType.JSON)
		.with()
		  .queryParams("id",1)
		    			    	
		.when()
		   .get("http://jsonplaceholder.typicode.com/photos/")
		   
		 .then()
		    .extract().asString();
		
		return response;

	}

	public String AllPhotos_String() {
		
		String response = 
	
		RestAssured.given()
		.contentType(ContentType.JSON)
				    			    	
		.when()
		   .get("http://jsonplaceholder.typicode.com/photos/")
		   
		 .then()
		    .extract().asString();
		
		return response;

	}
        /*  Dont know whether the specific below response pattern will work for assert not null or not in the test class*/
//			public Response AllPhotos_Response() {
//					
//					Response response = 
//				
//					RestAssured.given()
//					.contentType(ContentType.JSON)
//							    			    	
//					.when()
//					   .get("http://jsonplaceholder.typicode.com/photos/")
//					   
//					 .then()
//					    .extract().response();
//					
//					return response;

//	}

//*************All the below mentioned test scenarios, just check for status code ********************

	
	public Response invalidTLS() {	
		
		Response response = 
		
		RestAssured.given()
		  .relaxedHTTPSValidation("TLS")
		 .when()	   
		   .get("https://www.bupa.com.au/ ")
		   .then()
		   .extract().response();
		
		return response;
		
		
		}
	
	public Response invalidCertificates() {	
		
		Response response =
		RestAssured.given()
		  .relaxedHTTPSValidation()
		 .when()	   
		   .get("https://www.bupa.com.au/ ")
		   .then()
             .extract().response();
		
		return response;
		
		
		
		}
	
	public Response  loggingTest() {
		
		Response response = 
		RestAssured.given()
		  .auth().digest("username","password")	
		 .when()	   
		   .get("http://jsonplaceholder.typicode.com/photos/1 ")
		   .then()
               .extract().response();
		
		return response;
		
		}
	
	public Response digestAuthentication() {
		
		Response response = 
		RestAssured.given()
		  .auth().digest("username","password")	
		 .when()	   
		   .get("http://jsonplaceholder.typicode.com/photos/1 ")
		   .then()
		   .extract().response();
		
		return response;
		}
	
	public Response preemptiveAuthentication() {
		
		Response response = 
		RestAssured.given()
		  .auth().preemptive().basic("username","password")	
		 .when()	   
		   .get("http://jsonplaceholder.typicode.com/photos/1 ")
		   .then()
                 .extract().response();
		
		return response;
		
		
		
		}
	public Response challengedAuthentication() {
		
		Response response = 
		RestAssured.given()
		  .auth().basic("username","password")	
		  .when()	   
		   .get("http://jsonplaceholder.typicode.com/photos/1 ")
		   .then()
                .extract().response();
		
		return response;
		
		}
	public Response getSetHeader() {
		
		Response response = 
		
		RestAssured.given()
		   .header("Hey", "1")
		   .headers("bye" , "val1","rey","val2") // to set 2 pair of header values 
		   .when()	   
		   .get("http://jsonplaceholder.typicode.com/photos/1 ")
		   .then()
                 .extract().response();
		
		return response;
	}
	
	public Response getSetCookie() {
		
		Response response = 
		RestAssured.given()
		   .cookie("Hey", "1")
		   .cookie("bye" , "val1","val2","val3") // to set multiple cookie values to one cookie key
		   .when()	   
		   .get("http://jsonplaceholder.typicode.com/photos/1 ")
		   .then()
                 .extract().response();
		
		return response;
	}
	
	public Response getDetailedCookies() {
		
		Response href1 =
				
		RestAssured.given()
		 .when()
		   .get("http://jsonplaceholder.typicode.com/photos/")
		
		.then()
		.extract().response();
		
		return href1;
		  
//	  Cookie a = href1.getDetailedCookie("__cfduid");
//	  System.out.println(a.getValue());
//	  System.out.println(a.getVersion());
//	  System.out.println(a.hasExpiryDate());
//	  System.out.println(a.hasValue());
	  
	}
	
	public Response getCookies() {
		
		Response href1 =
				
		RestAssured.given()
		 .when()
		   .get("http://jsonplaceholder.typicode.com/photos/")
		 .then()
		 .extract().response();
		
		return href1;
		  
//		Map<String, String> cookies = href1.getCookies();
//		
//		for (Map.Entry<String, String> entry: cookies.entrySet()) {
//			System.out.println(entry.getKey() + "   " + entry.getValue());
			
		}
	
	public Response getHeaders() {
		
		Response href1 =
				
		RestAssured.given()
		 .when()
		   .get("http://jsonplaceholder.typicode.com/photos/")
		
		.then()
		.extract().response();
		
		return href1;
		  
//		Headers header = href1.getHeaders();
//		for (Header h:header) {
//			
//			System.out.println(h.getName()+ "   " + h.getValue());
	
		
		}
		
		public String getList() {
			
			String href1 =
					
			RestAssured.given()
			 .when()
			   .get("http://jsonplaceholder.typicode.com/photos/")
			   .then()
			    .extract()
			    .asString();
			
			return href1;
			
//			JsonPath jpath = new JsonPath(href1);			
//			List<String> ls = jpath.get("name");
//			System.out.println("size is " + ls.size());


		}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	

