package com.co.tempcal.vista;

import java.time.LocalDate;
import java.util.Locale;
import java.util.TimeZone;

import com.co.tempcal.controlador.VentanaPrincipal;
import com.co.tempcal.modelo.InformacionCalibracionDTO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DatosBasicoController {

	/**
	 * Identificador del Proceso
	 */
	@FXML
	private TextField txtSerial;

	/**
	 * Persona que realiza el proceso
	 */
	@FXML
	private TextField txtPersonalCalibra;

	/**
	 * Fecha del Proceso
	 */
	@FXML
	private DatePicker datePicker;

	/**
	 * Tipo de Temperatura
	 */
	@FXML
	private ComboBox<String> cmbTipoTemperatura;

	/**
	 * Boton Siguiente
	 */
	@FXML
	private Button btnSiguiente;

	/**
	 * Boton Cancelar
	 */
	@FXML
	private Button btnCancel;

	/**
	 * Stage actual
	 */
	private Stage dialogStage;

	/**
	 * DTO sobre el proceso
	 */
	private InformacionCalibracionDTO infoCalibracion;

	/**
	 * Referencia al Main Principal
	 */
	private VentanaPrincipal mainVentana;

	
	@FXML
	private void initialize() {
		
		TimeZone.setDefault(TimeZone.getTimeZone("America/Bogota"));
		Locale.setDefault(Locale.ENGLISH);
		
		infoCalibracion = new InformacionCalibracionDTO();
		
		cmbTipoTemperatura.getItems().addAll("C", "F");
		cmbTipoTemperatura.setValue("C");	
		
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
	 * Accion del boton siguiente
	 */
	@FXML
	private void handleSiguiente() {
		if (isFormValido()) {
			infoCalibracion.setCalibrationDate(datePicker.getValue().toString());
			infoCalibracion.setSerial(txtSerial.getText());
			infoCalibracion.setCalibrationPerson(txtPersonalCalibra.getText());
			infoCalibracion.setTemperatureType(cmbTipoTemperatura.getValue());

			mainVentana.mostrarPanelDatosTemperatura(this.dialogStage, infoCalibracion);

		}
	}

	/**
	 * Accion del Boton Cancelar
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

		if (datePicker.getValue() == null || datePicker.getValue().toString().length() == 0) {
			errorMessage += "Select a Date \n";
		}
		if (txtSerial.getText() == null || txtSerial.getText().length() == 0) {
			errorMessage += "Set a Serial \n";
		}
		if (txtPersonalCalibra.getText() == null || txtPersonalCalibra.getText().length() == 0) {
			errorMessage += "Set the person who will performed process \n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			showAlert(errorMessage);
			return false;
		}
	}

	/**
	 * Muestra una ventana con un mensaje
	 * 
	 * @param errorMessage
	 */
	public void showAlert(String errorMessage) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Invalid Fields");
		alert.setHeaderText("Please correct invalid fields");
		alert.setContentText(errorMessage);

		alert.showAndWait();
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
