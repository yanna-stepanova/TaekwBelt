//Parser:a class for creating Java object from json-file "resourses.json"
package com.example.taekwbelt.models;

import android.content.Context;
import com.example.taekwbelt.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UBDataStore {
    // Read the resources.json file and convert it to a java object.
    public static UBGradingItem parseJsonToObjectTest (Context context) throws JSONException, IOException {
        UBGradingItem objUbGradingItem = new UBGradingItem();
        // Read content of resources.json
        String jsonText = readText(context, R.raw.resources);
        JSONObject jsonObject = new JSONObject(jsonText);
        objUbGradingItem.setIdentifier((String)jsonObject.getString("id"));

        JSONArray jsonArrayT = jsonObject.getJSONArray("terminology");
        for (int i = 0; i< jsonArrayT.length(); i++){

            JSONObject jsonObjTerm = jsonArrayT.getJSONObject(i);
            UBTerminologyItem objUbTerItem = new UBTerminologyItem();
            System.out.println(jsonObjTerm.getString("id"));
            objUbTerItem.setIdentifier(jsonObjTerm.getString("id"));
            objUbTerItem.setEnglish(jsonObjTerm.getString("English"));
            objUbTerItem.setKorean(jsonObjTerm.getString("Korean"));
            objUbGradingItem.setTerminology(objUbTerItem);
        }
        return  objUbGradingItem;
    }


    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while(( s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }


    // Read the grading.json file and convert it to a java object.
    public static UBGradingMaterial parseJsonToObject (Context context) throws JSONException, IOException {
        UBGradingMaterial objMaterial = new UBGradingMaterial();
        // Read a content from the json-file and creating a json-object
        JSONObject jsonObject = new JSONObject(readText(context, R.raw.grading));
        // initialization 'id' of UBGradingMaterial
        objMaterial.setIdentifier(jsonObject.getString("id"));
        fillBelts(objMaterial, jsonObject,"colorBelts");
        fillBelts(objMaterial, jsonObject,"blackBelts");
        return  objMaterial;
    }

    public static UBGradingMaterial fillBelts (UBGradingMaterial matObj, JSONObject jsObj, String strBelt) throws JSONException {
        // creating a loop to get a data of array Belts
        JSONArray jsArrBelt = jsObj.getJSONArray(strBelt);
        for (int i = 0; i < jsArrBelt.length(); i++)
        {
            //take one of json-object for filling
            JSONObject jsObjBelt = jsArrBelt.getJSONObject(i);//??? get some json-object
            //creating  a object of UBGradingItem
            UBGradingItem objGrading = new UBGradingItem(); // creating empty object
            // fill fields of UBGradingItem
            objGrading.setIdentifier(jsObjBelt.getString("id"));
            objGrading.setGrade(jsObjBelt.getString("grade"));
            objGrading.setIconName(jsObjBelt.getString("iconName"));

            //creating a loop to get a data of requirements
            JSONArray jsArrRequirement = jsObjBelt.getJSONArray("requirements");
            for (int k = 0; k < jsArrRequirement.length(); k++ )
            {
                JSONObject jsObjRequirement = jsArrRequirement.getJSONObject(k);
                UBGradingRequirement objReq = new UBGradingRequirement();
                objReq.setIdentifier(jsObjRequirement.getString("id"));
                objReq.setName(jsObjRequirement.getString("name"));
                objReq.setPatternId(jsObjRequirement.getString("patternId"));
                objReq.setDescription(jsObjRequirement.getString("description"));
                objGrading.setRequirements(objReq);
            }

            //creating for reading list of patterns
            JSONArray jsArrPattern = jsObjBelt.getJSONArray("patterns");
            for (int l = 0; l < jsArrPattern.length(); l++)
            {
                JSONObject jsObjPattern = jsArrPattern.getJSONObject(l);
                UBGradingPattern objPat = new UBGradingPattern();
                objPat.setIdentifier(jsObjPattern.getString("id"));
                objPat.setName(jsObjPattern.getString("name"));
                objPat.setMovements(jsObjPattern.getInt("movements"));
                objPat.setMeaning(jsObjPattern.getString("meaning"));
                objPat.setVideoLink(jsObjPattern.getString("videoLink"));
                objGrading.setGradingPatterns(objPat);
            }

            //creating for reading list of terminologies
            JSONArray jsArrTerminology = jsObjBelt.getJSONArray("terminology");
            for (int m = 0; m < jsArrTerminology.length(); m++)
            {
                JSONObject jsObjTermin = jsArrTerminology.getJSONObject(m);
                UBTerminologyItem objTermin = new UBTerminologyItem();
                objTermin.setIdentifier(jsObjTermin.getString("id"));
                objTermin.setEnglish(jsObjTermin.getString("English"));
                objTermin.setKorean(jsObjTermin.getString("Korean"));
                objGrading.setTerminology(objTermin);
            }
            if (strBelt.equals("colorBelts"))
                matObj.setColorBelts(objGrading); //adding created object of UBGradingItem
            else if (strBelt.equals("blackBelts"))
                matObj.setBlackBelts(objGrading);
        }
        return matObj;
    }
}
