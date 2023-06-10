package com.info.fut5.servicios.equipo.impl;

import com.info.fut5.dominio.Entrenador;
import com.info.fut5.dominio.Equipo;
import com.info.fut5.dominio.Jugador;
import com.info.fut5.servicios.entrada.ServEntradaArchivo;
import com.info.fut5.servicios.entrada.impl.ServConsola;
import com.info.fut5.servicios.entrada.impl.ServEntradaArchivoImpl;
import com.info.fut5.servicios.entrenador.impl.ServEntrenadorImpl;
import com.info.fut5.servicios.equipo.ServEquipo;
import com.info.fut5.servicios.inicio.impl.ServInicioImpl;
import com.info.fut5.servicios.jugador.ServJugador;
import com.info.fut5.servicios.jugador.impl.ServJugadorImpl;
import com.info.fut5.servicios.validacion.ServValidacion;
import com.info.fut5.servicios.validacion.impl.ServValidacionImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ServEquipoImpl implements ServEquipo {


    @Override
    public void crearEquipo() {
        String entrada = "";
        String nombreEquipo = "";
        int dia, mes, anio;
        ServConsola servicioConsola = new ServConsola();

        do {

            nombreEquipo = servicioConsola.solicitarString("Ingrese el nombre del equipo: ");
            dia = servicioConsola.solicitarInt("Ingrese el día de creación: ");
            mes = servicioConsola.solicitarInt("Ingrese el mes de creación: ");
            anio = servicioConsola.solicitarInt("Ingrese el año de creación: ");

            System.out.println();

            Entrenador entrenador = new ServEntrenadorImpl().crearEntrenador();

            List<Jugador> jugadores = this.cargarJugadores();

            Equipo equipo = new Equipo(nombreEquipo, LocalDate.of(anio, mes, dia),
                    jugadores, entrenador);

            entrada = servicioConsola.solicitarSiNo("¿Desea Ingresar otro equipo?");

            ServInicioImpl.listaEquipos.add(equipo);

        } while (!entrada.equalsIgnoreCase("N"));
    }


    private List<Jugador> cargarJugadores() {
        String agregaDesdeArchivo = new ServConsola().solicitarSiNo("¿Quiere agregar los jugadores desde un archivo .txt?");

        if (agregaDesdeArchivo.equalsIgnoreCase("S")) {
            String rutaArchivo = "src/main/java/com/info/fut5/resouces/listjugadores.txt";
            ServEntradaArchivo entradaArchivo = new ServEntradaArchivoImpl();
            return entradaArchivo.cargarJugadoresDesdeArchivo(rutaArchivo);
        } else {
            return this.cargarJugadoresPorConsola();
        }
    }

    private List<Jugador> cargarJugadoresPorConsola() {
        List<Jugador> jugadores;
        ServValidacion servicioValidacionImpl = new ServValidacionImpl();

        ServJugador servicioJugador = new ServJugadorImpl();
        jugadores = new ArrayList<>();
        Jugador jugador = null;

        for (int i = 0; i < 5; i++) {
            jugador = servicioJugador.crearJugador();
            jugador.setEsCapitan(jugador.getEsCapitan() && !servicioValidacionImpl.hayCapitan(jugadores));

            while (servicioValidacionImpl.existeElNroCamiseta(jugador.getNroDeCamiseta(), jugadores)) {
                int nroCamiseta = new ServConsola().solicitarInt("El número de camiseta se repite (ingresar otro): ");
                jugador.setNroDeCamiseta(nroCamiseta);
            }
            jugadores.add(jugador);
            System.out.println();
        }
        return jugadores;
    }


    @Override
    public void borrarEquipo() {
        System.out.println("--- Eliminar un equipo ---\n");
        String nombreEquipo = new ServConsola().solicitarString("Ingrese el nombre del equipo que quiere eliminar: ");

        List<Equipo> equipoLinkedList = new LinkedList<>();
        equipoLinkedList.addAll(ServInicioImpl.listaEquipos);
        boolean seEncontro = false;
        for (Equipo equipo: equipoLinkedList) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)){
                seEncontro = true;
                equipoLinkedList.remove(equipo);
                break;
            }
        }
        ServInicioImpl.listaEquipos.clear();
        ServInicioImpl.listaEquipos.addAll(equipoLinkedList);
        if (seEncontro) {
            System.out.println("Equipo " + nombreEquipo + " Eliminado");
        } else {
            System.out.println(nombreEquipo + " no existe");
        }
    }


    @Override
    public Jugador getCapitan(Equipo equipo) {
        Jugador capitan = null;
        for (Jugador jugador : equipo.getListaDeJugadores()) {
            if (jugador.getEsCapitan()) {
                capitan = jugador;
                break;
            }
        }
        return capitan;
    }


    @Override
    public Equipo buscarEquipo(String nombre) {
        Equipo equipoEncontrado = null;
        for (Equipo equipo: ServInicioImpl.listaEquipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)){
                equipoEncontrado = equipo;
                break;
            }
        }
        if (equipoEncontrado == null) {
            System.out.println("No se encontró el equipo " + nombre);
        }
        return equipoEncontrado;
    }

    @Override
    public String getStringJugadores(List<Jugador> jugadores){
        String respuesta = "";
        for (Jugador jugador : jugadores) {
            respuesta = respuesta + " - " + jugador.getNombre().toUpperCase() + " " + jugador.getApellido().toUpperCase() + " " + jugador.getNroDeCamiseta() + "\n";
        }
        return respuesta;
    }

    @Override
    public String getNombreMasEntrenador(Equipo equipo) {
        String entrenador = (equipo.getEntrenador() != null ?
                equipo.getEntrenador().getNombre() + " " + equipo.getEntrenador().getApellido() : "No posee entrenador");
        String respuesta = "" + "* Nombre: " + equipo.getNombre().toUpperCase() + "\n* Entrenador: " + entrenador.toUpperCase();
        return respuesta;
    }



}