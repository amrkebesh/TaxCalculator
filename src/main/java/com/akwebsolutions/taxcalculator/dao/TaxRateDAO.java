package com.akwebsolutions.taxcalculator.dao;

import com.akwebsolutions.taxcalculator.model.TaxRange;
import com.akwebsolutions.taxcalculator.utility.GetURLContent;

public class TaxRateDAO {
	
public static TaxRange findRate(String year, String code, float annualIncome) {
		
		
		//code = code.substring(0, code.length()-1);
		String url = "http://localhost:4567/irs/" + year + "/" + code + "/" + annualIncome;
		TaxRange taxRange = GetURLContent.getData(url,TaxRange.class);
		//System.out.println(taxRange.getTaxRate());
		return taxRange;
	}

}
