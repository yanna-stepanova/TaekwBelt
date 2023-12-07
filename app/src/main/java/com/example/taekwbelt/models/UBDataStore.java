//Parser:a class for creating Java object from json-file "grading.json"
// This class is a Singleton pattern!
package com.stargiant.taekwbelt.models;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.stargiant.taekwbelt.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UBDataStore {

    //filling with data from json-file
    public static MutableLiveData<List<UBGradingItem>> getDataSet(Context context) throws JSONException, IOException {
        // Read a content from the json-file and creating a json-object
        UBGradingMaterial objectsFromJson = parseJsonToObject(context);
        //add two lists of belts
        ArrayList<UBGradingItem> dataSet = objectsFromJson.getColorBelts();
        dataSet.addAll(objectsFromJson.getBlackBelts());
        //set all belts
        MutableLiveData<List<UBGradingItem>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    // Read the grading.json file and convert it to a java object.
    public static UBGradingMaterial parseJsonToObject (Context context) throws JSONException, IOException {
        // Read a content from the json-file and creating a json-object
        JSONObject jsonObject = new JSONObject(readText(context, R.raw.grading));
        return new UBGradingMaterial(jsonObject);
    }

    //Reading from some json-file to String
    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while(( s = br.readLine()) != null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
