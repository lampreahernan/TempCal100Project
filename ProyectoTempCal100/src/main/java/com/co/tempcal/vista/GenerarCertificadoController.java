package com.co.tempcal.vista;

import com.co.tempcal.controlador.VentanaPrincipal;
import com.co.tempcal.modelo.CertificadoDTO;
import com.co.tempcal.modelo.InformacionCalibracionDTO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GenerarCertificadoController {

	

	@FXML
	private Button btnGuardarCertificado;

	/**
	 * Referencia al Main Principal
	 */
	private VentanaPrincipal mainVentana;
	
	/**
	 * DTO sobre el proceso
	 */
	private InformacionCalibracionDTO infoCalibracion;

	private Stage dialogStage;
	

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Setea el stage para el dialogo
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage, InformacionCalibracionDTO infoCalibracion) {
		this.dialogStage = dialogStage;
		this.infoCalibracion = infoCalibracion;
	}

	/**
	 * Llamado cuando el boton siguiente es precionado
	 */
	@FXML
	private void handleGuardar() {

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
