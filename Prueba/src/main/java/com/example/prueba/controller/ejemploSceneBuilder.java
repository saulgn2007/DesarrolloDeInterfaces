package com.example.prueba.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ejemploSceneBuilder {

    @FXML
    private Button miBoton;

    @FXML
    private Label miEtiqueta;

    @FXML
    private TextField text;

    @FXML
    void manejarClic(ActionEvent event) {
        miEtiqueta.setText(text.getText());
    }
}