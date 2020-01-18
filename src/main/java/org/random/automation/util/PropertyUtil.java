package org.random.automation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {

    public final static String CONFIGURATION = "configuration";
    private static final String PROPERTIES_EXTENSION = ".properties";

    public static Map<String, String> readPropertiesToMap(String fileName) {
        Properties properties = new Properties();
        String filePath = Paths.get("", CONFIGURATION, fileName + PROPERTIES_EXTENSION).toAbsolutePath().toString();

        try (InputStream inStream = new FileInputStream(new File(filePath))) {
            properties.load(inStream);
        } catch (IOException e) {
            throw new PropertiesControllerException("Cannot load '%s'", e, filePath);
        }

        Map<String, String> dataFromPropertyFile = new HashMap<>();
        properties.stringPropertyNames()
                .forEach(name -> dataFromPropertyFile.put(name, properties.getProperty(name)));

        return dataFromPropertyFile;
    }
}
