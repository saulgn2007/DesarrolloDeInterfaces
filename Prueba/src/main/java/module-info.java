module com.example.prueba {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.prueba to javafx.fxml;
    opens com.example.prueba.controller to javafx.fxml;
    exports com.example.prueba;
}