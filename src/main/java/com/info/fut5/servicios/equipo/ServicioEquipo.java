package com.info.fut5.servicios.equipo;

import com.info.fut5.dominio.Entrenador;
import com.info.fut5.dominio.Equipo;
import com.info.fut5.dominio.Jugador;

import java.time.LocalDate;
import java.util.List;

public interface ServicioEquipo {

    void crearEquipo();

    void borrarEquipo();

    Equipo buscarEquipo (String nombre);

    Jugador getCapitan(Equipo equipo);

    String getStringJugadores(List<Jugador> jugadores);

    String getNombreMasEntrenador(Equipo equipo);

}
