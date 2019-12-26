package com.bridgelabz.rest.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

/**
 * @author Sachin Barpete
 * @purpose Implemented test case for Get call
 * @date 25/12/2019
 */
public class GetCallBDD {

	@Test
	public void testGetResponse() {

		given().when().get("http://localhost:3030/docs/#!/products/findProducts").then().assertThat().statusCode(200);
	}
}
