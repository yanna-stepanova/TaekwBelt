package com.example.taekwbelt.ui.belts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BeltsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BeltsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Belts Page");
    }

    public LiveData<String> getText() {
        return mText;
    }
}