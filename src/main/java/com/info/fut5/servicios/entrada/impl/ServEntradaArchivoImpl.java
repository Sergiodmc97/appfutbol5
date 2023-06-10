package com.info.fut5.servicios.entrada.impl;

//import com.info.fut5.dominio.Equipo;
import com.info.fut5.dominio.Jugador;
import com.info.fut5.dominio.PosicionJugador;
import com.info.fut5.servicios.entrada.ServEntradaArchivo;

import org.apache.commons.io.FileUtils;
//import com.info.fut5.servicios.equipo.impl.ServicioEquipoImpl;
import com.info.fut5.servicios.validacion.ServValidacion;
import com.info.fut5.servicios.validacion.impl.ServValidacionImpl;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ServEntradaArchivoImpl implements ServEntradaArchivo {

    @Override
    public List<Jugador> cargarJugadoresDesdeArchivo(String rutaArchivo) {
        List<Jugador> jugadores = new ArrayList<>();
        ServValidacion servicioValidacionImpl = new ServValidacionImpl();

        try{
            List<String> lineas = FileUtils.readLines(new File(rutaArchivo), StandardCharsets.UTF_8);

            for (String linea: lineas) {
                String[] partes = linea.split(";");

                String nombre = partes[0];
                String apellido = partes[1];
                String altura = partes[2];
                String goles = partes[3];
                String posicion = partes[4];
                String esCapitan = partes[5];
                String nroCamiseta = partes[6];

                double doubleAltura = Double.parseDouble(altura);
                int intGoles  = Integer.parseInt(goles);
                PosicionJugador posicionObject = new PosicionJugador(posicion);
                int intNroCamiseta = Integer.parseInt(nroCamiseta);

                // control capitan
                boolean booleanEsCapitan = esCapitan.equalsIgnoreCase("true") &&
                        !servicioValidacionImpl.hayCapitan(jugadores);

                Jugador jugador = new Jugador(nombre, apellido, doubleAltura, intGoles, posicionObject,
                        booleanEsCapitan, intNroCamiseta);
                jugadores.add(jugador);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException n){
            System.out.println("Error");
            throw new RuntimeException(n);
        }
        return jugadores;
    }
}
