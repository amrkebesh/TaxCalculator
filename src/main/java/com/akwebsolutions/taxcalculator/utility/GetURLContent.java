package com.akwebsolutions.taxcalculator.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class GetURLContent {
	
	
	public static <T> T getData(String url, Class<T> classOfT) {		
		Gson gson = new Gson();
		String json = getData(url);
		T t  = gson.fromJson(json, classOfT);		
		return t;		
	}	
	
	public static String  getData(String sURL) {

		URL url;

		try {
			// get URL content
			url = new URL(sURL);
			URLConnection conn = url.openConnection();

			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

			String inputLine;	
			StringBuilder output = new StringBuilder();

			while ((inputLine = br.readLine()) != null) {
				output.append(inputLine);
			}				
			return output.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "";
	}
	
}
