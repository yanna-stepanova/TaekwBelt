// this class needs for refactoring: a checking for 'identifier' repeats in each class

package com.example.taekwbelt.models;

public class UBBaseID {
    // 'protected' needs for access to the field from child class
    protected String _identifier; // can't be Null

    public UBBaseID() { }

    public UBBaseID(String identifier) {
        checkNoNull(identifier);
    }

    public String getIdentifier() {
        return _identifier;
    }

    public void setIdentifier(String identifier) {
        checkNoNull(identifier);
    }

    // This function is used in two places:
    // constructor "UBBaseID(String identifier)" and method "setIdentifier(String identifier).

    // Check the field "identifier" for correct input: not null/empty.
    // If that checking is 'true' (null/empty), it will be an exception with a message
    // and the field '_identifier' will be assigned nothing.
    // If that checking is 'false' (not null/empty),
    // the field '_identifier' will be assigned a value of 'identifier'.
    public void checkNoNull (String identifier) {
        try{
            if (identifier == null || identifier.equals("") || identifier.equals(" ") )
                throw new NullPointerException("Identifier can't be Null or has nothing!"); // Doesn't it work ?!
            else this._identifier = identifier;
        } catch (NullPointerException ex){
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
