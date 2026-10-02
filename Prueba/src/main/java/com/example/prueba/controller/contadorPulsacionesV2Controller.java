package com.example.prueba.controller;

import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class contadorPulsacionesV2Controller {

    private static final int PROGRESS_GOAL = 50;

    @FXML
    private Label miEtiqueta;

    @FXML
    private TextField campoPulsaciones;

    @FXML
    private ProgressBar barraProgreso;

    private IntegerProperty pulsaciones;

    public void enlazarContador(IntegerProperty contadorCompartido) {
        pulsaciones = contadorCompartido;
        miEtiqueta.textProperty().bind(pulsaciones.asString());
        barraProgreso.progressProperty().bind(pulsaciones.divide((double) PROGRESS_GOAL));
    }

    @FXML
    private void btn1() {
        pulsaciones.set(pulsaciones.get() + 1);
    }

    @FXML
    private void btn2() {
        pulsaciones.set(pulsaciones.get() - 1);
    }

    @FXML
    private void btn3() {
        pulsaciones.set(0);
    }

    @FXML
    private void establecerPulsaciones() {
        try {
            pulsaciones.set(Integer.parseInt(campoPulsaciones.getText().trim()));
            campoPulsaciones.getStyleClass().remove("entrada-invalida");
        } catch (NumberFormatException e) {
            if (!campoPulsaciones.getStyleClass().contains("entrada-invalida")) {
                campoPulsaciones.getStyleClass().add("entrada-invalida");
            }
            campoPulsaciones.setPromptText("Introduce un número entero");
        }
    }
}
