package com.mvolution.radicale;


import com.github.caldav4j.CalDAVCollection;
import com.github.caldav4j.exceptions.CalDAV4JException;
import com.github.caldav4j.model.request.CalendarQuery;
import com.github.caldav4j.util.GenerateQuery;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// a class to communicate with the CalDAV-Server and send requests using REST-API
public class BaseCaldavClient {
    // instance variable that represents the default uri to calendar-collecction
    private static final String DEFAULT_URI = "http://localhost:5232/mvolution/91baf471-dbd6-9299-b238-0465e36b8f5e/";
    // object for logging the events of this class
    private final Logger LOG = LoggerFactory.getLogger(BaseCaldavClient.class);
    // instance variable sets the desired uri (default uri by standard)
    private String uri = DEFAULT_URI;

    // empty constructor
    BaseCaldavClient() {    }
    /* constructor
    * @param uri - the uri to the desired calendar collection*/
    public BaseCaldavClient(String uri) {
        this.uri = uri;
    }

    // method that prints all entries from the given calendar-path
    void printAllEntries() {
        // instantiate a HTTP-Client Object with default credentials
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try  {
            // instantiate a GenerateQuery and passing a generic query to a new CalendarQuery by using generate()
            GenerateQuery gq = new GenerateQuery();
            CalendarQuery calQ = gq.generate();

            // instantiate a new CalDAVCollection with the path to the collection
            CalDAVCollection collection = new CalDAVCollection(this.uri);

            // instantiate a List of Calendars with the previously set of credentials
            List<Calendar> calendars = collection.queryCalendars(httpClient, calQ);
            // counter for printing the position of the event
            int eventCounter = 1;
            // iterating through the calendars and events and print them
            for (Calendar calendar : calendars) {
                ComponentList componentList = calendar.getComponents().getComponents(Component.VEVENT);
                for (VEvent ve : (Iterable<VEvent>) componentList) {
                    LOG.info("\nEvent-Nr.: --->[ " + eventCounter++ + " ]<--- \n" + ve.toString());
                }
            }
        } catch (CalDAV4JException e) {
            e.printStackTrace();
        }
    }

    /* a method to create and save an all day-event to our calendar
    * @param date - the desired date for the event
    * @param summary - the summary of our event*/
    void createAllDayEvent(String date, String summary) {
        // instantiate a HTTP-Client Object with default credentials
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            // instantiate a new CalDAVCollection with the path to the collection
             CalDAVCollection collection = new CalDAVCollection(this.uri);
             // instantiate a new Date Object with the parameter date
             Date start = new Date(date);
             // instantiate a new VEvent Object with Date-Object and the summary as parameter
             VEvent testEvent = new VEvent(start, summary);
             // calling the add() and passing the httpClient & event as parameter to
             collection.add(httpClient, testEvent, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
