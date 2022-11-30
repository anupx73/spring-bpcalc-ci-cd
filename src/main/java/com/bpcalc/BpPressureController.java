package com.bpcalc;

import org.springframework.ui.Model;

import java.util.LinkedList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

@Controller
public class BpPressureController {
	
	private List<HistoricalPressure> historyList = new LinkedList<HistoricalPressure>();

    @GetMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("bpPressure", new BpPressure());
		return "index";
	}

	@PostMapping("/")
	public String updateIndex(@Valid @ModelAttribute BpPressure bpPressure, BindingResult bindingResult, Model model) {
		// Validation error
		if (bindingResult.hasErrors()) {
            return "index";
        }

		// Calculating the category
		BPCategory categoryId = calcCategory(bpPressure);
		String categoryValue = categoryId.getDisplayValue();

		// Storing to list for History table
		if (categoryId != BPCategory.Invalid) {
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			HistoricalPressure pressurreData = new HistoricalPressure(formatter.format(new Date()), categoryValue, 
												bpPressure.getSystolic().toString(), 
												bpPressure.getDiastolic().toString());
			historyList.add(pressurreData);
		}

		// Setting calculated category for view
		bpPressure.setCategory(categoryValue);
		model.addAttribute("bpPressure", bpPressure);

		return "index";
	}

	@GetMapping("/history")
	public String showHistory(Model model) {
		model.addAttribute("historyList", historyList);
		model.addAttribute("avgPressure", calcAveragePressure());
		return "history";
	}
	
	public enum BPCategory
    {
		Invalid("Invalid Pressure! Systolic should be higher than Diastolic"),
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
		
		if (bpPressure.getSystolic() < bpPressure.getDiastolic()) {
			return resultCategory;
		}

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

	private String calcAveragePressure() {
		String avgPressureValue = "";

		if (!historyList.isEmpty()) {
			Integer avgSys = 0;
			Integer avgDias = 0;
			for (HistoricalPressure data : historyList) {
				avgSys += Integer.parseInt(data.getSystolic());
				avgDias += Integer.parseInt(data.getDiastolic());
			}
			avgSys = avgSys / historyList.size();
			avgDias = avgDias / historyList.size();
			BPCategory avgCategory = calcCategory(new BpPressure(avgSys, avgDias));
			// avgPressureValue = "Systolic (" + avgSys.toString() + "), " + 
			// 					"Diastolic (" + avgDias.toString() + "), " + 
			// 					"Category (" + avgCategory.getDisplayValue() + ")";
			avgPressureValue = avgSys.toString() + "/" + avgDias.toString() + ", " + avgCategory.getDisplayValue();

		}

		return avgPressureValue;
	}
}
