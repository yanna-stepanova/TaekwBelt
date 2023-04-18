package com.example.taekwbelt;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taekwbelt.databinding.ItemBeltBinding;

public class BeltsViewHolder extends RecyclerView.ViewHolder {
    private ItemBeltBinding _itemBeltBinding;
    private TextView _textView;
    private ImageView _imageView;

    public ItemBeltBinding getItemBeltBinding() {
        return _itemBeltBinding;
    }

    public BeltsViewHolder(ItemBeltBinding itemBeltBinding) {
        super(itemBeltBinding.getRoot());
        this._itemBeltBinding = itemBeltBinding;
      //  this._textView = itemBeltBinding..beltNameTextView;
      //  this._imageView = itemBeltBinding.imageBelt;
    }
}
