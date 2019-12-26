package com.bridgelabz.rest.oauthtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @author Sachin Barpete
 * @purpose accessing API using OAuth2.0
 * @date 26/12/2019
 */
public class OAuth2Test {

	public String generateToken() {

		Response response = RestAssured.given().formParam("client_id", "RestAssuredOauth2.0")
				.formParam("client_secret", "cafb4d143c341db0203ead66d0244e8c")
				.formParam("grant_type", "client_credentials").post("http://coop.apps.symfonycasts.com/token");
		return response.jsonPath().get("access_token");
	}

	@Test(priority = 1)
	public void accessValidAPI() {
		Response response = RestAssured.given().auth().oauth2(generateToken())
				.post("http://coop.apps.symfonycasts.com/api/643/chickens-feed");
		System.out.println("Response code : " + response.getStatusCode());
		System.out.println("Json Response : " + response.getBody().jsonPath().prettify());
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2)
	public void accessInvalidAPI() {
		Response response = RestAssured.given().auth().oauth2(generateToken())
				.post("http://coop.apps.symfonycasts.com/api/643/eggs-collect");
		System.out.println("Response code : " + response.getStatusCode());
		System.out.println("Json Response : " + response.getBody().jsonPath().prettify());
		Assert.assertEquals(response.getStatusCode(), 401);

	}
}
