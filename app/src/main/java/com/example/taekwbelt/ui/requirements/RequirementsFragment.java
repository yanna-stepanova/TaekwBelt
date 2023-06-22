//A class of a list of requirements  the selected Taekwondo Belt when user selects a category
// "Requirements" in the list of grading material.

package com.example.taekwbelt.ui.requirements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.taekwbelt.databinding.FragmentRequirementsBinding;

public class RequirementsFragment extends Fragment {
    private FragmentRequirementsBinding binding;
    private RequirementsAdapter requirAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRequirementsBinding.inflate(inflater, container, false);



        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
