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
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.FragmentTabsBinding;

import java.util.Objects;

public class TabsFragment extends Fragment {
    private FragmentTabsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTabsBinding.inflate(inflater, container, false);

        // set navController for this fragment
        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().
                findFragmentById(R.id.tabsContainer);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.botNavView, navController);
        //setup the 2 top level destinations for Action Bar -> Tool Bar
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.
                Builder(R.id.navigation_belts, R.id.navigation_about).build();
        NavigationUI.setupActionBarWithNavController((AppCompatActivity) Objects.requireNonNull(getActivity()), navController, appBarConfiguration);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
