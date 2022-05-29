package com.example.taekwbelt.models;

public class UBTerminologyItem {
    private String identifier;
    private String english;
    private String korean;

    public UBTerminologyItem() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        try{
            if (identifier.isEmpty() || identifier == null)
                throw new Exception("Identifier can't be Null or empty!");
            else this.identifier = identifier;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public UBTerminologyItem(String identifier, String english, String korean) {
        try{
            if (identifier.isEmpty() || identifier == null)
                throw new Exception("Identifier can't be Null or empty!");
            else this.identifier = identifier;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
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

    @Override
    public String toString() {
        return "\n\tUBTerminologyItem{" +
                "identifier='" + identifier + '\'' +
                ", english='" + english + '\'' +
                ", korean='" + korean +'\''+
                "}\n\t";
    }
}
