package com.mvolution.radicale.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**This class represents an Airline for metaplanner flight-events. */
@JsonIgnoreProperties(ignoreUnknown = true)
class Airline extends TypedEntity {
    @JsonProperty(value = "@managed")
    private boolean managed;
    private String iata;
    private String icao;
    private String logoUrl;
    private String name;
    private String url;


    boolean isManaged() {
        return managed;
    }

    void setManaged(boolean managed) {
        this.managed = managed;
    }

    String getIata() {
        return iata;
    }

    void setIata(String iata) {
        this.iata = iata;
    }

    String getIcao() {
        return icao;
    }

    void setIcao(String icao) {
        this.icao = icao;
    }

    String getLogoUrl() {
        return logoUrl;
    }

    void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getUrl() {
        return url;
    }

    void setUrl(String url) {
        this.url = url;
    }
}
