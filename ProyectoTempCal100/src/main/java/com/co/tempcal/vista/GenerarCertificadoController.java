package com.co.tempcal.vista;

import com.co.tempcal.modelo.CertificadoDTO;
import com.co.tempcal.modelo.InformacionCalibracionDTO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GenerarCertificadoController {

	@FXML
	private TextField txtOwner;
	
	@FXML
	private TextField txtCertificateNumber;
	
	@FXML
	private TextField txtMachineModel;
	
	@FXML
	private Button btnGuardarCertificado;
	
	
	private Stage dialogStage;
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
    private void handleGuardar() {
        
    }
    
	
}
