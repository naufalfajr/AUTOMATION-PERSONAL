package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;
    private WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // default timeout
    }

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitForVisibility(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement scrollToElement(By locator) {
        String uiSelector = null;

        if (locator instanceof AppiumBy.ById) {
            String value = locator.toString().replace("AppiumBy.id: ", "").trim();
            uiSelector = "new UiSelector().resourceId(\""+value+"\")";
        } else if (locator instanceof AppiumBy.ByAccessibilityId) {
            String value = locator.toString().replace("AppiumBy.accessibilityId: ", "").trim();
            uiSelector = "new UiSelector().description(\""+value+"\")";
        } else if (locator instanceof AppiumBy.ByXPath) {
            throw new IllegalArgumentException("UiScrollable does not support XPath directly. Use ID or accessibilityId instead.");
        } else {
            throw new IllegalArgumentException("Locator type not supported for UiScrollable: " + locator);
        }

        String uiAutomatorString = "new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView("+uiSelector+");";

        return driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorString));
    }

}
