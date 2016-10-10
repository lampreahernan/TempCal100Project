package com.co.tempcal.vista;

import com.co.tempcal.controlador.VentanaPrincipal;
import com.co.tempcal.modelo.InformacionCalibracionDTO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DatosBasicoController {
	
	@FXML
	private TextField txtSerial;
	
	@FXML
	private TextField txtPersonalCalibra;
	
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private ComboBox<String> cmbTipoTemperatura;
	
	@FXML
	private Button btnSiguiente;
	
	@FXML
	private Button btnCancel;
	
	
	private Stage dialogStage;
    private InformacionCalibracionDTO infoCalibracion;
    private boolean isSiguienteClicked = false;
	
	
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
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isSiguienteClicked() {
        return isSiguienteClicked;
    }
    
    /**
     * Llamado cuando el boton siguiente es precionado
     */
    @FXML
    private void handleSiguiente() {
       // if (isFormValido()) {
       // 	infoCalibracion.setFechaCalibracion(datePicker.getValue().toString());
        //	infoCalibracion.setSerial(txtSerial.getText());
        //	infoCalibracion.setPersonaCalibra(txtPersonalCalibra.getText());
        //	infoCalibracion.setTipoTemperatura(cmbTipoTemperatura.getValue());

            isSiguienteClicked = true;
            
           mainVentana.mostrarPanelDatosTemperatura(this.dialogStage);
           
      //  }
    }
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancelar() {
        dialogStage.close();
    }
    
    /**
     * Valida los campos del formulario
     * 
     * @return true si los datos estan bien
     */
    private boolean isFormValido() {
        String errorMessage = "";

        if (txtSerial.getText() == null || txtSerial.getText().length() == 0) {
            errorMessage += "Por Favor ingrese el Serial"; 
        }
        if (txtPersonalCalibra.getText() == null || txtPersonalCalibra.getText().length() == 0) {
            errorMessage += "Por Favor ingrese la persona que esta realizando el Proceso"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
        	
        	
//            Dialogs.create()
//                .title("Invalid Fields")
//                .masthead("Please correct invalid fields")
//                .message(errorMessage)
//                .showError();
            return false;
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
