package com.example.prueba;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaDeLista extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {

        VBox raiz = new VBox();
        raiz.setPadding(new Insets(40));
        raiz.setSpacing(10);

        Label lbSelecciona = new Label("Selecciona los complementos:");

        Persona alejandro = new Persona("Alejandro");
        Persona triana = new Persona("Triana");
        Persona jacobo = new Persona("Jacobo");
        Persona saul = new Persona("Saul");

        ListView<Persona> lvComplementos = new ListView<>(
                FXCollections.observableArrayList(
                        triana, alejandro, jacobo, saul
                )
        );

        lvComplementos.getSelectionModel()
                .setSelectionMode(SelectionMode.MULTIPLE);

        TextField txtNuevoNombre = new TextField();
        txtNuevoNombre.setPromptText("Escribe el nuevo nombre aquí");

        Button btnModificar = new Button("Modificar el nombre seleccionado");

        btnModificar.setOnAction(e -> {

            Persona personaSeleccionada =
                    lvComplementos.getSelectionModel().getSelectedItem();

            String nuevoTexto = txtNuevoNombre.getText();

            if (personaSeleccionada != null && !nuevoTexto.isEmpty()) {
                personaSeleccionada.setNombre(nuevoTexto);
                txtNuevoNombre.clear();
            }
        });

        raiz.getChildren().addAll(
                lbSelecciona,
                lvComplementos,
                txtNuevoNombre,
                btnModificar
        );

        Scene escena = new Scene(raiz, 300, 300);

        escenarioPrincipal.setTitle("Vista de lista");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}