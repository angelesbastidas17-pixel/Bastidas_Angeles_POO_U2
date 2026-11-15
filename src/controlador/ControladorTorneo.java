package controlador;

import Modelo.*;
import Vista.*;
import excepciones.NumeroEquiposInvalidoException;
import excepciones.SorteoInvalidoException;
import java.io.IOException;
import java.util.ArrayList;

public class ControladorTorneo {
    private Torneo torneo;
    private VistaConsola vista;
    private String archivo = "torneo.ser";

    public ControladorTorneo(Torneo torneo, VistaConsola vista) {
        this.torneo = torneo;
        this.vista = vista;
    }
    
    public void iniciar(){
        int opcion;
        do{
            opcion = vista.mostrarMenu();
            switch(opcion){
                case 1:
                    cargarPredeterminadosYSortear();
                    break;
                case 2:
                    ingresarManualesYSortear();
                    break;
                case 3:
                    vista.mostrarPartidos(torneo.getHistorialPartidos());
                    break;
                case 4:
                    guardarEstado();
                    break;
                case 5:
                    cargarEstado();
                    break;
                case 0:
                    break;
                default:
                    vista.mostrarMensaje("\nOpción no valida");
            }
        }while(opcion != 0);
    }
    
    private void cargarPredeterminadosYSortear(){
        ArrayList<Equipo> lista = new ArrayList<>();
        for (int i = 65; i<(65+16); i++){
            lista.add(new Equipo(String.valueOf((char) i)));
        }
        ejecutarSorteoConLista(lista);
    }
    
    private void ingresarManualesYSortear(){
        try{
            int cantidad = vista.pedirCantidad();
            torneo.validarCantidad(cantidad);
            ArrayList<Equipo> lista = vista.pedirNombresEquipos(cantidad);
            
            ejecutarSorteoConLista(lista);
        } catch(NumeroEquiposInvalidoException e){
            vista.mostrarMensaje(e.getMessage());
        }
    }
    
    private void ejecutarSorteoConLista(ArrayList<Equipo> lista){
        try {
            torneo.registrarEquipos(lista);
            torneo.ejecutarTorneoCompleto();
            vista.mostrarPartidos(torneo.getHistorialPartidos());
        } catch(NumeroEquiposInvalidoException | SorteoInvalidoException e){
            vista.mostrarMensaje(e.getMessage());
        }
    }
    
    private void guardarEstado(){
        try{
            torneo.guardarTorneo(archivo);
            vista.mostrarMensaje("\nTorneo guardado");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void cargarEstado(){
        try{
            this.torneo = Torneo.cargarTorneo(archivo);
            vista.mostrarMensaje("\nTorneo cargado");
            vista.mostrarPartidos(torneo.getHistorialPartidos());
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
