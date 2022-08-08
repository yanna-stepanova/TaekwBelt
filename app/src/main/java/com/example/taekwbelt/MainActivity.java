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
            /*
            UBGradingItem parserObj = readFromJson.parseJsonToObject(this);
            numbersList = findViewById(R.id.rv_numbers);
            //отображает послед.в виде списка сверху-вниз
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            numbersList.setLayoutManager(layoutManager);
            numbersList.setHasFixedSize(true); //указ-м что знаем размер списка
            //указ-м сколько будет эл-в списка
            numbersAdapter = new NumbersAdapter(this,parserObj.getTerminology());
            numbersList.setAdapter(numbersAdapter);

             */
            //улучшает быстродействие списка
           // outputText.setText(parserObj.toString());

            UBGradingMaterial parserObj = new UBDataStore().parseJsonToObject(this);
            System.out.println(parserObj.toString());

        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

    }
}