package com.bridgelabz.rest.oauthtest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author Sachin Barpete
 * @purpose Accessing api using OAuth1.0
 * @date 26/12/2019
 */
public class TwitterAPI {

	@Test
	public void postTweet() {
		Response response = RestAssured.given().auth()
				.oauth("API Key", "API Secret Key", "Access Token", "Access Token Secret")
				.post("https://api.twitter.com/1.1/statuses/update.json?status=This is my tweet via API");
		System.out.println("Status code : " + response.getStatusCode());
		System.out.println("Json Response : " + response.getBody().jsonPath().prettify());

		JsonPath jsonPath = response.jsonPath();
		System.out.println("Tweet Id is : " + jsonPath.get("id_str"));
	}

}
