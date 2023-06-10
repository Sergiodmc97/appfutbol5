package com.info.fut5.servicios.jugador.impl;

import com.info.fut5.dominio.Equipo;
import com.info.fut5.dominio.Jugador;
import com.info.fut5.dominio.PosicionJugador;
import com.info.fut5.servicios.entrada.impl.ServConsola;
import com.info.fut5.servicios.inicio.impl.ServInicioImpl;
import com.info.fut5.servicios.jugador.ServJugador;

public class ServJugadorImpl implements ServJugador {

    @Override
    public void buscarJugadorPorNombre() {
        System.out.println("--- Buscar jugador por su nombre ---");
        String nombre = new ServConsola().solicitarString("Ingresar el nombre del jugador: ");

        String respuesta = "";

        for (Equipo equipo: ServInicioImpl.listaEquipos) {
            for (Jugador jugador: equipo.getListaDeJugadores()) {
                if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                    respuesta = respuesta +
                            "* Nombre: " + jugador.getNombre().toUpperCase() + " " + jugador.getApellido().toUpperCase() +
                            "\n* Posición: " + jugador.getPosicion().getNombre().toUpperCase() +
                            "\n* Capitán: " + (jugador.getEsCapitan() ? "Si" : "No") +
                            "\n* Equipo: " + jugador.getEquipo().getNombre().toUpperCase() +
                            "\n\n";
                }
            }
        }

        if (respuesta.equals("")) {
            System.out.println("El jugador con el nombre: " + nombre + " no existe");
        } else {
            System.out.println(respuesta);
        }
    }

    @Override
    public Jugador crearJugador() {
        ServConsola servicioConsola = new ServConsola();

        System.out.println("--- Ingrese datos del jugador ---");
        String nombre = servicioConsola.solicitarString("Nombre: ");
        String apellido = servicioConsola.solicitarString("Apellido: ");
        double altura = servicioConsola.solicitarDouble("Altura: ");
        int goles = servicioConsola.solicitarInt("Cantidad de goles: ");
        int nroCamiseta = servicioConsola.solicitarInt("Número de camiseta: ");

        boolean esCapitan;
        String respuestaCapitan;
        do {
            respuestaCapitan = servicioConsola.solicitarSiNo("¿Es capitán?");
            esCapitan = respuestaCapitan.equalsIgnoreCase("S");
        } while (respuestaCapitan.equalsIgnoreCase("S") && respuestaCapitan.equalsIgnoreCase("N"));

        System.out.println();
        int respuestaPosicion;
        int indice;
        PosicionJugador posicionJugador = null;
        do {
            System.out.println("- Posiciones: ");
            for (PosicionJugador posicion : ServInicioImpl.listaPosiciones) {
                indice = ServInicioImpl.listaPosiciones.indexOf(posicion);
                System.out.println("  " + (indice + 1) + ")" + posicion.getNombre());
            }
            respuestaPosicion = servicioConsola.solicitarInt("- Ingrese la posición en la que juega: ");
            posicionJugador = ServInicioImpl.listaPosiciones.get(respuestaPosicion - 1);
        } while (posicionJugador == null);

        return new Jugador(nombre, apellido, altura, goles, posicionJugador, esCapitan, nroCamiseta);
    }


}
