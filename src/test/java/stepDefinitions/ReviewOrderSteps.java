package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.*;
import pages.ReviewOrderPage;
import utils.ScenarioContext;

public class ReviewOrderSteps {
    ReviewOrderPage reviewOrderPage = new ReviewOrderPage();
    private ScenarioContext scenarioContext;

    public ReviewOrderSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("Verify product image, name and price on review order page")
    public void verifyProduct() {
        assertTrue("Product image displayed", reviewOrderPage.isProductImageDisplayed());
        assertEquals("Product name correct", scenarioContext.get("PRODUCT_NAME"), reviewOrderPage.getProductName());
        assertEquals("Product price correct", scenarioContext.get("PRODUCT_PRICE_CURR"), reviewOrderPage.getProductPrice());
    }

    @Then("Verify Shipping Address")
    public void verifyShippingAddress() {
        assertEquals("Full name correct", scenarioContext.get("FULL NAME"), reviewOrderPage.getFieldData("Full Name"));
        assertEquals("Address Line 1 correct", scenarioContext.get("ADDRESS LINE 1"), reviewOrderPage.getFieldData("Address Line 1"));
        assertTrue("City correct", reviewOrderPage.getFieldData("City").contains(scenarioContext.get("CITY")));
        assertTrue("State correct", reviewOrderPage.getFieldData("City").contains(scenarioContext.get("STATE")));
        assertTrue("Country correct", reviewOrderPage.getFieldData("Country").contains(scenarioContext.get("COUNTRY")));
        assertTrue("ZIP correct", reviewOrderPage.getFieldData("Country").contains(scenarioContext.get("ZIP CODE")));
    }

    @Then("Verify Payment Data")
    public void verifyPaymentData() {
        assertEquals("Card Holder correct", scenarioContext.get("FULL NAME"), reviewOrderPage.getFieldData("Card Holder"));
        assertEquals("Card Number correct", scenarioContext.get("CARD NUMBER"), reviewOrderPage.getFieldData("Card Number").replace(" ", ""));
        assertEquals("Expiration Date correct", scenarioContext.get("EXPIRATION DATE"), reviewOrderPage.getFieldData("Expiration Date").replaceAll("[^\\d]", ""));
    }

    @Then("Verify final price")
    public void verifyFinalPrice() {
        Double expectedFinalPrice = (Double) scenarioContext.get("TOTAL_PRICE") + reviewOrderPage.getShipmentPrice();
        assertEquals("Final price correct", expectedFinalPrice, reviewOrderPage.getFinalPrice());
    }

    @When("I place the order")
    public void placeOrder() {
        reviewOrderPage.placeOrder();
    }
}
