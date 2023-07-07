package com.example.taekwbelt.ui.patterns;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.taekwbelt.databinding.ItemPatternBinding;
import com.example.taekwbelt.models.UBGradingPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternsAdapter extends BaseAdapter {
    private List<UBGradingPattern> _patterns;
    private LayoutInflater _patternInflater;

    public LayoutInflater getPatternInflater() {
        return _patternInflater;
    }

    public PatternsAdapter(UBGradingPattern[] massivPatterns, LayoutInflater inflater) {
        this._patterns = new ArrayList<>(Arrays.asList(massivPatterns));
        this._patternInflater = inflater;
    }

    public List<UBGradingPattern> getPatterns() {
        return _patterns;
    }

    @Override
    public int getCount() {
        return _patterns.size();
    }

    @Override
    public Object getItem(int position) {
        return _patterns.get(position);
    }

    public UBGradingPattern getPatternModel(int position){
        return (UBGradingPattern) getItem(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemPatternBinding binding = ItemPatternBinding.inflate(getPatternInflater(), parent, false);
        binding.namePattern.setText(getPatternModel(position).getName());
        binding.tvMovement.setText(String.valueOf(getPatternModel(position).getMovements()));
        binding.meaningPattern.setText(getPatternModel(position).getMeaning());
        return binding.getRoot();
    }


}
