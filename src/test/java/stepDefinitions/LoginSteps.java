package stepDefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @When("I enter login credentials")
    public void enterLoginCredentials() {
        loginPage.tapToFillLoginFields();
    }

    @When("I click login button")
    public void clickLoginButton() {
        loginPage.login();
    }
}
