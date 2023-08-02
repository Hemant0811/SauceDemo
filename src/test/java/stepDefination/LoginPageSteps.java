package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginPageSteps {

	LoginPage login = new LoginPage();

	@Given("user enter {string} and {string}")
	public void user_enter_and(String uname, String pass) {
		login.user_enter_username_and_password(uname, pass);
	}

	@Given("user click on login button")
	public void user_click_on_login_button() {
		login.user_click_on_login_button();

	}

	@Then("validate user logged in succesfully")
	public void validate_user_logged_in_succesfully() {
		login.validate_user_logged_in_succesfully();
	}
	

}
