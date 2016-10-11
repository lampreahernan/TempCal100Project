package com.co.tempcal.vista;

import com.co.tempcal.controlador.VentanaPrincipal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DatosTemperaturaController {

	@FXML
	private Button btnSiguiente;

	@FXML
	private Button btnCancel;

	@FXML
	private TextField txtColdBathTemp;

	@FXML
	private TextField txtHotUncalibSensorTemp;

	@FXML
	private TextField txtHotCalibSensorTemp;

	private Stage dialogStage;

	/**
	 * Referencia al Main Principal
	 */
	private VentanaPrincipal mainVentana;
	
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
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(VentanaPrincipal mainApp) {
		this.mainVentana = mainApp;
	}

	@FXML
	private void handleSiguiente() {

		mainVentana.mostrarPanelResultado(dialogStage);

	}

}
