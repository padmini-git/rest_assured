package com.example.restassured.day3;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestStatusCodes {
	@Test
    public void testResponseTime() {
        given()
            .queryParam("id", "10")
        .when()
            .get("http://localhost:8071/findEmployeebyID")
        .then()
            .statusCode(200)
            .time(lessThan(2000L)); 
    }
	
	@Test
    public void testMissingID() {
        given()
            .queryParam("id", "") 
        .when()
            .get("http://localhost:8071/findEmployeebyID")
        .then()
            .statusCode(400); 
	
}
	
	@Test
    public void testEmployeeDetails() {
        given()
            .queryParam("id", "21")
        .when()
            .get("http://localhost:8071/findEmployeebyID")
        .then()
            .statusCode(200) 
            .body("name", equalTo("Lokesh")) 
            .body("id", equalTo(21)) 
            .body("age", equalTo(30)); 
    }
}
	

	    


	

