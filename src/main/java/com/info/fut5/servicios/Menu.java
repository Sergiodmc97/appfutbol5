package com.info.fut5.servicios;

import com.info.fut5.servicios.entrada.impl.ServConsola;
import com.info.fut5.servicios.equipo.ServEquipo;
import com.info.fut5.servicios.equipo.impl.ServEquipoImpl;
import com.info.fut5.servicios.equipo.impl.ServListadoEquipoImpl;
import com.info.fut5.servicios.jugador.ServJugador;
import com.info.fut5.servicios.jugador.impl.ServJugadorImpl;

public class Menu {
    private String[] menuOpciones =  {
            "1- Crear equipo.",
            "2- Eliminar equipo.",
            "3- Buscar jugadores por su nombre.",
            "4- Buscar equipo.",
            "5- Mostrar equipo.",
            "6- Mostrar equipo (ordenado por los nombres de los jugadores) .",
            "7- Mostrar equipo (ordenado por los números de camisetas) .",
            "8- Mostrar equipo (ordenado por la posición y el número de camiseta).",
            "9- Exportar jugadores de un equipo como txt.",
            "10- Exportar equipos ordenados por nombre de jugador como txt.",
            "11- Exportar equipos ordenados por número de camiseta como txt.",
            "12- Exportar equipos ordenados por posición y número de camiseta como txt.",
            "0- Salir."
    };

    private void titulo() {
        System.out.println();
        System.out.println("\t\t--------------------------------------");
        System.out.println("\t\t####### Aplicación de Futbol 5 #######");
        System.out.println("\t\t########### ¡BIENVENIDO!  ############");
        System.out.println("\t\t--------------------------------------");
        System.out.println();
    }

    private int getOpcion() {
        for (String menuOpcione : menuOpciones) {
            System.out.println(menuOpcione);
        }
        System.out.println("Seleccione una opción: ");
        int opcion = ServConsola.scanner.nextInt();
        ServConsola.scanner.nextLine();
        return opcion;
    }

    private void ejecutarOpcion(int opcionSeleccionada) {
        switch (opcionSeleccionada) {
            case 1:
                this.crearEquipo();
                break;
            case 2:
                this.borrarEquipo();
                break;
            case 3:
                this.buscarJugadorPorNombre();
                break;
            case 4:
                this.buscarEquipo();
                break;
            case 5:
                this.mostrarDetallesEquipo();
                break;
            case 6:
                this.mostrarDetallesEquipoOrdenadoPorNombreJugador();
                break;
            case 7:
                this.verDetallesEquipoOrdenadoPorNroCamiseta();
                break;
            case 8:
                this.verDetallesEquipoOrdenadoPorPosicionYNroCamiseta();
                break;
            case 9:
                this.exportarListaDeJugadoresArchivoTxt();
                break;
            case 10:
                this.exportarListaEquiposOrdenadosPorNombreJugadorArchivoTxt();
                break;
            case 11:
                this.exportarListaEquiposOrdenadosPorNroCamisetaArchivoTxt();
                break;
            case 12:
                this.exportarListaEquiposOrdenadosPorPosicionYNroCamisetaArchivoTxt();
                break;
        }
    }

    private void borrarEquipo() {
        System.out.println("Eliminar equipo por nombre.");
        new ServEquipoImpl().borrarEquipo();
        System.out.println("-----------------------------");
    }

    private void exportarListaEquiposOrdenadosPorPosicionYNroCamisetaArchivoTxt() {
        System.out.println("Exportar una lista de equipos ordenados por posición y número de camiseta a un archivo txt.");
        new ServListadoEquipoImpl().exportarTodosLosEquiposOrdenadosPorNombreJugador(false,
                false, true);
    }

    private void exportarListaEquiposOrdenadosPorNroCamisetaArchivoTxt() {
        System.out.println("Exportar una lista de equipos ordenados por número de camiseta a un archivo txt.");
        new ServListadoEquipoImpl().exportarTodosLosEquiposOrdenadosPorNombreJugador(false,
                true, false);
    }

    private void exportarListaEquiposOrdenadosPorNombreJugadorArchivoTxt() {
        System.out.println("Exportar lista de equipos ordenados por nombre de jugador a un archivo txt.");
        new ServListadoEquipoImpl().exportarTodosLosEquiposOrdenadosPorNombreJugador(true,
                false, false);
    }


    private void exportarListaDeJugadoresArchivoTxt() {
        System.out.println("Exportar la lista de jugadores a un archivo 'txt'.");
        new ServListadoEquipoImpl().exportarListaDeJugadores();
        System.out.println("-----------------------------");
    }


    private void crearEquipo() {
        System.out.println("Crear un equipo.");
        ServEquipo servicioEquipo = new ServEquipoImpl();
        servicioEquipo.crearEquipo();
        System.out.println("-----------------------------");
    }

    private void buscarJugadorPorNombre() {
        System.out.println("Buscar un jugador por su nombre y muestrar:  \n" +
                "Nombre, apellido, posición, si es capitán y el nombre de su equipo.");
        ServJugador servicioJugador = new ServJugadorImpl();
        servicioJugador.buscarJugadorPorNombre();
        System.out.println("-----------------------------");
    }


    private void buscarEquipo() {
        System.out.println("Buscar un equipo por su nombre y muestrar: \n" +
                "Nombre del equipo, nombre de entrenador y nombre del capitán del equipo.");
        new ServListadoEquipoImpl().listarNombreMasEntrenadorYJugadores();
        System.out.println("-----------------------------");
    }

    private void mostrarDetallesEquipo() {
        System.out.println("Buscar un equipo por su nombrey mostrar: \n" +
                "Nombre del equipo, nombre del entrenador y la lista de los jugadores del equipo.");
        new ServListadoEquipoImpl().listarNombreMasEntrenadorYJugadores();
        System.out.println("-----------------------------");
    }


    private void verDetallesEquipoOrdenadoPorPosicionYNroCamiseta() {
        System.out.println("Buscar un equipo por su nombre y mostrar: \n" +
                "Nombre, nombre del entrenador y la lista de los jugadores del equipo ordenados por: \n " +
                "Posición y número de camiseta.");
        new ServListadoEquipoImpl().listarNombreMasEntrenadorYJugadoresOrdenadosPorPosicionYNroCamiseta();
        System.out.println("-----------------------------");
    }

    private void verDetallesEquipoOrdenadoPorNroCamiseta() {
        System.out.println("Buscar un equipo por su nombre y mostrar: \n" +
                "Nombre, nombre del entrenador y la lista de los jugadores del equipo ordenados por número de camiseta.");
        new ServListadoEquipoImpl().listarNombreMasEntrenadorYJugadoresOrdenadosPorNroCamiseta();
        System.out.println("-----------------------------");
    }

    private void mostrarDetallesEquipoOrdenadoPorNombreJugador() {

        System.out.println("Buscar un equipo por su nombre y mostrar: \n" +
                "Nombre, nombre del entrenador y la lista de los jugadores del equipo ordenados por su nombre.");
        new ServListadoEquipoImpl().listarNombreMasEntrenadorYJugadoresOrdenadosPorNombreJugador();
        System.out.println("-----------------------------");
    }


    public void gestMenu(){
        int opcionSeleccionada = -1;
        this.titulo();

        do {
            opcionSeleccionada = this.getOpcion();
        } while (opcionSeleccionada < 0 || opcionSeleccionada > 12);

        if (opcionSeleccionada != 0) {
            this.ejecutarOpcion(opcionSeleccionada);
            this.gestMenu();
        } else {
            System.out.println("Fin.");
        }

    }
}
