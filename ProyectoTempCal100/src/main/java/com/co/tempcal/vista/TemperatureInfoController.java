package com.co.tempcal.vista;

import com.co.tempcal.controlador.MainGUI;
import com.co.tempcal.modelo.CalibrationInformationDTO;
import com.co.tempcal.modelo.CertificateDTO;
import com.co.tempcal.modelo.TemperatureCalculations;
import com.co.tempcal.modelo.Validations;

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
	 * Temperature Calculations
	 */
	private TemperatureCalculations calculations;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		this.calculations = new TemperatureCalculations();
	}

	/**
	 * Current Stage
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage, CalibrationInformationDTO infoCalibracion,
			CertificateDTO infoCertificate) {
		this.dialogStage = dialogStage;
		this.infoCalibracion = infoCalibracion;
		this.infoCertificate = infoCertificate;
	}

	public void setMainApp(MainGUI mainApp) {
		this.mainGUI = mainApp;
	}

	@FXML
	private void handleNext() {

		String errorMessage = "";

		if (txtColdBathTemp.getText() == null || txtColdBathTemp.getText().length() == 0) {
			errorMessage += "Set the Cold Bath Temp \n";
		} else {
			if (!Validations.validatedDecimals(txtColdBathTemp.getText())) {
				errorMessage += "Only a numbers in the Cold Bath field with ONE decimal \n";
			}
		}

		if (errorMessage.length() == 0) {
			infoCalibracion.setColdBathTemp1(txtColdBathTemp.getText());
			mainGUI.showHotSensorPanel(this.dialogStage, this.infoCalibracion, this.infoCertificate);
		} else {
			Validations.showAlert(errorMessage);
		}

	}

	@FXML
	private void handleCalculate() {

		String errorMessage = "";

		if (txtHotUncalibSensorTemp.getText() == null || txtHotUncalibSensorTemp.getText().length() == 0) {
			errorMessage += "Set the Cold Bath Temp \n";
		} else {
			if (!Validations.validatedDecimals(txtHotUncalibSensorTemp.getText())) {
				errorMessage += "Only a numbers in the Hot Uncalib Sensor field with ONE decimal \n";
			}
		}

		if (errorMessage.length() == 0) {
			infoCalibracion.setHotSensorTemp(txtHotUncalibSensorTemp.getText());
			float factor = calculations.calculateFactor(infoCalibracion.getColdBathTemp1(),
					infoCalibracion.getHotSensorTemp(), infoCalibracion.getTemperatureType());

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Calculation Factor");
			alert.setHeaderText("Temperatura del Sensor");
			alert.setContentText(String.valueOf(factor));
			alert.showAndWait();

			mainGUI.showTestTemperaturePanel(dialogStage, infoCalibracion, this.infoCertificate);
		} else {
			Validations.showAlert(errorMessage);
		}

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
