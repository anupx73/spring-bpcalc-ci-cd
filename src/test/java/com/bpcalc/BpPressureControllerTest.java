package com.bpcalc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.text.SimpleDateFormat;
import java.util.Date;

class BpPressureControllerTest {

    @Test
    void testCalcCategory_1() {
        var testPressure = new BpPressure(80, 50);

        var testController = new BpPressureController();
        var testCat = testController.calcCategory(testPressure);
        
        Assertions.assertEquals(BpPressureController.BPCategory.LOW, testCat);
    }

    @Test
    void testCalcCategory_2() {
        var testPressure = new BpPressure(100, 60);

        var testController = new BpPressureController();
        var testCat = testController.calcCategory(testPressure);
        
        Assertions.assertEquals(BpPressureController.BPCategory.IDEAL, testCat);
    }

    @Test
    void testCalcCategory_3() {
        var testPressure = new BpPressure(180, 100);

        var testController = new BpPressureController();
        var testCat = testController.calcCategory(testPressure);
        
        Assertions.assertEquals(BpPressureController.BPCategory.HIGH, testCat);
    }

    @Test
    void testCalcCategory_4() {
        var testPressure = new BpPressure(80, 100);

        var testController = new BpPressureController();
        var testCat = testController.calcCategory(testPressure);
        
        Assertions.assertEquals(BpPressureController.BPCategory.INVALID, testCat);
    }

    @Test
    void testCalcAveragePressure_1() {
        var testController = new BpPressureController();
        var avgPressure = testController.calcAveragePressure();

        Assertions.assertEquals("", avgPressure);
    }

    @Test
    void testCalcAveragePressure_2() {
        var testController = new BpPressureController();

        var formatter = new SimpleDateFormat("HH:mm:ss");
        var pressurreData_1 = new HistoricalPressure(formatter.format(new Date()), "Ideal Blood Pressure", 
        "100", 
        "60");

        var pressurreData_2 = new HistoricalPressure(formatter.format(new Date()), "High Blood Pressure", 
        "120", 
        "90");

        testController.historyList.add(pressurreData_1);
        testController.historyList.add(pressurreData_2);

        var avgPressure = testController.calcAveragePressure();

        Assertions.assertEquals("110/75, Ideal Blood Pressure", avgPressure);
    }
}
