package com.co.tempcal.vista;

import com.co.tempcal.controlador.MainGUI;
import com.co.tempcal.modelo.CalibrationInformationDTO;
import com.co.tempcal.modelo.CertificateDTO;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TemperatureInfoController {

	@FXML
	private Button btnNext;

	@FXML
	private Button btnCancel;
	
	@FXML
	private Button btnCalculate;
	
	@FXML
	private Button btnValidate;

	@FXML
	private TextField txtColdBathTemp;

	@FXML
	private TextField txtHotUncalibSensorTemp;

	@FXML
	private TextField txtHotCalibSensorTemp;
	
	@FXML
	private TextField txtTestColdBathTemp;
	
	@FXML
	private TextField txtTestColdSensorTemp;
	
	/**
	 * Current Stage
	 */
	private Stage dialogStage;

	/**
	 * Main GUI
	 */
	private MainGUI mainGUI;
	
	/**
	 * Proces DTO
	 */
	private CalibrationInformationDTO infoCalibracion;
	
	/**
	 * Certificate DTO
	 */
	private CertificateDTO infoCertificate;
	
	 /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }
	
	/**
	 * Current Stage
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage, CalibrationInformationDTO infoCalibracion, CertificateDTO infoCertificate) {
		this.dialogStage = dialogStage;
		this.infoCalibracion= infoCalibracion;
		this.infoCertificate=infoCertificate;
	}

	
	public void setMainApp(MainGUI mainApp) {
		this.mainGUI = mainApp;
	}

	@FXML
	private void handleNext() {
		
		infoCalibracion.setColdBathTemp1(txtColdBathTemp.getText());
		mainGUI.showHotSensorPanel(this.dialogStage, this.infoCalibracion, this.infoCertificate);
	}
	
	@FXML
	private void handleCalculate() {
		infoCalibracion.setHotSensorTemp(txtHotUncalibSensorTemp.getText());
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Result Process");
		alert.setHeaderText("TPH2");
		alert.setContentText("");
		alert.showAndWait();
		
		mainGUI.showTestTemperaturePanel(dialogStage, infoCalibracion, this.infoCertificate);
	}
	
	@FXML
	private void handleValidate() {
		
		infoCalibracion.setTestColdBathTemp(txtTestColdBathTemp.getText());
		infoCalibracion.setTestColdSensorTemp(txtTestColdSensorTemp.getText());
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Result Process");
		alert.setHeaderText("TPH2");
		alert.setContentText("PROCESS PASS");
		alert.showAndWait();
		
		mainGUI.showResultPanel(dialogStage, infoCalibracion, infoCertificate);
		
	}

}
