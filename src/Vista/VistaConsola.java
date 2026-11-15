package Vista;

import Modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaConsola {
    Scanner scan = new Scanner(System.in);
    
    public int mostrarMenu(){
        System.out.println("\nIngrese un numero para elegir una opción de las siguientes: ");
        System.out.println("1. Cargar 16 equipos predeterminados y realizar sorteo");
        System.out.println("2. Ingresar equipos manualmente y realizar sorteo");
        System.out.println("3. Mostrar resultados del sorteo actual");
        System.out.println("4. Guardar torneo (Serializar en torneo.ser)");
        System.out.println("5. Cargar torneo guardado (Deserializar de torneo.ser)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        try{
            return Integer.parseInt(scan.nextLine());
        }catch (NumberFormatException e){
            return -1;
        }
    }
    
    public int pedirCantidad(){
        while (true) {
            System.out.print("\n¿Cuántos equipos desea ingresar? ");
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero válido");
            }
        }
    }
    
    public ArrayList<Equipo> pedirNombresEquipos(int cantidad){
        ArrayList<Equipo> equipos = new ArrayList<>();
        System.out.println("\nIngrese los nombres de los 16 equipos:");
        for(int i = 1; i<=cantidad;i++){
            System.out.print("Equipo "+i+": ");
            equipos.add(new Equipo(scan.nextLine()));
        }
        return equipos;
    }
    
    public void mostrarPartidos(ArrayList<Partido> partidos) {
        if (partidos == null || partidos.isEmpty()) {
            System.out.println("\nNo hay partidos sorteados todavía.");
            return;
        }
        String etapaActual = "";
        for (Partido p : partidos) {
            if (!p.getEtapa().equals(etapaActual)) {
                etapaActual = p.getEtapa();
                System.out.println("\n Etapa: " + etapaActual);
            }
            System.out.println(p.getEquipoA().getNombreEquipo() + " vs " + p.getEquipoB().getNombreEquipo());
        }
    }
    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}
