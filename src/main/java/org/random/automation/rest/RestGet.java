package org.random.automation.rest;

import org.jsoup.nodes.Document;

import java.io.IOException;

import static org.random.automation.connection.RestConnectionFactory.getRestConnection;

public class RestGet {

    public static Document get(String path) {
        try {
            return getRestConnection(path).get();
        } catch (IOException e) {
            throw new RestException("Unable to connect by path '%s'", path);
        }
    }

}
