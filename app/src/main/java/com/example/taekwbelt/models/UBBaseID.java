// this class needs for refactoring: a checking for 'identifier' repeats in each class

package com.example.taekwbelt.models;

public class UBBaseID {
    // 'protected' needs for access to the field from child class
    protected String _identifier; // can't be Null

    public UBBaseID() { }

    public UBBaseID(String identifier) {
        setIdentifier(identifier);
    }

    public String getIdentifier() {
        return _identifier;
    }

    // If identifier is null, an empty string or a string which equals to a space,
    // then throws an exception and no value will be assigned to the identifier variable;
    // Otherwise, assigns value to the identifier variable.
    public void setIdentifier(String identifier) {
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
