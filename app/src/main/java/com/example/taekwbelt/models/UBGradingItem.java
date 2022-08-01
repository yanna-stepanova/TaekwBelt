// An object that describes learning material for a particular grade

package com.example.taekwbelt.models;

import java.util.ArrayList;

public class UBGradingItem extends UBBaseID {
    private String grade;
    private ArrayList<UBGradingRequirement> requirements; // an array of UBGradingRequirement - can be Null/empty
    private ArrayList<UBGradingPattern> gradingPatterns; // an array of UBGradingPattern - can be Null/empty
    private ArrayList<UBTerminologyItem> terminology; // an array of UBTerminologyItem - can be Null/empty
    private String iconName; // can't be Null/empty

    public UBGradingItem() {
        super();
        // build an empty array list
        this.requirements = new ArrayList<UBGradingRequirement>();
        this.gradingPatterns = new ArrayList<UBGradingPattern>();
        this.terminology = new ArrayList<UBTerminologyItem>();
    }

    public UBGradingItem(String identifier, String grade, ArrayList<UBGradingRequirement> requirements, ArrayList<UBGradingPattern> gradingPatterns, ArrayList<UBTerminologyItem> terminology, String iconName) {
        super(identifier);
        this.grade = grade;
        this.requirements = requirements;
        this.gradingPatterns = gradingPatterns;
        this.terminology = terminology;
        this.iconName = iconName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public ArrayList<UBGradingRequirement> getRequirements() {
        return requirements;
    }

    //adding objects to ArrayList
    public void setRequirements(UBGradingRequirement objRequir) {
        this.requirements.add(new UBGradingRequirement(objRequir.getIdentifier(),
                                                       objRequir.getName(),
                                                       objRequir.getPatternId(),
                                                       objRequir.getDescription()));
    }

    public ArrayList<UBGradingPattern> getGradingPatterns() {
        return gradingPatterns;
    }

    //adding objects to ArrayList
    public void setGradingPatterns(UBGradingPattern objPattern) {
        this.gradingPatterns.add(new UBGradingPattern(objPattern.getIdentifier(),
                                                      objPattern.getName(),
                                                      objPattern.getMovements(),
                                                      objPattern.getMeaning(),
                                                      objPattern.getVideoLink()));
    }

    public ArrayList<UBTerminologyItem> getTerminology() {
        return terminology;
    }

    //adding objects to ArrayList
    public void setTerminology(UBTerminologyItem objTerm) {
        terminology.add(new UBTerminologyItem(objTerm.getIdentifier(),
                                              objTerm.getEnglish(),
                                              objTerm.getKorean()));
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        try{
            if (iconName.isEmpty() || iconName == null)
                throw new Exception("IconName can't be Null or empty!");
            else this.iconName = iconName;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
