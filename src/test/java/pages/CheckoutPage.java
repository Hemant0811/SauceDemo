package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import helper.Base;

public class CheckoutPage extends Base {

	public By firstname = By.cssSelector("input#first-name");
	public By lastname = By.cssSelector("input#last-name");
	public By postalcode = By.cssSelector("input#postal-code");
	public By continueBtn = By.cssSelector("input#continue");
	public By finishBtn = By.cssSelector("button#finish");
	public By sucessMessage = By.cssSelector("h2.complete-header");
	public By errormessage = By.cssSelector("[data-test='error']");

	public void user_enter_information(String ftname, String ltname, String pscode) throws IOException {
		waitForExpectedElement(firstname).sendKeys(ftname);
		waitForExpectedElement(lastname).sendKeys(ltname);
		waitForExpectedElement(postalcode).sendKeys(pscode);
		//takeScreenShot();

		waitForExpectedElement(continueBtn).click();
	}

	public void userPlaceAnOrder() {
		waitForExpectedElement(finishBtn).click();

	}

	public void validateOrderConfirmation() {
		String confirmationMessage = waitForExpectedElement(sucessMessage).getText();
		assertEquals("Thank you for your order!", confirmationMessage);

	}

	public void validateerrormessage() {
		boolean error = waitForExpectedElement(errormessage).isDisplayed();
		assertTrue(error);
	}

}
