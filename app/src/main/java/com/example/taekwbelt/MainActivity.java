package com.example.taekwbelt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.taekwbelt.models.UBDataStore;
import com.example.taekwbelt.models.UBGradingItem;


public class MainActivity extends AppCompatActivity {
    private TextView outputText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.outputText = (TextView) this.findViewById(R.id.editText);
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
            outputText.setText(parserObj.toString());
        } catch (Exception e) {
            outputText.setText(e.getMessage());
            e.printStackTrace();
        }
    }
}