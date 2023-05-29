package com.example.taekwbelt.ui.categories;

public class CategoryModel {
    private int _icon;
    private String _nameCategory;

    public CategoryModel(int iconCategory, String nameCategory) {
        this._icon = iconCategory;
        this._nameCategory = nameCategory;
    }

    public CategoryModel() {

    }

    public int getIcon() {
        return _icon;
    }

    public void setIcon(int iconCategory) {
        this._icon = iconCategory;
    }

    public String getNameCategory() {
        return _nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this._nameCategory = nameCategory;
    }
}


