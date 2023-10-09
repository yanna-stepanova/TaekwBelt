package com.example.taekwbelt.ui.belts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taekwbelt.models.UBDataStore;
import com.example.taekwbelt.models.UBGradingItem;
import com.example.taekwbelt.models.UBGradingMaterial;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeltsViewModel extends ViewModel {
    //private final MutableLiveData<String> mText;
    private final MutableLiveData<List<UBGradingItem>> _beltsMutLD = new MutableLiveData<>();
    public LiveData <List<UBGradingItem>> beltsLD;
    private List<UBGradingItem> listenerBelts = new ArrayList<>();

    public BeltsViewModel() throws JSONException, IOException {
        /* mText = new MutableLiveData<>();
        mText.setValue("This is Belts Page");*/

        //reading from json-file
        UBGradingMaterial readFromJson = new UBDataStore().parseJsonToObject();
        //need to add color and black belts
        ArrayList<UBGradingItem> arrayBeltsList = readFromJson.getColorBelts();
        arrayBeltsList.addAll(readFromJson.getBlackBelts());

        this._beltsMutLD.setValue(arrayBeltsList);
        this.beltsLD = _beltsMutLD;
    }


    public void loadBelts(){

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void setBeltsMutLD(UBGradingMaterial jsonParser) {
        //initialization from BeltsAdapter
        ArrayList<UBGradingItem> arrayBeltsList = jsonParser.getColorBelts();
        arrayBeltsList.addAll(jsonParser.getBlackBelts());

        this._beltsMutLD.setValue(arrayBeltsList);
    }

    public MutableLiveData<List<UBGradingItem>> getBeltsMutLD() {
        return _beltsMutLD;
    }

   /* public LiveData<String> getText() {
        return mText;
    }*/
}