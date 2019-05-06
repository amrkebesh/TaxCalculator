package com.akwebsolutions.taxcalculator.dao;

import java.util.List;
import java.util.Optional;

import com.akwebsolutions.taxcalculator.model.TaxRange;



public class TaxCalculator {

	public static Optional<TaxRange> calculate(List<TaxRange> list, int year, String marginalTaxCode, float annualIncome) {

		Optional<TaxRange> x = list.stream().filter(
				e -> e.getEndSalary() >= annualIncome 
				&& e.getStartSalary() <= annualIncome 
				&& e.getTaxModel().getYear() == year 
				&& e.getTaxModel().getMarginalTaxCode().equalsIgnoreCase(marginalTaxCode))
				.findFirst();

		if (x.isPresent())
			return x;

		return null;
	}

}
