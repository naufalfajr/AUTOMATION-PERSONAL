package stepDefinitions;

import static org.junit.Assert.*;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import utils.ScenarioContext;

public class CartSteps {
    CartPage cartPage = new CartPage();
    private ScenarioContext scenarioContext;

    public CartSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("Verify product {string} with quantity {int} is added to cart")
    public void verifyProductInCart(String productName, int qty) {
        assertEquals("is Product name matched", productName, cartPage.getProductName());
        assertEquals("is Product quantity matched", String.valueOf(qty)+" Items", cartPage.getTotalItems());
        scenarioContext.set("TOTAL_ITEMS", cartPage.getTotalItems());
        assertEquals("is Product price matched", scenarioContext.get("PRODUCT_PRICE_CURR"), cartPage.getProductPriceCurr());
    }

    @Then("Verify total price is correct on the cart")
    public void verifyTotalPrice() {
        Double expectedTotal = cartPage.getProductPrice()*cartPage.getTotalItemsInt();
        scenarioContext.set("PRODUCT_PRICE", cartPage.getProductPrice());
        scenarioContext.set("TOTAL_PRICE", expectedTotal);
        assertEquals("is Product price correct", expectedTotal, cartPage.getTotalAmount());
    }

    @Then("Verify product color is displayed")
    public void verifyProductColor() {
        assertTrue("is Product color displayed", cartPage.isColorDisplayed());
    }

    @When("I proceed to checkout")
    public void proceedToCheckout() {
        cartPage.proceedToCheckout();
    }
}
