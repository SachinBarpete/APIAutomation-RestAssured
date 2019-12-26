package com.bridgelabz.rest.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Sachin Barpete
 * @purpose Authentication test for APIs
 * @date 26/12/2019
 */
public class AuthenticationTest {

	@Test(priority = 1)
	public void authenticationTest() {
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RequestSpecification request = RestAssured.given();

		Response response = request.get();
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("Status message " + response.body().asString());
	}

	@Test(priority = 2)
	public void authenticationTestWithCredentials() {
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RequestSpecification request = RestAssured.given().auth().preemptive().basic("ToolsQA", "TestPassword");

		Response response = request.get();
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("Status message " + response.body().asString());
	}
}