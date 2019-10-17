package com.mvolution.radicale;

import com.github.caldav4j.CalDAVCollection;
import com.github.caldav4j.exceptions.CalDAV4JException;
import com.github.caldav4j.model.request.CalendarQuery;
import com.github.caldav4j.util.GenerateQuery;
import com.mvolution.radicale.json.Flight;
import com.mvolution.radicale.json.FlightVEventFactory;
import com.mvolution.radicale.json.JsonEntityFactory;
import com.mvolution.radicale.json.TypedEntity;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/** a class to communicate with the CalDAV-Server and send requests by using REST-API
 * @author Marco Fiedler
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class BaseCaldavClient{
    // instance variable that represents the default uri to calendar-collecction
    private static final String DEFAULT_CALENDAR_URI = "http://localhost:5232/mvolution/91baf471-dbd6-9299-b238-0465e36b8f5e/";
    // instance variable sets the desired uri (default uri by standard)
    private String calendarUri = DEFAULT_CALENDAR_URI;

    // empty constructor
    private BaseCaldavClient() {    }

    /** constructor wit calendar path as parameter
    * @param calendarUri - the uri to the desired calendar collection*/
    public BaseCaldavClient(String calendarUri) {
        this.calendarUri = calendarUri;
    }

    /** this is the main method which uses the BaseCaldavClient-Class
     * @param args Unused
     * @exception IOException On input error
     * @see IOException
     * @exception ParseException On parsing error
     * @see ParseException
     * @exception CalDAV4JException On CalDAV caused errors
     * @see CalDAV4JException
     * */
    public static void main(String[] args) throws IOException, ParseException, CalDAV4JException {
        // creating an instance of our BaseCalDAVClient
        BaseCaldavClient client = new BaseCaldavClient();
        // calling the method that prints all calendar entries
        client.printAllEntries();
        // calling the method for create and save an all day event
         client.createAllDayEvent("20191022", "---->FlightVEvent test<----");

        // path to the json-source
        String flightJson = "/metaplanner-flight.json";
        // passing a FlightEvent to radicaleServer
        client.createFlightVEvent(flightJson);
    }

    /** prints all entries from the given calendar-path*/
    private void printAllEntries() {
        // instantiate a HTTP-Client Object with default credentials
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try  {
            // instantiate a GenerateQuery and passing a generic query to a new CalendarQuery by using generate()
            GenerateQuery gq = new GenerateQuery();
            CalendarQuery calQ = gq.generate();

            // instantiate a new CalDAVCollection with the path to the collection
            CalDAVCollection collection = new CalDAVCollection(this.calendarUri);

            // instantiate a List of Calendars with the previously set of credentials
            List<Calendar> calendars = collection.queryCalendars(httpClient, calQ);
            // counter for printing the position of the event
            int eventCounter = 1;
            // iterating through the calendars and events and print them
            for (Calendar calendar : calendars) {
                ComponentList componentList = calendar.getComponents().getComponents(Component.VEVENT);
                for (VEvent ve : (Iterable<VEvent>) componentList) {
                    System.out.print("\nEvent-Nr.: --->[ " + eventCounter++ + " ]<--- \n" + ve.toString());
                }
            }
        } catch (CalDAV4JException e) {
            e.printStackTrace();
        }
    }

    /** create and save an all day-event to our calendar
    * @param date the desired date for the event
    * @param summary the summary of our event*/
    private void createAllDayEvent(String date, String summary) {
        // instantiate a HTTP-Client Object with default credentials
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            // instantiate a new CalDAVCollection with the path to the collection
             CalDAVCollection collection = new CalDAVCollection(this.calendarUri);
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

    /** create a metaplanner-flight event in CalDAV-Standard
     * @param jsonSrc path to the json that contains the metaplanner-flight information
     * @exception IOException On input error
     * @see IOException
     * @exception ParseException On parsing error
     * @see ParseException
     * @exception CalDAV4JException On CalDAV caused errors
     * @see CalDAV4JException
     * */
    private void createFlightVEvent(String jsonSrc) throws IOException, ParseException, CalDAV4JException {
        // instantiate a new Http-Object with default credentials
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // instantiate a TypedEntity-Object with the static method from our JsonEntityFactory to deserialize the json-source
        TypedEntity jf = JsonEntityFactory.deserialize(jsonSrc);
        // instantiate a new CalDAVCollection with the path to the collection
        CalDAVCollection collection = new CalDAVCollection(this.calendarUri);
        // typecast the TypedEntity-Object into Flight-Object
        Flight flight = (Flight)jf;
        // instantiate a new VEvent by using the static FlightVEventFactory with his static method to generate a flight event
        VEvent flightEvent = FlightVEventFactory.generateFlightEvent(flight);
        // adding the flight event to our calendar
        collection.add(httpClient, flightEvent, null);
    }

    /**getter for the current path to the calendar
     * @return calendar path as a String*/
    public String getCalendarUri() {
        return calendarUri;
    }
    /**setter for calendar path
     * @param calendarUri path to the desired calendar */
    public void setCalendarUri(String calendarUri) {
        this.calendarUri = calendarUri;
    }
}
