package com.db.properties;

import com.db.logger.Log;
import com.db.logger.Logger;

import java.io.InputStream;
import java.util.Properties;

public abstract class AbsCallProperties {

    private static final Properties props = new Properties();

    private static final Log log= Logger.getLogger(AbsCallProperties.class);

    public static void loadProperties() {
        log.info("Loading application.properties");

        try (InputStream is =
                     AbsCallProperties.class
                             .getClassLoader()
                             .getResourceAsStream("application.properties")) {

            if (is == null) {
                log.error("application.properties not found in classpath");
                throw new RuntimeException("application.properties not found");
            }

            props.load(is);
            log.info("application.properties loaded successfully {}",props);

        } catch (Exception e) {
            log.error("Failed to load application.properties", e);
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
