package com.info.fut5.servicios.inicio.impl;

import com.info.fut5.dominio.Entrenador;
import com.info.fut5.dominio.Equipo;
import com.info.fut5.dominio.Jugador;
import com.info.fut5.dominio.Posicion;
import com.info.fut5.servicios.equipo.ServicioEquipo;
import com.info.fut5.servicios.equipo.impl.ServicioEquipoImpl;
import com.info.fut5.servicios.inicio.ServicioInicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicioInicioImpl implements ServicioInicio {
    public static List<Equipo> listaEquipos = new ArrayList<>();
    public static List<Posicion> listaPosiciones = new ArrayList<>();


    @Override
    public void iniciar() {
        Posicion posicion1 = new Posicion("Arquero");
        Posicion posicion2 = new Posicion("Defensa");
        Posicion posicion3 = new Posicion("Mediocampista");
        Posicion posicion4 = new Posicion("Delantero");

        listaPosiciones.add(posicion1);
        listaPosiciones.add(posicion2);
        listaPosiciones.add(posicion3);
        listaPosiciones.add(posicion4);
    }
}
