package com.mvolution.radicale;

import java.util.List;

import com.mvolution.radicale.helper.CalDAVCollectionHelper;
import com.mvolution.radicale.helper.HttpConnectionHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.component.VEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.osaf.caldav4j.CalDAVCollection;
import org.osaf.caldav4j.CalDAVConstants;
import org.osaf.caldav4j.exceptions.CalDAV4JException;
import org.osaf.caldav4j.methods.CalDAV4JMethodFactory;
import org.osaf.caldav4j.methods.HttpClient;
import org.osaf.caldav4j.model.request.CalendarQuery;
import org.osaf.caldav4j.util.GenerateQuery;


import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
// class for requesting
public class CalDAVRequest {

    // LOG-Instance for logging
    private static final Logger LOGGER = LoggerFactory.getLogger(CalDAVRequest.class);

    // calculates the duration of the given VEvent
    private double calcDuration(VEvent ve) {
        return (ve.getEndDate().getDate().getTime() - ve.getStartDate().getDate().getTime()) / (1000. * 60. * 60.);
    }

    @Test
    public void getCalendarEntries() throws CalDAV4JException {
        // declaring a new HttpConnectionHelper-Object
        HttpConnectionHelper httpHelper = new HttpConnectionHelper();
        // setting http properties
        HttpClient httpClient = httpHelper.setHttpConnection();
        // declaring a new CalDAVCollectionHelper-Object
        CalDAVCollectionHelper calDAVHelper = new CalDAVCollectionHelper();
        // setting the CalDAVCollection properties
        CalDAVCollection collection = calDAVHelper.setCalDAVCollection();

        // create a new Query-Object
        GenerateQuery gq=new GenerateQuery();
        LOGGER.info(">>>>>>>>>>>>>>>>>>Query: "+ gq.prettyPrint());
        // set the query to calendar query
        CalendarQuery calendarQuery = gq.generate();
        // passes the httpClient & calendarQuery to a List
        List<Calendar>calendars = collection.queryCalendars(httpClient, calendarQuery);

        // loop for iterating through all calendars
        for (Calendar calendar : calendars) {
            // sets a componentList with VEvents for the current calendar
            ComponentList componentList = calendar.getComponents().getComponents(Component.VEVENT);
            // loop for iterating through all VEvents of the current calendar
            for (VEvent ve : (Iterable<VEvent>) componentList) {
                // print the information via the LOG-Objects
                LOGGER.info(">>>>>>>>>>Event: " + ve.toString());
                LOGGER.info(">>>>>>>>>>Duration (h): " + String.format("%.2f", calcDuration(ve)));
                LOGGER.info("\n\n");
            }
        }

        // Give us a good feeling
        assertTrue(true);
    }

}
