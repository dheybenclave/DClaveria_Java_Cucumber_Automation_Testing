package stepdefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.apache.log4j.Logger;
import com.utils.ConstantsURL;

@SuppressWarnings("static-access")
public class GetPostSteps {

	Logger logger = Logger.getLogger("GetPostSteps");
	private static ConstantsURL url;
	private static String BASE_URL = url.JSON_API_LOCALHOST.getURL();
	private static Response request;

	@Given("I perform GET operation for \"([^\"]*)\"$")
	public void i_perform_get_operation_for(String url) {
		given().contentType(ContentType.JSON);
	}

	@When("I perform GET for the post number \"([^\"]*)\"$")
	public void i_perform_get_for_the_post_number(String dataNumber) {
		String url_posts = BASE_URL + "/posts?id=" + dataNumber;
		request = when().get(url_posts);
	}

	@Then("I should see the author name as \"([^\"]*)\"$")
	public void i_should_see_the_author_name_as(String author) {
		request.then().body("author", contains(author));
	}

}
