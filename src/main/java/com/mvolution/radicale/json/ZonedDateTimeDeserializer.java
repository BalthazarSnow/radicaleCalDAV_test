package com.mvolution.radicale.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeDeserializer extends StdDeserializer<ZonedDateTime> {

    @SuppressWarnings("unused")
    public ZonedDateTimeDeserializer() {
        this(null);
    }
    private ZonedDateTimeDeserializer(Class<ZonedDateTime> vc) {
        super(vc);
    }
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        return ZonedDateTime.parse(jsonParser.getText(), formatter ) ;
    }

}
