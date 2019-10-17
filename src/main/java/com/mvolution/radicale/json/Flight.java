package com.mvolution.radicale.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.ZoneId;
import java.time.ZonedDateTime;
/**This class represents a flight for metaplanner-events*/
// JSON annotation to ignore unknown properties
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flight extends TypedEntity {
    @JsonProperty(value = "@calendarId")
    private String calendarId;
    @JsonProperty(value = "@provider")
    private String provider;

    // metaplanner appearance data
    private String arrivalTextColor;
    private String departureTextColor;
    private String statusButtonBackgroundColor;
    private String statusButtonTextColor;
    private String statusButtonLabel;
    private String symbol;

    // flight-data primitives
    private String groupId;
    private String id;
    private String title;
    private boolean allDay;
    private String cabinClass;
    private String checkinUrl;
    private double distanceKm;
    private int flightNumber;
    private int persons;

    //flight specific objects
    // JSON annotation to use the ZonedDateTimeDeserializer-class
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime start;
    // JSON annotation to use the ZoneIdDeserializer-class
    @JsonDeserialize(using = ZoneIdDeserializer.class)
    private ZoneId startTimeZone;
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime end;
    @JsonDeserialize(using = ZoneIdDeserializer.class)
    private ZoneId endTimeZone;
    private BookingInfo bookingInfo;
    private Airport destination;
    private Airport origin;
    private Airline operatingAirline;
    private Airline serviceProvider;



    // GETTER & SETTER
    String getCalendarId() {
        return calendarId;
    }

    void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    String getProvider() {
        return provider;
    }

    void setProvider(String provider) {
        this.provider = provider;
    }

    String getArrivalTextColor() {
        return arrivalTextColor;
    }

    void setArrivalTextColor(String arrivalTextColor) {
        this.arrivalTextColor = arrivalTextColor;
    }

    String getDepartureTextColor() {
        return departureTextColor;
    }

    void setDepartureTextColor(String departureTextColor) {
        this.departureTextColor = departureTextColor;
    }

    String getStatusButtonBackgroundColor() {
        return statusButtonBackgroundColor;
    }

    void setStatusButtonBackgroundColor(String statusButtonBackgroundColor) {
        this.statusButtonBackgroundColor = statusButtonBackgroundColor;
    }

    String getStatusButtonTextColor() {
        return statusButtonTextColor;
    }

    void setStatusButtonTextColor(String statusButtonTextColor) {
        this.statusButtonTextColor = statusButtonTextColor;
    }

    String getStatusButtonLabel() {
        return statusButtonLabel;
    }

    void setStatusButtonLabel(String statusButtonLabel) {
        this.statusButtonLabel = statusButtonLabel;
    }

    String getSymbol() {
        return symbol;
    }

    void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    String getGroupId() {
        return groupId;
    }

    void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    boolean isAllDay() {
        return allDay;
    }

    void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    String getCabinClass() {
        return cabinClass;
    }

    void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    String getCheckinUrl() {
        return checkinUrl;
    }

    public void setCheckinUrl(String checkinUrl) {
        this.checkinUrl = checkinUrl;
    }

    double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    int getPersons() {
        return persons;
    }

    void setPersons(int persons) {
        this.persons = persons;
    }

    ZonedDateTime getStart() {
        return start;
    }

    void setStart(ZonedDateTime start) {
        this.start = start;
    }

    ZoneId getStartTimeZone() {
        return startTimeZone;
    }

    void setStartTimeZone(ZoneId startTimeZone) {
        this.startTimeZone = startTimeZone;
    }

    ZonedDateTime getEnd() {
        return end;
    }

    void setEnd(ZonedDateTime end) {
        this.end = end;
    }

    ZoneId getEndTimeZone() {
        return endTimeZone;
    }

    void setEndTimeZone(ZoneId endTimeZone) {
        this.endTimeZone = endTimeZone;
    }

    BookingInfo getBookingInfo() {
        return bookingInfo;
    }

    void setBookingInfo(BookingInfo bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    Airport getDestination() {
        return destination;
    }

    void setDestination(Airport destination) {
        this.destination = destination;
    }

    Airport getOrigin() {
        return origin;
    }

    void setOrigin(Airport origin) {
        this.origin = origin;
    }

    Airline getOperatingAirline() {
        return operatingAirline;
    }

    void setOperatingAirline(Airline operatingAirline) {
        this.operatingAirline = operatingAirline;
    }

    Airline getServiceProvider() {
        return serviceProvider;
    }

    void setServiceProvider(Airline serviceProvider) {
        this.serviceProvider = serviceProvider;
    }


}
