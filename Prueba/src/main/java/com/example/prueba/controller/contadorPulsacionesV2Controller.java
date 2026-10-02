package com.example.prueba.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class contadorPulsacionesV2Controller {

    // Número de pulsaciones que completa la barra de progreso.
    private static final int PROGRESS_GOAL = 50;

    @FXML
    private Label miEtiqueta;

    @FXML
    private TextField campoPulsaciones;

    @FXML
    private ProgressBar barraProgreso;

    private int pulsaciones;

    // Incrementa el contador.
    @FXML
    private void btn1() {
        pulsaciones++;
        actualizarVista();
    }

    // Reduce el contador
    @FXML
    private void btn2() {
        pulsaciones--;
        actualizarVista();
    }

    // Reinicia el contador
    @FXML
    private void btn3() {
        pulsaciones = 0;
        actualizarVista();
    }

    // Lee el número escrito y actualiza el contador y la vista.
    @FXML
    private void establecerPulsaciones() {
        pulsaciones = Integer.parseInt(campoPulsaciones.getText().trim());
        actualizarVista();
    }

    // Actualiza la etiqueta y la barra, sin escribir el contador en el campo de texto.
    private void actualizarVista() {
        miEtiqueta.setText(Integer.toString(pulsaciones));
        barraProgreso.setProgress(Math.min(1.0, (double) pulsaciones / PROGRESS_GOAL));
    }
}
