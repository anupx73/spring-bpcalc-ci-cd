package com.bpcalc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class BpPressure {

	public BpPressure(){}

	public BpPressure(Integer systolic, Integer diastolic) {
		this.systolic = systolic;
		this.diastolic = diastolic;
	}

	public final short SystolicMin = 70;
	public final short SystolicMax = 190;
	public final short DiastolicMin = 40;
	public final short DiastolicMax = 100;

	@NotNull
	@Min(SystolicMin)
	@Max(SystolicMax)
	@Getter
	@Setter
	private Integer systolic;

	@NotNull
	@Min(DiastolicMin)
	@Max(DiastolicMax)
	@Getter
	@Setter
	private Integer diastolic;

	@Getter
	@Setter
	private String category = null;
}
