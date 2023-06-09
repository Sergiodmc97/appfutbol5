package com.info.fut5.servicios.validacion;

import com.info.fut5.dominio.Jugador;

import java.util.List;

public interface ServicioValidacion {

    boolean hayCapitan(List<Jugador> jugadores);

    boolean existeElNroCamiseta(int nroCamiseta, List<Jugador> jugadores);
}
