package com.api;

import static com.utils.BaseClass.logger;
import static com.utils.BaseClass.restAssuredGET;

import com.utils.ConstantsURL;

import io.restassured.response.*;
import io.restassured.specification.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class RestAssuredExtension {

	String BASE_URL = ConstantsURL.JSON_API_LOCALHOST.getURL();
	RequestSpecification requestSpec;
	Response response;

	public static Response getCurrentURL;

	public RestAssuredExtension() {

		// Arrange
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(BASE_URL);
		builder.setContentType(ContentType.JSON);

		requestSpec = RestAssured.given().spec(builder.build());
		

	}
	
	
}

