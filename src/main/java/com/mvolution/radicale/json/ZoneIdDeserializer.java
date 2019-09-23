package com.mvolution.radicale.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.ZoneId;

public class ZoneIdDeserializer extends StdDeserializer<ZoneId> {

    @SuppressWarnings("unused")
    public ZoneIdDeserializer() {
        this((JavaType) null);
    }
    protected ZoneIdDeserializer(Class<ZoneId> vc) {
        super(vc);
    }

    private ZoneIdDeserializer(JavaType valueType) {
        super(valueType);
    }

    private ZoneIdDeserializer(StdDeserializer<ZoneId> src) {
        super(src);
    }

    @Override
    public ZoneId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException{
        return ZoneId.of(jsonParser.getText());
    }
}
