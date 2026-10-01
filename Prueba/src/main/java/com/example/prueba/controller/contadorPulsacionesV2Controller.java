package com.example.prueba.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import
// Contador reactivo compartido por ambas ventanas
//private final IntegerProperty numero = new SimpleIntegerProperty(0);

public class contadorPulsacionesV2Controller {

        @FXML
        private Button btnaumentar;{
                btnaumentar.setOnAction(event -> {
                        miEtiqueta.setText();
                });
        }

        @FXML
        private Button btnreset;

        @FXML
        private Button btnrestar;

        @FXML
        private Label miEtiqueta;
//         miEtiqueta.textProperty().bind(numero.asString());

        @FXML
        void btn1(ActionEvent event) {

        }

        @FXML
        void btn2(ActionEvent event) {

        }

        @FXML
        void btn3(ActionEvent event) {

        }

    }

