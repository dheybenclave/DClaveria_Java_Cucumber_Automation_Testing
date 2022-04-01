package stepdefinitions.api;

import static com.utils.BaseClass.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

@SuppressWarnings("deprecation")
public class DeleteSteps extends BasedAPI {
	
	@Given("I perform DELETE operation for {string}")
	public void i_perform_operation_for( String url) {
		logger.debug("i_perform_operation_for :" + url);
		
		responseOptions = setUpResponseBody("PATCH", url);
	}
	
	@When("user perform a post operation with body for delete operation")
	public void user_perform_a_post_operation_with_body_for_delete_operation(DataTable dataTable) {

		logger.debug("user_perform_a_post_operation_with_body_for_delete_operation : " + dataTable);
		
		List<Map<String, Object>> postUserList = dataTable.asMaps(String.class, Object.class);

		int userCredsCount = responseOptions.getBody().jsonPath().getList("username").size();
		
//		JSONObject requestParams = new JSONObject();
		LinkedHashMap<String, Object> requestPathParams = new LinkedHashMap<String, Object>();

		for (Map<String, Object> e : postUserList) {
			userCredsCount++;
			logger.debug("postUserList | username: " + e.get("username") + " password: " + e.get("password") + " titlePage: " + e.get("titlePage"));
			requestPathParams.put("id", userCredsCount);
			requestPathParams.put("username", e.get("username"));
			requestPathParams.put("password", e.get("password"));	
			responseOptions = restAssuredPOST.PostWithBodyParams(getURL(), requestPathParams);
		}
	}

	@When("I will see the created data with username {string}")
	public void i_will_see_the_created_data_with_username(String username) {
		logger.debug("i_will_see_the_created_data_with_username : " + username);

		setUserName(username);
		responseOptions = restAssuredGET.GetOps(getURL());
		assertThat(responseOptions.getBody().jsonPath().get("username"), hasItem(username));
	}

	@Then("I will delete the posted data for {string}")
	public void i_will_delete_the_posted_data_in_user_credentials(String urlDeletion) {
		
		logger.debug("i_will_delete_the_posted_data_in_user_credentials : " + urlDeletion);
		
		responseOptions = restAssuredGET.GETOpsWithQueryParam(getURL(), "username", getUserName());
		String getBodyID = responseOptions.getBody().jsonPath().getString("id");
		
		responseOptions = restAssuredDELETE.DeleteWithBodyParams(urlDeletion, "id", getBodyID);
	}

	@Then("Verify that the created data is no longer available")
	public void verify_that_the_created_data_is_no_longer_available() {
		logger.debug("verify_that_the_created_data_is_no_longer_available : " );
		
		responseOptions = restAssuredGET.GETOpsWithQueryParam(getURL(), "username", getUserName());
		assertThat(responseOptions.getBody().jsonPath().get("username"), is(not(contains(getUserName()))));

	}
}
