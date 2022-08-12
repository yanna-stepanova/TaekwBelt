//a class explains some exercise

package com.example.taekwbelt.models;

import org.json.JSONException;
import org.json.JSONObject;

public class UBGradingPattern  extends UBBaseID{
    private String name;
    private int movements;
    private String meaning;
    private String videoLink; // A link to the video showcasing how to perform actions in the pattern

    public UBGradingPattern() {
        super();
    }

    public UBGradingPattern(String identifier, String name, int movements, String meaning, String videoLink) {
        super(identifier);
        this.name = name;
        this.movements = movements;
        this.meaning = meaning;
        this.videoLink = videoLink;
    }

    // Initializes an instance of grading pattern with the data retrieved from JSON object
    public UBGradingPattern(JSONObject jsObj) throws JSONException {
        super();
        this.setIdentifier(jsObj.getString("id"));
        this.setName(jsObj.getString("name"));
        this.setMovements(jsObj.getInt("movements"));
        this.setMeaning(jsObj.getString("meaning"));
        this.setVideoLink(jsObj.getString("videoLink"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovements() {
        return movements;
    }

    public void setMovements(int movements) {
        this.movements = movements;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    @Override
    public String toString() {
        return "\n\t\t  UBGradingPattern{" +
                "\n\t\t\tidentifier='" + getIdentifier() + '\'' +
                ",\n\t\t\tname='" + getName() + '\'' +
                ",\n\t\t\tmovements=" + getMovements() +
                ",\n\t\t\tmeaning='" + getMeaning() + '\'' +
                ",\n\t\t\tvideoLink='" + getVideoLink() + '\'' +
                '}';
    }
}
