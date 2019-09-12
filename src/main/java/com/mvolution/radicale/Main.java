package com.mvolution.radicale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main{
    // object for logging the events of this class
    static final Logger LOG = LoggerFactory.getLogger(Main.class);


    public static void main(String args[]) {
        // creating an instance of our BaseCalDAVClient
        BaseCaldavClient client = new BaseCaldavClient();
        // calling the method that prints all calendar entries
        client.printAllEntries();
        // calling the method for create and save an all day event
        client.createAllDayEvent("20191005", "Franks Geburtstagsfeier");

        // creating an instance of our JSON2CaldavParser with setting the path to json-file
        JSON2CalDAVParser flight = new JSON2CalDAVParser("C:\\Users\\mvolution\\IdeaProjects\\radicaleCalDAV_test\\res\\metaplanner-flight.json");
        // calling the method that print the JSON-content a String
        flight.printJSONFile();
        // printing the corresponding value to the given key with help of the logging object
        LOG.info("----------------> JSONObject Response: " + flight.getJSONContent("@calendarId"));



    }
}
