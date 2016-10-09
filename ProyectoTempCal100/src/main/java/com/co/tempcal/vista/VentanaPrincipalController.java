package com.co.tempcal.vista;

import com.co.tempcal.controlador.VentanaPrincipal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VentanaPrincipalController {

	@FXML
	private Button btnNuevoProceso;

	@FXML
	private Button btnSalir;
	
	/**
	 * Referencia al Main Principal
	 */
	private VentanaPrincipal mainVentana;
	
	
	/**
	 * Constructor
	 */
	public VentanaPrincipalController() {
	}
	
	/**
	 * 
	 */
	private void initialize(){
	}
	
	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void controladorBtnNuevo() {
		
		boolean isSiguienteClicked = mainVentana.MostrarPanelDatosBasicos();
	    if (isSiguienteClicked) {
	    }
		
	}
	
	
	 /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(VentanaPrincipal mainApp) {
        this.mainVentana = mainApp;
    }

	
	
	
}
