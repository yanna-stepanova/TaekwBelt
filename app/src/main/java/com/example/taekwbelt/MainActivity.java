package com.example.taekwbelt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.taekwbelt.models.UBDataStore;
import com.example.taekwbelt.models.UBGradingItem;


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
            UBGradingItem parserObj = readFromJson.parseJsonToObject(this);
            numbersList = findViewById(R.id.rv_numbers);
            // Displays a list of items vertically (from top to bottom)
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            numbersList.setLayoutManager(layoutManager);
            numbersList.setHasFixedSize(true); //указ-м что знаем размер списка
            // Setting a number of items in the list
            numbersAdapter = new NumbersAdapter(this,parserObj.getTerminology());
            numbersList.setAdapter(numbersAdapter);
            // Improves list performance
           // outputText.setText(parserObj.toString());
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

    }
}