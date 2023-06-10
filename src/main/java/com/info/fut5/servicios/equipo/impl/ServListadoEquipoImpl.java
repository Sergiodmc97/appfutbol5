package com.info.fut5.servicios.equipo.impl;

import com.info.fut5.dominio.Equipo;
import com.info.fut5.dominio.Jugador;
import com.info.fut5.servicios.entrada.impl.ServConsola;
import com.info.fut5.servicios.equipo.ServListadoEquipo;
import com.info.fut5.servicios.inicio.impl.ServInicioImpl;
import com.info.fut5.servicios.salida.file.ServSalidaArchivo;
import com.info.fut5.servicios.salida.file.impl.ServSalidaArchivoImpl;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ServListadoEquipoImpl implements ServListadoEquipo {


    @Override
    public void listarNombreMasEntrenadorYCapitan() {
        System.out.println("--- Lista: Nombre, entrenador y capitán de un equipo ---");
        String nombreEquipo = new ServConsola().solicitarString("Ingrese el nombre del equipo: ");
        ServEquipoImpl servicioEquipoImpl = new ServEquipoImpl();
        System.out.println();
        String respuesta = "";

        Equipo equipo = servicioEquipoImpl.buscarEquipo(nombreEquipo);
        if (equipo != null) {
            Jugador capitan = servicioEquipoImpl.getCapitan(equipo);
            String nombreCapitan = (capitan != null ? capitan.getNombre() + " " + capitan.getApellido() : "No posee capitán");
            respuesta = servicioEquipoImpl.getNombreMasEntrenador(equipo) + "\n* capitán: " + nombreCapitan.toUpperCase();
            System.out.println(respuesta);
        }
    }

    @Override
    public void listarNombreMasEntrenadorYJugadores() {
        System.out.println("--- Lista: Nombre, entrenador y jugadores de un equipo ---");
        String listado = this.listarNombreMasEntrenadorYJugadores(false,
                false, false);
        System.out.println(listado);
    }

    @Override
    public void listarNombreMasEntrenadorYJugadoresOrdenadosPorNombreJugador() {
        System.out.println("--- Lista: Nombre, entrenador y jugadores de un equipo --- Orden por nombre de jugador ---");
        String listado = this.listarNombreMasEntrenadorYJugadores(true,
                false, false);
        System.out.println(listado);
    }

    @Override
    public void listarNombreMasEntrenadorYJugadoresOrdenadosPorNroCamiseta() {
        System.out.println("--- Lista: Nombre, entrenador y jugadores de un equipo --- Orden por su número de camiseta ---");
        String listado = this.listarNombreMasEntrenadorYJugadores(false,
                true, false);
        System.out.println(listado);
    }

    @Override
    public void listarNombreMasEntrenadorYJugadoresOrdenadosPorPosicionYNroCamiseta() {
        System.out.println("*** Lista: Nombre, entrenador y jugadores de un equipo --- Orden por su posición y su número de camiseta ---");
        String listado = this.listarNombreMasEntrenadorYJugadores(false,
                false, true);
        System.out.println(listado);
    }

    @Override
    public void exportarListaDeJugadores() {
        System.out.println("--- Exportar jugadores de un equipo ---");
        String nombreEquipo = new ServConsola().solicitarString("Ingresar el nombre del equipo: ");

        Equipo equipo = new ServEquipoImpl().buscarEquipo(nombreEquipo);
        if (equipo != null) {
            try {
                String rutaArchivoSalida = "src/main/java/com/info/fut5/resouces/jugadoresequipo.txt";
                ServSalidaArchivo salidaArchivo = new ServSalidaArchivoImpl();
                salidaArchivo.exportarJugadoresEquipo(equipo.getListaDeJugadores(), rutaArchivoSalida);
                System.out.println("Lista de jugadores exportados en archivo txt");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al exportar jugadores.");
            }
        }
    }

    @Override
    public void exportarTodosLosEquiposOrdenadosPorNombreJugador(boolean esOrdenadoPorNombre, boolean esOrdenadoPorNroCamiseta,
                                                                 boolean esOrdenadoPorPosicionYNroCamiseta) {
        String listado = "";
        String listadoEquipos = "";
        for (Equipo equipo : ServInicioImpl.listaEquipos) {
            if (esOrdenadoPorNombre) {
                listado = this.getStringJugadoresOrdenadosPorNombre(equipo.getListaDeJugadores());
            } else if (esOrdenadoPorNroCamiseta) {
                listado = this.getStringJugadoresOrdenadosPorNroCamiseta(equipo.getListaDeJugadores());
            } else if (esOrdenadoPorPosicionYNroCamiseta) {
                listado = this.getStringJugadoresOrdenadosPorPosicionYNroCamiseta(equipo.getListaDeJugadores());
            }

            listadoEquipos = listadoEquipos +
                            equipo.getNombre() + "\n" + listado + "\n\n";
        }
        try {
            String rutaArchivoSalida = "src/main/java/com/info/fut5/resouces/equipos.txt";
            new ServSalidaArchivoImpl().exportarAArchivo(listadoEquipos, rutaArchivoSalida);
            System.out.println("Equipos ordenados por nombre de jugador ha sido exportada en archivo .txt con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al exportar equipo.");
        }
    }

    @Override
    public void exportarTodosLosEquiposOrdenadosPorNroCamiseta() {

    }

    @Override
    public void exportarTodosLosEquiposOrdenadosPorPosicionYNroCamiseta() {

    }

    private String listarNombreMasEntrenadorYJugadores(boolean esOrdenadoPorNombre, boolean esOrdenadoPorNroCamiseta,
                                                     boolean esOrdenadoPorPosicionYNroCamiseta) {
        String nombreEquipo = new ServConsola().solicitarString("Ingresar el nombre del Equipo: ");
        System.out.println();
        String listado = "";
        String listadoDeJugadores = "";
        Equipo equipo = new ServEquipoImpl().buscarEquipo(nombreEquipo);

        if (equipo != null) {
            if (esOrdenadoPorNombre) {
                listadoDeJugadores = this.getStringJugadoresOrdenadosPorNombre(equipo.getListaDeJugadores());
            } else if (esOrdenadoPorNroCamiseta) {
                listadoDeJugadores = this.getStringJugadoresOrdenadosPorNroCamiseta(equipo.getListaDeJugadores());
            } else if (esOrdenadoPorPosicionYNroCamiseta) {
                listadoDeJugadores = this.getStringJugadoresOrdenadosPorPosicionYNroCamiseta(equipo.getListaDeJugadores());
            } else {
                listadoDeJugadores = new ServEquipoImpl().getStringJugadores(equipo.getListaDeJugadores());
            }

            listado = new ServEquipoImpl().getNombreMasEntrenador(equipo) + "\n* Jugadores: " + "\n" + listadoDeJugadores;
        }
            return listado;
    }

    private String getStringJugadoresOrdenadosPorNombre(List<Jugador> jugadores) {
        List<Jugador> jugadoresLinkedList = new LinkedList<>(jugadores);
        jugadoresLinkedList.sort(new Comparator<Jugador>() {
            @Override
            public int compare(Jugador jugador1, Jugador jugador2) {
                return jugador1.getNombre().compareToIgnoreCase(jugador2.getNombre());
            }
        });
        return new ServEquipoImpl().getStringJugadores(jugadoresLinkedList);
    }

    private String getStringJugadoresOrdenadosPorNroCamiseta(List<Jugador> jugadores) {
        List<Jugador> jugadoresLinkedList = new LinkedList<>(jugadores);
        jugadoresLinkedList.sort(new Comparator<Jugador>() {
            @Override
            public int compare(Jugador jugador1, Jugador jugador2) {
                return Integer.compare(jugador1.getNroDeCamiseta(), jugador2.getNroDeCamiseta());
            }
        });
        return new ServEquipoImpl().getStringJugadores(jugadoresLinkedList);
    }

    private String getStringJugadoresOrdenadosPorPosicionYNroCamiseta(List<Jugador> jugadores) {
        List<Jugador> jugadoresLinkedList = new LinkedList<>(jugadores);
        jugadoresLinkedList.sort(new Comparator<Jugador>() {
            @Override
            public int compare(Jugador jugador1, Jugador jugador2) {
                if (jugador1.getPosicion().getNombre().compareToIgnoreCase(jugador2.getPosicion().getNombre()) == 0) {
                    return Integer.compare(jugador1.getNroDeCamiseta(), jugador2.getNroDeCamiseta());
                } else {
                    return jugador1.getPosicion().getNombre().compareToIgnoreCase(jugador2.getPosicion().getNombre());
                }
            }
        });
        return new ServEquipoImpl().getStringJugadores(jugadoresLinkedList);
    }


}
