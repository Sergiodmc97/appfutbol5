package com.info.fut5.servicios.equipo;

public interface ServicioListadoEquipo {

    void listarNombreMasEntrenadorYCapitan();

    void listarNombreMasEntrenadorYJugadores();

    void listarNombreMasEntrenadorYJugadoresOrdenadosPorNombreJugador();

    void listarNombreMasEntrenadorYJugadoresOrdenadosPorNroCamiseta();

    void listarNombreMasEntrenadorYJugadoresOrdenadosPorPosicionYNroCamiseta();

    void exportarListaDeJugadores();

    void exportarTodosLosEquiposOrdenadosPorNombreJugador(boolean esOrdenadoPorNombre, boolean esOrdenadoPorNroCamiseta,
                                                          boolean esOrdenadoPorPosicionYNroCamiseta);

    void exportarTodosLosEquiposOrdenadosPorNroCamiseta();

    void exportarTodosLosEquiposOrdenadosPorPosicionYNroCamiseta();

}
