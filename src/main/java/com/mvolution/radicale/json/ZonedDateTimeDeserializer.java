package com.mvolution.radicale.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/** class to deserialize the ZonedDateTime-Object into our desired pattern
 * @see com.mvolution.radicale.json.Flight*/
public class ZonedDateTimeDeserializer extends StdDeserializer<ZonedDateTime> {

    @SuppressWarnings("unused")
    public ZonedDateTimeDeserializer() {this(null);}

    // constructor matching super
    private ZonedDateTimeDeserializer(Class<ZonedDateTime> vc) {super(vc);}

    /**This method is used to deserialize the json-input of ZonedDateTime format
     * @param jsonParser - the json-object
     * @param deserializationContext - serializable JSON-Context
     * @return returns the ZoneDateTime-Object which matches our desired pattern
     * @exception IOException On input error
     * @see IOException*/
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        return ZonedDateTime.parse(jsonParser.getText(), formatter ) ;
    }

}
