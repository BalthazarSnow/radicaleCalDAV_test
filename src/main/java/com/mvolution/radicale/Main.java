package com.mvolution.radicale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main{
    // object for logging the events of this class
    static final Logger LOG = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        // creating an instance of our BaseCalDAVClient
        BaseCaldavClient client = new BaseCaldavClient();
        // calling the method that prints all calendar entries
        client.printAllEntries();
        // calling the method for create and save an all day event
        client.createAllDayEvent("20191005", "Franks Geburtstagsfeier");



    }
}
