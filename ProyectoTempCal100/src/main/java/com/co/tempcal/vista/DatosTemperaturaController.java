package com.co.tempcal.vista;

import com.co.tempcal.controlador.VentanaPrincipal;
import com.co.tempcal.modelo.InformacionCalibracionDTO;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DatosTemperaturaController {

	@FXML
	private Button btnSiguiente;

	@FXML
	private Button btnCancel;
	
	@FXML
	private Button btnCalcular;

	@FXML
	private TextField txtColdBathTemp;

	@FXML
	private TextField txtHotUncalibSensorTemp;

	@FXML
	private TextField txtHotCalibSensorTemp;
	
	/**
	 * 
	 */
	private Stage dialogStage;

	/**
	 * Referencia al Main Principal
	 */
	private VentanaPrincipal mainVentana;
	
	/**
	 * DTO sobre el proceso
	 */
	private InformacionCalibracionDTO infoCalibracion;
	
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
		this.infoCalibracion= infoCalibracion;
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
		mainVentana.mostrarHotSensorPanel(dialogStage, infoCalibracion);
	}
	
	@FXML
	private void handleCalcular() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Result Process");
		alert.setHeaderText("PROCESS PASS");
		alert.setContentText("TPH2 es :");
		alert.showAndWait();
		
		mainVentana.mostrarPanelResultado(dialogStage, infoCalibracion);
	}

}
