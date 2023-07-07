//a class explains some exercise

package com.example.taekwbelt.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

public class UBGradingPattern  extends UBBaseID implements Parcelable {
    private String name;
    private int movements;
    private String meaning;
    private String videoLink; // A link to the video showcasing how to perform actions in the pattern

    public UBGradingPattern(String identifier, String name, int movements, String meaning, String videoLink) {
        super(identifier);
        this.name = name;
        this.movements = movements;
        this.meaning = meaning;
        this.videoLink = videoLink;
    }

    // Initializes an instance of grading pattern with the data retrieved from JSON object
    public UBGradingPattern(JSONObject jsObj) throws JSONException {
        super();

        if (jsObj.has("id") && !jsObj.isNull("id")) {
            this.setIdentifier(jsObj.getString("id"));
        }

        if (jsObj.has("name") && !jsObj.isNull("name")) {
            this.setName(jsObj.getString("name"));
        }

        if (jsObj.has("movements") && !jsObj.isNull("movements")) {
            this.setMovements(jsObj.getInt("movements"));
        }

        if (jsObj.has("meaning") && !jsObj.isNull("meaning")) {
            this.setMeaning(jsObj.getString("meaning"));
        }

        if (jsObj.has("videoLink") && !jsObj.isNull("videoLink")) {
            this.setVideoLink(jsObj.getString("videoLink"));
        }
    }

    protected UBGradingPattern(Parcel in) {
        name = in.readString();
        movements = in.readInt();
        meaning = in.readString();
        videoLink = in.readString();
    }

    public static final Creator<UBGradingPattern> CREATOR = new Creator<UBGradingPattern>() {
        @Override
        public UBGradingPattern createFromParcel(Parcel in) {
            return new UBGradingPattern(in);
        }

        @Override
        public UBGradingPattern[] newArray(int size) {
            return new UBGradingPattern[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovements() {
        return movements;
    }

    public void setMovements(int movements) {
        this.movements = movements;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    @Override
    public String toString() {
        return "\n\t\t  UBGradingPattern{" +
                " identifier='" + getIdentifier() + '\'' +
                ", name='" + getName() + '\'' +
                ", movements=" + getMovements() +
                ", meaning='" + getMeaning() + '\'' +
                ", videoLink='" + getVideoLink() + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeInt(getMovements());
        dest.writeString(getMeaning());
        dest.writeString(getVideoLink());
    }
}
