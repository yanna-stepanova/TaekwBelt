package com.example.taekwbelt.ui.terminologies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.taekwbelt.databinding.ItemTerminologyBinding;
import com.example.taekwbelt.models.UBTerminologyItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TerminologiesAdapter extends BaseAdapter {

    private List<UBTerminologyItem> _terminologies;
    private LayoutInflater _terminInflater;

    public LayoutInflater getIerminInflater() {
        return _terminInflater;
    }

    public List<UBTerminologyItem> getTerminologies() {
        return _terminologies;
    }

    public TerminologiesAdapter(UBTerminologyItem[] massivTermin, LayoutInflater inflater) {
        this._terminologies = new ArrayList<>(Arrays.asList(massivTermin));
        this._terminInflater = inflater;
    }

    @Override
    public int getCount() {
        return _terminologies.size();
    }

    public UBTerminologyItem getTerminologyItem(int position){
        return (UBTerminologyItem) getItem(position);
    }

    @Override
    public Object getItem(int position) {
        return _terminologies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemTerminologyBinding binding = ItemTerminologyBinding.inflate(getIerminInflater(),
                parent, false);
        binding.textEnglish.setText(getTerminologyItem(position).getEnglish());
        binding.textKorean.setText(getTerminologyItem(position).getKorean());
        return binding.getRoot();
    }


}