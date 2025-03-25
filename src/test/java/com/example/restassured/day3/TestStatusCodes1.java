package com.example.restassured.day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestStatusCodes1 {	
	
	
	@Test
	public void validateBadRequestResponse() {
		
		String jsonPayload = "{\"name\": \"NiyaTest\",\r\n"
				+ "        \"age\": abc,\r\n"
				+ "        \"mobile\": \"niyanshika\",\r\n"
				+ "        \"email\": \"Niya@gmail.com\",\r\n"
				+ "        \"salary\": 68300.0}";
		
		
		        given()
		            .contentType(ContentType.JSON)
				    .body(jsonPayload) 
				.when()
				    .post("http://localhost:8071/saveEmployee") 
				.then()
				    .statusCode(400)
				    .body("mobile", containsString("niyanshika")); 
																				
	}

	@Test
	void testStatusCode() {	
		
		given()
		  .contentType("application/json")
		.when()
		    .get("http://localhost:8071/findAllEmployees")
		.then()
		   .statusCode(200)		   
		   .log().all();
		
	}	
	
	@Test
    public void testCreateEmployeeReturns201NoContent() {
        
        given()
            .queryParam("id", "100") 
        .when()
            .get("http://localhost:8071/findEmployeebyID") 
        .then()
            .assertThat()
            .statusCode(204);
             
    }
}
			

	


