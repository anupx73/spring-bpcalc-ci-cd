package com.bpcalc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class HistoricalPressureTest {
    @Test
    void testGet_1() {
        var testCat = new HistoricalPressure("11-12-2021", "Ideal", "100", "60");
        
        Assertions.assertEquals("Ideal", testCat.getCategory());
        Assertions.assertEquals("11-12-2021", testCat.getTimestamp());
        Assertions.assertEquals("100", testCat.getSystolic());
        Assertions.assertEquals("60", testCat.getDiastolic());
    }

    @Test
    void testSet_1() {
        var testCat = new HistoricalPressure("", "", "", "");
        testCat.setCategory("Ideal");
        testCat.setTimestamp("11-12-2021");
        testCat.setSystolic("100");
        testCat.setDiastolic("60");

        Assertions.assertEquals("Ideal", testCat.getCategory());
        Assertions.assertEquals("11-12-2021", testCat.getTimestamp());
        Assertions.assertEquals("100", testCat.getSystolic());
        Assertions.assertEquals("60", testCat.getDiastolic());
    }
}
