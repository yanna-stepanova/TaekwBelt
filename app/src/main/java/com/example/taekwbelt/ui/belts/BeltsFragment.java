package com.example.taekwbelt.ui.belts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taekwbelt.BeltsAdapter;
import com.example.taekwbelt.R;
import com.example.taekwbelt.databinding.FragmentBeltsBinding;
import com.example.taekwbelt.models.UBDataStore;
import com.example.taekwbelt.models.UBGradingMaterial;

public class BeltsFragment extends Fragment {
    private FragmentBeltsBinding beltsFragmentBinding;
    private BeltsAdapter beltsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       // BeltsViewModel beltsViewModel = new ViewModelProvider(this).get(BeltsViewModel.class);

        beltsFragmentBinding = FragmentBeltsBinding.inflate(inflater, container, false);


        //final TextView textView = beltsFragmentBinding.recyclerView.findViewById(R.id.beltNameTextView);//???це потрібно?
        //beltsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        //!!!!зчитати джейсон файл та передати його UBGradingMaterial
        try{
            UBGradingMaterial parserObject = new UBDataStore().parseJsonToObject(beltsFragmentBinding.recyclerView.getContext());
            beltsAdapter = new BeltsAdapter(parserObject,getActivity());

            //LinearLayoutManager myLayoutManager = new LinearLayoutManager(beltsFragmentBinding.recyclerView.getContext());
            beltsFragmentBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            beltsFragmentBinding.recyclerView.setAdapter(beltsAdapter);
            beltsFragmentBinding.recyclerView.setHasFixedSize(true);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return beltsFragmentBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        beltsFragmentBinding = null;
    }

}