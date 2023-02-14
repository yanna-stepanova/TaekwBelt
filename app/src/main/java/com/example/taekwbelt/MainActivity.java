package com.example.taekwbelt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.taekwbelt.models.UBDataStore;
import com.example.taekwbelt.models.UBGradingItem;
import com.example.taekwbelt.models.UBGradingMaterial;


public class MainActivity extends AppCompatActivity {
    private Button button;

    private RecyclerView numbersList;
    private NumbersAdapter numbersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = (Button) this.findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    runExample(view);
            }
        });
    }

    public void runExample(View view) {
        try {
            UBDataStore readFromJson = new UBDataStore();
            //Creating an object fot testing output of a text on the display
            UBGradingItem parserObjTest = readFromJson.parseJsonToObjectTest(this);
            numbersList = findViewById(R.id.rv_numbers);
            // Displays a list of items vertically (from top to bottom)
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            numbersList.setLayoutManager(layoutManager);
            numbersList.setHasFixedSize(true); //Show that we know the size of the list
            // Setting a number of items in the list
            numbersAdapter = new NumbersAdapter(this,parserObjTest.getTerminologies());
            numbersList.setAdapter(numbersAdapter);

            //Creating an object for parsing
            UBGradingMaterial parserObj = new UBDataStore().parseJsonToObject(this);
            // Output the result in a console
            System.out.println(parserObj.toString());

        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

    }
}