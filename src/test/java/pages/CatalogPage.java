package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class CatalogPage extends BasePage {
    private final By hamburgerMenu = AppiumBy.xpath("//*[contains(@resource-id,'menuIV')]");
    private final By product(String productName) {
        return AppiumBy.accessibilityId(productName);
    }
    private final By sideMenuItem(String itemName) {
        return AppiumBy.xpath("//*[contains(@resource-id,'itemTV') and contains(@text,'"+itemName+"')]");
    }

    public void goToMenu(String menu) {
        click(hamburgerMenu);
        click(sideMenuItem(menu));
    }

    public void selectProduct(String productName) {
        click(product(productName));
    }
}
