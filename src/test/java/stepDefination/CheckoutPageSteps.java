package stepDefination;

import java.io.IOException;

import io.cucumber.java.en.Given;
import pages.CheckoutPage;

public class CheckoutPageSteps {

	CheckoutPage checkout = new CheckoutPage();
	
	

	@Given("user enter information {string} {string} {string}")
	public void user_enter_information(String ftname, String ltname, String pscode) throws IOException {
		checkout.user_enter_information(ftname, ltname, pscode);
	}

	@Given("user place order with cash on delivery")
	public void user_place_order_with_cash_on_delivery() {
		checkout.userPlaceAnOrder();
	}

	@Given("validate order confirmation")
	public void validate_order_confirmation() {
		checkout.validateOrderConfirmation();
	}

	@Given("validate error message")
	public void validate_error_message() {
		checkout.validateerrormessage();
	}

}
