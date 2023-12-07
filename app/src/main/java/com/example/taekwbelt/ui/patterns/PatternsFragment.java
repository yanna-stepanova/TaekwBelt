// A class of a list of patterns for selected Taekwondo Belt when user selects a category
// "Patterns" in the list of grading material.
package com.stargiant.taekwbelt.ui.patterns;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.stargiant.taekwbelt.R;
import com.stargiant.taekwbelt.databinding.FragmentPatternsBinding;

public class PatternsFragment extends Fragment {
    private FragmentPatternsBinding binding;
    private PatternsAdapter adapter;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //hide bottom navigation from activity_main.xml
        getActivity().requireViewById(R.id.botNavView).setVisibility(View.GONE);
        binding = FragmentPatternsBinding.inflate(inflater, container, false);
        adapter = new PatternsAdapter(PatternsFragmentArgs.fromBundle(requireArguments()).getParserPattern(), inflater.getContext());// ???getActivity
        binding.listPatterns.setAdapter(adapter);
        return binding.getRoot();
    }
}
