package com.bridgelabz.rest.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @author Sachin Barpete
 * @purpose Get call implementation
 * @date 25/12/2019
 */
public class GetCallTest {

	@Test
	public void getTest() {
		Response response = RestAssured.get("http://localhost:3000/posts/");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void getBodyTest() {
		Response response = RestAssured.get("http://localhost:3000/posts/");
		System.out.println("Json Body : " + response.asString());
		System.out.println("Response Time : " + response.getTime());

	}
}
