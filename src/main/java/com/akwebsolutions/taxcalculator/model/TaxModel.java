package com.akwebsolutions.taxcalculator.model;

public class TaxModel {

	private int year;
	private String marginalTaxCode;
	private String description;

	public TaxModel(int year, String marginalTaxCode, String description) {
		super();
		this.year = year;
		this.marginalTaxCode = marginalTaxCode;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getMarginalTaxCode() {
		return marginalTaxCode;
	}

	public int getYear() {
		return year;
	}

	public TaxModel() {
	}

}
