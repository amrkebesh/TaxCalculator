package com.akwebsolutions.taxcalculator.dao;

import static spark.Spark.get;
import static spark.Spark.port;

import com.akwebsolutions.taxcalculator.utility.GlobalVariables;


public class Driver {

	public static void main(String[] args) {
		
		if(args.length > 0) {
			int portNumber = Integer.parseInt(args[0]);
			port(portNumber);
		}
		else
			port(GlobalVariables.portNumber);
		
		get("/irs/:year/:marginalTaxCode/:annualIncome", TaxResource::getTaxRate);

	}

}
