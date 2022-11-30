package com.bpcalc;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.bpcalc.BpPressureController.BPCategory;

public class BpPressureControllerSteps {

	private BpPressureController bpPressureController = new BpPressureController();

    private Integer systolic = 0;
    private Integer diastolic = 0;
    private BPCategory bpCategory = BPCategory.Invalid;

	private String output = "";

	public BpPressureControllerSteps() {
	}

    @Given("A systolic Integer of $systolic and diastolic Integer of $diastolic")
	public void givenInput(Integer systolic, Integer diastolic) {
		this.systolic = systolic;
		this.diastolic = diastolic;
	}

	@When("calcCategory method of BpPressureController.java is called")
	public void whenBusinessLogicCalled() {
		bpCategory = bpPressureController.calcCategory(new BpPressure(systolic, diastolic));
	}

	@Then("It should return $response")
	public void thenCheckOutput(String response) {
		output = bpCategory.getDisplayValue();
        Assert.assertEquals(output, response);
	}
}