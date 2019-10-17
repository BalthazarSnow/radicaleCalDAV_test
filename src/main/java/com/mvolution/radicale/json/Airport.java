package com.mvolution.radicale.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.ZoneId;

/**This class represents an Airport for metaplanner flight-events. */
@JsonIgnoreProperties(ignoreUnknown = true)
class Airport extends TypedEntity {
    @JsonProperty(value = "@managed")
    private boolean managed;

    private String airportType;
    private String name;
    private String city;
    private String country;
    private String iata;
    private String website;
    private String gate;
    private int terminal;
    @JsonDeserialize(using = ZoneIdDeserializer.class)
    private ZoneId timeZone;
    private double latitude;
    private double longitude;
    private boolean resolved;

    boolean isManaged() {
        return managed;
    }

    void setManaged(boolean managed) {
        this.managed = managed;
    }

    String getAirportType() {
        return airportType;
    }

    void setAirportType(String airportType) {
        this.airportType = airportType;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    String getCountry() {
        return country;
    }

    void setCountry(String country) {
        this.country = country;
    }

    String getIata() {
        return iata;
    }

    void setIata(String iata) {
        this.iata = iata;
    }

    String getWebsite() {
        return website;
    }

    void setWebsite(String website) {
        this.website = website;
    }

    ZoneId getTimeZone() {
        return timeZone;
    }

    void setTimeZone(ZoneId timeZone) {
        this.timeZone = timeZone;
    }

    double getLatitude() {
        return latitude;
    }

    void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    double getLongitude() {
        return longitude;
    }

    void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    boolean isResolved() {
        return resolved;
    }

    void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
