package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import com.pages.LoginPage;
import com.pages.drivers.DriversFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import com.utils.ExcelReader;

public class LoginPageSteps {

	LoginPage loginPage = new LoginPage(DriversFactory.getWebDriver());
	Logger logger = loginPage.logger;
	
	private String getTitlePage;

	@Given("that the user should navigate in PEGA Login Page")
	public void that_the_user_should_navigate_in_pega_login_page() {
		loginPage.openApplication();
		loginPage.verifyPageApplication("Login Page");
	}

	@And("user verify the Login Page Elements is Visible")
	public void user_verify_the_login_page_elements_is_visible() {
		loginPage.verifyLoginPageElements();
	}
	
	@When("user login using valid credentials")
	public void user_login_using_valid_credentials(DataTable dataTable) {

		List<Map<String, String>> userList = dataTable.asMaps(String.class, String.class);
		logger.debug("List of User: " + userList);

		for (Map<String, String> e : userList) {
			System.out.println(e.get("username") + "e.get(\"username\")");
			loginPage.enterUserCredentails(e.get("username"), e.get("password"));
			getTitlePage = e.get("titlePage");
		}
	}

	@When("user login using valid credentials with username {string} and password {string}")
	public void user_login_using_valid_credentials_with_username_and_password(String username, String password) {
		loginPage.enterUserCredentails(username, password);
	}

	@Then("user should proceed to Dashboard Page")
	public void user_should_proceed_to_dashboard_page() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.verifyPageApplication(getTitlePage);

	}

	//INVALID LOGIN STEPS//////////////////////////////////////////////////////////
	
	@When("user login using invalid credentials form ExcelData with File {string} and SheetName {string}")
	public void user_login_using_invalid_credentials_form_excel_data_with_file_and_sheet_name(String exceFile, String sheetName) {

		ExcelReader reader = new ExcelReader();
		try {
			List<Map<String, String>> testData = reader.getData("./src/main/resources/TestData/" + exceFile + ".xlsx", sheetName);
			logger.debug(testData.toString());
			
			for (Map<String, String> e : testData) {
				loginPage.enterUserCredentails(e.get("username"), e.get("password"));
				loginPage.verifyErrorMessage("The information you entered was not recognized.", true);
				getTitlePage = "Login Page";
			}

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@When("user login using invalid credentials with username {string} and password {string}")
	public void user_login_using_invalid_credentials_with_username_and_password(String username, String password) {

		loginPage.enterUserCredentails(username, password);
		loginPage.verifyErrorMessage("The information you entered was not recognized.", true);

	}

	@Then("user should not proceed to Dashboard Page")
	public void user_should_not_proceed_to_dashboard_page() {
		loginPage.verifyPageApplication("Login Page");
		loginPage.verifyErrorMessage("The information you entered was not recognized.", true);
	}

	
	@Then("user gets login failed error message")
	public void user_gets_login_failed_error_message() {
		loginPage.verifyErrorMessage("The information you entered was not recognized.", true);

	}

}
