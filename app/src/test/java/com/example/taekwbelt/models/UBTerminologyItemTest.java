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

    @Test
    public void testFillFromJson() throws JSONException {
        JSONObject jsonObject = new JSONObject(textJson);
        UBTerminologyItem actualObject = new UBTerminologyItem(jsonObject);
        assertEquals(expectedObject.getIdentifier(), actualObject.getIdentifier());
        assertEquals(expectedObject.getEnglish(), actualObject.getEnglish());
        assertEquals(expectedObject.getKorean(), actualObject.getKorean());
    }

    @Test
    public void testDataCorrectness() throws JSONException {
        JSONObject jsonObject = new JSONObject(textJson);
        UBTerminologyItem actualObject = new UBTerminologyItem(jsonObject);

        // We decided to check all fields for correctness to ensure that we get
        // correct data in our app from the beginning rather then validating all the time inside the UI

        // Check that identifier is correct, i.e. not null and not empty
        testNotEmpty(actualObject.getIdentifier());

        // Check that english field is correct...
        // Is it right? Compare with what???
        testNotEmpty(actualObject.getEnglish()); //it's wrong!?

        // Check that korean field is correct...
        // Is it right? Compare with what???
        testNotEmpty(actualObject.getKorean()); //it's wrong!?
    }

    private void testNotEmpty(String testString) {
        assertNotNull(testString);
        assertNotEquals(testString,"");
        assertNotEquals(testString," ");
    }

}