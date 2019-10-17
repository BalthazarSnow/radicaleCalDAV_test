package com.mvolution.radicale.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/** A class to deserialize metaplanner events from JSON-Format
 * @author - Marco Fiedler.
 * {@link net.fortuna.ical4j}*/
public class JsonEntityFactory {

    /**A static method to deserialize a metaplanner event from a JSON source.*/
    public static TypedEntity deserialize(String jsonSource) throws IOException {

        return new ObjectMapper().readValue( JsonEntityFactory.class.getResourceAsStream(jsonSource), TypedEntity.class);
    }
}
