//The adapter class converts our data into elements that are created on the basis of layout file "item_requirement.xml"

package com.example.taekwbelt.ui.requirements;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
// The adapter class converts our data into elements that are created on the basis
// of layout file "item_requirement.xml"
import com.example.taekwbelt.databinding.ItemRequirementBinding;
import com.example.taekwbelt.models.UBGradingRequirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequirementsAdapter extends BaseAdapter {

    private List<UBGradingRequirement> _requirements;
    private LayoutInflater _reqInflater;

    public LayoutInflater getReqInflater() {
        return _reqInflater;
    }

    public RequirementsAdapter(UBGradingRequirement[] masRequirements, LayoutInflater inflater) {
        this._requirements = new ArrayList<>(Arrays.asList(masRequirements));
        this._reqInflater = inflater;
    }

    public List<UBGradingRequirement> getRequirements() {
        return _requirements;
    }

    @Override
    public int getCount() {
        return _requirements.size();
    }

    @Override
    public Object getItem(int position) {
        return _requirements.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemRequirementBinding binding = ItemRequirementBinding.inflate(getReqInflater(), parent, false);
        binding.nameRequirement.setText(getRequirModel(position).getName());
        return binding.getRoot();
    }

    public UBGradingRequirement getRequirModel(int position){
        return (UBGradingRequirement) getItem(position);
    }
}
