package com.mvolution.radicale.helper;

import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.osaf.caldav4j.methods.HttpClient;

// helper class to prepare the HttpClient Object for use
public class HttpConnectionHelper {

    // properties needed for a http connection
    private String username = "mvolution";
    private String password = "";
    private String host = "localhost";
    private String protocol = "http";
    private int port = 5232;

    // empty constructor
    public HttpConnectionHelper(){

    }

    // constructor to set custom http properties
    public HttpConnectionHelper(String username, String password, String host, String protocol, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.protocol = protocol;
        this.port = port;
    }

    // method that returns a httpClient-object for use
    public HttpClient setHttpConnection(){

        // declaring a new HTTPClient-Object
        HttpClient httpClient = new HttpClient();

        // set the required host information to the httpClient
        httpClient.getHostConfiguration().setHost(host, port, protocol);

        // referencing the auth info to the new UsernamePasswordCredentials
        UsernamePasswordCredentials httpCredentials = new UsernamePasswordCredentials(username, password);
        httpClient.getState().setCredentials(AuthScope.ANY, httpCredentials);
        httpClient.getParams().setAuthenticationPreemptive(true);
        return httpClient;
    }


    // GETTER & SETTER for the HTTP properties
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public String getProtocol() {
        return protocol;
    }

    public int getPort() {
        return port;
    }

}
