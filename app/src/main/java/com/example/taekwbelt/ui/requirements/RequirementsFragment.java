// A class of a list of requirements for selected Taekwondo Belt when user selects a category
// "Requirements" in the list of grading material.

package com.stargiant.taekwbelt.ui.requirements;

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

import com.stargiant.taekwbelt.R;
import com.stargiant.taekwbelt.databinding.FragmentRequirementsBinding;

public class RequirementsFragment extends Fragment {
    private FragmentRequirementsBinding binding;
    private RequirementsAdapter requirAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRequirementsBinding.inflate(inflater, container, false);

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //hide bottom navigation from activity_main.xml
        getActivity().requireViewById(R.id.botNavView).setVisibility(View.GONE);
    }
}
