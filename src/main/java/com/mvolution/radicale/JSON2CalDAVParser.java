package com.mvolution.radicale;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// class for parsing incoming JSON-data in an .ics-calendar format
public class JSON2CalDAVParser {
    // object for logging the events of this class
    private final Logger LOG = LoggerFactory.getLogger(BaseCaldavClient.class);
    // declaring a instance variable that references the path to the json-file
    private String jsonFilePath;
    // declaring a instance variable that should hold the content of the json-file as String
    private String jsonContent;
    // declaring a JSONObject
    private JSONObject jsonObject;

    // empty constructor
    JSON2CalDAVParser(){}

    /*constructor
    * @param jsonFilePath - path to the desired json-file*/
    JSON2CalDAVParser(String jsonFilePath) {
        try {
            // instantiate the path to the json-file
            this.jsonFilePath = jsonFilePath;
            // instantiate the content-String by reading the file from the given path
            this.jsonContent = new String((Files.readAllBytes(Paths.get(jsonFilePath))));
            // instantiate the JSONObject by using the content-String as parameter
            this.jsonObject = new JSONObject(jsonContent);
        } catch (IOException e) {e.printStackTrace();}

    }

    // method for printing the json-content String
    public void printJSONFile() {
        LOG.info(jsonContent);
    }

    /* method that returns the corresponding value of our jsonObject
    * @param key - that key references to a value*/
    public String getJSONContent(String key){
        return (String)jsonObject.get(key);
    }

    public String getJsonFilePath() {
        return jsonFilePath;
    }

    public void setJsonFilePath(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }
}
