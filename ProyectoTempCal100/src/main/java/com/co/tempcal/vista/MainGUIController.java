package com.co.tempcal.vista;

import com.co.tempcal.controlador.MainGUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;

public class MainGUIController {

	@FXML
	private Button btnNuevoProceso;

	@FXML
	private Button btnSalir;
	
	/**
	 * Referencia al Main Principal
	 */
	private MainGUI mainVentana;
	
	
	/**
	 * Constructor
	 */
	public MainGUIController() {
	}
	
	/**
	 * 
	 */
	private void initialize(){
		 btnNuevoProceso.setEffect(new Reflection());
	}
	
	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void controladorBtnNuevo() {		
		mainVentana.showBasicInformationPanel();
	}
	
	
	 /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainGUI mainApp) {
        this.mainVentana = mainApp;
    }

	
	
	
}
