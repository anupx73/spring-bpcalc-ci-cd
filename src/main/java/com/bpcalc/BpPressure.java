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

	public static final short SYSTOLIC_MIN = 70;
	public static final short SYSTOLIC_MAX = 190;
	public static final short DIASTOLIC_MIN = 40;
	public static final short DIASTOLIC_MAX = 100;

	@NotNull
	@Min(SYSTOLIC_MIN)
	@Max(SYSTOLIC_MAX)
	@Getter
	@Setter
	private Integer systolic;

	@NotNull
	@Min(DIASTOLIC_MIN)
	@Max(DIASTOLIC_MAX)
	@Getter
	@Setter
	private Integer diastolic;

	@Getter
	@Setter
	private String category = null;
}
