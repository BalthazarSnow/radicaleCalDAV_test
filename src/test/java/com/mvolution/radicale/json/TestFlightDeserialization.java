package com.mvolution.radicale.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class TestFlightDeserialization {

    @Test
    public void deserializeFlight() throws IOException {

        TypedEntity typedEntity = new ObjectMapper().readValue( getClass().getResourceAsStream("/metaplanner-flight.json"), TypedEntity.class);
        assertNotNull(typedEntity);
        assertTrue(typedEntity instanceof Flight);
        Flight flight = (Flight) typedEntity;

        // ASSERTION TESTS FLIGHT-PROPERTIES
        assertEquals("Flight", flight.getType());
        assertEquals("93c9d0d1-b59d-11e8-a990-02420a000029", flight.getCalendarId());
        assertEquals("metaplanner", flight.getProvider());
        assertEquals("false", String.valueOf(flight.isAllDay()));
        assertEquals("#48306d", flight.getArrivalTextColor());

            // ASSERTION TESTS BOOKING INFO PROPERTIES
            assertEquals("BookingInfo", flight.getBookingInfo().getType());
            assertEquals("false", String.valueOf(flight.getBookingInfo().isBooked()));
            assertEquals("http://partners.api.skyscanner.net/apiservices/deeplink/v2?_cje=QlonENvQHP03vCq9%2fPaazBifsTgoGwCvO0wlCKi%2bWMBwgOMrHOl2nBZmIE5It7Dy&url=https%3a%2f%2fwww.skyscanner.net%2ftransport_deeplink%2f4.0%2fDE%2fde-DE%2fEUR%2fluft%2f1%2f15277.11616.2019-02-04%2fair%2fairli%2fflights%3fitinerary%3dflight%7c-32090%7c721%7c15277%7c2019-02-04T11%3a20%7c11616%7c2019-02-04T14%3a55%7c635%7cHKRFOCBB%7cH%7c-%26carriers%3d-32090%26operators%3d-32090%26passengers%3d1%26channel%3ddataapi%26cabin_class%3deconomy%26facilitated%3dfalse%26ticket_price%3d1084.57%26is_npt%3dfalse%26is_multipart%3dfalse%26client_id%3dskyscanner_b2b%26q_ids%3dluft.15277.2687.190204..1..E%7c7002622562344495247%26commercial_filters%3dfalse%26q_datetime_utc%3d2019-01-25T12%3a45%3a00%26source_website_id%3damac",
                                    flight.getBookingInfo().getBookingURL());
            assertEquals("EUR", flight.getBookingInfo().getCurrency());
            assertEquals("1084.57", String.valueOf(flight.getBookingInfo().getPrice()));
            assertEquals("false", String.valueOf(flight.getBookingInfo().isPriceEstimated()));

        assertEquals("Economy", flight.getCabinClass());
        assertEquals("http://www.lufthansa.com/de/de/Online-Check-in", flight.getCheckinUrl());
        assertEquals("#48306d", flight.getDepartureTextColor());

            // ASSERTION TESTS DESTINATION PROPERTIES
            assertEquals("Airport", flight.getDestination().getType());
            assertEquals("true", String.valueOf(flight.getDestination().isManaged()));
            assertEquals("LargeAirport", flight.getDestination().getAirportType());
            assertEquals("Frankfurt", flight.getDestination().getCity());
            assertEquals("Deutschland", flight.getDestination().getCountry());
            assertEquals("FRA", flight.getDestination().getIata());
            assertEquals("50.050735", String.valueOf(flight.getDestination().getLatitude()));
            assertEquals("8.570773", String.valueOf(flight.getDestination().getLongitude()));
            assertEquals("Frankfurt Airport", flight.getDestination().getName());
            assertEquals("true", String.valueOf(flight.getDestination().isResolved()));
            assertEquals("Europe/Berlin", String.valueOf(flight.getDestination().getTimeZone()));
            assertEquals("http://www.frankfurt-airport.de/", flight.getDestination().getWebsite());

        assertEquals("7784.831701880228", String.valueOf(flight.getDistanceKm()));
        ZonedDateTime testEnd = ZonedDateTime.of(2019, 2, 4,13,55, 0, 0, ZoneId.of("Z"));
        assertEquals(testEnd , flight.getEnd());
        assertEquals("Europe/Berlin", String.valueOf(flight.getEndTimeZone()));
        assertEquals("721", String.valueOf(flight.getFlightNumber()));
        assertEquals("d8b9b992-209f-11e9-bab5-02420a000060", flight.getGroupId());
        assertEquals("d8b94462-209f-11e9-bab5-02420a000060", flight.getId());

            // ASSERTION TESTS OPERATING AIRLINE PROPERTIES
            assertEquals("Airline", flight.getOperatingAirline().getType());
            assertEquals("true", String.valueOf(flight.getOperatingAirline().isManaged()));
            assertEquals("LH", flight.getOperatingAirline().getIata());
            assertEquals("DLH", flight.getOperatingAirline().getIcao());
            assertEquals("https://s1.apideeplink.com/images/airlines/LH.png", flight.getOperatingAirline().getLogoUrl());
            assertEquals("Lufthansa", flight.getOperatingAirline().getName());
            assertEquals("http://www.lufthansa.com", flight.getOperatingAirline().getUrl());

            // ASSERTION TESTS DESTINATION PROPERTIES
            assertEquals("Airport", flight.getOrigin().getType());
            assertEquals("true", String.valueOf(flight.getOrigin().isManaged()));
            assertEquals("LargeAirport", flight.getOrigin().getAirportType());
            assertEquals("Beijing", flight.getOrigin().getCity());
            assertEquals("China", flight.getOrigin().getCountry());
            assertEquals("PEK", flight.getOrigin().getIata());
            assertEquals("40.079305", String.valueOf(flight.getOrigin().getLatitude()));
            assertEquals("116.582209", String.valueOf(flight.getOrigin().getLongitude()));
            assertEquals("Beijing Capital International Airport", flight.getOrigin().getName());
            assertEquals("true", String.valueOf(flight.getOrigin().isResolved()));
            assertEquals("Asia/Shanghai", String.valueOf(flight.getOrigin().getTimeZone()));
            assertEquals("http://en.bcia.com.cn/", flight.getOrigin().getWebsite());

        assertEquals("1", String.valueOf(flight.getPersons()));

            // ASSERTION TESTS SERVICE PROVIDER PROPERTIES
            assertEquals("Airline", flight.getServiceProvider().getType());
            assertEquals("true", String.valueOf(flight.getServiceProvider().isManaged()));
            assertEquals("LH", flight.getServiceProvider().getIata());
            assertEquals("DLH", flight.getServiceProvider().getIcao());
            assertEquals("https://s1.apideeplink.com/images/airlines/LH.png", flight.getServiceProvider().getLogoUrl());
            assertEquals("Lufthansa", flight.getOperatingAirline().getName());
            assertEquals("http://www.lufthansa.com", flight.getOperatingAirline().getUrl());

        ZonedDateTime testStart = ZonedDateTime.of(2019,2,4,3,20,0,0, ZoneId.of("Z"));
        assertEquals(testStart, flight.getStart());
        assertEquals("Asia/Shanghai", String.valueOf(flight.getStartTimeZone()));
        assertEquals("#ffffff", flight.getStatusButtonBackgroundColor());
        assertEquals("Unknown", flight.getStatusButtonLabel());
        assertEquals("#48306d", flight.getStatusButtonTextColor());
        assertEquals("Flight", flight.getSymbol());
        assertEquals("Flug LH 721 (Lufthansa)", flight.getTitle());
    }
}
