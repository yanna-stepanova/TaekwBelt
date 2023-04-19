package com.example.taekwbelt;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taekwbelt.databinding.ItemBeltBinding;

public class BeltsViewHolder extends RecyclerView.ViewHolder {
    private ItemBeltBinding _itemBeltBinding;

    public ItemBeltBinding getItemBeltBinding() {
        return _itemBeltBinding;
    }

    public BeltsViewHolder(ItemBeltBinding itemBeltBinding) {
        super(itemBeltBinding.getRoot());
        this._itemBeltBinding = itemBeltBinding;
    }
}
