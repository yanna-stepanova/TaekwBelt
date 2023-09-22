// A class of a list of requirements for selected Taekwondo Belt when user selects a category
// "Requirements" in the list of grading material.

package com.example.taekwbelt.ui.requirements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.FragmentRequirementsBinding;

public class RequirementsFragment extends Fragment {
    private FragmentRequirementsBinding binding;
    private RequirementsAdapter requirAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRequirementsBinding.inflate(inflater, container, false);

        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().
                getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        Toolbar requirToolBar = binding.requirToolbar.findViewById(R.id.requirToolbar);
        NavigationUI.setupWithNavController(requirToolBar, navController);

        requirAdapter = new RequirementsAdapter(RequirementsFragmentArgs.
                                    fromBundle(requireArguments()).getParserRequir(), inflater);
        binding.listRequirements.setAdapter(requirAdapter);
        
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
