package org.random.automation.data;

import org.random.automation.util.PropertyUtil;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationHolder {

    private static Map<String, String> configuration = new HashMap<>();

    private ConfigurationHolder() {
    }

    public static void setConfigurationData(String configurationFileName) {
        Map<String, String> configurationData = PropertyUtil.readPropertiesToMap(configurationFileName);
        configuration.putAll(configurationData);
    }

    public static String getConfigurationValue(String key) {
        if (!configuration.containsKey(key)) {
            throw new ConfigurationException("No data found in properties file by key '%s'", key);
        }

        return configuration.get(key);
    }
}
