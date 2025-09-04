package pages;

import java.util.Map;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class PaymentPage extends BasePage {
    private final By getFieldName(String fieldName) {
        return AppiumBy.xpath("//*[contains(@resource-id,'"+fieldNameMap.get(fieldName)+"ET')]");
    }
    private final By reviewOrderButton = AppiumBy.accessibilityId("Saves payment info and launches screen to review checkout data");

    Map<String, String> fieldNameMap = Map.of(
        "Full Name", "name", 
        "Card Number", "cardNumber", 
        "Expiration Date", "expirationDate", 
        "Security Code", "securityCode"
    );

    public void inputField(String fieldName, String value) {
        sendKeys(getFieldName(fieldName), value);
    }

    public void reviewOrder() {
        click(reviewOrderButton);
    }
}
