package com.mvolution.radicale.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvolution.radicale.BaseCaldavClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingInfo extends TypedEntity {

    // object for logging the events of this class
    private final Logger LOG = LoggerFactory.getLogger(BookingInfo.class);

    private boolean booked;
    private String bookingURL;
    private String currency;
    private  double price;
    private boolean priceEstimated;

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getBookingURL() {
        return bookingURL;
    }

    public void setBookingURL(String bookingURL) {
        this.bookingURL = bookingURL;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPriceEstimated() {
        return priceEstimated;
    }

    public void setPriceEstimated(boolean priceEstimated) {
        this.priceEstimated = priceEstimated;
    }

}
