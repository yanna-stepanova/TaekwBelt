//a class describes what students need to learn to reach a particular level (grade)

package com.example.taekwbelt.models;

import org.json.JSONException;
import org.json.JSONObject;

public class UBGradingRequirement  extends UBBaseID{
    private String name; // The name of the requirement
    private String patternId; // An identifier of an object of the pattern associated the requirement
    private String description; // A description of the requirement

    public UBGradingRequirement() {
        super();
    }

    public UBGradingRequirement(String identifier, String name, String patternId, String description) {
        super(identifier);
        this.name = name;
        this.patternId = patternId;
        this.description = description;
    }

    // Initializes an instance of grading requirement with the data retrieved from JSON object
    public  UBGradingRequirement(JSONObject jsObj) throws JSONException {
        super();
        this.setIdentifier(jsObj.getString("id"));
        this.setName(jsObj.getString("name"));
        this.setPatternId(jsObj.getString("patternId"));
        this.setDescription(jsObj.getString("description"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatternId() {
        return patternId;
    }

    public void setPatternId(String patternId) {
        this.patternId = patternId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n\t\t  UBGradingRequirement{" +
                "\n\t\t\tidentifier='" + getIdentifier() + '\'' +
                ",\n\t\t\tname='" + getName() + '\'' +
                ",\n\t\t\tpatternId='" + getPatternId() + '\'' +
                ",\n\t\t\tdescription='" + getDescription() + '\'' +
                '}';
    }
}
