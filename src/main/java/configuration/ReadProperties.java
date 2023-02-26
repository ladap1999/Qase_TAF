package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getApiUrl() {
        return properties.getProperty("apiUrl");
    }

    public static String getApiKey() {
        return properties.getProperty("apiKey");
    }
}
