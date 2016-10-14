package com.co.tempcal.controlador;

import java.io.IOException;
import java.net.URL;

import com.co.tempcal.modelo.InformacionCalibracionDTO;
import com.co.tempcal.vista.DatosBasicoController;
import com.co.tempcal.vista.DatosTemperaturaController;
import com.co.tempcal.vista.GenerarCertificadoController;
import com.co.tempcal.vista.ResultadoCalibracionController;
import com.co.tempcal.vista.VentanaPrincipalController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaPrincipal extends Application {

	/**
	 * 
	 */
	private Stage stgVistaPrincipal;
	
	/**
	 * 
	 */
	private BorderPane pnlVistaPrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		this.stgVistaPrincipal = primaryStage;
		this.stgVistaPrincipal.setTitle("TempCal100");
		this.stgVistaPrincipal.getIcons().add(new Image("images/icon.png"));
		
		inicializarVentanaPrincipal();

		mostrarVentanaPrincipal();
	}

	/**
	 * Carga de los componentes iniciales
	 */
	public void inicializarVentanaPrincipal() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					VentanaPrincipal.class.getClassLoader().getResource("com/co/tempcal/vista/RootLayout.fxml"));
			pnlVistaPrincipal = (BorderPane) loader.load();

			Scene scene = new Scene(pnlVistaPrincipal);
			stgVistaPrincipal.setScene(scene);
			stgVistaPrincipal.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	*  Carga del Panel principal
	*/
	public void mostrarVentanaPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					VentanaPrincipal.class.getClassLoader().getResource("com/co/tempcal/vista/VentanaPrincipal.fxml"));
			AnchorPane pnlPrincipal = (AnchorPane) loader.load();

			VentanaPrincipalController controller = loader.getController();
			controller.setMainApp(this);

			pnlVistaPrincipal.setCenter(pnlPrincipal);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	*  Carga del Panel con la informacion Basica
	*/
	public void mostrarPanelDatosBasicos() {
		try {

			Stage dialogStage = new Stage();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					VentanaPrincipal.class.getClassLoader().getResource("com/co/tempcal/vista/pnlDatosBasicos.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			dialogStage.getIcons().add(new Image("images/icon.png"));
			dialogStage.setTitle("Basic Information");
			dialogStage.initOwner(stgVistaPrincipal);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DatosBasicoController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMainApp(this);

			dialogStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	*  Carga del Panel con el resultado del proceso
	*/
	public void mostrarPanelResultado(Stage dialogStage, InformacionCalibracionDTO infoCalibracion) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(VentanaPrincipal.class.getClassLoader()
					.getResource("com/co/tempcal/vista/pnlResultadoCalibracion.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			dialogStage.setTitle("Result Process");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			ResultadoCalibracionController controller = loader.getController();
			controller.setDialogStage(dialogStage, infoCalibracion);
			controller.setMainApp(this);

			dialogStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	*  Carga para solicitar el Cold Bath
	*/
	public void mostrarColdBathPanel(Stage dialogStage, InformacionCalibracionDTO infoCalibracion) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(VentanaPrincipal.class.getClassLoader()
					.getResource("com/co/tempcal/vista/pnlDataColdBath.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			dialogStage.setTitle("Proceso #" + infoCalibracion.getSerial());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DatosTemperaturaController controller = loader.getController();
			controller.setDialogStage(dialogStage, infoCalibracion);
			controller.setMainApp(this);

			dialogStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	*  Carga para solicitar el Cold Bath
	*/
	public void mostrarHotSensorPanel(Stage dialogStage, InformacionCalibracionDTO infoCalibracion) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(VentanaPrincipal.class.getClassLoader()
					.getResource("com/co/tempcal/vista/pnlDataHotSensor.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			dialogStage.setTitle("Proceso #" + infoCalibracion.getSerial());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DatosTemperaturaController controller = loader.getController();
			controller.setDialogStage(dialogStage, infoCalibracion);
			controller.setMainApp(this);

			dialogStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Carga del Panel con los datos de la temperatura
	 * @param dialogStage 
	 */
	public void mostrarPanelDatosTemperatura(Stage dialogStage, InformacionCalibracionDTO infoCalibracion) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(VentanaPrincipal.class.getClassLoader()
					.getResource("com/co/tempcal/vista/pnlDatosTemperatura.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			dialogStage.setTitle("Temperature Information");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			DatosTemperaturaController controller = loader.getController();
			controller.setDialogStage(dialogStage, infoCalibracion);
			controller.setMainApp(this);

			dialogStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	*  Carga del Panel para generar el certificado del proceso
	*/
	public void mostrarPanelGenerarCertificado(Stage dialogStage, InformacionCalibracionDTO infoCalibracion) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(VentanaPrincipal.class.getClassLoader()
					.getResource("com/co/tempcal/vista/pnlGenerarCertificado.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			dialogStage.setTitle("Generate Certificate");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			GenerarCertificadoController controller = loader.getController();
			controller.setDialogStage(dialogStage, infoCalibracion);
			controller.setMainApp(this);

			dialogStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna la vista principal
	 * @return
	 */
	public Stage getVistaPrincipal() {
		return stgVistaPrincipal;
	}

	/**
	 * Main de la Aplicacion
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
