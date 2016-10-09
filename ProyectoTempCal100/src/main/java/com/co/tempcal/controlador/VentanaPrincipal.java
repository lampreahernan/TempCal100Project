package com.co.tempcal.controlador;

import java.io.IOException;

import com.co.tempcal.vista.DatosBasicoController;
import com.co.tempcal.vista.VentanaPrincipalController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
    
    public boolean MostrarPanelDatosBasicos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VentanaPrincipal.class.getResource("../vista/pnlDatosBasicos.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Datos Basicos");
            dialogStage.initOwner(stgVistaPrincipal);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            DatosBasicoController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            //dialogStage.showAndWait();
            dialogStage.show();
            
            
            return controller.isSiguienteClicked();
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
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
