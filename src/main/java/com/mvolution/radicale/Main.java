package com.mvolution.radicale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;


public class Main{

    static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String args[]) throws IOException {


        // create new TestHTTPConnection Object with a String which represents the URL
        TestHTTPConnection conTest = new TestHTTPConnection("http://localhost:5232");

        // checking the availability of the given url
        conTest.checkConnectionState();

        // use the Logger to see the result of the request
        LOGGER.info("Try to connect: {} --------> {}",conTest.getConnectedURL(), conTest.getResult());
    }
}
