package stepDefinitions;

import io.cucumber.java.en.*;
import pages.CatalogPage;

public class CatalogSteps {
    CatalogPage catalogPage = new CatalogPage();
    
    @Given("I navigate to {string} menu")
    public void navigateToMenu(String menu) {
        catalogPage.goToMenu(menu);
    }

    @When("I select the product {string}")
    public void selectProduct(String productName) {
        catalogPage.selectProduct(productName);
    }
}
