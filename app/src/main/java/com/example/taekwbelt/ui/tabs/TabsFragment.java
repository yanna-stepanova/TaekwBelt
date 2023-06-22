//A class...
package com.example.taekwbelt.ui.tabs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.FragmentTabsBinding;


public class TabsFragment extends Fragment {
    private FragmentTabsBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentTabsBinding.bind(view);

       // NavHostFragment.findNavController(this);//what does it do?

        //connect navigation component to BottomNavigationView
        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.tabsContainer);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.botNavView, navController);
    }
}
