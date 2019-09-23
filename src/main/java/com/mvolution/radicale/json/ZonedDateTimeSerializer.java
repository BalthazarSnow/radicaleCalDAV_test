package com.mvolution.radicale.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class ZonedDateTimeSerializer extends StdSerializer<ZonedDateTime> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    static {
        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
    @SuppressWarnings("unused")
    public ZonedDateTimeSerializer() {
        this(null);
    }
    private ZonedDateTimeSerializer(Class<ZonedDateTime> t) {
        super(t);
    }
    @Override
    public void serialize(ZonedDateTime date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(DATE_FORMAT.format(date));
    }

}
