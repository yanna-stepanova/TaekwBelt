package com.example.taekwbelt;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.example.taekwbelt.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // calling binding class for activity_main.xml

    private ActivityMainBinding binding; // it's generated automatically
    private NavController navController; // navController of the current screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // inflating our xml layout in our activity main binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // getting our root layout in our view to set Content view for our layout
        setContentView(binding.getRoot());

        // preparing root nav controller:
        // we use androidx.fragment.app.FragmentContainerView, so that's why need 'NavHostFragment'
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                                         .findFragmentById(R.id.fragment_activity_main);
        navController = navHostFragment.getNavController();
        navController.setGraph(R.navigation.main_graph);
    }
}