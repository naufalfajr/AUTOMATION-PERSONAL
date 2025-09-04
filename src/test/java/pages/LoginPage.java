package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class LoginPage extends BasePage {
    private final By tapLogin = AppiumBy.id("com.saucelabs.mydemoapp.android:id/username1TV");
    private final By loginButton = AppiumBy.accessibilityId("Tap to login with given credentials");

    public void tapToFillLoginFields() {
        click(tapLogin);
    }

    public void login() {
        click(loginButton);
    }
}
