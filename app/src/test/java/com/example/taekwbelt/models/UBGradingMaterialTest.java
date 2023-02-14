package com.example.taekwbelt.models;

import static org.junit.Assert.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class UBGradingMaterialTest {
    private UBGradingMaterial expectedObject;
    private String textJson;

    //initialization an object and some json-text for the testing
    @Before
    public void setUp() {
        expectedObject = new UBGradingMaterial("0",
                new ArrayList<UBGradingItem>() {
                    {
                        add(new UBGradingItem("0", "10th kup - White Belt",
                                new ArrayList<UBGradingRequirement>(){
                                    {
                                        add(new UBGradingRequirement("0", "Parallel Stance (Narani Sogi), Middle Punch (x10)", null, null));
                                        add(new UBGradingRequirement("1", "Front Rising Kick", null, null));
                                    }
                                },
                                new ArrayList<UBGradingPattern>(){
                                    {
                                        add(new UBGradingPattern("0", "Saju Jirugi, Four Directional Punch", 14, "This pattern is a basic set of fundamental movements learned by the begginer student of Taekwon-Do.", "https://youtu.be/-jU-6897y9U"));
                                        add(new UBGradingPattern("1", "Saju Maki, Four Directional Block", 16, "This pattern is a basic set of fundamental movements learned by the begginer student of Taekwon-Do.", "https://youtu.be/nO9EmLaxbAA"));
                                    }
                                },
                                new ArrayList<UBTerminologyItem>(){
                                    {
                                        add(new UBTerminologyItem("0", "Training Hall", "Dojang"));
                                        add(new UBTerminologyItem("1", "Bow", "Kyong Ye"));
                                    }
                                },
                                "white-belt.png"));
                        add(new UBGradingItem("1", "9th kup - Yellow Tag",
                                new ArrayList<UBGradingRequirement>() {
                                    {
                                        add(new UBGradingRequirement("0", "Chon-Ji Tul", "0", null));
                                        add(new UBGradingRequirement("1", "Press Ups (x10)", null, null));
                                    }
                                },
                                new ArrayList<UBGradingPattern>() {
                                    {
                                        add(new UBGradingPattern("0", "Chon-Ji Tul", 19, "Chon-Ji literally means 'The Heaven the Earth'. It is interpreted as the creation of the world or the beginning of human history, therefore, it is the initial pattern performed by the beginner. This pattern consists of two similar parts: one part represents the Heaven and the other - the Earth.", "https://youtu.be/bNUla5J8qEg?list=PL222664842EEDE4DE"));
                                    }
                                },
                                new ArrayList<UBTerminologyItem>(){
                                    {
                                        add(new UBTerminologyItem("0", "Elbow", "Palkup"));
                                        add(new UBTerminologyItem("1", "Footsword", "Balkal"));
                                    }
                                },
                                "yellow-tag.png"));
                    }
                },
                new ArrayList<UBGradingItem>(){
                    {
                        add(new UBGradingItem("0", "1st Degree - Black Belt",
                                new ArrayList<UBGradingRequirement>() {
                                    {
                                        add(new UBGradingRequirement("0", "Kwang-Gae Tul", "0", null));
                                        add(new UBGradingRequirement("1", "Po-Eun Tul", "1", null));
                                    }
                                },
                                new ArrayList<UBGradingPattern>(){
                                    {
                                        add(new UBGradingPattern("0", "Kwang-Gae Tul", 39, "Kwang-Gae is named after the famous Kwang-Gae-Toh-Wang, the 19th King of the Koguryo Dynasty, who regained all the lost territories including the greater part of Manchuria. The diagram represents the expansion and recovery of lost territory. The 39 movements refer to the first two figures of 391 A. D., the year he came to the throne.", "https://youtu.be/9QcmRQWUxao"));
                                        add(new UBGradingPattern("1", "Po-Eun Tul", 36, "Po-Eun is the pseudonym of a loyal subject Chong Mong-Chu (1400) who was a famous poet and whose poem 'I would not serve a second master though I might be crucified a hundred times' is known to every Korean. He was also a pioneer in the field of physics. The diagram represents his unerring loyalty to the king and country towards the end of the Koryo Dynasty.", "https://youtu.be/_AYUC_Xjdrs"));
                                        add(new UBGradingPattern("2", "Ge-Baek Tul", 44, "Ge-Baek is named after Ge-Baek, a great general in the Baek Je Dynasty (660 AD). The diagram represents his severe and strict military discipline.", "https://youtu.be/s3BvnSCtJg8"));
                                    }
                                },
                                new ArrayList<UBTerminologyItem>() {
                                    {
                                        add(new UBTerminologyItem("0", "Pressing Kick", "Noollo Chagi"));
                                        add(new UBTerminologyItem("1", "Downward Side Fist Strike", "Naeryo Yop Joomuk Taerigi"));
                                        add(new UBTerminologyItem("2", "Back Elbow Thrust", "Dwit Palkup Tulgi"));
                                    }
                                },
                                 "black-belt-1.png"));
                    }
                }
        );

        // Setting up JSON string
        textJson = "{\"id\": \"0\"," +
                "    \"colorBelts\": [" +
                "                   {\"id\": \"0\", \"grade\": \"10th kup - White Belt\"," +
                "                   \"iconName\": \"white-belt.png\"," +
                "                   \"requirements\": [" +
                "                       {\"id\":\"0\",\"name\":\"Parallel Stance (Narani Sogi), Middle Punch (x10)\", \"patternId\":null, \"description\": null}," +
                "                       {\"id\":\"1\",\"name\":\"Front Rising Kick\", \"patternId\":null, \"description\": null}" +
                "                       ]," +
                "                   \"patterns\": [" +
                "                                {\"id\": \"0\"," +
                "                                \"name\": \"Saju Jirugi, Four Directional Punch\"," +
                "                                \"movements\": 14," +
                "                                \"meaning\": \"This pattern is a basic set of fundamental movements learned by the begginer student of Taekwon-Do.\"," +
                "                                \"videoLink\":\"https://youtu.be/-jU-6897y9U\"" +
                "                                }," +
                "                                {\"id\": \"1\"," +
                "                                \"name\": \"Saju Maki, Four Directional Block\"," +
                "                                \"movements\": 16," +
                "                                \"meaning\": \"This pattern is a basic set of fundamental movements learned by the begginer student of Taekwon-Do.\"," +
                "                                \"videoLink\":\"https://youtu.be/nO9EmLaxbAA\"}" +
                "                                ]," +
                "                   \"terminology\": [" +
                "                                   {\"id\": \"0\", \"English\": \"Training Hall\",\"Korean\": \"Dojang\"}," +
                "                                   {\"id\": \"1\", \"English\": \"Bow\",\"Korean\": \"Kyong Ye\"}" +
                "                                   ]" +
                "                   }," +
                "                   {\"id\": \"1\", \"grade\": \"9th kup - Yellow Tag\"," +
                "                   \"iconName\": \"yellow-tag.png\"," +
                "                   \"requirements\": [" +
                "                       {\"id\":\"0\", \"name\": \"Chon-Ji Tul\", \"patternId\":\"0\", \"description\": null}," +
                "                       {\"id\":\"1\", \"name\": \"Press Ups (x10)\", \"patternId\":null, \"description\": null}" +
                "                       ]," +
                "                   \"patterns\": [" +
                "                                {\"id\": \"0\", \"name\": \"Chon-Ji Tul\",\"movements\": 19," +
                "                                \"meaning\": \"Chon-Ji literally means 'The Heaven the Earth'. It is interpreted as the creation of the world or the beginning of human history, therefore, it is the initial pattern performed by the beginner. This pattern consists of two similar parts: one part represents the Heaven and the other - the Earth.\"," +
                "                                \"videoLink\":\"https://youtu.be/bNUla5J8qEg?list=PL222664842EEDE4DE\"}" +
                "                                ]," +
                "                   \"terminology\": [" +
                "                                   {\"id\": \"0\", \"English\": \"Elbow\", \"Korean\": \"Palkup\"}," +
                "                                   {\"id\": \"1\", \"English\": \"Footsword\", \"Korean\": \"Balkal\"}" +
                "                                   ]" +
                "                   }" +
                "                  ]," +
                "\"blackBelts\":[" +
                "                  {\"id\": \"0\", \"grade\": \"1st Degree - Black Belt\"," +
                "                  \"iconName\": \"black-belt-1.png\"," +
                "                  \"requirements\": [" +
                "                      {\"id\":\"0\", \"name\":\"Kwang-Gae Tul\", \"patternId\":\"0\", \"description\":null}," +
                "                      {\"id\":\"1\", \"name\":\"Po-Eun Tul\", \"patternId\":\"1\", \"description\":null}" +
                "                      ]," +
                "                  \"patterns\": [" +
                "                               {\"id\": \"0\", \"name\": \"Kwang-Gae Tul\", \"movements\": 39," +
                "                               \"meaning\": \"Kwang-Gae is named after the famous Kwang-Gae-Toh-Wang, the 19th King of the Koguryo Dynasty, who regained all the lost territories including the greater part of Manchuria. The diagram represents the expansion and recovery of lost territory. The 39 movements refer to the first two figures of 391 A. D., the year he came to the throne.\"," +
                "                               \"videoLink\":\"https://youtu.be/9QcmRQWUxao\"" +
                "                               }," +
                "                               {\"id\": \"1\", \"name\": \"Po-Eun Tul\", \"movements\": 36," +
                "                               \"meaning\": \"Po-Eun is the pseudonym of a loyal subject Chong Mong-Chu (1400) who was a famous poet and whose poem 'I would not serve a second master though I might be crucified a hundred times' is known to every Korean. He was also a pioneer in the field of physics. The diagram represents his unerring loyalty to the king and country towards the end of the Koryo Dynasty.\"," +
                "                               \"videoLink\":\"https://youtu.be/_AYUC_Xjdrs\"" +
                "                               }," +
                "                               {\"id\": \"2\", \"name\": \"Ge-Baek Tul\", \"movements\": 44," +
                "                               \"meaning\": \"Ge-Baek is named after Ge-Baek, a great general in the Baek Je Dynasty (660 AD). The diagram represents his severe and strict military discipline.\"," +
                "                               \"videoLink\":\"https://youtu.be/s3BvnSCtJg8\"}" +
                "                              ]," +
                "                  \"terminology\": [{\"id\": \"0\", \"English\": \"Pressing Kick\", \"Korean\": \"Noollo Chagi\"}," +
                "                                  {\"id\": \"1\", \"English\": \"Downward Side Fist Strike\", \"Korean\": \"Naeryo Yop Joomuk Taerigi\"}," +
                "                                  {\"id\": \"2\", \"English\": \"Back Elbow Thrust\", \"Korean\": \"Dwit Palkup Tulgi\"}]" +
                "               }]" +
                "}";
    }

    // Verifying if the content of the fields of the object that we receive
    // after we parse a JSON-string corresponds to the ones of what we expect them to be
    @Test
    public void fillFromJsonTest() throws JSONException {
        JSONObject jsonObject = new JSONObject(textJson);
        UBGradingMaterial actualObject = new UBGradingMaterial(jsonObject);
        assertEquals(expectedObject.getIdentifier(), actualObject.getIdentifier());
        compareBelts(expectedObject.getColorBelts(), actualObject.getColorBelts());
        compareBelts(expectedObject.getBlackBelts(), actualObject.getBlackBelts());
        }

    public void compareBelts(ArrayList<UBGradingItem> expectedBelts, ArrayList<UBGradingItem> actualBelts) {
        if (expectedBelts.size() == actualBelts.size()) {
            for (int k =0; k < actualBelts.size(); k++) {
                assertEquals(expectedBelts.get(k).getIdentifier(), actualBelts.get(k).getIdentifier());
                assertEquals(expectedBelts.get(k).getGrade(), actualBelts.get(k).getGrade());
                assertEquals(expectedBelts.get(k).getIconName(), actualBelts.get(k).getIconName());

                if (expectedBelts.get(k).getRequirements().size() == actualBelts.get(k).getRequirements().size()) {
                    for (int i = 0; i < actualBelts.get(k).getRequirements().size(); i++) {
                        UBGradingRequirement expectedReq = expectedBelts.get(k).getRequirements().get(i); //reduce text length for better readability
                        UBGradingRequirement actualReq = actualBelts.get(k).getRequirements().get(i);     //reduce text length for better readability

                        assertEquals(expectedReq.getIdentifier(), actualReq.getIdentifier());
                        assertEquals(expectedReq.getName(), actualReq.getName());
                        assertEquals(expectedReq.getPatternId(), actualReq.getPatternId());
                        assertEquals(expectedReq.getDescription(), actualReq.getDescription());
                    }
                }

                if (expectedBelts.get(k).getGradingPatterns().size() == actualBelts.get(k).getGradingPatterns().size()) {
                    for (int i = 0; i < actualBelts.get(k).getGradingPatterns().size(); i++) {
                        UBGradingPattern expectedPattern = expectedBelts.get(k).getGradingPatterns().get(i); //reduce text length for better readability
                        UBGradingPattern actualPattern = actualBelts.get(k).getGradingPatterns().get(i);     //reduce text length for better readability

                        assertEquals(expectedPattern.getIdentifier(), actualPattern.getIdentifier());
                        assertEquals(expectedPattern.getName(), actualPattern.getName());
                        assertEquals(expectedPattern.getMovements(), actualPattern.getMovements());
                        assertEquals(expectedPattern.getMeaning(), actualPattern.getMeaning());
                        assertEquals(expectedPattern.getVideoLink(), actualPattern.getVideoLink());
                    }
                }

                if (expectedBelts.get(k).getTerminologies().size() == actualBelts.get(k).getTerminologies().size()) {
                    for (int i = 0; i < actualBelts.get(k).getTerminologies().size(); i++) {
                        UBTerminologyItem expectedTermin = expectedBelts.get(k).getTerminologies().get(i); //reduce text length for better readability
                        UBTerminologyItem actualTermin = actualBelts.get(k).getTerminologies().get(i);     //reduce text length for better readability

                        assertEquals(expectedTermin.getIdentifier(), actualTermin.getIdentifier());
                        assertEquals(expectedTermin.getEnglish(), actualTermin.getEnglish());
                        assertEquals(expectedTermin.getKorean(), actualTermin.getKorean());
                    }
                }
            }
        }
    }
}


