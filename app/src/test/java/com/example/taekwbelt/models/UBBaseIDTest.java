package com.example.taekwbelt.models;

import static org.junit.Assert.*;
import org.junit.Test;

public class UBBaseIDTest {

    @Test
    public void testIdentifierEmpty() {
        UBBaseID testObject = new UBBaseID("");
        assertNull(testObject.getIdentifier());
    }

    @Test
    public void testIdentifierNull() {
        UBBaseID testObject = new UBBaseID(null);
        assertNull(testObject.getIdentifier());
    }

    @Test
    public void testIdentifierNotNul() {
        UBBaseID testID = new UBBaseID("001");
        assertNotNull(testID.getIdentifier());
    }

}