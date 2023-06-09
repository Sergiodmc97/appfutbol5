package com.info.fut5.servicios.salida.file;

import com.info.fut5.dominio.Jugador;

import java.io.IOException;
import java.util.List;

public interface ServSalidaArchivo {
    void exportarJugadoresEquipo(List<Jugador> jugadores, String rutaDeDestino) throws IOException;

    void exportarAArchivo(String listado, String rutaDeDestino) throws IOException;
}
