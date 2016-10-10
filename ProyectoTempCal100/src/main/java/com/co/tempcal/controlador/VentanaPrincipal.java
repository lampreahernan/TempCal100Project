package com.co.tempcal.controlador;

import java.io.IOException;

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

	private Stage stgVistaPrincipal;
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
     * 
     */
    public void inicializarVentanaPrincipal() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VentanaPrincipal.class.getResource("../vista/RootLayout.fxml"));
            pnlVistaPrincipal = (BorderPane) loader.load();

            Scene scene = new Scene(pnlVistaPrincipal);
            stgVistaPrincipal.setScene(scene);
            stgVistaPrincipal.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /**
    * 
    */
    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VentanaPrincipal.class.getResource("../vista/VentanaPrincipal.fxml"));
            AnchorPane pnlPrincipal = (AnchorPane) loader.load();    
            
            VentanaPrincipalController controller = loader.getController();
            controller.setMainApp(this);
            
            pnlVistaPrincipal.setCenter(pnlPrincipal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean mostrarPanelDatosBasicos() {
        try {
        	
        	// Create the dialog Stage.
            Stage dialogStage = new Stage();
        	
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VentanaPrincipal.class.getResource("../vista/pnlDatosBasicos.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            dialogStage.getIcons().add(new Image("images/icon.png"));
            dialogStage.setTitle("Datos Basicos");
            dialogStage.initOwner(stgVistaPrincipal);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            // Set the person into the controller.
            DatosBasicoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);

            // Show the dialog and wait until the user closes it
            //dialogStage.showAndWait();
            dialogStage.show();
            
            
            return controller.isSiguienteClicked();
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void mostrarPanelResultado(Stage dialogStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VentanaPrincipal.class.getResource("../vista/pnlResultadoCalibracion.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
    
            dialogStage.setTitle("Resultado");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ResultadoCalibracionController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            
            dialogStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void mostrarPanelDatosTemperatura(Stage dialogStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VentanaPrincipal.class.getResource("../vista/pnlDatosTemperatura.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
    
            dialogStage.setTitle("Datos Temperatura");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            DatosTemperaturaController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            
            dialogStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void mostrarPanelGenerarCertificado(Stage dialogStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VentanaPrincipal.class.getResource("../vista/pnlGenerarCertificado.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
    
            dialogStage.setTitle("Generar Certificado");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            GenerarCertificadoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            
            dialogStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 
     * @return
     */
    public Stage getVistaPrincipal() {
        return stgVistaPrincipal;
    }
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
