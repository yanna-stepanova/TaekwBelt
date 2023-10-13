package com.example.taekwbelt;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> mutLDToolbar = new MutableLiveData<>();

    public void init(String someText) {
        this.mutLDToolbar.setValue(someText);
    }

    public MutableLiveData<String> getMutLDToolbar() {
        return mutLDToolbar;
    }
}
