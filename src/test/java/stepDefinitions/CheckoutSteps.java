package stepDefinitions;

import io.cucumber.java.en.When;
import pages.CheckoutPage;
import utils.ScenarioContext;

public class CheckoutSteps {
    CheckoutPage checkoutPage = new CheckoutPage();
    private ScenarioContext scenarioContext;

    public CheckoutSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @When("I enter {string} to field {string} on shipping address form")
    public void inputField(String value, String fieldName) {
        checkoutPage.inputField(fieldName, value);
        scenarioContext.set(fieldName.toUpperCase(), value);
    }

    @When("I click to Payment button")
    public void toPayment() {
        checkoutPage.toPayment();
    }
}
