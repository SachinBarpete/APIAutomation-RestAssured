package com.bridgelabz.rest.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Sachin Barpete
 * @purpose Implemented test case for Put call
 * @date 26/12/2019
 */
public class PutCallTest {

	@Test
	public void putTest() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();

		json.put("title", "Selenium - webdriver");
		json.put("author", "Sachin Barpete");
		request.body(json.toJSONString());
		Response response = request.put("http://localhost:3000/posts/21");
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
