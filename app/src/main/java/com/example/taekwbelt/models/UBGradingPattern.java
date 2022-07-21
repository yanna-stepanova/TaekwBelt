//a class explains some exercise

package com.example.taekwbelt.models;

public class UBGradingPattern  extends UBBaseID{
    private String name;
    private int movements;
    private String meaning;
    private String videoLink;

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
}
