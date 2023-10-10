package com.example.taekwbelt.ui.belts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taekwbelt.models.UBDataStore;
import com.example.taekwbelt.models.UBGradingItem;
import com.example.taekwbelt.models.UBGradingMaterial;

import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class BeltsViewModel extends ViewModel {
    //private final MutableLiveData<String> mText;
    private MutableLiveData<List<UBGradingItem>> _beltsMutLD;
    private UBDataStore dataStore;

    public  void init() throws JSONException, IOException, URISyntaxException {
        if(_beltsMutLD != null)
            return;
        dataStore = UBDataStore.getInstance();
        _beltsMutLD = dataStore.getDataSet();
    }

    public LiveData<List<UBGradingItem>> getBeltsListLD() {
        return _beltsMutLD;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}