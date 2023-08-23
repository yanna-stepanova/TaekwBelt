package com.example.taekwbelt.ui.terminologies;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.FragmentTerminologiesBinding;

/**
 * A fragment representing a list of Items.
 */
public class TerminologiesFragment extends Fragment {

    private FragmentTerminologiesBinding binding;
    private TerminologiesAdapter terminAdapter;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTerminologiesBinding.inflate(inflater, container, false);
        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().
                getSupportFragmentManager().findFragmentById(R.id.fragment_activity_main);
        NavController navController = navHostFragment.getNavController();
        Toolbar terminToolBar = binding.terminToolbar.findViewById(R.id.terminToolbar);
        NavigationUI.setupWithNavController(terminToolBar, navController);

        terminAdapter = new TerminologiesAdapter(TerminologiesFragmentArgs.
                fromBundle(requireArguments()).getParserTerminologies(), inflater);
        binding.listTerminologies.setAdapter(terminAdapter);
        return binding.getRoot();
    }
}