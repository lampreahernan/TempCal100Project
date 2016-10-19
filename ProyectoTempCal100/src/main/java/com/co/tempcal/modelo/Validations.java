package com.co.tempcal.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Validations {
	
	private Validations(){
	}
	
	public static boolean validatedNumber(String text){
		Pattern pat = Pattern.compile("[0-9]+");
		Matcher mat = pat.matcher(text);

		if(text.isEmpty() || mat.matches()) {
		    return true;
		}else {
			return false;
		}
	}
	
	public static boolean validatedLetter(String text){
		Pattern pat = Pattern.compile("[a-zA-Z]+");
		Matcher mat = pat.matcher(text);

		if(text.isEmpty() || mat.matches()) {
		    return true;
		}else {
			return false;
		}
	}
	
	public static boolean validatedDecimals(String text){
		Pattern pat = Pattern.compile("[0-9]{2,3}[.]{1}[0-9]{1}+");
		Matcher mat = pat.matcher(text);

		if(text.isEmpty() || mat.matches()) {
		    return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Show Error Alert
	 * 
	 * @param errorMessage
	 */
	public static void showAlert(String errorMessage) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Invalid Fields");
		alert.setHeaderText("Please correct invalid fields");
		alert.setContentText(errorMessage);

		alert.showAndWait();
	}
	
}
