package pages;

import java.util.Map;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class CheckoutPage extends BasePage {
    private final By getFieldName(String fieldName) {
        return AppiumBy.id("com.saucelabs.mydemoapp.android:id/"+fieldNameMap.get(fieldName)+"ET");
    }
    private final By toPaymentButton = AppiumBy.accessibilityId("Saves user info for checkout");

    Map<String, String> fieldNameMap = Map.of(
        "Full Name", "fullName", 
        "Address Line 1", "address1", 
        "State", "state", 
        "City", "city", 
        "Zip Code", "zip", 
        "Country", "country"
    );

    public void inputField(String fieldName, String value) {
        sendKeys(getFieldName(fieldName), value);
    }

    public void toPayment() {
        click(toPaymentButton);
    }
}
