package com.info.fut5.servicios.entrada;

import com.info.fut5.dominio.Jugador;

import java.util.List;

public interface ServicioEntradaArchivo {

    List<Jugador> cargarJugadoresDesdeArchivo(String rutaArchivo);

}
