package com.info.fut5.servicios.inicio.impl;

import com.info.fut5.dominio.Equipo;
import com.info.fut5.dominio.PosicionJugador;
import com.info.fut5.servicios.inicio.ServInicio;

import java.util.ArrayList;
import java.util.List;

public class ServInicioImpl implements ServInicio {
    public static List<Equipo> listaEquipos = new ArrayList<>();
    public static List<PosicionJugador> listaPosiciones = new ArrayList<>();


    @Override
    public void iniciar() {
        PosicionJugador posicion1 = new PosicionJugador("Arquero");
        PosicionJugador posicion2 = new PosicionJugador("Defensor");
        PosicionJugador posicion3 = new PosicionJugador("Mediocampista");
        PosicionJugador posicion4 = new PosicionJugador("Delantero");

        listaPosiciones.add(posicion1);
        listaPosiciones.add(posicion2);
        listaPosiciones.add(posicion3);
        listaPosiciones.add(posicion4);
    }
}
