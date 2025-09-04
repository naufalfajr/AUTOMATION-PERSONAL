package stepDefinitions;

import io.cucumber.java.en.*;
import pages.ProductPage;

public class ProductSteps {
    ProductPage productPage = new ProductPage();

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
    }

    @When("I go to cart")
    public void goToCart() {
        productPage.goToCart();
    }
}
