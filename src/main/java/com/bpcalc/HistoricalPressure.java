package com.bpcalc;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class HistoricalPressure {
    private String timestamp;
    private String category;
    private String systolic;
    private String diastolic;

    public HistoricalPressure(String timestamp, String category, String systolic, String diastolic) {
        this.timestamp = timestamp;
        this.category = category;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }
}
