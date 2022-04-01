package com.api;

import static com.utils.BaseClass.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class RestAssuredDELETE extends RestAssuredExtension {
	
	String regexNoSpeChar = "[^a-zA-Z0-9]";
	public ResponseOptions<Response> DeleteWithBodyParams(String url, Object requestPathParams) {

		logger.debug("DeleteWithBodyParams : " + url + ": Object : " + requestPathParams);

		try {
			response = requestSpec.get(new URI(url));
			requestSpec.body(requestPathParams.toString());
			response = requestSpec.delete(url);
		} catch (URISyntaxException e) {
			logger.debug("URISyntaxException : " + e);
			e.printStackTrace();
			response = null;
		}
		return response;
	}

	public ResponseOptions<Response> DeleteWithBodyParams(String url, String paramName, String paramValue) {
		logger.debug("DeleteWithBodyParams : " + url + " |  ParamName  : " + paramName + "| ParamValue: " + paramValue);
		
		LinkedHashMap<String, String> pathParams = new LinkedHashMap<>();
	
		pathParams.put(paramName, paramValue.replaceAll(regexNoSpeChar, ""));
		logger.debug(pathParams+ "pathParams");
		
//		ResponseOptions<Response> setJSONdata = restAssuredGET.GETOpsWithQueryParam(url, paramName, paramValue);
		
		requestSpec.pathParams(pathParams);
		response = requestSpec.delete(url);
	
		return response;
	}
	
	public ResponseOptions<Response> DeleteWithBodyParams(String url, LinkedHashMap<String, String> bodyPathParams) {
		logger.debug("DeleteWithBodyParams : " + url + " |  Body Path Params  : "+ bodyPathParams);

		requestSpec.pathParams(bodyPathParams);
		response = requestSpec.delete(url);
	
		return response;
	}
	
}
