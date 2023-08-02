package pages;

import org.openqa.selenium.By;
import helper.Base;

public class LoginPage extends Base {

	public By username = By.cssSelector("input#user-name");
	public By password = By.cssSelector("input#password");
	public By loginbtn = By.cssSelector("input#login-button");

	public void user_enter_username_and_password(String uname, String pass) {
		waitForExpectedElement(username).sendKeys(uname);
		waitForExpectedElement(password).sendKeys(pass);
	}

	public void user_click_on_login_button() {
		waitForExpectedElement(loginbtn).click();

	}

	public void validate_user_logged_in_succesfully() {  
		System.out.println("Validation");
	}

}
