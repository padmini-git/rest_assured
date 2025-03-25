package io.cucumber.java.en;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Given {

	@Test
	public void testFindAllEmployees() {

		RestAssured.baseURI = "http://localhost:8071";

		Response response = RestAssured
				.given()
				   .param("status", "active")
				   //.header("Authorization", "Bearer <token>")
				   .cookie("session_id", "1234")
				.when()
				   .get("/findAllEmployees");				   
		        response.then()
		          .statusCode(200)
		          .body("size()", greaterThan(0))
		          .body("employees[0].name", equalTo("Ajay"))
		          .log().all();

		// String employeeName = response.jsonPath().getString("employees[0].name");
		// assertThat(employeeName, equalTo("Ajay"));

		// System.out.println("Response: " + response.asString());
	}
}
