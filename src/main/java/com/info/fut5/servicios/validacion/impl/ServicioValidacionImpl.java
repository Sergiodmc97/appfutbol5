package com.info.fut5.servicios.validacion.impl;

import com.info.fut5.dominio.Jugador;
import com.info.fut5.servicios.validacion.ServicioValidacion;

import java.util.List;

public class ServicioValidacionImpl implements ServicioValidacion {

    @Override
    public boolean hayCapitan(List<Jugador> jugadores) {
        boolean hayCapitan = false;

        for (Jugador jugador: jugadores ) {
            if (jugador.getEsCapitan()) {
                System.out.println("No se puede designar mas de un capitán" +
                        " '" + jugador.getNombre() +
                        " " + jugador.getApellido() +
                        "' ya fue designado. Las designaciones posteriores serán omitidas."
                );
                hayCapitan = true;
                break;
            }
        }
        return hayCapitan;
    }

    @Override
    public boolean existeElNroCamiseta(int nroCamiseta, List<Jugador> jugadores) {
        for (Jugador jugador: jugadores ) {
            if (jugador.getNroDeCamiseta() == nroCamiseta) {
                return true;
            }
        }
        return false;
    }


}
