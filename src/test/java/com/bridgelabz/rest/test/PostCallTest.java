package com.bridgelabz.rest.test;

import java.util.Random;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Sachin Barpete
 * @purpose Implemented test case for Post call
 * @date 26/12/2019
 */
public class PostCallTest {

	@Test
	public void testPost() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		Random random = new Random();
		json.put("id", random.nextInt(1000));
		json.put("title", "Selenium - webdriver");
		json.put("author", "Sachin Barpete");
		request.body(json.toJSONString());
		Response response = request.post("http://localhost:3000/posts");
		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
