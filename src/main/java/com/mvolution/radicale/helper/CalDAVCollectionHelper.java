package com.mvolution.radicale.helper;

import org.osaf.caldav4j.CalDAVCollection;
import org.osaf.caldav4j.CalDAVConstants;
import org.osaf.caldav4j.methods.CalDAV4JMethodFactory;
import org.osaf.caldav4j.methods.HttpClient;

// helper class to prepare the CalDAvCollection for use
public class CalDAVCollectionHelper extends HttpConnectionHelper {

    // httpHelper-Object to get the HTTP connection properties
    private HttpConnectionHelper httpHelper = new HttpConnectionHelper();
    private HttpClient httpClient = httpHelper.setHttpConnection();

    // sets the username from the prepared http connection
    private String username = httpHelper.getUsername();
    // path to the users calendar
    private String collectionPath = "/91baf471-dbd6-9299-b238-0465e36b8f5e/";

    // empty constructor
    public CalDAVCollectionHelper(){

    }

    // constructor to st the path to the users calendar
    public CalDAVCollectionHelper(String collectionPath){
        this.collectionPath = collectionPath;
    }

    // method to set the properties of the expected CalDav - Calendar collection
    public CalDAVCollection setCalDAVCollection(){

        CalDAVCollection collection = new CalDAVCollection(
                this.username + this.collectionPath,
                httpClient.getHostConfiguration(),
                new CalDAV4JMethodFactory(),
                CalDAVConstants.PROC_ID_DEFAULT
        );

        return collection;
    }

    // method to get the collection path
    public String getCollectionPath() {
        return collectionPath;
    }

}
