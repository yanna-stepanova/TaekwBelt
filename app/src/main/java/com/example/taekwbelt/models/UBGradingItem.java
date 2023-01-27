// An object that describes learning material for a particular grade

package com.example.taekwbelt.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UBGradingItem extends UBBaseID {
    private String _grade; // The name of the grade
    private ArrayList<UBGradingRequirement> _requirements; // A list of requirements needed to complete in order to pass grading
    private ArrayList<UBGradingPattern> _gradingPatterns; // A list of patterns associated with the grade
    private ArrayList<UBTerminologyItem> _terminologies; // A list of terminology associated with the grade
    private String _iconName; // The name of the icon representing the grade

    public UBGradingItem() {
        super();
        // build an empty array list
        this._requirements = new ArrayList<UBGradingRequirement>();
        this._gradingPatterns = new ArrayList<UBGradingPattern>();
        this._terminologies = new ArrayList<UBTerminologyItem>();
    }

    public UBGradingItem(String identifier, String grade, ArrayList<UBGradingRequirement> requirements, ArrayList<UBGradingPattern> gradingPatterns, ArrayList<UBTerminologyItem> terminologies, String iconName) {
        super(identifier);
        this._grade = grade;
        this._requirements = requirements;
        this._gradingPatterns = gradingPatterns;
        this._terminologies = terminologies;
        this._iconName = iconName;
    }

    // Initializes an instance of grading item with the date retrieved from JSON object
    public UBGradingItem(JSONObject jsObj) throws JSONException {
        super();
        // build an empty array list
        this._requirements = new ArrayList<UBGradingRequirement>();
        this._gradingPatterns = new ArrayList<UBGradingPattern>();
        this._terminologies = new ArrayList<UBTerminologyItem>();

        // fill arrays with data from json
        this.parseJson(jsObj);
    }

    // fill fields of UBGradingItem from JSON object
    private void parseJson(JSONObject jsObj) throws JSONException {

        if (jsObj.has("id") && !jsObj.isNull("id")) {
            this.setIdentifier(jsObj.getString("id"));
        }

        if (jsObj.has("grade") && !jsObj.isNull("grade")) {
            this.setGrade(jsObj.getString("grade"));
        }

        if (jsObj.has("iconName") && !jsObj.isNull("iconName")) {
            this.setIconName(jsObj.getString("iconName"));
        }

        if (jsObj.has("requirements") && !jsObj.isNull("requirements")) {
            //creating a loop to get a data of requirements
            JSONArray jsArrRequirement = jsObj.getJSONArray("requirements");
            for (int k = 0; k < jsArrRequirement.length(); k++) {
                JSONObject jsObjRequirement = jsArrRequirement.getJSONObject(k);
                UBGradingRequirement objReq = new UBGradingRequirement(jsObjRequirement);
                this.setRequirements(objReq);
            }
        }

        if (jsObj.has("patterns") && !jsObj.isNull("patterns")) {
            //creating for reading list of patterns
            JSONArray jsArrPattern = jsObj.getJSONArray("patterns");
            for (int l = 0; l < jsArrPattern.length(); l++) {
                JSONObject jsObjPattern = jsArrPattern.getJSONObject(l);
                UBGradingPattern objPat = new UBGradingPattern(jsObjPattern);
                this.setGradingPatterns(objPat);
            }
        }

        if (jsObj.has("terminology") && !jsObj.isNull("terminology")) {
            //creating for reading list of terminologies
            JSONArray jsArrTerminology = jsObj.getJSONArray("terminology");
            for (int m = 0; m < jsArrTerminology.length(); m++) {
                JSONObject jsObjTermin = jsArrTerminology.getJSONObject(m);
                UBTerminologyItem objTermin = new UBTerminologyItem(jsObjTermin);
                this.setTerminology(objTermin);
            }
        }
    }

    public String getGrade() {
        return _grade;
    }

    public void setGrade(String grade) {
        this._grade = grade;
    }

    public ArrayList<UBGradingRequirement> getRequirements() {
        return _requirements;
    }

    //adding objects to ArrayList
    public void setRequirements(UBGradingRequirement objRequir) {
        this._requirements.add(new UBGradingRequirement(objRequir.getIdentifier(),
                                                       objRequir.getName(),
                                                       objRequir.getPatternId(),
                                                       objRequir.getDescription()));
    }

    public ArrayList<UBGradingPattern> getGradingPatterns() {
        return _gradingPatterns;
    }

    //adding objects to ArrayList
    public void setGradingPatterns(UBGradingPattern objPattern) {
        this._gradingPatterns.add(new UBGradingPattern(objPattern.getIdentifier(),
                                                      objPattern.getName(),
                                                      objPattern.getMovements(),
                                                      objPattern.getMeaning(),
                                                      objPattern.getVideoLink()));
    }

    public ArrayList<UBTerminologyItem> getTerminologies() {
        return _terminologies;
    }

    //adding objects to ArrayList
    public void setTerminology(UBTerminologyItem objTerm) {
        _terminologies.add(new UBTerminologyItem(objTerm.getIdentifier(),
                                              objTerm.getEnglish(),
                                              objTerm.getKorean()));
    }

    public String getIconName() {
        return _iconName;
    }

    public void setIconName(String iconName) {
        try{
            if (iconName.isEmpty() || iconName == null)
                throw new Exception("IconName can't be Null or empty!");
            else this._iconName = iconName;
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
                ", \n\t\tterminology:" + getTerminologies().toString() +
                ", \n\t\ticonName='" + getIconName() + '\'' +
                '}';
    }
}
