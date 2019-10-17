package com.mvolution.radicale.json;

import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.parameter.XParameter;
import net.fortuna.ical4j.model.property.*;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;

/** A class to deserialize metaplanner flight events from JSON-Format
 * @author - Marco Fiedler.
 * {@link net.fortuna.ical4j}*/
public class FlightVEventFactory {
    /*Flight Properties*/
    /*Property Prefixes*/

    private static final String MP_PREFIX = Component.EXPERIMENTAL_PREFIX + "MP-";
    private static final String TYPE =  MP_PREFIX + "TYPE";
    private static final String PROVIDER =  MP_PREFIX + "PROVIDER";
    private static final String BOOKING =  MP_PREFIX + "BOOKING";
    private static final String TAGS =  MP_PREFIX + "TAGS";
    private static final String ORIGIN =  MP_PREFIX + "ORIGIN";
    private static final String DESTINATION =  MP_PREFIX + "DESTINATION";
    private static final String AIRLINE =  MP_PREFIX + "AIRLINE";
    private static final String STATUS =  MP_PREFIX + "STATUS";
    private final static String TAG_PREFIX = "@";

    /*BOOKING PARAMETERS*/
    private static final String BOOKING_STATUS = "STATUS";
    private static final String BOOKING_URL = "BOOKING-URL";
    private static final String BOOKING_CURRENCY = "CURRENCY";
    private static final String BOOKING_PRICE = "PRICE";
    private static final String BOOKING_PRICE_ESTIMATED = "PRICE-ESTIMATED";

     /*Origin Parameters*/
    private static final String ORIGIN_AIRPORT_TYPE = "AIRPORT-TYPE";
    private static final String ORIGIN_NAME = "NAME";
    private static final String ORIGIN_CITY = "CITY";
    private static final String ORIGIN_COUNTRY = "COUNTRY";
    private static final String ORIGIN_IATA = "IATA";
    private static final String ORIGIN_TERMINAL = "TERMINAL";
    private static final String ORIGIN_GATE = "GATE";
    private static final String ORIGIN_WEBSITE = "WEBSITE";
    private static final String ORIGIN_LATITUDE = "LATITUDE";
    private static final String ORIGIN_LONGITUDE = "LONGITUDE";
    private static final String ORIGIN_TIMEZONE = "TIMEZONE";

     /*Destination Parameters*/
    private static final String DESTINATION_AIRPORT_TYPE = "AIRPORT-TYPE";
    private static final String DESTINATION_NAME = "NAME";
    private static final String DESTINATION_CITY = "CITY";
    private static final String DESTINATION_COUNTRY = "COUNTRY";
    private static final String DESTINATION_IATA = "IATA";
    private static final String DESTINATION_TERMINAL = "TERMINAL";
    private static final String DESTINATION_GATE = "GATE";
    private static final String DESTINATION_WEBSITE = "WEBSITE";
    private static final String DESTINATION_LATITUDE = "LATITUDE";
    private static final String DESTINATION_LONGITUDE = "LONGITUDE";
    private static final String DESTINATION_TIMEZONE = "TIMEZONE";

    /*Airline Parameters*/
    private static final String AIRLINE_IATA = "IATA";
    private static final String AIRLINE_NAME = "NAME";
    private static final String AIRLINE_ICAO = "ICAO";
    private static final String AIRLINE_URL = "URL";
    private static final String AIRLINE_LOGO_URL = "LOGO-URL";
    private static final String FLIGHT_NO =  MP_PREFIX + "FLIGHT-NO";
    private static final String CODESHARES =  MP_PREFIX + "CODESHARES";
    private static final String CABIN =  MP_PREFIX + "CABIN";
    private static final String AIRCRAFT =  MP_PREFIX + "AIRCRAFT";
    private static final String SEAT =  MP_PREFIX + "SEAT";
    private static final String CHECKIN_URL =  MP_PREFIX + "CHECKIN-URL";
    private static final String TICKET =  MP_PREFIX + "TICKET";
    private static final String STATUS_URL =  MP_PREFIX + "STATUS-URL";

    /*Status Parameters*/
    private static final String FLIGHT_STATUS = "STATUS";

    /* Object of the desired pattern of flights ZonedDateTime*/
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmssSSSX");

