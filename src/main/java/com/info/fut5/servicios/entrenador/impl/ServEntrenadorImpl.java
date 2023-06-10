package com.info.fut5.servicios.entrenador.impl;

import com.info.fut5.dominio.Entrenador;
import com.info.fut5.servicios.entrada.impl.ServConsola;
import com.info.fut5.servicios.entrenador.ServEntrenador;

import java.time.LocalDate;

public class ServEntrenadorImpl implements ServEntrenador {


    @Override
    public Entrenador crearEntrenador() {
        String nombre = "";
        String apellido = "";
        int diaNacimiento, mesNacimiento, anioNacimiento;
        ServConsola servicioConsola = new ServConsola();

        nombre = servicioConsola.solicitarString("Ingrese el Nombre del entrenador: ");
        apellido = servicioConsola.solicitarString("Ingrese el Apellido del entrenador: ");
        diaNacimiento = servicioConsola.solicitarInt("Ingrese el día de nacimiento del entrenador: ");
        mesNacimiento = servicioConsola.solicitarInt("Ingrese el mes de nacimiento del entrenador: ");
        anioNacimiento = servicioConsola.solicitarInt("Ingrese el año de nacimiento del entrenador: ");

        return new Entrenador(nombre, apellido, LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento));
    }
}
