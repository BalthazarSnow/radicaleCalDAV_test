package com.mvolution.radicale.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type", include = JsonTypeInfo.As.EXISTING_PROPERTY,  visible = true)
@JsonSubTypes(
        {@JsonSubTypes.Type(value = Flight.class, name = "Flight"),
         @JsonSubTypes.Type(value = BookingInfo.class, name = "BookingInfo"),
         @JsonSubTypes.Type(value = Airport.class, name = "Airport"),
         @JsonSubTypes.Type(value = Airline.class, name = "Airline")
        }        )
public class TypedEntity {
    @JsonProperty(value = "@type")
    private String type;

    String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
