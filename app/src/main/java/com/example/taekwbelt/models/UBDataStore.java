//Parser:a class for creating Java object from json-file "grading.json"
// This class is a Singleton зфееукт!
package com.example.taekwbelt.models;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.taekwbelt.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UBDataStore {
    private static UBDataStore instance;

    public static UBDataStore getInstance(){
        if(instance == null)
            instance = new UBDataStore();
        return instance;
    }

    public MutableLiveData<List<UBGradingItem>> getDataSet() throws JSONException{
        // Read a content from the json-file and creating a json-object
        JSONObject jsonObject = new JSONObject(getResource());
        UBGradingMaterial objectsFromJson = new UBGradingMaterial(jsonObject);
        ArrayList<UBGradingItem> dataSet = objectsFromJson.getColorBelts();
        dataSet.addAll(objectsFromJson.getBlackBelts());
        MutableLiveData<List<UBGradingItem>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
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

    private static String getResource() {
        //Path path = Paths.get("src/main/res/raw/grading.json");
       /* String read = Files.readAllLines(path).get(0);
        System.out.println(read);*/
        /*BufferedReader reader = Files.newBufferedReader(path);
        System.out.println(path.toAbsolutePath());
        String line = reader.readLine();
        System.out.println(line);
*/
        //String file ="src/main/res/raw/grading.json";
        String data = null;
        try {
            File myObj = new File("app/src/main/res/raw/grading.json");
            if (myObj.exists()){
                System.out.println("File name: " + myObj.getName());
                System.out.println("Absolute path: " + myObj.getAbsolutePath());
                System.out.println("Writeable: " + myObj.canWrite());
                System.out.println("Readable " + myObj.canRead());
                System.out.println("File size in bytes " + myObj.length());
            } else {
                System.out.println("The file does not exist.");
            }
                Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       /* Path path = Paths.get(Objects.requireNonNull(UBDataStore.class.getClassLoader())
                .getResource("grading.json").toURI());

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        System.out.println(data.toString());

        StringBuilder json = new StringBuilder();
        try {
            //BufferedReader in = new BufferedReader(new FileReader(file));
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(Objects.requireNonNull(Objects.requireNonNull(
                            UBDataStore.class.getClassLoader()).getResourceAsStream("raw/grading.json")),
                            StandardCharsets.UTF_8));
            String str;
            while ((str = in.readLine()) != null) {
                json.append(str);
                json.append("\n");
            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Caught exception reading resource " + "raw/grading.json", e);
        }
        return json.toString();*/

    }

    // Read the grading.json file and convert it to a java object.
    public static UBGradingMaterial parseJsonToObject (Context context) throws JSONException, IOException {
        // Read a content from the json-file and creating a json-object
        JSONObject jsonObject = new JSONObject(readText(context, R.raw.grading));
        return new UBGradingMaterial(jsonObject);
    }

    public static UBGradingMaterial parseJsonToObject () throws JSONException{
        // Read a content from the json-file and creating a json-object
        JSONObject jsonObject = new JSONObject(getResource());
        return new UBGradingMaterial(jsonObject);
    }

}
