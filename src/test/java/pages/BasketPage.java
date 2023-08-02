package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import helper.Base;

public class BasketPage extends Base {

	public By addtoCartBtn = By.cssSelector("button#add-to-cart-sauce-labs-backpack");
	public By basketCount = By.cssSelector("a.shopping_cart_link");
	public By basketIcon = By.cssSelector("a.shopping_cart_link");
	public By verifyname = By.cssSelector("div.inventory_item_name");
	public By verifyprice = By.cssSelector("div.inventory_item_price");
	public By checkoutBtn = By.cssSelector("button#checkout");

	public void user_add_product_into_the_basket_from_plp_page() {

		waitForExpectedElement(addtoCartBtn).click();
	}

	public void validateBasketCount() {

		String actualCount = waitForExpectedElement(basketCount).getText();
		assertEquals("1", actualCount);

		waitForExpectedElement(basketIcon).click();
	}

	public void verifyproductnameandprice() {

		String productname = waitForExpectedElement(verifyname).getText();
		assertEquals("Sauce Labs Backpack", productname);

		String productprice = waitForExpectedElement(verifyprice).getText();
		assertEquals("$29.99", productprice);
	}

	public void clickonCheckoutButton() {

		waitForExpectedElement(checkoutBtn).click();

	}
}
