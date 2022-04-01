package com.api;

import static com.utils.BaseClass.logger;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import org.json.JSONObject;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class RestAssuredPOST extends RestAssuredExtension {

	public ResponseOptions<Response> PostWithBodyParams(String url, JSONObject requestPathParams) {

		logger.debug("PostWithBodyParams : " + url + ": JSONObject : " + requestPathParams);

		try {
			response = requestSpec.get(new URI(url));
			requestSpec.body(requestPathParams.toString());
			response = requestSpec.post(url);
		} catch (URISyntaxException e) {
			logger.debug("URISyntaxException : " + e);
			e.printStackTrace();
			response = null;
		}
		return response;
	}

	public ResponseOptions<Response> PostWithBodyParams(String url, LinkedHashMap<String, Object> bodyContent) {
		logger.debug("PostWithBodyParams : " + url + ": LinkedHashMap : " + bodyContent);

		try {
			response = requestSpec.get(new URI(url));
			requestSpec.body(bodyContent);
			response = requestSpec.post(url);
		} catch (URISyntaxException e) {
			logger.debug("URISyntaxException : " + e);
			e.printStackTrace();
			response = null;
		}
		return response;
	}
}
