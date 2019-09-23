package com.mvolution.radicale.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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

    // flight specific objects
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime start;
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

    String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getArrivalTextColor() {
        return arrivalTextColor;
    }

    public void setArrivalTextColor(String arrivalTextColor) {
        this.arrivalTextColor = arrivalTextColor;
    }

    public String getDepartureTextColor() {
        return departureTextColor;
    }

    public void setDepartureTextColor(String departureTextColor) {
        this.departureTextColor = departureTextColor;
    }

    public String getStatusButtonBackgroundColor() {
        return statusButtonBackgroundColor;
    }

    public void setStatusButtonBackgroundColor(String statusButtonBackgroundColor) {
        this.statusButtonBackgroundColor = statusButtonBackgroundColor;
    }

    public String getStatusButtonTextColor() {
        return statusButtonTextColor;
    }

    public void setStatusButtonTextColor(String statusButtonTextColor) {
        this.statusButtonTextColor = statusButtonTextColor;
    }

    public String getStatusButtonLabel() {
        return statusButtonLabel;
    }

    public void setStatusButtonLabel(String statusButtonLabel) {
        this.statusButtonLabel = statusButtonLabel;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public String getCheckinUrl() {
        return checkinUrl;
    }

    public void setCheckinUrl(String checkinUrl) {
        this.checkinUrl = checkinUrl;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    public ZoneId getStartTimeZone() {
        return startTimeZone;
    }

    public void setStartTimeZone(ZoneId startTimeZone) {
        this.startTimeZone = startTimeZone;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    public void setEnd(ZonedDateTime end) {
        this.end = end;
    }

    public ZoneId getEndTimeZone() {
        return endTimeZone;
    }

    public void setEndTimeZone(ZoneId endTimeZone) {
        this.endTimeZone = endTimeZone;
    }

    public BookingInfo getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(BookingInfo bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airline getOperatingAirline() {
        return operatingAirline;
    }

    public void setOperatingAirline(Airline operatingAirline) {
        this.operatingAirline = operatingAirline;
    }

    public Airline getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(Airline serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
