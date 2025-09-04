package stepDefinitions;

import io.cucumber.java.en.*;
import pages.CatalogPage;
import utils.ScenarioContext;

public class CatalogSteps {
    CatalogPage catalogPage = new CatalogPage();
    private ScenarioContext scenarioContext;

    public CatalogSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("I navigate to {string} menu")
    public void navigateToMenu(String menu) {
        catalogPage.goToMenu(menu);
    }

    @When("I select the product {string}")
    public void selectProduct(String productName) {
        scenarioContext.set("PRODUCT_NAME", productName);
        catalogPage.selectProduct(productName);
    }
}
