package com.example.taekwbelt;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taekwbelt.databinding.ItemBeltBinding;
import com.example.taekwbelt.models.UBGradingItem;
import com.example.taekwbelt.models.UBGradingMaterial;

import java.util.ArrayList;
import java.util.Locale;


public class BeltsAdapter extends RecyclerView.Adapter <BeltsViewHolder> {
    private ArrayList<UBGradingItem> _arrayObjectList;
    Context _myContext;

    public ArrayList<UBGradingItem> getArrayObjectList() {
        return _arrayObjectList;
    }

    //make general collection of belts
    public BeltsAdapter(UBGradingMaterial arrayObjectList, Context context){
        //arrayObjectList has two parts (color&black belts)
        this._arrayObjectList = arrayObjectList.getColorBelts();
        this._arrayObjectList.addAll(arrayObjectList.getBlackBelts());
        this._myContext = context;
    }

    @NonNull
    @Override
    public BeltsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_belt, parent, false);
        return new BeltsViewHolder(ItemBeltBinding.inflate(LayoutInflater.from(parent.getContext()),
                 parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BeltsViewHolder holder, int position) {
        UBGradingItem object = getArrayObjectList().get(position);
        _myContext = holder.getItemBeltBinding().getRoot().getContext();
        Activity activity = (Activity) _myContext;
        holder.getItemBeltBinding().beltNameTextView.setText(object.getGrade());

        //search in resourses ID-icon(int) from "grading.json"(string)
        String nameIcon = object.getIconName();
        if (nameIcon.endsWith(".png"))
            nameIcon = nameIcon.substring(0, nameIcon.length() - 4); // there's just a name without ".png"
        Integer myIconInt = activity.getResources().getIdentifier(nameIcon, "drawable",
                activity.getPackageName());
        holder.getItemBeltBinding().imageBelt.setImageResource(myIconInt);

        holder.getItemBeltBinding().imageButtonNext.setImageResource(R.drawable.ic_navigate_next);
        holder.getItemBeltBinding().barrier.getMargin();
    }

    @Override
    public int getItemCount() {
        return getArrayObjectList() != null ? getArrayObjectList().size() : 0;
    }
}
