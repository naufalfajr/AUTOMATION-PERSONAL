package stepDefinitions;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Then;
import pages.CompleteOrderPage;

public class CompleteOrderSteps {
    CompleteOrderPage completeOrderPage = new CompleteOrderPage();

    @Then("Verify Order Complete page message is {string}")
    public void verifyOrderComplete(String messsage) {
        assertTrue("complete page message is correct", completeOrderPage.getOrderConfirmationMessage().contains(messsage));
    }

    @Then("I click continue shopping button")
    public void continueShopping() {
        completeOrderPage.continueShopping();
    }
}
