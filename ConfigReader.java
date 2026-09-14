package com.utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        try {

            String path = "src/test/resources/config.properties";

            FileInputStream fis = new FileInputStream(path);

            properties.load(fis);

            fis.close();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load config.properties", e
            );
        }
    }

    public static String get(String key) {

        return properties.getProperty(key);
    }

    public static int getInt(String key) {

        return Integer.parseInt(
                properties.getProperty(key)
        );
    }

    public static boolean getBoolean(String key) {

        return Boolean.parseBoolean(
                properties.getProperty(key)
        );
    }
}
