package com.example.taekwbelt;

import android.os.Bundle;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.taekwbelt.databinding.ActivityMainBinding;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {
    // calling binding class for activity_main.xml
    private ActivityMainBinding binding; // it's generated automatically
    NavHostFragment navHostFragment;
    NavController navController;
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // inflating our xml layout in our activity main binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // getting our root layout in our view to set Content view for our layout
        setContentView(binding.getRoot());

        Toolbar myToolBar = binding.toolbar.findViewById(R.id.toolbar);
        //set the toolbar as the app bar for the activity to have access to the utility methods provided by the AndroidX library's ActionBar class.
        setSupportActionBar(myToolBar);

        // preparing root nav controller:
        // we use androidx.fragment.app.FragmentContainerView, so that's why need 'NavHostFragment'
        navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        //use Optional instead of to check data for null and NullPointerException
        navController = Optional.ofNullable(navHostFragment.getNavController()).get();
        NavGraph navGraph = navController.getNavInflater().inflate(R.navigation.main_graph);
        navGraph.setStartDestination(R.id.tabsFragment);
        navController.setGraph(navGraph);
        NavigationUI.setupActionBarWithNavController(this, navController);

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        NavigationUI.setupWithNavController(myToolBar, navController, appBarConfiguration);

        //setup the 2 top level destinations for Action Bar -> Toolbar
        /*appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_belts, R.id.navigation_about).build();

        NavigationUI.setupWithNavController(myToolBar, navController, appBarConfiguration);*/
        //appBarConfiguration = new AppBarConfiguration.Builder(R.id.tabs_graph).build(); // appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //navController = null; //?
        binding = null;
    }


/*    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }*/
}