package Modelo;

import excepciones.NumeroEquiposInvalidoException;
import excepciones.SorteoInvalidoException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Torneo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private ArrayList<Equipo> equiposIniciales = new ArrayList<>();
    private ArrayList<Partido> historialPartidos = new ArrayList<>();    
    
    public void validarCantidad(int cantidad) throws NumeroEquiposInvalidoException {
        if (cantidad != 16) {
            throw new NumeroEquiposInvalidoException(
                "El número de equipos (" + cantidad + ") no es válido para eliminación directa. Debe ser 16 exactamente."
            );
        }
    }
    
    public void registrarEquipos(ArrayList<Equipo> equipos) throws NumeroEquiposInvalidoException {
        validarCantidad(equipos.size());
        this.equiposIniciales = new ArrayList<>(equipos);
    }

    public void ejecutarTorneoCompleto() throws SorteoInvalidoException{
        historialPartidos.clear();
        ArrayList<Equipo> equiposEnCompetencia = new ArrayList<>(equiposIniciales);
        String[] etapas = {"Octavos", "Cuartos", "Semifinales", "Final"};
        
        for(String etapaActual : etapas){ // "Octavos", "Cuartos", "Semifinales", "Final"
            ArrayList<Partido> partidosEtapa = sortearEtapa(equiposEnCompetencia, etapaActual);
            historialPartidos.addAll(partidosEtapa);
            
            // Obtiene los clasificados para la siguiente etapa
            equiposEnCompetencia = obtenerClasificados(partidosEtapa);
        }
    }
    
    private ArrayList<Partido> sortearEtapa(ArrayList<Equipo> equiposEtapa, String etapa) throws SorteoInvalidoException{
        
        ArrayList<Equipo> copiaEquiposMezclada = new ArrayList<>(equiposEtapa);
        // desordena la lista, al tomar de 1 en 1 asegura que no se repitan y ninguno sea competidor y oponente a la vez
        Collections.shuffle(copiaEquiposMezclada); // en vez de A","B","C" -> "C","A","B"
        
        ArrayList<Partido> partidosGenerados = new ArrayList<>();
        emparejarRecursivo(copiaEquiposMezclada, etapa, partidosGenerados);
        return partidosGenerados;
    }
    
    private void emparejarRecursivo(ArrayList<Equipo> copiaEquiposMezclada, String etapa, ArrayList<Partido> partidosGenerados) throws SorteoInvalidoException{
        if(copiaEquiposMezclada.isEmpty()){
            return;
        }

        Equipo equipo1 = copiaEquiposMezclada.remove(0);
        Equipo equipo2 = copiaEquiposMezclada.remove(0);

        if (equipo1 == null || equipo1.getNombreEquipo().isEmpty() ||
        equipo2 == null || equipo2.getNombreEquipo().isEmpty()) {
      
            throw new SorteoInvalidoException(
                "Error en el sorteo: No se puede emparejar un equipo sin nombre válido/vacio. Revise los datos del equipo."
            );
        }
        
        partidosGenerados.add(new Partido(equipo1, equipo2,etapa));

        emparejarRecursivo(copiaEquiposMezclada,etapa,partidosGenerados);
    }
    
    private ArrayList<Equipo> obtenerClasificados(ArrayList<Partido> partidos){
        ArrayList<Equipo> ganadores = new ArrayList<>();
        for(Partido partido : partidos){
            ganadores.add(partido.obtenerGanador());
        }
        return ganadores;
    }
    
    // serialización
    public void guardarTorneo(String rutaArchivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(this);
        }
    }
    
    // deserialización
    public static Torneo cargarTorneo(String rutaArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))){
            return (Torneo) ois.readObject();
        }
    }
    
    public ArrayList<Equipo> getEquiposIniciales() {
        return equiposIniciales;
    }

    public ArrayList<Partido> getHistorialPartidos() {
        return historialPartidos;
    }
    
}
