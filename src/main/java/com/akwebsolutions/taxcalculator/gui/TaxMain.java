package com.akwebsolutions.taxcalculator.gui;



import com.akwebsolutions.taxcalculator.utility.GlobalVariables;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TaxMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
    	Parent root = FXMLLoader.load(getClass().getResource("A.MarignalTaxView.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
       
        // * new * 
        primaryStage.setResizable(false);   
        primaryStage.setTitle("Tax Margin");

    }

    public static void main(String[] args) {   	
    	
    	if (args.length > 0) {
    		GlobalVariables.portNumber = (Integer.parseInt(args[0]));    		
    	}    	
    	
        launch(args);
    }
}