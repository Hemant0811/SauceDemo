package stepDefination;

import io.cucumber.java.en.Given;
import pages.Logoutpage;

public class LogoutPageSteps {
	
	Logoutpage logout = new Logoutpage();
	
	@Given("user click on three dot option")
	public void user_click_on_three_dot_option() {
	   logout.clickonThreeDots();
	}
	@Given("user click on logout button")
	public void user_click_on_logout_button() {
	    logout.clickonlogoutbutton();
	}

	@Given("verify logout sucessfully")
	public void verify_logout_sucessfully() {
	   logout.verifylogout();
	}

}
