// An object that describes a syllabus for Taekwondo gradings

package com.stargiant.taekwbelt.models;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UBGradingMaterial extends UBBaseID{
    private ArrayList<UBGradingItem> _colorBelts; // A list of color belts syllabus
    private ArrayList<UBGradingItem> _blackBelts; // A list of black belts syllabus

    public UBGradingMaterial() {
        super();
        //initialization: ArrayLists are Null
        this._colorBelts = new ArrayList<UBGradingItem>();
        this._blackBelts = new ArrayList<UBGradingItem>();
    }

    // Initializes an instance of grading material with the date retrieved from JSON object
    public UBGradingMaterial(JSONObject jsObj) throws JSONException {
        super();
        //initialization: ArrayLists are Null
        this._colorBelts = new ArrayList<UBGradingItem>();
        this._blackBelts = new ArrayList<UBGradingItem>();

        if (jsObj.has("id") && !jsObj.isNull("id")) {
            this.setIdentifier(jsObj.getString("id"));
        }

        this.parseJson(jsObj, "colorBelts");
        this.parseJson(jsObj, "blackBelts");
    }

    public UBGradingMaterial(String identifier, ArrayList<UBGradingItem> ubGradingItems, ArrayList<UBGradingItem> ubGradingItems1) {
        super(identifier);
        this._colorBelts = ubGradingItems;
        this._blackBelts = ubGradingItems1;
    }

    // fills fields from JSON object
    private void parseJson(JSONObject jsObj, String strBelt) throws JSONException {
        // creating a loop to get a data of array Belts
        JSONArray jsArrBelt = jsObj.getJSONArray(strBelt);
        for (int i = 0; i < jsArrBelt.length(); i++)
        {
            //take one of json-object for filling
            JSONObject jsObjBelt = jsArrBelt.getJSONObject(i);//??? get some json-object
            //creating  a object of UBGradingItem
            UBGradingItem objGrading = new UBGradingItem(jsObjBelt);
            if (strBelt.equals("colorBelts")) {
                this.setColorBelts(objGrading); //adding created object of UBGradingItem
            } else if (strBelt.equals("blackBelts"))
                this.setBlackBelts(objGrading);
        }
    }

    public ArrayList<UBGradingItem> getColorBelts() {
        return _colorBelts;
    }

    public void setColorBelts(UBGradingItem objColor) {
        this._colorBelts.add(new UBGradingItem(objColor.getIdentifier(),
                                              objColor.getGrade(),
                                              objColor.getRequirements(),
                                              objColor.getGradingPatterns(),
                                              objColor.getTerminologies(),
                                              objColor.getIconName()));
    }

    public ArrayList<UBGradingItem> getBlackBelts() {
        return _blackBelts;
    }

    public void setBlackBelts(UBGradingItem objBlack) {
        this._blackBelts.add(new UBGradingItem(objBlack.getIdentifier(),
                                              objBlack.getGrade(),
                                              objBlack.getRequirements(),
                                              objBlack.getGradingPatterns(),
                                              objBlack.getTerminologies(),
                                              objBlack.getIconName()));
    }

    @Override
    public String toString() {
        return "UBGradingMaterial{\n" +
                "\tidentifier='" + getIdentifier() + '\'' +
                ", \n\tcolorBelts:" + getColorBelts().toString() + '\n' +
                ", \n\tblackBelts:" + getBlackBelts().toString() + '\n' +
                '}';
    }
}
