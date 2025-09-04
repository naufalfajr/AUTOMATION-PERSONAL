package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    public static void initializeDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName(ConfigReader.get("platformName"));
                options.setAutomationName(ConfigReader.get("automationName"));
                options.setDeviceName(ConfigReader.get("deviceName"));
                options.setApp(System.getProperty("user.dir") + "/" + ConfigReader.get("app"));
                options.setAutoGrantPermissions(Boolean.parseBoolean(ConfigReader.get("autoGrantPermissions")));
                options.setNewCommandTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.get("newCommandTimeout"))));
                
                driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Appium server not found", e);
            }
        }
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
