//The adapter class converts our data into elements that are created on the basis of layout file "item_category.xml"
package com.stargiant.taekwbelt.ui.categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.stargiant.taekwbelt.R;
import com.stargiant.taekwbelt.databinding.ItemCategoryBinding;

import java.util.List;

public class CategoriesAdapter extends BaseAdapter {
    private List<CategoryModel> _categoryModelList;
    private  LayoutInflater _myInflater;

    public LayoutInflater getMyInflater() {
        return _myInflater;
    }

    public CategoriesAdapter(List<CategoryModel> categoriesList, LayoutInflater inflater) {

        if (categoriesList.size() != 0 || categoriesList != null) {
            this._categoryModelList = categoriesList;
            this._myInflater = inflater;
        }
    }

    @Override
    public int getCount() {
        return _categoryModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return _categoryModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemCategoryBinding binding = ItemCategoryBinding.inflate(getMyInflater(), parent, false);
        binding.nameCategory.setText(getCategoryModel(position).getNameCategory());
        binding.imageCategory.setImageResource(getCategoryModel(position).getIcon());
        binding.ivNext.setImageResource(R.drawable.ic_navigate_next);
        return binding.getRoot();
    }

    //reuse method 'getItem' to return type 'CategoryModel' instead of type 'Object'
    public CategoryModel getCategoryModel(int position){
        return (CategoryModel) getItem(position);
    }
}
