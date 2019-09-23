package com.mvolution.radicale.json;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestFlightSerialisation {

    @Test
    public void deserializeFlight() throws IOException {

        TypedEntity typedEntity = new ObjectMapper().readValue( getClass().getResourceAsStream("/metaplanner-flight.json"), TypedEntity.class);
        assertNotNull(typedEntity);
        assertTrue(typedEntity instanceof Flight);
        Flight flight = (Flight) typedEntity;

        assertEquals("Flight", flight.getType());
        assertEquals("93c9d0d1-b59d-11e8-a990-02420a000029", flight.getCalendarId());
        assertEquals("metaplanner", flight.getProvider());
        //assertEquals("http://www.lufthansa.com/de/de/Online-Check-in", flight.getCheckInURL());

    }
}
