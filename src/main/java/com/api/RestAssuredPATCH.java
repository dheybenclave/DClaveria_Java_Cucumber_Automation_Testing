package com.api;

import static com.utils.BaseClass.logger;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import org.json.JSONObject;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class RestAssuredPATCH extends RestAssuredExtension {

	public ResponseOptions<Response> PatchWithBodyParams(String url, JSONObject requestPathParams) {

		logger.debug("PatchWithBodyParams : " + url + ": JSONObject : " + requestPathParams);

		try {
			response = requestSpec.get(new URI(url));
			requestSpec.body(requestPathParams.toString());
			response = requestSpec.patch(url);
		} catch (URISyntaxException e) {
			logger.debug("URISyntaxException : " + e);
			e.printStackTrace();
			response = null;
		}
		return response;
	}

	public ResponseOptions<Response> PatchWithBodyParams(String url, LinkedHashMap<String, Object> bodyPathParams) {
		
		logger.debug("PatchWithBodyParams : " + url + ": LinkedHashMap : " + bodyPathParams);
		
		requestSpec.body(bodyPathParams);
		response = requestSpec.patch(url);
	
		return response;
		
	
	}
}
