package com.example.prueba;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.prueba.controller.contadorPulsacionesV2Controller;

public class MainContadorPulsaciones extends Application {

    private final IntegerProperty pulsaciones = new SimpleIntegerProperty(0);

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene1 = crearEscena();
        Scene scene2 = crearEscena();

        primaryStage.setTitle("Contador de pulsaciones 1");
        primaryStage.setScene(scene1);
        primaryStage.show();

        Stage secondStage = new Stage();
        secondStage.setTitle("Contador de pulsaciones 2");
        secondStage.setScene(scene2);
        secondStage.show();
    }

    private Scene crearEscena() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("contadorPulsacionesV2.fxml"));
        Parent root = loader.load();
        contadorPulsacionesV2Controller controller = loader.getController();
        controller.enlazarContador(pulsaciones);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles/Pulsaciones.css").toExternalForm());
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}