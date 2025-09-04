package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class ProductPage extends BasePage {
    private final By selectProductColor(String color) {
        return AppiumBy.accessibilityId(color+" color");
    }
    private final By plusQuantity = AppiumBy.xpath("//*[contains(@resource-id,'plusIV')]");
    private final By minusQuantity = AppiumBy.xpath("//*[contains(@resource-id,'minusIV')]");
    private final By quantity = AppiumBy.xpath("//*[contains(@resource-id,'noTV')]");
    private final By addToCartButton = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt");
    private final By cartButton = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartRL");
    private final By productPrice = AppiumBy.id("com.saucelabs.mydemoapp.android:id/priceTV");

    public void selectColor(String color) {
        click(selectProductColor(color));
    }

    public void putQuantity(int desiredQty) {
        int currentQty = Integer.parseInt(getText(quantity));
        while (currentQty < desiredQty) {
            click(plusQuantity);
            currentQty = Integer.parseInt(getText(quantity));
        }
        while (currentQty > desiredQty) {
            click(minusQuantity);
            currentQty = Integer.parseInt(getText(quantity));
        }
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public void addToCart() {
        click(addToCartButton);
    }

    public void goToCart() {
        click(cartButton);
    }
}
