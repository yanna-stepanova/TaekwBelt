// The adapter class converts our data into elements that are created on the basis
// of layout file "item_pattern.xml"
package com.stargiant.taekwbelt.ui.patterns;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.stargiant.taekwbelt.databinding.ItemPatternBinding;
import com.stargiant.taekwbelt.models.UBGradingPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternsAdapter extends BaseAdapter {
    private List<UBGradingPattern> _patterns;
    private Context _сontext;

    public PatternsAdapter(UBGradingPattern[] massivPatterns, Context context) {
        this._patterns = new ArrayList<>(Arrays.asList(massivPatterns));
        this._сontext = context;
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
        LayoutInflater patternInflater = LayoutInflater.from(parent.getContext());
        ItemPatternBinding binding = ItemPatternBinding.inflate(patternInflater, parent, false);
        binding.namePattern.setText(getPatternModel(position).getName());
        binding.tvMovement.setText(String.valueOf(getPatternModel(position).getMovements()));
        binding.meaningPattern.setText(getPatternModel(position).getMeaning());

        //the video starts when user clicks on icon of "play_video"
        binding.imageVideoPattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get address URL
                Uri urlVideoBelt = Uri.parse(getPatternModel(position).getVideoLink());
                Intent intent = new Intent(Intent.ACTION_VIEW, urlVideoBelt);
                _сontext.startActivity(intent);
            }
        });
        return binding.getRoot();
    }

}
