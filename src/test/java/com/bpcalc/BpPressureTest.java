package com.bpcalc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BpPressureTest {
    @Test
    void testGet_1() {
        var testPressure = new BpPressure(120, 70);
        
        Assertions.assertEquals(120, testPressure.getSystolic());
        Assertions.assertEquals(70, testPressure.getDiastolic());
    }

    @Test
    void testSet_1() {
        var testPressure = new BpPressure(0, 0);

        testPressure.setSystolic(120);
        testPressure.setDiastolic(70);
        
        Assertions.assertEquals(120, testPressure.getSystolic());
        Assertions.assertEquals(70, testPressure.getDiastolic());
    }

    @Test
    void testCategorySet() {
        var testPressure = new BpPressure();

        testPressure.setCategory("Ideal");
        Assertions.assertEquals("Ideal", testPressure.getCategory());
    }
}
