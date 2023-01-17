package com.example.taekwbelt.models;

import static org.junit.Assert.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class UBTerminologyItemTest {
    private UBTerminologyItem expectedObject;
    private String textJson;

    //initialization an object and some json-text for the testing
    @Before
    public void setUp() throws JSONException {
        expectedObject = new UBTerminologyItem("0",
                "Training Hall",
                "Dojang");
        textJson = "{ \"id\": \"0\",\n \"English\": \"Training Hall\",\n \"Korean\": \"Dojang\"}";

    }

    // Verifying if content of the fields of the object that we receive
    // after we parse a JSON string corresponds to the ones of what we expect them to be
    @Test
    public void fillFromJsonTest() throws JSONException {
        JSONObject jsonObject = new JSONObject(textJson);
        UBTerminologyItem actualObject = new UBTerminologyItem(jsonObject);
        assertEquals(expectedObject.getIdentifier(), actualObject.getIdentifier());
        assertEquals(expectedObject.getEnglish(), actualObject.getEnglish());
        assertEquals(expectedObject.getKorean(), actualObject.getKorean());
    }
}