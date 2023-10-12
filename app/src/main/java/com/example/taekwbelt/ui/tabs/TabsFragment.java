//A class for screens with tabs: 'Belt Syllabus' and 'About'

package com.example.taekwbelt.ui.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.FragmentTabsBinding;

import java.util.Objects;
import java.util.Optional;

public class TabsFragment extends Fragment {
    private FragmentTabsBinding binding;
    private NavHostFragment navHostFragment;
    private  NavController navController;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTabsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // set navController for this fragment
       navHostFragment = (NavHostFragment) requireActivity().
                getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        navController = Optional.ofNullable(navHostFragment.getNavController()).get();
        navController.getGraph().setStartDestination(R.id.beltsFragment);

        NavigationUI.setupWithNavController(binding.botNavView, navController);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.
                Builder(R.id.beltsFragment, R.id.aboutFragment).build();
        NavigationUI.setupActionBarWithNavController((AppCompatActivity) Objects.
                requireNonNull(getActivity()), navController, appBarConfiguration);
/*
        //use Optional instead of to check data for null and NullPointerException
        navController = Optional.ofNullable(navHostFragment.getNavController()).get();
        NavGraph navGraph = navController.getNavInflater().inflate(R.navigation.main_graph);
        navGraph.setStartDestination(R.id.beltsFragment);
        navController.setGraph(navGraph);

        NavigationUI.setupWithNavController(binding.botNavView, navController);

        //setup the 2 top level destinations for Action Bar -> Toolbar
       *//* AppBarConfiguration appBarConfiguration = new AppBarConfiguration.
                Builder(R.id.beltsFragment, R.id.aboutFragment).build();*//*
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.beltsFragment, R.id.aboutFragment)
                .setFallbackOnNavigateUpListener(new AppBarConfiguration.OnNavigateUpListener() {
                    public boolean onNavigateUp() {
                        requireActivity().onBackPressed();
                        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
                        getActivity().getActionBar().setDisplayShowHomeEnabled(true);
                        return true;
                    }
                }).build();


        NavigationUI.setupActionBarWithNavController((AppCompatActivity) Objects.
                requireNonNull(getActivity()), navController, appBarConfiguration);
*/
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }

}
