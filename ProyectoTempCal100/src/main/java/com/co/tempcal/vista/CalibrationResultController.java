package com.co.tempcal.vista;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.co.tempcal.controlador.MainGUI;
import com.co.tempcal.modelo.CertificateDTO;
import com.co.tempcal.modelo.CalibrationInformationDTO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CalibrationResultController {

	@FXML
	private TextField txtDate;

	@FXML
	private TextField txtSerial;

	@FXML
	private TextField txtCalibBy;

	@FXML
	private TextField txtTypeTemp;

	@FXML
	private TextField txtColdBathTemp;
	
	@FXML
	private TextField txtHotBathTemp;

	@FXML
	private TextField txtHotUncalibSensor;

	@FXML
	private TextField txtHotCalibSensor;

	@FXML
	private TextField txtTestColdBath;

	@FXML
	private TextField txtTestColdSensor;

	@FXML
	private TextField txtProcedureResult;

	@FXML
	private TextField txtTimeProcedure;

	@FXML
	private Button btnGeneteCertificate;

	@FXML
	private Button btnResetProcess;

	/**
	 * 
	 */
	private Stage dialogStage;

	/**
	 * Main GUI
	 */
	private MainGUI mainGUI;

	/**
	 * Process DTO
	 */
	private CalibrationInformationDTO infoCalibration;

	/**
	 * Certificate DTO
	 */
	private CertificateDTO infoCertificate;

	@FXML
	private void initialize() {
	}

	/**
	 * Current Stage
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage, CalibrationInformationDTO infoCalibration,
			CertificateDTO infoCertificate) {
		this.dialogStage = dialogStage;
		this.infoCalibration = infoCalibration;
		this.infoCertificate = infoCertificate;
		loadInformation(this.infoCalibration);

	}

	private void loadInformation(CalibrationInformationDTO infoCalibracion) {

		txtDate.setText(infoCalibracion.getCalibrationDate());
		txtSerial.setText(infoCalibracion.getSerial());
		txtCalibBy.setText(infoCalibracion.getCalibrationPerson());
		txtTypeTemp.setText(infoCalibracion.getTemperatureType());
		txtColdBathTemp.setText(infoCalibracion.getColdBathTemp1());
		txtHotCalibSensor.setText(infoCalibracion.getHotSensorTemp2());
		txtHotUncalibSensor.setText(infoCalibracion.getHotSensorTemp());
		txtTestColdBath.setText(infoCalibracion.getTestColdBathTemp());
		txtTestColdSensor.setText(infoCalibracion.getTestColdSensorTemp());
		txtProcedureResult.setText(infoCalibracion.getResultProcess());
		txtHotBathTemp.setText(infoCalibracion.getHotBathTemp());
		
		if(infoCalibracion.getResultProcess().equals("PROCESS PASSED")){
			btnGeneteCertificate.setDisable(false);
			btnResetProcess.setDisable(true);
		}else{
			btnGeneteCertificate.setDisable(true);
			btnResetProcess.setDisable(false);
		}
		
	}

	/**
	 * Llamado cuando el boton siguiente es precionado
	 */
	@FXML
	private void handleGenerate() {
		
		try {	
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save Certifcate");
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text", "*.pdf");
			fileChooser.getExtensionFilters().add(extFilter);
			fileChooser.setInitialFileName("Certificate Machine" + this.infoCertificate.getMachineModel());
			File certificateFile = fileChooser.showSaveDialog(this.dialogStage);
			
			if(certificateFile != null){
				createCertificate(certificateFile);
			}
		}catch(Exception err){
			err.printStackTrace();
		}
			
	}

	private File createCertificate(File file) throws IOException {

		 FileWriter fileWriter = null;
         fileWriter = new FileWriter(file);
         fileWriter.write("Hola Nuevo Certificado");
         fileWriter.close();
		
		return file;
	}

	
	@FXML
	private void handleReset() {
		this.dialogStage.close();
		mainGUI.showBasicInformationPanel();
	}

	public void setMainApp(MainGUI mainApp) {
		this.mainGUI = mainApp;
	}

}
