//a class describes what students need to learn to reach a particular level (grade)

package com.example.taekwbelt.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

public class UBGradingRequirement  extends UBBaseID implements Parcelable {
    private String _name; // The name of the requirement
    private String _patternId; // An identifier of an object of the pattern associated the requirement
    private String _description; // A description of the requirement

    public UBGradingRequirement() {
        super();
    }

    public UBGradingRequirement(String identifier, String name, String patternId, String description) {
        super(identifier);
        setName(name);
        setPatternId(patternId);
        setDescription(description);
    }

    // Initializes an instance of grading requirement with the data retrieved from JSON object
    public  UBGradingRequirement(JSONObject jsObj) throws JSONException {
        super();

        if (jsObj.has("id") && !jsObj.isNull("id")) {
            this.setIdentifier(jsObj.getString("id"));
        }

        if (jsObj.has("name") && !jsObj.isNull("name")) {
            this.setName(jsObj.getString("name"));
        }

        if (jsObj.has("patternId") && !jsObj.isNull("patternId")) {
            this.setPatternId(jsObj.getString("patternId"));
        }

        if (jsObj.has("description") && !jsObj.isNull("description")) {
            this.setDescription(jsObj.getString("description"));
        }

    }

    protected UBGradingRequirement(Parcel in) {
        this._name = in.readString();
        this._patternId = in.readString();
        this._description = in.readString();
    }

    public static final Creator<UBGradingRequirement> CREATOR = new Creator<UBGradingRequirement>() {
        @Override
        public UBGradingRequirement createFromParcel(Parcel in) {
            return new UBGradingRequirement(in);
        }

        @Override
        public UBGradingRequirement[] newArray(int size) {
            return new UBGradingRequirement[size];
        }
    };

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getPatternId() {
        return _patternId;
    }

    public void setPatternId(String patternId) {
        this._patternId = patternId;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    @Override
    public String toString() {
        return "\n\t\t  UBGradingRequirement{" +
                " identifier='" + getIdentifier() + '\'' +
                ", name='" + getName() + '\'' +
                ", patternId='" + getPatternId() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeString(getPatternId());
        dest.writeString(getDescription());
    }
}
