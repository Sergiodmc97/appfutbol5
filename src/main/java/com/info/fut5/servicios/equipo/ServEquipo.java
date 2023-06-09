package com.info.fut5.servicios.equipo;

import com.info.fut5.dominio.Equipo;
import com.info.fut5.dominio.Jugador;

import java.util.List;

public interface ServEquipo {

    void crearEquipo();

    void borrarEquipo();

    Equipo buscarEquipo (String nombre);

    Jugador getCapitan(Equipo equipo);

    String getStringJugadores(List<Jugador> jugadores);

    String getNombreMasEntrenador(Equipo equipo);

}
