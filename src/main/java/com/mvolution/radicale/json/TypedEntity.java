package com.mvolution.radicale.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**A class representing a general metaplanner event from a JSON source and determining it by the "type"-value.*/
// JSON annotation to determine NON_NULL
@JsonInclude(JsonInclude.Include.NON_NULL)
// JSON annotation to determine the type of the event
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type", include = JsonTypeInfo.As.EXISTING_PROPERTY,  visible = true)
// JSON annotation to determine the usage of the corresponding class depending on the "type"-value
@JsonSubTypes(
        {@JsonSubTypes.Type(value = Flight.class, name = "Flight"),
         @JsonSubTypes.Type(value = BookingInfo.class, name = "BookingInfo"),
         @JsonSubTypes.Type(value = Airport.class, name = "Airport"),
         @JsonSubTypes.Type(value = Airline.class, name = "Airline")
        }        )
public class TypedEntity {
    // JSON annotation to determine the event by the value "type"
    @JsonProperty(value = "@type")
    private String type;


    // GETTER & SETTER
    String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }


}
