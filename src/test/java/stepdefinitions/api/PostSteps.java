package stepdefinitions.api;

import static com.utils.BaseClass.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import io.cucumber.java.en.*;

import io.cucumber.datatable.DataTable;

@SuppressWarnings("deprecation")
public class PostSteps extends BasedAPI {

	/// POST/////////////////////////////////////////////////////////////////////////////
	
	
	@Given("I perform POST operation for {string}")
	public void i_perform_operation_for( String url) {
		logger.debug("i_perform_operation_for :" + url);
		
		responseOptions = setUpResponseBody("PATCH", url);
	}
	
	@When("user perform a post operation with body for {string}")
	public void user_perform_a_post_operation_with_body_for(String url, DataTable dataTable) {

		logger.debug("user_perform_a_post_operation_with_body_for" + url + " : " + dataTable);

		List<Map<String, Object>> postUserList = dataTable.asMaps(String.class, Object.class);

		int userCredsCount = responseOptions.getBody().jsonPath().getList("username").size();

//			JSONObject requestParams = new JSONObject();
		LinkedHashMap<String, Object> requestPathParams = new LinkedHashMap<String, Object>();

		for (Map<String, Object> e : postUserList) {
			userCredsCount++;
			logger.debug("postUserList | username: " + e.get("username") + " password: " + e.get("password") + " titlePage: " + e.get("titlePage"));
			requestPathParams.put("id", userCredsCount);
			requestPathParams.put("username", e.get("username"));
			requestPathParams.put("password", e.get("password"));
			responseOptions = restAssuredPOST.PostWithBodyParams(url, requestPathParams);
		}

	}

	@Then("I will see the created post data with username {string}")
	public void i_will_see_the_created_post_data_with_username(String username) {

		logger.debug("i_will_see_the_created_post_data_with_username" + username);

		responseOptions = restAssuredGET.GetOps(getURL());
		assertThat(responseOptions.getBody().jsonPath().get("username"), hasItem(username));

	}

}
