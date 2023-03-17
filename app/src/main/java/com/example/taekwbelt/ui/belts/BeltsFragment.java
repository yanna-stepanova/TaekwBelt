package com.example.taekwbelt.ui.belts;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.example.taekwbelt.databinding.FragmentBeltsBinding;

public class BeltsFragment extends Fragment {
    private FragmentBeltsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BeltsViewModel beltsViewModel =
                new ViewModelProvider(this).get(BeltsViewModel.class);

        binding = FragmentBeltsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textBelts;
        beltsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}