//Parser:a class for creating Java object from json-file "grading.json"
package com.example.taekwbelt.models;

import android.content.Context;
import com.example.taekwbelt.R;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class UBDataStore {
    /*
    !!! I think that this code is needless, isn't it?
    // Read the resources.json file and convert it to a java object.
    //This is test variant for outputting on a display
    public static UBGradingItem parseJsonToObjectTest (Context context) throws JSONException, IOException {
        UBGradingItem objUbGradingItem = new UBGradingItem();
        // Read a content of resources.json
        String jsonText = readText(context, R.raw.resources);
        JSONObject jsonObject = new JSONObject(jsonText);
        objUbGradingItem.setIdentifier((String)jsonObject.getString("id"));

        JSONArray jsonArrayT = jsonObject.getJSONArray("terminology");
        for (int i = 0; i< jsonArrayT.length(); i++){

            JSONObject jsonObjTerm = jsonArrayT.getJSONObject(i);
            UBTerminologyItem objUbTerItem = new UBTerminologyItem(jsonObjTerm);
            System.out.println(jsonObjTerm.getString("id"));
            objUbGradingItem.setTerminology(objUbTerItem);
        }
        return  objUbGradingItem;
    }
     */

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

   /* private static String readText() throws IOException {
        return getResource("raw/grading.json");
    }*/

    private static String getResource(String resource) {
        StringBuilder json = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(Objects.requireNonNull(Objects.requireNonNull(
                            UBDataStore.class.getClassLoader()).getResourceAsStream(resource)),
                            StandardCharsets.UTF_8));
            String str = null;
            while ((str = in.readLine()) != null) {
                json.append(str);
                json.append("\n");
            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Caught exception reading resource " + resource, e);
        }
        return json.toString();
    }

    // Read the grading.json file and convert it to a java object.
    public static UBGradingMaterial parseJsonToObject (Context context) throws JSONException, IOException {

        // Read a content from the json-file and creating a json-object
        JSONObject jsonObject = new JSONObject(readText(context, R.raw.grading));
        UBGradingMaterial objMaterial = new UBGradingMaterial(jsonObject);

        return  objMaterial;
    }
    public static UBGradingMaterial parseJsonToObject () throws JSONException, IOException {

        // Read a content from the json-file and creating a json-object
        JSONObject jsonObject = new JSONObject(getResource("raw/grading.json"));
        UBGradingMaterial objMaterial = new UBGradingMaterial(jsonObject);

        return  objMaterial;
    }

}
