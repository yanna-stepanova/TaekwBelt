package com.example.taekwbelt.models;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class UBGradingRequirementTest {
    private UBGradingRequirement expectedObject;
    private String textJson;

    //initialization an object and some json-text for the testing
    @Before
    public void setUp() {
        expectedObject = new UBGradingRequirement("1", "Moon-Moo Tul","1","null");
        textJson = "{\"id\":\"1\", \"name\":\"Moon-Moo Tul\", \"patternId\":\"1\", \"description\":\"null\"}";
    }

    // Verifying if the content of the fields of the object that we receive
    // after we parse a JSON-string corresponds to the ones of what we expect them to be
    @Test
    public void EqualFieldsTest() throws JSONException {
        JSONObject jsonObject = new JSONObject(textJson);
        UBGradingRequirement actualObject = new UBGradingRequirement(jsonObject);
        assertEquals(expectedObject.getIdentifier(), actualObject.getIdentifier());
        assertEquals(expectedObject.getName(), actualObject.getName());
        assertEquals(expectedObject.getPatternId(), actualObject.getPatternId());
        assertEquals(expectedObject.getDescription(), actualObject.getDescription());
    }

    //??? Could the expectedObject be created (and actualObject)?
    // because 'identifier' is null!
    @Test
    public void allFieldsNullTest() throws JSONException {
        expectedObject = new UBGradingRequirement("null", "null","","  ");
        textJson = "{\"id\":\"null\", \"name\":\"null\", \"patternId\":\"\", \"description\":\"  \"}";
        JSONObject jsonObject = new JSONObject(textJson);
        UBGradingRequirement actualObject = new UBGradingRequirement(jsonObject);
        assertEquals(expectedObject.getIdentifier(), actualObject.getIdentifier());
        assertEquals(expectedObject.getName(), actualObject.getName());
        assertEquals(expectedObject.getPatternId(), actualObject.getPatternId());
        assertEquals(expectedObject.getDescription(), actualObject.getDescription());
        System.out.println(expectedObject.toString());
        System.out.println(actualObject.toString());
    }
    // Check that identifier is correct, i.e. not null and not empty
    @Test
    public void validIdentifierTest() throws JSONException {
        JSONObject jsonObject = new JSONObject(textJson);
        UBGradingRequirement actualObject = new UBGradingRequirement(jsonObject);
        NotEmptyTest(actualObject.getIdentifier());
    }

    private void NotEmptyTest(String testString) {
        assertNotNull(testString);
        assertNotEquals(testString,"");
        assertNotEquals(testString," ");
    }
}