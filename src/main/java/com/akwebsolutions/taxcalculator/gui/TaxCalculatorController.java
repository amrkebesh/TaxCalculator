package com.akwebsolutions.taxcalculator.gui;

import java.util.ArrayList;
import java.util.List;

import com.akwebsolutions.taxcalculator.dao.TaxRateDAO;
import com.akwebsolutions.taxcalculator.model.TaxRange;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;

public class TaxCalculatorController {

	 @FXML
	    private FlowPane fpTaxes;

	    @FXML
	    private TextField txtSalary;

	    @FXML
	    private Button btnCalculate;

	    @FXML
	    private RadioButton rbSingle;

	    @FXML
	    private ToggleGroup tgStatus;

	    @FXML
	    private RadioButton rbQualifiedWindow;

	    @FXML
	    private RadioButton rbMarriedFilingSingle;

	    @FXML
	    private RadioButton rbMarriedFilingJointly;

	    @FXML
	    private RadioButton rbHHH;

	    @FXML
	    private RadioButton rbAll;

	final String highLight = "-fx-background-color: silver;";
	final String clear = "";

	@FXML
	void calculateTaxes(ActionEvent event) {

		String code = tgStatus.getSelectedToggle().getUserData().toString();
		float annualIncome = Float.parseFloat(txtSalary.getText());

		List<TaxRange> tr = new ArrayList<>();

		if (code.equals("All")) {
			tr.add(TaxRateDAO.findRate("2017", "S", annualIncome));
			tr.add(TaxRateDAO.findRate("2017", "MFJ", annualIncome));
			tr.add(TaxRateDAO.findRate("2017", "MFS", annualIncome));
			tr.add(TaxRateDAO.findRate("2017", "QW", annualIncome));
			tr.add(TaxRateDAO.findRate("2017", "HH", annualIncome));
		}

		else
			tr.add(TaxRateDAO.findRate("2017", code, annualIncome));

		fpTaxes.getChildren().stream().forEach(e -> {
			Label l = (Label) e;
			l.setStyle(clear);
			tr.stream().forEach(i -> {
				if (i.getCode().equals(l.getUserData()))
					l.setStyle(highLight);
			});
		});

		System.out.println(tgStatus.getSelectedToggle().getUserData());
	}

/*	@FXML
	void highLight(MouseEvent event) {
		
		 fpCode.getChildren().stream().forEach(e -> { Label l2 = (Label) e;
		 l2.setStyle(clear); });
		 
		  Label l = (Label) event.getTarget(); 
		  String code = (String) l.getUserData();
		  //System.out.println(code); 
		  l.setStyle(highLight);
		 
	}*/

}
