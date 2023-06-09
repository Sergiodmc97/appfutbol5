package com.info.fut5;

import com.info.fut5.servicios.GestionMenu;
import com.info.fut5.servicios.inicio.impl.ServicioInicioImpl;
import com.info.fut5.servicios.entrada.impl.ServicioConsola;

public class App 
{
    public static void main( String[] args )
    {
        ServicioConsola.abrirScanner();
        new ServicioInicioImpl().iniciar();
        new GestionMenu().gestionarMenu();
        ServicioConsola.cerrarScanner();
    }
}