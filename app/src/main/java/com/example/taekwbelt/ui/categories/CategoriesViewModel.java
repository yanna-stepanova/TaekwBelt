package com.example.taekwbelt.ui.categories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CategoriesViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    public CategoriesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Categories Page");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
