package com.mvolution.radicale;

import java.net.HttpURLConnection;
import java.net.URL;

// for checking the http-connection
class TestHTTPConnection {

    // declaring instance variables for the http-connection
    private String url;
    private String result;
    private String connectedURL;

    // constructor that awaits the url to the desired host
    TestHTTPConnection(String url) {
        this.url = url;
    }

    // checking the connection to the host & sets the result and connected url
    void checkConnectionState(){
        // represents the error code for the http-connection
        int code;
        try {
            // new URL-object which were enriched with the given url
            URL siteURL = new URL(this.url);
            // sets and open a new http-connection with the url from the constructor
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            // sets the request method to GET
            connection.setRequestMethod("GET");
            // sets the connection timeout to 3000 milliseconds
            connection.setConnectTimeout(3000);
            // build up the connection
            connection.connect();
            // sets the instance variable connectedURL
            this.connectedURL = String.valueOf(connection.getURL());
            // gets the connections response code
            code = connection.getResponseCode();
            // checking the code value
            if (code == 200) {
                this.result = "Connection to URL >>> " + this.connectedURL + " <<< succeeded:-> Green <-\t" + "Code: " + code;
                ;
            } else {
                this.result = "Connection to URL >>> " + this.connectedURL + " <<< failed:-> Yellow <-\t" + "Code: " + code;
            }
        } catch (Exception e) {
            this.result = "Connection to URL >>> " + this.connectedURL + "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();
        }
    }

    // GETTERS
    String getResult() { return result; }

    String getConnectedURL() { return connectedURL; }
}
