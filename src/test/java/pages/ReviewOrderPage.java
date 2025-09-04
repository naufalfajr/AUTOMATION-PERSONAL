package pages;

import java.util.Map;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class ReviewOrderPage extends BasePage{
    private final By productImage = AppiumBy.accessibilityId("Displays selected product");
    private final By productName = AppiumBy.id("com.saucelabs.mydemoapp.android:id/titleTV");
    private final By productPrice = AppiumBy.id("com.saucelabs.mydemoapp.android:id/priceTV");
    private final By getFieldName(String fieldName) {
        return AppiumBy.id("com.saucelabs.mydemoapp.android:id/"+fieldNameMap.get(fieldName)+"TV");
    }
    private final By shipmentPrice = AppiumBy.id("com.saucelabs.mydemoapp.android:id/amountTV");
    private final By totalItems = AppiumBy.id("com.saucelabs.mydemoapp.android:id/itemNumberTV");
    private final By finalPrice = AppiumBy.id("com.saucelabs.mydemoapp.android:id/totalAmountTV");
    private final By placeOrderButton = AppiumBy.accessibilityId("Completes the process of checkout");

    Map<String, String> fieldNameMap = Map.of(
        "Full Name", "fullName", 
        "Address Line 1", "address",
        "City", "city",
        "Country", "country",
        "Card Holder", "cardHolder", 
        "Card Number", "cardNumber", 
        "Expiration Date", "expirationDate"
    );

    public Boolean isProductImageDisplayed() {
        return isDisplayed(productImage);
    }

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public String getFieldData(String fieldName) {
        return getText(getFieldName(fieldName));
    }

    public Double getShipmentPrice() {
        scrollToElement(shipmentPrice);
        String shipment = getText(shipmentPrice);
        return Double.parseDouble(shipment.replace("$", ""));
    }

    public String getTotalItems() {
        return getText(totalItems);
    }

    public Double getFinalPrice() {
        String finalPriceString = getText(finalPrice);
        return Double.parseDouble(finalPriceString.replace("$", ""));
    }

    public void placeOrder() {
        click(placeOrderButton);
    }
}
