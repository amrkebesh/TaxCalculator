package com.akwebsolutions.taxcalculator.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import com.akwebsolutions.taxcalculator.model.TaxModel;
import com.akwebsolutions.taxcalculator.model.TaxRange;
import com.google.gson.Gson;

import spark.Request;
import spark.Response;



public class TaxResource {

	
	final static TaxModel taxModel_17_S = new TaxModel(2017, "S", "Single");
	final static TaxModel taxModel_17_MFJ= new TaxModel(2017, "MFJ", "Married Filing Jointly");
	final static TaxModel taxModel_17_QW = new TaxModel(2017, "QW", "Qualified Widow(er)");	
	final static TaxModel taxModel_17_MFS = new TaxModel(2017, "MFS", "Married Filing Separately");
	final static TaxModel taxModel_17_HH = new TaxModel(2017, "HH", "Head of Household");
	
	
	static Gson gson = new Gson();

	public static String getTaxRate(Request req, Response res) {
		
		
		List<TaxRange> list = new ArrayList<>();
			
		TaxRange.addModel(list, taxModel_17_S, 0, 9325.99f, 0.1f,"S1");
		TaxRange.addModel(list, taxModel_17_S, 9326, 37950.99f, 0.15f,"S2");
		TaxRange.addModel(list, taxModel_17_S, 37951, 91900.99f, 0.25f,"S3");
		TaxRange.addModel(list, taxModel_17_S, 91901, 191650.99f, 0.28f,"S4");
		TaxRange.addModel(list, taxModel_17_S, 191651, 416700.99f, 0.33f,"S5");
		TaxRange.addModel(list, taxModel_17_S, 416701, 418400.99f, 0.35f,"S6");
		TaxRange.addModel(list, taxModel_17_S, 418401, 9999999.99f, 0.396f,"S7");
		
		TaxRange.addModel(list, taxModel_17_MFJ, 0, 18650.99f, 0.1f, "MFJ1");
		TaxRange.addModel(list, taxModel_17_MFJ, 18651, 75900.99f, 0.15f, "MFJ2");
		TaxRange.addModel(list, taxModel_17_MFJ, 75901, 153100.99f, 0.25f, "MFJ3");
		TaxRange.addModel(list, taxModel_17_MFJ, 153101, 233350.99f, 0.28f, "MFJ4");
		TaxRange.addModel(list, taxModel_17_MFJ, 233351, 416700.99f, 0.33f, "MFJ5");
		TaxRange.addModel(list, taxModel_17_MFJ, 416701, 470700.99f, 0.35f, "MFJ6");
		TaxRange.addModel(list, taxModel_17_MFJ, 470701, 9999999.99f, 0.396f, "MFJ7");

		TaxRange.addModel(list, taxModel_17_QW, 0, 18650.99f, 0.1f, "QW1");
		TaxRange.addModel(list, taxModel_17_QW, 18651, 75900.99f, 0.15f, "QW2");
		TaxRange.addModel(list, taxModel_17_QW, 75901, 153100.99f, 0.25f, "QW3");
		TaxRange.addModel(list, taxModel_17_QW, 153101, 233350.99f, 0.28f, "QW4");
		TaxRange.addModel(list, taxModel_17_QW, 233351, 416700.99f, 0.33f, "QW5");
		TaxRange.addModel(list, taxModel_17_QW, 416701, 470700.99f, 0.35f, "QW6");
		TaxRange.addModel(list, taxModel_17_QW, 470701, 9999999.99f, 0.396f, "QW7");
		
		TaxRange.addModel(list, taxModel_17_MFS, 0, 9325.99f, 0.1f, "MFS1");
		TaxRange.addModel(list, taxModel_17_MFS, 9326, 37950.99f, 0.15f, "MFS2");
		TaxRange.addModel(list, taxModel_17_MFS, 37951, 76550.99f, 0.25f, "MFS3");
		TaxRange.addModel(list, taxModel_17_MFS, 76551, 116675.99f, 0.28f, "MFS4");
		TaxRange.addModel(list, taxModel_17_MFS, 116676, 208350.99f, 0.33f, "MFS5");
		TaxRange.addModel(list, taxModel_17_MFS, 208351, 235350.99f, 0.35f, "MFS6");
		TaxRange.addModel(list, taxModel_17_MFS, 235351, 9999999.99f, 0.396f, "MFS7");
		
		TaxRange.addModel(list, taxModel_17_HH, 0, 13350.99f, 0.1f, "HH1");
		TaxRange.addModel(list, taxModel_17_HH, 13351, 50800.99f, 0.15f, "HH2");
		TaxRange.addModel(list, taxModel_17_HH, 50801, 131200.99f, 0.25f, "HH3");
		TaxRange.addModel(list, taxModel_17_HH, 131201, 212500.99f, 0.28f, "HH4");
		TaxRange.addModel(list, taxModel_17_HH, 212501, 416700.99f, 0.33f, "HH5");
		TaxRange.addModel(list, taxModel_17_HH, 416701, 444550.99f, 0.35f, "HH6");
		TaxRange.addModel(list, taxModel_17_HH, 444501, 9999999.99f, 0.396f, "HH7");
		
		res.type("application/json");
		int year = Integer.parseInt(req.params(":year"));
		String marginalTaxCode = req.params(":marginalTaxCode");
		float annualIncome = Float.parseFloat(req.params(":annualIncome"));
		
		System.out.println(year +marginalTaxCode +annualIncome);
		
		
		
		Optional<TaxRange> x = TaxCalculator.calculate(list, year, marginalTaxCode, annualIncome);
		
		System.out.println(x.get().getTaxModel().getYear());
		
		HashMap<String, Object> map = new LinkedHashMap<>();
		map.put("code", x.get().getCode());
		map.put("taxRate", x.get().getTaxRate());	
		map.put("startSalary", x.get().getStartSalary());
		map.put("endSalary",x.get().getEndSalary());		
		map.put("status",x.get().getTaxModel().getMarginalTaxCode());	
		map.put("description",x.get().getTaxModel().getDescription());
		
		return gson.toJson(map);
		
	}
	
}
