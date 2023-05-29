package com.example.taekwbelt;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.taekwbelt.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // using toolbar as ActionBar
        Toolbar myToolBar = binding.toolbar.findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(myToolBar);

        NavController navController= Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment_activity_main);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                Log.e(TAG, "onDestinationChanged: "+navDestination.getLabel());
            }

        });

        myToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // add code here that execute on click of navigation button
               // NavController navController = Navigation.findNavController(view);
                int idCurrentFragment = navController.getCurrentDestination().getId();
                if (idCurrentFragment == R.id.navigation_selected_belt){
                    navController.popBackStack();
                } else if (idCurrentFragment == R.id.navigation_about) {
                    navController.popBackStack();
                }


            }
        });


        //BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
      //  NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                navController.getGraph()).build(); // use 'navController.getGraph()' (look in activity_main.xml 'app:navGraph="@navigation/mobile_nav"') for transaction between fragment

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);

    }

}