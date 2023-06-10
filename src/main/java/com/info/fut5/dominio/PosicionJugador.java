package com.info.fut5.dominio;

public class PosicionJugador {
    private String nombre;


    public PosicionJugador(String nombre) {
        this.nombre = nombre;
    }

    public PosicionJugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
