package com.mvolution.radicale;

import com.mvolution.radicale.helper.CalDAVCollectionHelper;
import com.mvolution.radicale.helper.HttpConnectionHelper;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.osaf.caldav4j.CalDAVCollection;
import org.osaf.caldav4j.exceptions.CalDAV4JException;
import org.osaf.caldav4j.methods.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;

@RunWith(JUnit4.class)
// class to creating various VEvents
public class CreateVEvent {

    // LOG-Instance for logging
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateVEvent.class);


    @Test
    public void createAllDayVEvent() throws ParseException {

        // create a date & timezone reference for passing it to the VEvent
        Date startVEvent = new Date("20190831", "yyyyMMdd");

        //TODO
        VTimeZone tZone = new VTimeZone();

        LOGGER.info(">>>>>>>>TimeZoneInfo: {}", tZone.toString());

        // creating an VEvent.Object and passing the properties to it
        VEvent vevent = new VEvent(startVEvent, "the fucking first test");

        // declaring a new HttpConnectionHelper-Object
        HttpConnectionHelper httpHelper = new HttpConnectionHelper();
        // setting http properties
        HttpClient httpClient = httpHelper.setHttpConnection();
        // declaring a new CalDAVCollectionHelper-Object
        CalDAVCollectionHelper calDAVHelper = new CalDAVCollectionHelper();
        // setting the CalDAVCollection properties
        CalDAVCollection collection = calDAVHelper.setCalDAVCollection();

        LOGGER.info(vevent.getProperties().toString());

        //TODO
        try {
            collection.add(httpClient, vevent, tZone);
        } catch (CalDAV4JException e) {
            e.printStackTrace();
        }

        LOGGER.info( collection.toString());

    }


}
