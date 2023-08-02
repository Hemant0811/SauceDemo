package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import helper.Base;

public class Logoutpage extends Base {

	public By Threedots = By.cssSelector("button#react-burger-menu-btn");
	public By logout = By.cssSelector("a#logout_sidebar_link");
	public By loginpage = By.cssSelector("div.login_wrapper");

	public void clickonThreeDots() {
		waitForExpectedElement(Threedots).click();
	}

	public void clickonlogoutbutton() {
		waitForExpectedElement(logout).click();
	}

	public void verifylogout() {
		boolean pagelogin = waitForExpectedElement(loginpage).isDisplayed();
		assertTrue(pagelogin);
	}

}
