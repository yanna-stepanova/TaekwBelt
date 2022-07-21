//a class describes what needs to know to reach some level

package com.example.taekwbelt.models;

public class UBGradingRequirement  extends UBBaseID{
    private String name;
    private String patternId;
    private String description;

    public UBGradingRequirement() {
        super();
    }

    public UBGradingRequirement(String identifier, String name, String patternId, String description) {
        super(identifier);
        this.name = name;
        this.patternId = patternId;
        this.description = description;
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
}
