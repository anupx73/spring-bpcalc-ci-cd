package com.bpcalc;

// import javax.validation.constraints.Max;
// import javax.validation.constraints.Min;
// import javax.validation.constraints.NotNull;

public class BpPressure {

	public BpPressure(){}

	public BpPressure(Integer systolic, Integer diastolic) {
		this.systolic = systolic;
		this.diastolic = diastolic;
	}

	// public final Integer SystolicMin = 70;
	// public final Integer SystolicMax = 190;
	// public final Integer DiastolicMin = 40;
	// public final Integer DiastolicMax = 100;

	// @NotNull
	// @Min(SystolicMin)
	// @Max(SystolicMax)
	private Integer systolic;

	// @NotNull
	// @Min(DiastolicMin)
	// @Max(DiastolicMax)
	private Integer diastolic;

	private String category = null;

	public Integer getSystolic() {
		return this.systolic;
	}

	public void setSystolic(Integer systolic) {
		this.systolic = systolic;
	}

	public Integer getDiastolic() {
		return this.diastolic;
	}

	public void setDiastolic(Integer diastolic) {
		this.diastolic = diastolic;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
