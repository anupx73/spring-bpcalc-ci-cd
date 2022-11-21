package com.bpcalc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BpPressureControllerTest {

    @Test
    public void testCalcCategory() {
        var testPressure = new BpPressure(100, 60);

        var testController = new BpPressureController();
        var testCat = testController.calcCategory(testPressure);
        
        Assertions.assertEquals(BpPressureController.BPCategory.Ideal, testCat);
    }

    @Test
    public void testCalcAveragePressure_1() {
        var testController = new BpPressureController();
        var avgPressure = testController.calcAveragePressure();

        Assertions.assertEquals("", avgPressure);
    }

    @Test
    public void testCalcAveragePressure_2() {
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

    @Test
    public void testShowIndex() {
        var testController = new BpPressureController();
        var page = testController.showIndex(null);

        Assertions.assertEquals("index", page);
    }

    // @Test
    // public void testUpdateIndex() {
    //     var testController = new BpPressureController();
    //     var testPressure = new BpPressure(100, 60);
        
    //     var page = testController.updateIndex(testPressure, null, null);

    //     assertEquals("index", page);
    // }

    // @Test
    // public void testShowHistory() {
    //     var testModel = new Model;
    //     var testController = new BpPressureController();
    //     var page = testController.showHistory(testModel);

    //     assertEquals("history", page);
    // }
}
