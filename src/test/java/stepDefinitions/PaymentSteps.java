package stepDefinitions;

import io.cucumber.java.en.*;
import pages.PaymentPage;
import utils.ScenarioContext;

public class PaymentSteps {
    PaymentPage paymentPage = new PaymentPage();
    private ScenarioContext scenarioContext;

    public PaymentSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @When("I enter {string} to field {string} on payment form")
    public void inputField(String value, String fieldName) {
        paymentPage.inputField(fieldName, value);
        scenarioContext.set(fieldName.toUpperCase(), value);
    }

    @When("I click Review Order button")
    public void reviewOrder() {
        paymentPage.reviewOrder();
    }
}
