package com.api;

import static com.utils.BaseClass.logger;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class RestAssuredGET extends RestAssuredExtension {
	
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
	
	public Response GETOpsWithPathParams(String url, Map<String, String> params) {
		logger.debug("GETOpsWithPathParams : " + params);

		for (Map.Entry<String, String> _pr : params.entrySet()) {		
			requestSpec.queryParam(_pr.getKey(), _pr.getValue());
		}

		// Actions,
		response = requestSpec.get(url);
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
	
	public ResponseOptions<Response> GETOpsWithQueryParams(String url, Map<String, String> params){
		logger.debug("GETOpsWithQueryParams : " + params);

		// Actions,
		requestSpec.queryParams(params);
		try {
			response = requestSpec.get(new URI(url));
		} catch (URISyntaxException e) {
			logger.debug("URISyntaxException : " + e);
			e.printStackTrace();
			response = null;
		}
		return response;
	}
	
	public ResponseOptions<Response> GETOpsWithQueryParam(String url, String paramsName, String paramsValue){
		logger.debug("GETOpsWithQueryParams | Params Name :" + paramsName + " Params Name :" + paramsValue);

		// Actions,	
		requestSpec.queryParam(paramsName, paramsValue);
		try {
			response = requestSpec.get(new URI(url));
		} catch (URISyntaxException e) {
			logger.debug("URISyntaxException : " + e);
			e.printStackTrace();
			response = null;
		}
		return response;
	}
	
}
