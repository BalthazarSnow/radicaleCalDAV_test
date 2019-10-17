package com.mvolution.radicale.json;

import com.github.caldav4j.CalDAVCollection;
import com.github.caldav4j.exceptions.CalDAV4JException;
import com.github.caldav4j.model.request.CalendarQuery;
import com.github.caldav4j.util.GenerateQuery;
import com.mvolution.radicale.BaseCaldavClient;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

  public class TestBaseCalDavClient {

    // instance variable that represents the default uri to calendar-collection
    private static final String DEFAULT_URI = "http://localhost:5232/mvolution/91baf471-dbd6-9299-b238-0465e36b8f5e/";
    // object for logging the events of this class
    private final Logger LOG = LoggerFactory.getLogger(BaseCaldavClient.class);
    // instance variable sets the desired uri (default uri by standard)
    private String uri = DEFAULT_URI;

    // empty constructor
    public TestBaseCalDavClient() {    }

    // method that prints all entries from the given calendar-path
    @Test
    @SuppressWarnings("unchecked")
    public void printAllEntries() {
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
    @Test
    public void createAllDayEvent() {
        // instantiate a HTTP-Client Object with default credentials
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            // instantiate a new CalDAVCollection with the path to the collection
            CalDAVCollection collection = new CalDAVCollection(this.uri);
            // instantiate a new Date Object with the parameter date
            Date start = new Date(23102019);
            // instantiate a new VEvent Object with Date-Object and the summary as parameter
            VEvent testEvent = new VEvent(start, "Test");
            // calling the add() and passing the httpClient & event as parameter to
            collection.add(httpClient, testEvent, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createFlightVEvent() throws IOException, ParseException, CalDAV4JException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        TypedEntity jf = JsonEntityFactory.deserialize("/metaplanner-flight.json");

        // instantiate a new CalDAVCollection with the path to the collection
        CalDAVCollection collection = new CalDAVCollection(this.uri);
        Flight flight = (Flight)jf;
        VEvent flightEvent = FlightVEventFactory.generateFlightEvent(flight);
        collection.add(httpClient, flightEvent, null);
    }
}
