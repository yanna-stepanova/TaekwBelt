// An object that describes a syllabus for Taekwondo gradings

package com.example.taekwbelt.models;

import java.util.ArrayList;

public class UBGradingMaterial extends UBBaseID{
    private ArrayList<UBGradingItem> colorBelts; // A list of color belts syllabus
    private ArrayList<UBGradingItem> blackBelts; // A list of black belts syllabus

    public UBGradingMaterial() {
        super();
        //initialization: ArrayLists are Null
        this.colorBelts = new ArrayList<UBGradingItem>();
        this.blackBelts = new ArrayList<UBGradingItem>();
    }

    public ArrayList<UBGradingItem> getColorBelts() {
        return colorBelts;
    }

    public void setColorBelts(UBGradingItem objColor) {
        this.colorBelts.add(new UBGradingItem(objColor.getIdentifier(),
                                              objColor.getGrade(),
                                              objColor.getRequirements(),
                                              objColor.getGradingPatterns(),
                                              objColor.getTerminology(),
                                              objColor.getIconName()));
    }

    public ArrayList<UBGradingItem> getBlackBelts() {
        return blackBelts;
    }

    public void setBlackBelts(UBGradingItem objBlack) {
        this.blackBelts.add(new UBGradingItem(objBlack.getIdentifier(),
                                              objBlack.getGrade(),
                                              objBlack.getRequirements(),
                                              objBlack.getGradingPatterns(),
                                              objBlack.getTerminology(),
                                              objBlack.getIconName()));
    }
}
