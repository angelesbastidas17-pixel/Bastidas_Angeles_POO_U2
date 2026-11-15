package controlador;

import Modelo.*;
import Vista.*;

public class Main {
    public static void main(String[] args) {
        Torneo modelo = new Torneo();
        VistaConsola vista = new VistaConsola();
        ControladorTorneo controlador = new ControladorTorneo(modelo,vista);
        
        controlador.iniciar();
    }
}
