package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class CompleteOrderPage extends BasePage {
    private final By orderConfirmationMessage = AppiumBy.id("com.saucelabs.mydemoapp.android:id/completeTV");
    private final By continueShoppingButton = AppiumBy.accessibilityId("Tap to open catalog");

    public String getOrderConfirmationMessage() {
        return getText(orderConfirmationMessage);
    }

    public void continueShopping() {
        click(continueShoppingButton);
    }
    
}
