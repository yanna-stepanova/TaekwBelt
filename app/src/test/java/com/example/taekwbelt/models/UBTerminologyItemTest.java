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

    // Checking whether we receive data in a correct format
    @Test
    public void dataValidationTest() throws JSONException {
        JSONObject jsonObject = new JSONObject(textJson);
        UBTerminologyItem actualObject = new UBTerminologyItem(jsonObject);

        // We decided to check all fields for correctness to ensure that we get
        // correct data in our app from the beginning rather then validating all the time inside the UI

        // Check that identifier is correct, i.e. not null and not empty
        notEmpty(actualObject.getIdentifier());
    }

    // Method that checks whether an input string is not null or empty
    private void notEmpty(String testString) {
        assertNotNull(testString);
        assertNotEquals(testString,"");
        assertNotEquals(testString," ");
    }

}