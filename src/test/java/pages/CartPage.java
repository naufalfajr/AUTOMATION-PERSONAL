package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class CartPage extends BasePage {
    private final By productName = AppiumBy.id("com.saucelabs.mydemoapp.android:id/titleTV");
    private final By productColor = AppiumBy.accessibilityId("Displays color of selected product");
    private final By productPrice = AppiumBy.id("com.saucelabs.mydemoapp.android:id/priceTV");
    private final By totalItems = AppiumBy.id("com.saucelabs.mydemoapp.android:id/itemsTV");
    private final By totalPrice = AppiumBy.id("com.saucelabs.mydemoapp.android:id/totalPriceTV");
    private final By proceedCheckoutButton = AppiumBy.accessibilityId("Confirms products for checkout");

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPriceCurr() {
        return getText(productPrice);
    }

    public Double getProductPrice() {
        String price = getText(productPrice);
        return Double.parseDouble(price.replace("$ ", ""));
    }

    public String getTotalItems() {
        return getText(totalItems);
    }

    public int getTotalItemsInt() {
        String items = getText(totalItems);
        return Integer.parseInt(items.replaceAll("[^\\d]", ""));
    }

    public Double getTotalAmount() {
        String price = getText(totalPrice);
        return Double.parseDouble(price.replace("$ ", ""));
    }

    public Boolean isColorDisplayed() {
        return isDisplayed(productColor);
    }

    public void proceedToCheckout() {
        click(proceedCheckoutButton);
    }
}
