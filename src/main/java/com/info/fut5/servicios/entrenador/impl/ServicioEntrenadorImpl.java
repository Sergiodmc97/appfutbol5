package com.info.fut5.servicios.entrenador.impl;

import com.info.fut5.dominio.Entrenador;
import com.info.fut5.servicios.entrada.impl.ServicioConsola;
import com.info.fut5.servicios.entrenador.ServicioEntrenador;

import java.time.LocalDate;

public class ServicioEntrenadorImpl implements ServicioEntrenador {


    @Override
    public Entrenador crearEntrenador() {
        String nombre = "";
        String apellido = "";
        int diaNacimiento, mesNacimiento, anioNacimiento;
        ServicioConsola servicioConsola = new ServicioConsola();

        nombre = servicioConsola.solicitarString("Nombres del entrenador: ");

        apellido = servicioConsola.solicitarString("Apellido del entrenador: ");

        diaNacimiento = servicioConsola.solicitarInt("Día de nacimiento del entrenador: ");

        mesNacimiento = servicioConsola.solicitarInt("Mes de nacimiento del entrenador: ");

        anioNacimiento = servicioConsola.solicitarInt("Año de nacimiento del entrenador: ");

        return new Entrenador(nombre, apellido, LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento));
    }
}
