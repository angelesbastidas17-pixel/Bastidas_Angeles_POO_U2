package Modelo;

import java.io.Serializable;

public class Equipo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nombreEquipo;

    public Equipo( String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+nombreEquipo;
    }
    
}
