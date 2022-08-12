// An object that describes learning material for a particular grade

package com.example.taekwbelt.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UBGradingItem extends UBBaseID {
    private String grade; // The name of the grade
    private ArrayList<UBGradingRequirement> requirements; // A list of requirements needed to complete in order to pass grading
    private ArrayList<UBGradingPattern> gradingPatterns; // A list of patterns associated with the grade
    private ArrayList<UBTerminologyItem> terminology; // A list of terminology associated with the grade
    private String iconName; // The name of the icon representing the grade

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

    // Initializes an instance of grading item with the date retrieved from JSON object
    public UBGradingItem(JSONObject jsObj) throws JSONException {
        super();
        // build an empty array list
        this.requirements = new ArrayList<UBGradingRequirement>();
        this.gradingPatterns = new ArrayList<UBGradingPattern>();
        this.terminology = new ArrayList<UBTerminologyItem>();

        // fill arrays with data from json
        this.parseJson(jsObj);
    }
    // fill fields of UBGradingItem from JSON object
    private void parseJson(JSONObject jsObj) throws JSONException {
        this.setIdentifier(jsObj.getString("id"));
        this.setGrade(jsObj.getString("grade"));
        this.setIconName(jsObj.getString("iconName"));

        //creating a loop to get a data of requirements
        JSONArray jsArrRequirement = jsObj.getJSONArray("requirements");
        for (int k = 0; k < jsArrRequirement.length(); k++ )
        {
            JSONObject jsObjRequirement = jsArrRequirement.getJSONObject(k);
            UBGradingRequirement objReq = new UBGradingRequirement(jsObjRequirement);
            this.setRequirements(objReq);
        }

        //creating for reading list of patterns
        JSONArray jsArrPattern = jsObj.getJSONArray("patterns");
        for (int l = 0; l < jsArrPattern.length(); l++)
        {
            JSONObject jsObjPattern = jsArrPattern.getJSONObject(l);
            UBGradingPattern objPat = new UBGradingPattern(jsObjPattern);
            this.setGradingPatterns(objPat);
        }

        //creating for reading list of terminologies
        JSONArray jsArrTerminology = jsObj.getJSONArray("terminology");
        for (int m = 0; m < jsArrTerminology.length(); m++)
        {
            JSONObject jsObjTermin = jsArrTerminology.getJSONObject(m);
            UBTerminologyItem objTermin = new UBTerminologyItem(jsObjTermin);
            this.setTerminology(objTermin);
        }
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

    @Override
    public String toString() {
        return "\n\t UBGradingItem{\n" +
                "\t\tidentifier='" + getIdentifier() + '\'' +
                ", \n\t\tgrade='" + getGrade() + '\'' +
                ", \n\t\trequirements:" + getRequirements().toString() +
                ", \n\t\tgradingPatterns:" + getGradingPatterns().toString() +
                ", \n\t\tterminology:" + getTerminology().toString() +
                ", \n\t\ticonName='" + getIconName() + '\'' +
                '}';
    }
}
