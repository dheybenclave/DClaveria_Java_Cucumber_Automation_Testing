package stepdefinitions.api;

import static com.utils.BaseClass.logger;
import static com.utils.BaseClass.restAssuredGET;

import io.cucumber.java.en.Given;

public class CommonSteps extends BasedAPI {

	@Given("I perform {string} operation for {string}")
	public void i_perform_operation_for(String apiPerform, String url) {
		logger.debug("i_perform_operation_for :" + apiPerform +" | URL:" + url);
		
		responseOptions = setUpResponseBody(apiPerform,url);
	}

}
