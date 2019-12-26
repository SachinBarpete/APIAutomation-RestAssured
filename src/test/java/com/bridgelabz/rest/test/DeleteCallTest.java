package com.bridgelabz.rest.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Sachin Barpete
 * @purpose Implemented test case for Delete call
 * @date 26/12/2019
 */
public class DeleteCallTest {

	@Test
	public void testDelete() {
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("http://localhost:3000/posts/21");
		Assert.assertEquals(response.getStatusCode(), 200);

	}
}
