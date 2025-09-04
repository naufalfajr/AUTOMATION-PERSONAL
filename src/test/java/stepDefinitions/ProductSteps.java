package stepDefinitions;

import io.cucumber.java.en.When;
import pages.ProductPage;
import utils.ScenarioContext;

public class ProductSteps {
    ProductPage productPage = new ProductPage();
    private ScenarioContext scenarioContext;

    public ProductSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @When("I select color {string}")
    public void selectColor(String color) {
        productPage.selectColor(color);
    }

    @When("I set quantity to {int}")
    public void setQuantity(int qty) {
        productPage.putQuantity(qty);
    }

    @When("I add the product to cart")
    public void addToCart() {
        productPage.addToCart();
        scenarioContext.set("PRODUCT_PRICE_CURR", productPage.getProductPrice());
    }

    @When("I go to cart")
    public void goToCart() {
        productPage.goToCart();
    }
}
