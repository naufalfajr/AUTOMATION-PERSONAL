package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.DriverFactory;

public class LoginPage {
    private final AndroidDriver driver;

    // Locators
    private final By usernameField = By.id("com.example:id/username");
    private final By passwordField = By.id("com.example:id/password");
    private final By loginButton   = By.id("com.example:id/login_button");
    private final By homeScreen    = By.id("com.example:id/home_screen");

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void tapLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Verification
    public boolean isHomeScreenDisplayed() {
        return driver.findElement(homeScreen).isDisplayed();
    }
}
