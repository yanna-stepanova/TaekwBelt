//the class is a vocabulary of taekwondo

package com.stargiant.taekwbelt.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

public class UBTerminologyItem extends UBBaseID implements Parcelable {
    private String english; // An English word for an object (for a punch, kick, action, etc.)
    private String korean; // A Korean word for an object

    public UBTerminologyItem() {
        super();
    }

    public UBTerminologyItem(String identifier, String english, String korean) {
        super(identifier);
        this.english = english;
        this.korean = korean;
    }

    // Initializes an instance of terminology item with the data retrieved from JSON object
    public UBTerminologyItem(JSONObject jsObj) throws JSONException {
        super();

        if (jsObj.has("id") && !jsObj.isNull("id")) {
            this.setIdentifier(jsObj.getString("id"));
        }

        if (jsObj.has("English") && !jsObj.isNull("English")) {
            this.setEnglish(jsObj.getString("English"));
        }

        if (jsObj.has("Korean") && !jsObj.isNull("Korean")) {
            this.setKorean(jsObj.getString("Korean"));
        }
    }

    protected UBTerminologyItem(Parcel in) {
        english = in.readString();
        korean = in.readString();
    }

    public static final Creator<UBTerminologyItem> CREATOR = new Creator<UBTerminologyItem>() {
        @Override
        public UBTerminologyItem createFromParcel(Parcel in) {
            return new UBTerminologyItem(in);
        }

        @Override
        public UBTerminologyItem[] newArray(int size) {
            return new UBTerminologyItem[size];
        }
    };

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getKorean() {
        return korean;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }

    @Override
    public String toString() {
        return "\n\t\t  UBTerminologyItem{" +
                " identifier='" + getIdentifier() + '\'' +
                ", english='" + getEnglish() + '\'' +
                ", korean='" + getKorean() + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(getEnglish());
        dest.writeString(getKorean());
    }
}
