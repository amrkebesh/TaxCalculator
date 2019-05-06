package com.akwebsolutions.taxcalculator.model;

import java.util.List;

public class TaxRange extends TaxModel {
	private TaxModel taxModel;
	private float startSalary;
	private float endSalary;
	private float taxRate;
	private String code;


	public String getCode() {
		return code;
	}

	public TaxModel getTaxModel() {
		return taxModel;
	}
	
	public float getStartSalary() {
		return startSalary;
	}

	public float getEndSalary() {
		return endSalary;
	}

	public float getTaxRate() {
		return taxRate;
	}

	

	public TaxRange(TaxModel taxModel, float startSalary, float endSalary, float taxRate, String code) {
		super();
		this.taxModel = taxModel;
		this.startSalary = startSalary;
		this.endSalary = endSalary;
		this.taxRate = taxRate;
		this.code = code;
	}

	public static void addModel(List<TaxRange> list, TaxModel taxModel, float startSalary, float endSalary, float taxRate, String code) {
		list.add(new TaxRange(taxModel, startSalary, endSalary, taxRate, code));
	}
	
}
