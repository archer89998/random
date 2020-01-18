package org.random.automation.connection;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import static org.random.automation.data.ConfigurationHolder.getConfigurationValue;

public class RestConnectionFactory {

    private RestConnectionFactory() {
    }

    public static Connection getRestConnection(String path) {
        return Jsoup.connect(getConfigurationValue("url") + path).ignoreContentType(true).ignoreHttpErrors(true)
                .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                .referrer("http://www.google.com")
                .timeout(Integer.valueOf(getConfigurationValue("timeout")));

    }

}
