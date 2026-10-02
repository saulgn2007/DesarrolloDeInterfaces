package com.example.prueba;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CampoTextoLongitudMaxima extends Application {

    private Label lbTexto, lbInfo;
    private TextField tfTexto;
    private final int MAX_CARACTERES = 10;

    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            VBox raiz = new VBox(20);
            raiz.setPadding(new Insets(10));
            raiz.setAlignment(Pos.CENTER);

            HBox hbTexto =new HBox(30);
            hbTexto.setPadding(new Insets(10));
            hbTexto.setAlignment(Pos.CENTER);

            lbTexto = new Label("Introduce texto \n(máximo " + MAX_CARACTERES + " caracteres)");
            lbTexto.setWrapText(true);
            lbTexto.setFont(Font.font("Arial", 14));
            tfTexto = new TextField();

            lbInfo = new Label("Longitud: 0 caracteres");
            lbInfo.setFont(Font.font("Arial", 24));

            tfTexto.setTextFormatter(new TextFormatter<String>(c ->
                    c.getControlNewText().length() <= MAX_CARACTERES ? c : null));
            tfTexto.textProperty().addListener((observable, textoAnterior, textoNuevo) ->
                    lbInfo.setText("Longitud: " + textoNuevo.length() + " caracteres"));

            hbTexto.getChildren().addAll(lbTexto, tfTexto);
            raiz.getChildren().addAll(hbTexto, lbInfo);

            Scene escena = new Scene(raiz, 450, 150);
            escenarioPrincipal.setTitle("Texto con tamaño máximo");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.show();
        } catch(Exception e) {
            throw new IllegalStateException("No se pudo iniciar la interfaz de texto con tamaño máximo.", e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}