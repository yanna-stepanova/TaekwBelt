//A class is used for filling a list view of grading material categories in 'selected_belt.xml'

package com.stargiant.taekwbelt.ui.categories;

public class CategoryModel {
    private int _icon;
    private String _nameCategory;

    public CategoryModel(int iconCategory, String nameCategory) {
        this._icon = iconCategory;
        this._nameCategory = nameCategory;
    }

    public int getIcon() {
        return _icon;
    }

    public String getNameCategory() {
        return _nameCategory;
    }

}


