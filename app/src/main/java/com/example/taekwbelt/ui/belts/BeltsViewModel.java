package com.example.taekwbelt.ui.belts;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taekwbelt.models.UBDataStore;
import com.example.taekwbelt.models.UBGradingItem;

import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class BeltsViewModel extends ViewModel {
    private MutableLiveData<List<UBGradingItem>> _beltsMutLD;

    public void init(Context context) throws JSONException, IOException, URISyntaxException {
        if(_beltsMutLD != null)
            return;
        _beltsMutLD = UBDataStore.getDataSet(context);
    }

    public LiveData<List<UBGradingItem>> getBeltsListLD() {
        return _beltsMutLD;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}