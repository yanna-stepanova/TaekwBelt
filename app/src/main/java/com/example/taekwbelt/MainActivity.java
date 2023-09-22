package com.example.taekwbelt;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.taekwbelt.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // calling binding class for activity_main.xml
    private ActivityMainBinding binding; // it's generated automatically
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // inflating our xml layout in our activity main binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // getting our root layout in our view to set Content view for our layout
        setContentView(binding.getRoot());
        Toolbar myToolBar = binding.toolbar.findViewById(R.id.toolbar);
        //set ToolBar is instead of AtionBar
        setSupportActionBar(myToolBar);

        // preparing root nav controller:
        // we use androidx.fragment.app.FragmentContainerView, so that's why need 'NavHostFragment'
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                                         .findFragmentById(R.id.nav_host_fragment);

        navController = navHostFragment.getNavController();

        /*AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();*/
         appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        NavigationUI.setupWithNavController(myToolBar,navController,appBarConfiguration);

//        NavigationUI.setupActionBarWithNavController(this, navController);
//        setSupportActionBar(myToolBar);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }
}