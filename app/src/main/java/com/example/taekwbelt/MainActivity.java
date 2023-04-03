package com.example.taekwbelt;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taekwbelt.databinding.ActivityMainBinding;
import com.example.taekwbelt.models.UBDataStore;
import com.example.taekwbelt.models.UBGradingItem;
import com.example.taekwbelt.models.UBGradingMaterial;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private Button button;
    private RecyclerView numbersList;
    private NumbersAdapter numbersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_belts, R.id.navigation_about)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);

        /*
        try {
            UBDataStore readFromJson = new UBDataStore();
            //Creating an object fot testing output of a text on the display
            UBGradingItem parserObjTest = readFromJson.parseJsonToObjectTest(this);
            // numbersList = findViewById(R.id.rv_numbers);
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

         */

    }

}