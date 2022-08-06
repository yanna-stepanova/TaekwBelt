// this class needs for refactoring: a checking for 'identifier' repeats in each classe

package com.example.taekwbelt.models;

public class UBBaseID {
    // 'protected' needs for access to the field from child classe
    protected String identifier; // can't be Null

    public UBBaseID() { }

    public UBBaseID(String identifier) {
        checkNoNull(identifier);
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        checkNoNull(identifier);
    }

    // a function to check  set value 'checkID' for null or empty
    // if it's true (null/empty), it will print a message
    // if it's false (not nul/empty), a value of 'checkID' is defined to 'identifier' of this class
    public void checkNoNull (String checkedID){
        try{
            if (checkedID.isEmpty() || checkedID == null)
                throw new Exception("Identifier can't be Null or empty!");
            else this.identifier = checkedID;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "UBBaseID{" +
                "identifier='" + getIdentifier() + '\'' +
                '}';
    }
}
