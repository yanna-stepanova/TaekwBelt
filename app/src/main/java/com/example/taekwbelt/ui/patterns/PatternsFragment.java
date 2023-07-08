package com.example.taekwbelt.ui.patterns;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.FragmentPatternsBinding;

public class PatternsFragment extends Fragment {
    private FragmentPatternsBinding binding;
    private PatternsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPatternsBinding.inflate(inflater, container, false);
        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().
                getSupportFragmentManager().findFragmentById(R.id.fragment_activity_main);
        NavController navController = navHostFragment.getNavController();
        Toolbar patternToolBar = binding.patternToolbar.findViewById(R.id.patternToolbar);
        NavigationUI.setupWithNavController(patternToolBar, navController);

        adapter = new PatternsAdapter(PatternsFragmentArgs.fromBundle(requireArguments()).
                getParserPattern(), inflater);
        binding.listPatterns.setAdapter(adapter);
        binding.listPatterns.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri videoBelt = Uri.parse(adapter.getPatternModel(position).getVideoLink());
                Intent intent = new Intent(Intent.ACTION_VIEW,videoBelt);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }
}
