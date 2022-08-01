//the class is a vocabulary of taekwondo

package com.example.taekwbelt.models;

public class UBTerminologyItem extends UBBaseID {
    private String english; // An English word for an object (for a punch, kick, action, etc.)
    private String korean;

    public UBTerminologyItem() {
        super();
    }

    public UBTerminologyItem(String identifier, String english, String korean) {
        super(identifier);
        this.english = english;
        this.korean = korean;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getKorean() {
        return korean;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }
}
