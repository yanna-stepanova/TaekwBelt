package com.example.taekwbelt.models;

import static org.junit.Assert.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class UBGradingItemTest {
    private UBGradingItem expectedObject;
    private String textJson;

    //initialization an object and some json-text for the testing
    @Before
    public void setUp() {
        expectedObject = new UBGradingItem("3","4th Degree - Black Belt",
                new ArrayList<UBGradingRequirement>() {
                    {
                        add(new UBGradingRequirement("0", "UL-Ji Tul", "0", null));
                        add(new UBGradingRequirement("1", "Moon-Moo Tul", "1", null));
                    }
                },
                new ArrayList<UBGradingPattern>() {
                    {
                        add(new UBGradingPattern("0","UL-Ji Tul",42,"UL- JI is named after general Ul-Ji Moon Dok who successfully defended Korea against a Tang's invasion force of nearly one million soldiers led by Yang Je in 612 A.D., Ul-Ji employing hit and run guerilla tactics, was able to decimate a large percentage of the force. The diagram represents his surname. The 42 movements represent the author's age when he designed the pattern. Continuous Motion - Yonsok Dongjak Moves 2 and 3. Fast Motion - Bbarun Dongjak move 11",
                                                 "https://youtu.be/GKMhqmzG1y8"));
                        add(new UBGradingPattern("1","Moon-Moo Tul",61,"Moon-Moo honours the 30th King of the Silla Dynasty. His body was buried near Dae Wang Am (Great King's Rock). According to his will, the body was placed in the sea 'where my soul shall forever defend my land against the Japanese.' It is said that the Sok Gul Am (Stone cave) was built to guard his tomb. The Sok Gul Am is a fine example of the culture of the Silla Dynasty. The 61 movements in this pattern symbolize the last two figures of 661 A.D. when Moon Moo came to the throne. Connecting Motion - Eeojin Dongjak moves 28 and 29, 37 and 38. Consecutive Motion - Gaesok Dongjak moves 50, 53. Slow Motion - Neurin Dongjak moves 1, 2, 5, 9, 10, 11, 14, 18, 20, 23",
                                                 "https://youtu.be/nnKNrv_sWRQ"));
                    }
                },
                new ArrayList<UBTerminologyItem>() {
                    {
                        add(new UBTerminologyItem("0","Twin side-fist horizontal strike","sang yop joomuk soopyong taerigi"));
                        add(new UBTerminologyItem("1","Flying high kick","Twimyo nopi chagi"));
                    }
                },
                "black-belt-4.png");

        textJson = "{" +
                "\"id\": \"3\",\"grade\": \"4th Degree - Black Belt\", \"iconName\": \"black-belt-4.png\"," +
                "\"requirements\": [" +
                "{\"id\":\"0\", \"name\":\"UL-Ji Tul\", \"patternId\":\"0\", \"description\":null}, " +
                "{\"id\":\"1\", \"name\":\"Moon-Moo Tul\", \"patternId\":\"1\", \"description\":null}," +
                "], " +
                "\"patterns\": [" +
                "{\"id\": \"0\", \"name\": \"UL-Ji Tul\", \"movements\": 42," +
                "\"meaning\": \"UL- JI is named after general Ul-Ji Moon Dok who successfully defended Korea against a Tang's invasion force of nearly one million soldiers led by Yang Je in 612 A.D., Ul-Ji employing hit and run guerilla tactics, was able to decimate a large percentage of the force. The diagram represents his surname. The 42 movements represent the author's age when he designed the pattern. Continuous Motion - Yonsok Dongjak Moves 2 and 3. Fast Motion - Bbarun Dongjak move 11\", " +
                "\"videoLink\":\"https://youtu.be/GKMhqmzG1y8\"}," +
                "{\"id\": \"1\", \"name\": \"Moon-Moo Tul\", \"movements\": 61," +
                "\"meaning\": \"Moon-Moo honours the 30th King of the Silla Dynasty. His body was buried near Dae Wang Am (Great King's Rock). According to his will, the body was placed in the sea 'where my soul shall forever defend my land against the Japanese.' It is said that the Sok Gul Am (Stone cave) was built to guard his tomb. The Sok Gul Am is a fine example of the culture of the Silla Dynasty. The 61 movements in this pattern symbolize the last two figures of 661 A.D. when Moon Moo came to the throne. Connecting Motion - Eeojin Dongjak moves 28 and 29, 37 and 38. Consecutive Motion - Gaesok Dongjak moves 50, 53. Slow Motion - Neurin Dongjak moves 1, 2, 5, 9, 10, 11, 14, 18, 20, 23\"," +
                "\"videoLink\":\"https://youtu.be/nnKNrv_sWRQ\"} ]," +
                "\"terminology\": [" +
                "{\"id\": \"0\", \"English\": \"Twin side-fist horizontal strike\"," +
                "\"Korean\": \"sang yop joomuk soopyong taerigi\"}," +
                "{\"id\": \"1\", \"English\": \"Flying high kick\"," +
                "\"Korean\": \"Twimyo nopi chagi\"}], " +
                "}";
    }

    // Verifying if the content of the fields of the object that we receive
    // after we parse a JSON-string corresponds to the ones of what we expect them to be
    @Test
    public void fillFromJsonTest() throws JSONException {
        JSONObject jsonObject = new JSONObject(textJson);
        UBGradingItem actualObject = new UBGradingItem(jsonObject);
        assertEquals(expectedObject.getIdentifier(), actualObject.getIdentifier());
        assertEquals(expectedObject.getGrade(), actualObject.getGrade());
        if (expectedObject.getGradingPatterns().size() == actualObject.getGradingPatterns().size()) {
            for (int i = 0; i < expectedObject.getGradingPatterns().size(); i++) {
                assertEquals(expectedObject.getGradingPatterns().get(i).getIdentifier(), actualObject.getGradingPatterns().get(i).getIdentifier());
                assertEquals(expectedObject.getGradingPatterns().get(i).getName(), actualObject.getGradingPatterns().get(i).getName());
                assertEquals(expectedObject.getGradingPatterns().get(i).getMovements(), actualObject.getGradingPatterns().get(i).getMovements());
                assertEquals(expectedObject.getGradingPatterns().get(i).getMeaning(), actualObject.getGradingPatterns().get(i).getMeaning());
                assertEquals(expectedObject.getGradingPatterns().get(i).getVideoLink(), actualObject.getGradingPatterns().get(i).getVideoLink());
            }
        }

        if (expectedObject.getRequirements().size() == actualObject.getRequirements().size()) {
            for (int i = 0; i < expectedObject.getRequirements().size(); i++) {
                assertEquals(expectedObject.getRequirements().get(i).getIdentifier(), actualObject.getRequirements().get(i).getIdentifier());
                assertEquals(expectedObject.getRequirements().get(i).getName(), actualObject.getRequirements().get(i).getName());
                assertEquals(expectedObject.getRequirements().get(i).getPatternId(), actualObject.getRequirements().get(i).getPatternId());
                assertEquals(expectedObject.getRequirements().get(i).getDescription(), actualObject.getRequirements().get(i).getDescription());
            }
        }

        if (expectedObject.getTerminology().size() == actualObject.getTerminology().size()) {
            for (int i = 0; i < actualObject.getTerminology().size(); i++) {
                assertEquals(expectedObject.getTerminology().get(i).getIdentifier(), actualObject.getTerminology().get(i).getIdentifier());
                assertEquals(expectedObject.getTerminology().get(i).getEnglish(), actualObject.getTerminology().get(i).getEnglish());
                assertEquals(expectedObject.getTerminology().get(i).getKorean(), actualObject.getTerminology().get(i).getKorean());
            }
        }

        assertEquals(expectedObject.getIconName(), actualObject.getIconName());
    }

}