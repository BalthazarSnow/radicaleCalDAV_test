package com.mvolution.radicale;


import com.github.caldav4j.CalDAVCollection;
import com.github.caldav4j.exceptions.CalDAV4JException;
import com.github.caldav4j.model.request.CalendarQuery;
import com.github.caldav4j.util.GenerateQuery;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.component.VEvent;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;


public class BaseCaldavClient {
    private static final String DEFAULT_URI = "http://localhost:5232/mvolution/91baf471-dbd6-9299-b238-0465e36b8f5e/";
    private final Logger LOG = LoggerFactory.getLogger(BaseCaldavClient.class);
    private String uri = DEFAULT_URI;

    public BaseCaldavClient() {    }

    @Test
    public void printAllEntries() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(this.uri);
        CloseableHttpResponse httpStatResponse = httpClient.execute(httpGet);
        try {
            LOG.debug("HTTP-Status Code: ---> " + httpStatResponse.getStatusLine().toString());
            HttpEntity entity1 = httpStatResponse.getEntity();
            LOG.info(entity1.getContent().toString());
            GenerateQuery gq = new GenerateQuery();
            CalendarQuery calQ = gq.generate();

            CalDAVCollection collection = new CalDAVCollection(this.uri);

            List<Calendar> calendars = collection.queryCalendars(httpClient, calQ);
            int eventCounter = 1;
            for (Calendar calendar : calendars) {
                ComponentList componentList = calendar.getComponents().getComponents(Component.VEVENT);
                for (VEvent ve : (Iterable<VEvent>) componentList) {

                    LOG.info("\nEvent-Nr.: --->[ " + eventCounter++ + " ]<--- \n" + ve.toString());
                }
            }
            EntityUtils.consume(entity1);
        } catch (CalDAV4JException e) {
            e.printStackTrace();
        } finally {
            httpStatResponse.close();
        }
    }
}
