//The class is reused each time when an adapter of RecyclerView converts data into elements of xml-file
package com.stargiant.taekwbelt.ui.belts;

import androidx.recyclerview.widget.RecyclerView;
import com.stargiant.taekwbelt.databinding.ItemBeltBinding;

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
