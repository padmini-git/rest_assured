package com.example.restassured.day3;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.Iterator;
import java.util.Map;

public class CookiesDemo {
	
	
	@Test	
	void testCookies() {
		
		given()		
		
		.when()
		   .get("http://localhost:8071/findAllEmployees")		
		
		.then()
		  .cookie("AEC", "AVYB7cp6DLDtAjTLyT8ISiqc7SxmZF4sSUnUY7bIK_UBxb7LFtngHVRvbSM")
		  .log().all();

		
	}
	
	@Test	
	void getCookiiesInfo() {
		
		Response res=given()		
		
		.when()
		   .get("http://localhost:8071/findAllEmployees");		
		
		//String cookie_value=res.getCookie("AEC");
		//System.out.println("value of cookie is====>"+cookie_value);		
      
		Map<String,String>cookies_values=res.getCookies();
		//System.out.println(cookies_values.keySet());
		
		for(String k:cookies_values.keySet()) {
			String cookie_value=res.getCookie(k);
			System.out.println(k+"               "+cookie_value);
			
		}
		
	}

}
 