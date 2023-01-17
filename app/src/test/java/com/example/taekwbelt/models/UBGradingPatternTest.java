package com.example.taekwbelt.models;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;


public class UBGradingPatternTest {
    private UBGradingPattern expectedObject;
    private String textJson;

    //initialization an object and some json-text for the testing
    @Before
    public void setUp() {
        expectedObject = new UBGradingPattern("0", "Hwa-Rang Tul", 29,
                "Hwa-Rang is named after the Hwa-Rang youth group, which originated in the Silla dynasty about 1350 years ago (early 7th century). The 29 movements refer to the 29th infantry division, where Taekwon-Do developed into maturity.",
                "https://youtu.be/Eo765RRvkKU");
        textJson = "{\"id\":\"0\", \"name\":\"Hwa-Rang Tul\", \"movements\": 29, " +
                   "\"meaning\": \"Hwa-Rang is named after the Hwa-Rang youth group, which originated in the Silla dynasty about 1350 years ago (early 7th century). The 29 movements refer to the 29th infantry division, where Taekwon-Do developed into maturity.\", " +
                   "\"videoLink\":\"https://youtu.be/Eo765RRvkKU\"}";
    }

    // Verifying if the content of the fields of the object that we receive
    // after we parse a JSON-string corresponds to the ones of what we expect them to be
    @Test
    public void fillFromJsonTest() throws JSONException {
        JSONObject jsonObject = new JSONObject(textJson);
        UBGradingPattern actualObject = new UBGradingPattern(jsonObject);
        assertEquals(expectedObject.getIdentifier(), actualObject.getIdentifier());
        assertEquals(expectedObject.getName(), actualObject.getName());
        assertEquals(expectedObject.getMovements(), actualObject.getMovements());
        assertEquals(expectedObject.getMeaning(), actualObject.getMeaning());
        assertEquals(expectedObject.getVideoLink(), actualObject.getVideoLink());
    }
}