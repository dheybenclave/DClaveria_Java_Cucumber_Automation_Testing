package stepdefinitions.api;

import static com.utils.BaseClass.logger;
import static com.utils.BaseClass.restAssuredGET;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;

public class BasedAPI {
	
	public ResponseBody<?> getBody;
	public ResponseOptions<Response> responseOptions;
	public  String URL, ID, userName, password;
	HashMap<String, String> setJSON;
	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String _password) {
		password = _password;
	}


	public BasedAPI() {
		
	}

	public ResponseOptions<Response> setUpResponseBody(String apiPerform , String url) {
		
		logger.debug("Set Up Response Body URL:" + url);
		setURL(url);
		responseOptions = restAssuredGET.GetOps(url);
		return responseOptions;
	}
	
}
