package com.example.prueba;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class MainContadorPulsaciones extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
// 1. Localizar y cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("contadorPulsacionesV2.fxml"));
            Parent root = loader.load();
// 2. Crear la escena con el contenedor raíz
            Scene scene = new Scene(root);
// 3. Configurar y mostrar el escenario principal
            primaryStage.setTitle("Contador Pulaciones V2");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}