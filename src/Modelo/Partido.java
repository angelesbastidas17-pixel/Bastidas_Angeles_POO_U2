
package Modelo;

import java.io.Serializable;

public class Partido implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Equipo equipoA;
    private Equipo equipoB;
    private String etapa;
    
    
    // Se inicializa afuera porque los equipos son independientes del partido
    public Partido(Equipo equipoA, Equipo equipoB, String etapa) {
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.etapa = etapa;
    }

    // metodo para que eliga el ganador al azar 
    public Equipo obtenerGanador(){
        return (Math.random()<0.5) ? equipoA : equipoB;
    }
    
    public Equipo getEquipoA() {
        return equipoA;
    }

    public void setEquipoA(Equipo equipoA) {
        this.equipoA = equipoA;
    }

    public Equipo getEquipoB() {
        return equipoB;
    }

    public void setEquipoB(Equipo equipoB) {
        this.equipoB = equipoB;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    @Override
    public String toString(){
        return etapa+" Equipo: "+equipoA+" vs "+equipoB;
    }
}
