package com.example.taekwbelt.models;

import android.content.Context;

import com.example.taekwbelt.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import org.json.JSONException;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONValue;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class UBDataStore {
    // Read the resources.json file and convert it to a java object.
    public static UBGradingItem parseJsonToObject (Context context) throws JSONException, IOException {
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
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }



}
