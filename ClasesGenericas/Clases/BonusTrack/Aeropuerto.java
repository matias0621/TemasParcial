package Clases.BonusTrack;

import Clases.BonusTrack.Aviones.Avion;

import java.util.ArrayList;

public class Aeropuerto {
    private String nombre;
    private String codigoInternacional;
    private String direccion;
    private int capacidadDeOperacion;

    private ArrayList<Hangares> hangares;

    public Aeropuerto(String nombre, String codigoInternacional, String direccion, int capacidadDeOperacion) {
        this.nombre = nombre;
        this.codigoInternacional = codigoInternacional;
        this.direccion = direccion;
        this.capacidadDeOperacion = capacidadDeOperacion;
        hangares = new ArrayList<>();
    }

    public void mostrarTodosLosAvionesDeUnHangar(Hangares hagar){
        ArrayList<Avion> aviones = hagar.getAvionesEnElHangar();

        for(Avion avion : aviones){
            avion.despegar();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoInternacional() {
        return codigoInternacional;
    }

    public void setCodigoInternacional(String codigoInternacional) {
        this.codigoInternacional = codigoInternacional;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidadDeOperacion() {
        return capacidadDeOperacion;
    }

    public void setCapacidadDeOperacion(int capacidadDeOperacion) {
        this.capacidadDeOperacion = capacidadDeOperacion;
    }
}
