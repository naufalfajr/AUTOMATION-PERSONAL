package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static String get(String key) {
        if (properties == null) {
            properties = new Properties();
            try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
                if (input == null) {
                    throw new RuntimeException("config.properties not found in resources folder");
                }
                properties.load(input);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config.properties file", e);
            }
        }
        return properties.getProperty(key);
    }
}