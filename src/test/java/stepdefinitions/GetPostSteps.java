package stepdefinitions;

import static com.utils.BaseClass.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import io.restassured.response.*;
import io.cucumber.java.en.*;

import com.api.RestAssuredExtension;


@SuppressWarnings("deprecation")
public class GetPostSteps {

	private Response request;
	private ResponseBody<?> getBody;
	private ResponseOptions<Response> restponseOptions;
	private String getURL;
	
	
	@Given("I perform GET operation for \"([^\"]*)\"$")
	public void i_perform_get_operation_for(String url) {
		getURL = url;
		logger.debug("i_perform_get_operation_for" + url);
		restponseOptions = restAssuredExtension.GetOps(url);
		logger.info(restponseOptions.getBody().asPrettyString());
	}

	@When("I perform GET for the post number \"([^\"]*)\"$")
	public void i_perform_get_for_the_post_number(String dataNumber) {
//		String url_posts = BASE_URL + "/posts?id=" + dataNumber;
		logger.debug("i_perform_get_for_the_post_number" + dataNumber);
		
		HashMap<String, String> setJSON = new HashMap<String, String>();
		setJSON.put("id", dataNumber);

		restponseOptions = RestAssuredExtension.GETOpsWithPathParams(getURL, setJSON);
//		when().get(String.format(BASE_URL + "%s", dataNumber));
		logger.debug("request body : \n " + restponseOptions.getBody().asPrettyString());
			
	}


	@When("I perform GET for the id number {int}")
	public void i_perform_get_for_the_id_number(Integer idNumber) {
		logger.debug("i_perform_get_for_the_id_number : " + idNumber);

//		restponseOptions = with().pathParams("usercreds", idNumber).when().get(BASE_URL + "/{usercreds}");

		HashMap<String, String> setJSON = new HashMap<String, String>();
		setJSON.put("id", idNumber.toString());

		restponseOptions = RestAssuredExtension.GETOpsWithPathParams(getURL, setJSON);
		logger.debug("request body : \n" + restponseOptions.getBody().asPrettyString());
	}

	@When("I perform GET using parameter id number {int}")
	public void i_perform_get_using_parameter_id_number(Integer idNumber) {
		
		logger.debug("i_perform_get_using_parameter_id_number : " + idNumber);

//		restponseOptions = with().queryParam("id", idNumber).when().get(BASE_URL + "/");
		HashMap<String, String> setJSON = new HashMap<String, String>();
		setJSON.put("id", idNumber.toString());

		restponseOptions = RestAssuredExtension.GETOpsWithPathParams(getURL, setJSON);
		logger.debug("request body : \n" + restponseOptions.getBody().asPrettyString());
		

	}


	@Then("I should see the comment body is {string}")
	public void i_should_see_the_comment_body_is(String commentBody) {

		logger.debug("i_should_see_the_comment_body_is : " + commentBody);

//		request.then().log().all().assertThat().body("body", contains(commentBody));
		
		assertThat(restponseOptions.getBody().jsonPath().get("body"), hasItem(commentBody));
		
	}

	@Then("I should see the username is {string} and password is {string}")
	public void i_should_see_the_username_is_and_password_is(String username, String password) {

		logger.debug("i_should_see_the_username_is_and_password_is : " + username + " : " + password);

//		request.then().log().all()
//		.assertThat().body("username", is(username))
//		.assertThat().body("password", is(password));
		
		HashMap<String, String> setJSON = new HashMap<String, String>();
		setJSON.put("username", username);
		setJSON.put("password", password);
		
		for (Map.Entry<String, String> _pr : setJSON.entrySet()) {		
			assertThat(restponseOptions.getBody().jsonPath().get(_pr.getKey()), hasItem(_pr.getValue()));
		}
		getBody = restponseOptions.getBody();
		logger.debug(getBody);
	}
	
	@Then("I should see the author name as \"([^\"]*)\"$")
	public void i_should_see_the_author_name_as(String author) {
		
		logger.debug("geti_should_see_the_author_name_asBody : " + author);
		
//		request.then().log().all().body("author", is(author));
		getBody = restponseOptions.getBody();
		
		assertThat(restponseOptions.getBody().jsonPath().get("author"), hasItem(author));
		
		logger.debug("getBody : " + getBody);
		getBody.asString().contains(author);
		

	}
	
	

}
