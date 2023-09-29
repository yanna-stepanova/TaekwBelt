//A class for screens with tabs: 'Belt Syllabus' and 'About'

package com.example.taekwbelt.ui.tabs;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
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

        // set navController for this fragment
        navHostFragment = (NavHostFragment) getChildFragmentManager().
                findFragmentById(R.id.tabsContainer);
        //use Optional instead of to check data for null and NullPointerException
        navController = Optional.ofNullable(navHostFragment.getNavController()).get();
        NavigationUI.setupWithNavController(binding.botNavView, navController);
        //setup the 2 top level destinations for Action Bar -> Tool Bar
       /* appBarConfiguration = new AppBarConfiguration.
                Builder(R.id.tab_belt_graph,R.id.tab_about_graph).build();*/
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.
                Builder(R.id.navigation_belts, R.id.navigation_about).build();
        NavigationUI.setupActionBarWithNavController((AppCompatActivity) Objects.
                requireNonNull(getActivity()), navController, appBarConfiguration);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      /*  getChildFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentViewCreated(@NonNull FragmentManager fm, @NonNull Fragment f, @NonNull View v, @Nullable Bundle savedInstanceState) {
                super.onFragmentViewCreated(fm, f, v, savedInstanceState);
                if (f.equals(R.id.navigation_selected_belt)) {

                    //navController.navigate(R.id.navigation_belts);
                   navController.popBackStack();
                }
            }
        }, true);*/
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
       // binding = null;
    }

}
