package com.stargiant.taekwbelt;

import android.os.Bundle;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.stargiant.taekwbelt.databinding.ActivityMainBinding;
import com.stargiant.taekwbelt.ui.belts.BeltsViewModel;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {
    // calling binding class for activity_main.xml
    private ActivityMainBinding binding; // it's generated automatically
    //NavHostFragment navHostFragment;
    NavController navController;
    private static final String TOOLBAR_STATE = "TOOLBAR_STATE";
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityViewModel mainViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        // inflating our xml layout in our activity main binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // getting our root layout in our view to set Content view for our layout
        setContentView(binding.getRoot());

        Toolbar myToolBar = binding.toolbar.findViewById(R.id.toolbar);

        // preparing root nav controller:
        // we use androidx.fragment.app.FragmentContainerView, so that's why need 'NavHostFragment'
        NavHostFragment  navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        //use Optional instead of to check data for null and NullPointerException
        navController = Optional.ofNullable(navHostFragment.getNavController()).get();

        NavigationUI.setupWithNavController(binding.botNavView, navController);

        if (savedInstanceState != null) {
// Restore the state of the Fragment to handle orientation change
            mainViewModel.init(savedInstanceState.getString(TOOLBAR_STATE));
        } else
            mainViewModel.init(navController.getGraph().getStartDestDisplayName().toString());
        myToolBar.setTitle(mainViewModel.getMutLDToolbar().getValue()); //should be before 'setSupportActionBar(...)'

        //set the toolbar as the app bar for the activity to have access to the utility methods provided by the AndroidX library's ActionBar class.
        setSupportActionBar(myToolBar);
        //setup the 2 top level destinations for Action Bar -> Toolbar
        appBarConfiguration = new AppBarConfiguration.
                Builder(R.id.beltsFragment, R.id.aboutFragment).build();
        NavigationUI.setupWithNavController(myToolBar, navController, appBarConfiguration);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TOOLBAR_STATE, navController.getCurrentBackStackEntry()
                .getDestination().getLabel().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

}