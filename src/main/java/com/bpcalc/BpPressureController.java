package com.bpcalc;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BpPressureController {
    @GetMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("bpPressure", new BpPressure());
		return "index";
	}

	@PostMapping("/")
	public String updateIndex(@ModelAttribute BpPressure bpPressure, Model model) {
		String category = calcCategory(bpPressure).getDisplayValue();
		bpPressure.setCategory(category);
		
		System.out.println(bpPressure.getSystolic());
		System.out.println(bpPressure.getDiastolic());
		System.out.println(bpPressure.getCategory());
		
		model.addAttribute("bpPressure", bpPressure);
		return "index";
	}

	public enum BPCategory
    {
		Invalid("Invalid Pressure"),
        Low("Low Blood Pressure"),
        Ideal("Ideal Blood Pressure"),
        PreHigh("Pre-High Blood Pressure"),
        High("High Blood Pressure");

		private final String displayValue;

		private BPCategory(String displayValue) {
			this.displayValue = displayValue;
		}

		public String getDisplayValue() {
			return displayValue;
		}
    }

	public BPCategory calcCategory(BpPressure bpPressure)
	{
		BPCategory resultCategory = BPCategory.Invalid;

		if (bpPressure.getSystolic() < 90 && bpPressure.getDiastolic() < 60)
			resultCategory = BPCategory.Low;
		else if (bpPressure.getSystolic() < 120 && bpPressure.getDiastolic() < 80)
			resultCategory = BPCategory.Ideal;
		else if (bpPressure.getSystolic() < 140 && bpPressure.getDiastolic() < 90)
			resultCategory = BPCategory.PreHigh;
		else if (bpPressure.getSystolic() <= 190 && bpPressure.getDiastolic() <= 100)
			resultCategory = BPCategory.High;
		else
			throw new java.lang.UnsupportedOperationException("BP calc logic failure!!!");

		return resultCategory;
	}
}
