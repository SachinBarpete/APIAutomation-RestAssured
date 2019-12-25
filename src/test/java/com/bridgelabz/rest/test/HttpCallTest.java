package com.bridgelabz.rest.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class HttpCallTest {

	@Test
	public void test() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("id", 20);
		json.put("title", "Selenium - webdriver");
		json.put("author", "Sachin");
		request.body(json.toJSONString());

	}
}
