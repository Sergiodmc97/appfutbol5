package com.info.fut5.servicios.salida.file.impl;

import com.info.fut5.dominio.Jugador;
import com.info.fut5.servicios.salida.file.ServSalidaArchivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ServSalidaArchivoImpl implements ServSalidaArchivo {

    @Override
    public void exportarJugadoresEquipo(List<Jugador> jugadores, String rutaDeDestino) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDeDestino))){
            for (Jugador jugador: jugadores) {
                String linea = jugador.getNombre() + ";" +
                        jugador.getApellido() + ";" +
                        jugador.getAltura() + ";" +
                        jugador.getGoles() + ";" +
                        jugador.getPosicion().getNombre() + ";" +
                        jugador.getEsCapitan() + ";" +
                        jugador.getNroDeCamiseta() + ";" +
                        jugador.getEquipo().getNombre();

                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    @Override
    public void exportarAArchivo(String listado, String rutaDeDestino) throws IOException {
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(rutaDeDestino))){
                writer1.write(listado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
