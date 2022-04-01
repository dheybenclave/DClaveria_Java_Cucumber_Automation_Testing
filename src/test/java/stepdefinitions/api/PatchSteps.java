package stepdefinitions.api;

import static com.utils.BaseClass.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import static com.utils.Utils.*;

@SuppressWarnings("deprecation")
public class PatchSteps extends BasedAPI {
	String patchURL, patchRandBody;

	@Given("I perform PATCH operation for {string}")
	public void i_perform_operation_for(String url) {
		logger.debug("i_perform_operation_for :" + url);

		responseOptions = setUpResponseBody("PATCH", url);
	}

	@When("user perform a PATCH operation with body")
	public void user_perform_a_patch_operation_with_body(DataTable dataTable) {
		logger.debug("user_perform_a_post_operation_with_body_for_delete_operation : " + dataTable);

		List<Map<String, Object>> patchUserList = dataTable.asMaps(String.class, Object.class);
		LinkedHashMap<String, Object> requestPathParams = new LinkedHashMap<String, Object>();

		for (Map<String, Object> e : patchUserList) {
			logger.debug("patchUserList | id: " + e.get("id") + " body: " + e.get("body") + " postId: " + e.get("postId"));
			
			requestPathParams.put("id", e.get("id"));
			patchRandBody = randomString(5);

			requestPathParams.put("id", e.get("id"));
			requestPathParams.put("body", e.get("body") + patchRandBody);
			requestPathParams.put("postId", e.get("postId"));
			patchURL = getURL() + "/" + e.get("id").toString();
			setID(e.get("id").toString());
			responseOptions = restAssuredPATCH.PatchWithBodyParams(patchURL, requestPathParams);
		}
	}


	@Then("I will see the created patch data with body {string}")
	public void i_will_see_the_created_patch_data_with_body(String bodyValueContent) {
		logger.debug("i_will_see_the_created_patch_data_with_body : " + bodyValueContent);

		responseOptions = restAssuredGET.GETOpsWithQueryParam(patchURL, "id", getID());

		logger.debug("Actual : " + responseOptions.getBody().jsonPath().get("body") + " Expected : " + bodyValueContent);
		assertThat(responseOptions.getBody().jsonPath().get("body"), is(bodyValueContent + patchRandBody));

	}
}
