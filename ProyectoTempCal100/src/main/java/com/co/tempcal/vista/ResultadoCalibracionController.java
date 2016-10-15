package com.co.tempcal.vista;

import com.co.tempcal.controlador.VentanaPrincipal;
import com.co.tempcal.modelo.CertificadoDTO;
import com.co.tempcal.modelo.InformacionCalibracionDTO;

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
        this.infoCalibracion=infoCalibracion;
        
        cargarDatos(infoCalibracion);
        
    }
    
    
    private void cargarDatos(InformacionCalibracionDTO infoCalibracion) {
		
    	txtDate.setText(infoCalibracion.getCalibrationDate());
		
	}

	/**
     * Llamado cuando el boton siguiente es precionado
     */
    @FXML
    private void handleGenerar() {
    	mainVentana.mostrarPanelGenerarCertificado(dialogStage, infoCalibracion);
    }
    
    /**
     * Llamado cuando el boton siguiente es precionado
     */
    @FXML
    private void handleReiniciar() {
        
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
