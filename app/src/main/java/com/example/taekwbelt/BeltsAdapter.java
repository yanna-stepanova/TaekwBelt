package com.example.taekwbelt;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taekwbelt.databinding.ItemBeltBinding;
import com.example.taekwbelt.models.UBGradingItem;
import com.example.taekwbelt.models.UBGradingMaterial;

import java.util.ArrayList;


public class BeltsAdapter extends RecyclerView.Adapter <BeltsViewHolder> {
    private ArrayList<UBGradingItem> _arrayObjectList;
    Context _myContext;

    public ArrayList<UBGradingItem> getArrayObjectList() {
        return _arrayObjectList;
    }

    //make general collection of belts
    public BeltsAdapter(UBGradingMaterial arrayObjectList, Context context){
        this._arrayObjectList = arrayObjectList.getColorBelts();
        //this._arrayObjectList.addAll(arrayObjectList.getColorBelts());
        //this._arrayObjectList.addAll(arrayObjectList.getBlackBelts());
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
        //holder.getItemBeltBinding().imageBelt.setImageResource();//не можу перейменувати іконки через знак "-" у назві в json-файлі
    }

    @Override
    public int getItemCount() {
        return getArrayObjectList() != null ? getArrayObjectList().size() : 0;
    }
}
