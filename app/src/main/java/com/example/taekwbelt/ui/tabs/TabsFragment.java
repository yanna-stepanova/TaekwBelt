//A class for screens with tabs: 'Belt Syllabus' and 'About'

package com.example.taekwbelt.ui.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.FragmentTabsBinding;

public class TabsFragment extends Fragment {
    private FragmentTabsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTabsBinding.inflate(inflater, container, false);

        // set navController for this fragment
        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().
                findFragmentById(R.id.tabsContainer);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.botNavView, navController);

        Toolbar myToolBar = binding.tabsToolbar.findViewById(R.id.tabsToolbar);
        NavigationUI.setupWithNavController(myToolBar, navController);
        myToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idCurrentFragment = navController.getCurrentDestination().getId();
                if (idCurrentFragment == R.id.navigation_selected_belt) {
                    navController.popBackStack();
                } else if (idCurrentFragment == R.id.navigation_about) {
                    navController.popBackStack(); //return to the home screen
                }
            }
        });

        return binding.getRoot();
    }

}
