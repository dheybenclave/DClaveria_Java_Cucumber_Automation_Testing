package com.api;

import static com.utils.BaseClass.logger;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import com.utils.ConstantsURL;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
public class RestAssuredExtension {

	private String BASE_URL = ConstantsURL.JSON_API_LOCALHOST.getURL();
	private static RequestSpecification requestSpec;
	private static Response response;
	public  static Response  getCurrentURL;

	public RestAssuredExtension() {

		// Arrange
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(BASE_URL);
		builder.setContentType(ContentType.JSON);

		requestSpec = RestAssured.given().spec(builder.build());
	}
	

	public static Response GETOpsWithPathParams(String url, Map<String, String> params) {
		logger.debug("GETOpsWithPathParams : " + params);

		for (Map.Entry<String, String> _pr : params.entrySet()) {		
			requestSpec.queryParam(_pr.getKey(), _pr.getValue());
		}
		logger.debug(requestSpec.get().asPrettyString()+ "asdasdasd");

		// Actions,
		response = requestSpec.get(url);
		logger.debug(response.getBody().asPrettyString()+ "asdasdasd");
		return response;
	}

	public ResponseOptions<Response> GETOpsWithPathParam(String url, String param) {
		logger.debug("GETOpsWithPathParams : " + param);
		
	
		// Actions,
		requestSpec.pathParam(url, param);
		try {
			response = requestSpec.get(new URI(url));
		} catch (URISyntaxException e) {
			logger.debug("URISyntaxException : " + e);
			e.printStackTrace();
			response = null;
		}
		return response;
	}

	public ResponseOptions<Response> GetOps(String url) {
		logger.debug("GetOps : " + url);
		// Actions,
		try {
			response = requestSpec.get(new URI(url));
		} catch (URISyntaxException e) {
			logger.debug("URISyntaxException : " + e);
			e.printStackTrace();
			response = null;
		}
		getCurrentURL = response;
		return response;
	}
	
	
}
