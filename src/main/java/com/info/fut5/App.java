package com.info.fut5;

import com.info.fut5.servicios.Menu;
import com.info.fut5.servicios.inicio.impl.ServInicioImpl;
import com.info.fut5.servicios.entrada.impl.ServConsola;

public class App 
{
    public static void main( String[] args )
    {
        ServConsola.abrirScanner();
        new ServInicioImpl().iniciar();
        new Menu().gestionarMenu();
        ServConsola.cerrarScanner();
    }
}