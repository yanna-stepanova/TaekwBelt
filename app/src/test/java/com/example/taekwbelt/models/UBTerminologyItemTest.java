package com.example.taekwbelt.models;

import static org.junit.Assert.*;
import org.junit.Test;

public class UBTerminologyItemTest {

    @Test
    public void testIdNull() {
        UBTerminologyItem testObject = new UBTerminologyItem();
        testObject.setIdentifier(null);
        assertNull(testObject.getIdentifier());
    }

    @Test
    public void testIdEmpty() {
        UBTerminologyItem testObject = new UBTerminologyItem("", "eng_text", "kor_text");
        assertNull(testObject.getIdentifier());
    }

    @Test
    public void testIdNotNull(){
        UBTerminologyItem testObject = new UBTerminologyItem();
        testObject.setIdentifier("001");
        assertNotNull(testObject.getIdentifier());
    }
}