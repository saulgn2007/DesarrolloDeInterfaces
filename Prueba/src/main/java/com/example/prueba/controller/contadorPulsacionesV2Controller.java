package com.example.prueba.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class contadorPulsacionesV2Controller {

    private static final int PROGRESS_GOAL = 100;

    @FXML
    private Label miEtiqueta;

    @FXML
    private TextField campoPulsaciones;

    @FXML
    private ProgressBar barraProgreso;

    private int pulsaciones;

    @FXML
    private void btn1() {
        if (pulsaciones < Integer.MAX_VALUE) {
            pulsaciones++;
            actualizarVista();
        }
    }

    @FXML
    private void btn2() {
        if (pulsaciones > 0) {
            pulsaciones--;
            actualizarVista();
        }
    }

    @FXML
    private void btn3() {
        pulsaciones = 0;
        actualizarVista();
    }

    @FXML
    private void establecerPulsaciones() {
        String valor = campoPulsaciones.getText().trim();
        if (valor.isEmpty()) {
            campoPulsaciones.setText(Integer.toString(pulsaciones));
            return;
        }

        try {
            pulsaciones = Math.max(0, Integer.parseInt(valor));
            actualizarVista();
        } catch (NumberFormatException e) {
            campoPulsaciones.setText(Integer.toString(pulsaciones));
        }
    }

    private void actualizarVista() {
        miEtiqueta.setText(Integer.toString(pulsaciones));
        barraProgreso.setProgress(Math.min(1.0, (double) pulsaciones / PROGRESS_GOAL));
        campoPulsaciones.setText(Integer.toString(pulsaciones));
    }
}
