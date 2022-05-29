package com.example.taekwbelt.models;

import java.util.ArrayList;

public class UBGradingItem {
    private String identifier; // НЕ может быть пустым или Null
    private ArrayList<UBTerminologyItem> terminology; // типа массив объектов UBTerminologyItem, может быть Null или пустым

    public UBGradingItem() {
        this.terminology = new ArrayList<UBTerminologyItem>();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        try{
            if (identifier.isEmpty() || identifier == null)
                throw new Exception("Identifier can't be Null or empty!");
            else this.identifier = identifier;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<UBTerminologyItem> getTerminology() {
        return terminology;
    }

    public void setTerminology(UBTerminologyItem objTerm) {
        terminology.add(new UBTerminologyItem(objTerm.getIdentifier(),
                                              objTerm.getEnglish(),
                                              objTerm.getKorean()));

    }

    @Override
    public String toString() {
        return "UBGradingItem{\n" +
                "identifier='" + identifier + '\'' +
                ",\nterminology:" + terminology.toString() +
                "\n }";
    }
}
