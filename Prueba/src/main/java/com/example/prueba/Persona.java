package com.example.prueba;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

    private final StringProperty nombre =
            new SimpleStringProperty(this, "nombre");

    public Persona(String nombre) {
        setNombre(nombre);
    }

    public final String getNombre() {
        return nombre.get();
    }

    public final void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public final StringProperty nombreProperty() {
        return nombre;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}