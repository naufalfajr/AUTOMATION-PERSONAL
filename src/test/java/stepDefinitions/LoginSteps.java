package stepDefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("the app is launched")
    public void theAppIsLaunched() {
        // App launch handled by Hooks
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I tap on login button")
    public void iTapOnLoginButton() {
        loginPage.tapLoginButton();
    }

    @Then("I should see the home screen")
    public void iShouldSeeTheHomeScreen() {
        assertTrue("Home screen was not displayed!", loginPage.isHomeScreenDisplayed());
    }
}