    /**A static method for generating VEvents with metaplanner-specific flight-properties
     * @param flight takes a Flight-Object as parameter
     * @return VEvent
     * @exception ParseException On parsing error
     * @see ParseException*/
    public static VEvent generateFlightEvent(Flight flight) throws ParseException{

        PropertyList<net.fortuna.ical4j.model.Property> props = new PropertyList<>();
        // adding CalDAV - standard & metaplanner properties
        props.add(new Uid(flight.getCalendarId()));
        props.add(new DtStamp());
        props.add(new DtStart(flight.getStart().format(formatter)));
        props.add(new DtEnd(flight.getEnd().format(formatter)));
        props.add(new Summary(flight.getTitle()));
        props.add(new Description("Eigene Notizen zu diesem Flug."));


        props.add(new XProperty(TYPE, flight.getType()));
        props.add(new XProperty(PROVIDER, flight.getProvider()));

        // instantiate & fill a ParameterList with flights booking information
        ParameterList bookingInfo = new ParameterList();
        bookingInfo.add(new XParameter(BOOKING_STATUS, String.valueOf(flight.getBookingInfo().isBooked())));
        bookingInfo.add(new XParameter(BOOKING_URL, flight.getBookingInfo().getBookingURL()));
        bookingInfo.add(new XParameter(BOOKING_CURRENCY, flight.getBookingInfo().getCurrency()));
        bookingInfo.add(new XParameter(BOOKING_PRICE, String.valueOf(flight.getBookingInfo().getPrice())));
        bookingInfo.add(new XParameter(BOOKING_PRICE_ESTIMATED, String.valueOf(flight.getBookingInfo().isPriceEstimated())));
        props.add(new XProperty(BOOKING, bookingInfo, ""));

        props.add(new XProperty(TAGS,TAG_PREFIX + flight.getType()));

        // instantiate & fill a ParameterList with flights original airport information
        ParameterList originInfo = new ParameterList();
        originInfo.add(new XParameter(ORIGIN_AIRPORT_TYPE, flight.getOrigin().getAirportType()));
        originInfo.add(new XParameter(ORIGIN_NAME, flight.getOrigin().getName()));
        originInfo.add(new XParameter(ORIGIN_CITY,flight.getOrigin().getCity()));
        originInfo.add(new XParameter(ORIGIN_COUNTRY,flight.getOrigin().getCountry()));
        originInfo.add(new XParameter(ORIGIN_IATA,flight.getOrigin().getIata()));
        originInfo.add(new XParameter(ORIGIN_WEBSITE,flight.getOrigin().getWebsite()));
        originInfo.add(new XParameter(ORIGIN_LATITUDE, String.valueOf(flight.getOrigin().getLatitude())));
        originInfo.add(new XParameter(ORIGIN_LONGITUDE, String.valueOf(flight.getOrigin().getLongitude())));
        originInfo.add(new XParameter(ORIGIN_TIMEZONE, String.valueOf(flight.getOrigin().getTimeZone())));
        props.add(new XProperty(ORIGIN, originInfo, ""));

        // instantiate & fill a ParameterList with flights destination airport information
        ParameterList destinationInfo = new ParameterList();
        destinationInfo.add(new XParameter(DESTINATION_AIRPORT_TYPE, flight.getDestination().getAirportType()));
        destinationInfo.add(new XParameter(DESTINATION_NAME, flight.getDestination().getName()));
        destinationInfo.add(new XParameter(DESTINATION_CITY,flight.getDestination().getCity()));
        destinationInfo.add(new XParameter(DESTINATION_COUNTRY,flight.getDestination().getCountry()));
        destinationInfo.add(new XParameter(DESTINATION_IATA,flight.getDestination().getIata()));
        destinationInfo.add(new XParameter(DESTINATION_WEBSITE,flight.getDestination().getWebsite()));
        destinationInfo.add(new XParameter(DESTINATION_LATITUDE, String.valueOf(flight.getDestination().getLatitude())));
        destinationInfo.add(new XParameter(DESTINATION_LONGITUDE, String.valueOf(flight.getDestination().getLongitude())));
        destinationInfo.add(new XParameter(DESTINATION_TIMEZONE, String.valueOf(flight.getDestination().getTimeZone())));
        props.add(new XProperty(DESTINATION, destinationInfo, ""));

        // instantiate & fill a ParameterList with flights destination airport information
        ParameterList airlineInfo = new ParameterList();
        airlineInfo.add(new XParameter(AIRLINE_NAME, flight.getOperatingAirline().getName()));
        airlineInfo.add(new XParameter(AIRLINE_IATA, flight.getOperatingAirline().getIata()));
        airlineInfo.add(new XParameter(AIRLINE_ICAO, flight.getOperatingAirline().getIcao()));
        airlineInfo.add(new XParameter(AIRLINE_URL, flight.getOperatingAirline().getUrl()));
        airlineInfo.add(new XParameter(AIRLINE_LOGO_URL, flight.getOperatingAirline().getLogoUrl()));
        props.add(new XProperty(AIRLINE, airlineInfo, ""));

        props.add(new XProperty(FLIGHT_NO, String.valueOf(flight.getFlightNumber())));
        props.add(new XProperty(CABIN, flight.getCabinClass()));
        props.add(new XProperty(CHECKIN_URL, flight.getCheckinUrl()));

        return new VEvent(props);
    }
}
