package com.example.taekwbelt;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.taekwbelt.ui.tabs.TabsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.taekwbelt.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {
    // calling binding class for activity_main.xml

    private ActivityMainBinding binding; // it's generated automatically
    private NavController navController; // navController of the current screen
    private int topLevelDestination; // ID of navigation graph

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
       // requireViewById()
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // inflating our xml layout in our activity main binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // getting our root layout in our view to set Content view for our layout
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                                         .findFragmentById(R.id.fragment_activity_main);
        navController = navHostFragment.getNavController();

        navController.setGraph(R.navigation.main_graph);

        TabsFragment tabsFragment = new TabsFragment();

        //start a process adding new fragment inside activity's fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_activity_main, tabsFragment);
        fragmentTransaction.commit();

    }

}