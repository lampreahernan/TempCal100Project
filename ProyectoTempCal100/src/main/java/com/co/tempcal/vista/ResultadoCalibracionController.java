package com.co.tempcal.vista;

import com.co.tempcal.modelo.CertificadoDTO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ResultadoCalibracionController {
	

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
	private Button btnGenerarCertificado;
	
	@FXML
	private Button btnReiniciarProceso;
	
	/**
	 * 
	 */
	private Stage dialogStage;
	
	/**
	 * 
	 */
    private CertificadoDTO infoCertificado;
    
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
     * Llamado cuando el boton siguiente es precionado
     */
    @FXML
    private void handleGenerar() {
        
    }
    
    /**
     * Llamado cuando el boton siguiente es precionado
     */
    @FXML
    private void handleReiniciar() {
        
    }
    
    
}
