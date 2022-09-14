package com.example.taekwbelt.models;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class UBTerminologyItemTest {
    @Test
    public void testFillFromJson() throws JSONException {
        UBTerminologyItem expectedObject = new UBTerminologyItem("0",
                                                                 "Training Hall",
                                                                 "Dojang");
        String textJson = "{ \"id\": \"0\",\n \"English\": \"Training Hall\",\n \"Korean\": \"Dojang\"}";
        JSONObject jsonObject = new JSONObject(textJson);
        UBTerminologyItem actualObject = new UBTerminologyItem(jsonObject);
        assertEquals(expectedObject.getIdentifier(), actualObject.getIdentifier());
        assertEquals(expectedObject.getEnglish(), actualObject.getEnglish());
        assertEquals(expectedObject.getKorean(), actualObject.getKorean());
    }

    @Test
    public void testIdNull() {
        UBTerminologyItem testObject = new UBTerminologyItem();
        testObject.setIdentifier(null);
        assertNull(testObject.getIdentifier());
    }

    @Test
    public void testIdEmpty() {
        UBTerminologyItem testObject = new UBTerminologyItem("", "eng_text", "kor_text");
        assertNull(testObject.getIdentifier());
    }

    @Test
    public void testIdNotNull(){
        UBTerminologyItem testObject = new UBTerminologyItem();
        testObject.setIdentifier("001");
        assertNotNull(testObject.getIdentifier());
    }
}