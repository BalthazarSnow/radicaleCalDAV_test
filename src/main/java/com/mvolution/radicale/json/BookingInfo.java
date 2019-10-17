package com.mvolution.radicale.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**This class represents the booking information for metaplanner flight-events. */
// JSON annotation to ignore unknown properties
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingInfo extends TypedEntity {

    private boolean booked;
    private String bookingURL;
    private String currency;
    private  double price;
    private boolean priceEstimated;

    boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    String getBookingURL() {
        return bookingURL;
    }

    public void setBookingURL(String bookingURL) {
        this.bookingURL = bookingURL;
    }

    String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    boolean isPriceEstimated() {
        return priceEstimated;
    }

    public void setPriceEstimated(boolean priceEstimated) {
        this.priceEstimated = priceEstimated;
    }

}
