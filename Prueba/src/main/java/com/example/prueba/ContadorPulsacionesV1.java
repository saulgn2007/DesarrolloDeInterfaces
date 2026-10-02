package com.example.prueba;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class ContadorPulsacionesV1 extends Application {

    // Contador reactivo compartido por ambas ventanas
    private final IntegerProperty numero = new SimpleIntegerProperty(0);

    @Override
    public void start(Stage escenarioPrincipal) {

        // ==========================================
        // VENTANA 1
        // ==========================================
        VBox raiz1 = new VBox(20);
        raiz1.setPadding(new Insets(40));
        raiz1.setAlignment(Pos.CENTER);
        raiz1.getStyleClass().add("raiz"); // Clase CSS .raiz

        Label label1 = new Label();
        // Vinculación automática con la propiedad 'numero'
        label1.textProperty().bind(numero.asString());

        Button btnMas1 = new Button("+");
        Button btnMenos1 = new Button("-");
        Button btnReset1 = new Button("Reset");

        // Asignación de IDs para aplicar estilos CSS
        btnMas1.setId("btAceptar");
        btnReset1.setId("btCancelar");

        HBox botones1 = new HBox(10, btnMas1, btnMenos1, btnReset1);
        botones1.setAlignment(Pos.CENTER);

        raiz1.getChildren().addAll(label1, botones1);

        // ==========================================
        // VENTANA 2
        // ==========================================
        Stage escenario2 = new Stage();

        VBox raiz2 = new VBox(20);
        raiz2.setPadding(new Insets(40));
        raiz2.setAlignment(Pos.CENTER);
        raiz2.getStyleClass().add("raiz"); // Clase CSS .raiz

        Label label2 = new Label();
        // Vinculación automática con la misma propiedad
        label2.textProperty().bind(numero.asString());

        Button btnMas2 = new Button("+");
        Button btnMenos2 = new Button("-");
        Button btnReset2 = new Button("Reset");

        // Asignación de IDs para aplicar estilos CSS
        btnMas2.setId("btAceptar");
        btnReset2.setId("btCancelar");

        HBox botones2 = new HBox(10, btnMas2, btnMenos2, btnReset2);
        botones2.setAlignment(Pos.CENTER);

        raiz2.getChildren().addAll(label2, botones2);

        // ==========================================
        // EVENTOS DE LOS BOTONES
        // ==========================================
        btnMas1.setOnAction(e -> numero.set(numero.get() + 1));
        btnMenos1.setOnAction(e -> numero.set(numero.get() - 1));
        btnReset1.setOnAction(e -> numero.set(0));

        btnMas2.setOnAction(e -> numero.set(numero.get() + 1));
        btnMenos2.setOnAction(e -> numero.set(numero.get() - 1));
        btnReset2.setOnAction(e -> numero.set(0));

        // ==========================================
        // CREACIÓN DE ESCENAS Y CARGA DEL CSS
        // ==========================================
        Scene escena1 = new Scene(raiz1, 300, 300);
        Scene escena2 = new Scene(raiz2, 300, 300);

        // Ruta correspondiente a tu carpeta 'styles/Pulsaciones.css' dentro de resources
        URL cssURL = getClass().getResource("/styles/Pulsaciones.css");

        if (cssURL != null) {
            String cssPath = cssURL.toExternalForm();
            escena1.getStylesheets().add(cssPath);
            escena2.getStylesheets().add(cssPath);
        } else {
            throw new IllegalStateException("No se encontró el archivo '/styles/Pulsaciones.css'.");
        }

        // Mostrar Ventana 1
        escenarioPrincipal.setTitle("Contador 1");
        escenarioPrincipal.setScene(escena1);
        escenarioPrincipal.setX(200);
        escenarioPrincipal.setY(200);
        escenarioPrincipal.show();

        // Mostrar Ventana 2
        escenario2.setTitle("Contador 2");
        escenario2.setScene(escena2);
        escenario2.setX(550);
        escenario2.setY(200);
        escenario2.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}