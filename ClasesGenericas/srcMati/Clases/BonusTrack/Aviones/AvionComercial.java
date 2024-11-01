package Clases.BonusTrack.Aviones;

import Clases.BonusTrack.Interfaces.DarComida;
import Clases.BonusTrack.Interfaces.DarManta;

import java.util.ArrayList;

public class AvionComercial extends Avion implements DarComida, DarManta {
    private int cantidadDeAzafatas;
    private ArrayList<String> listaDeServicio;

    public AvionComercial(String nombreDeModelo, String marca, Double capacidadDeCombustible, String tipoDeMotor, int cantidadDeAsientos, int cantidadDeAzafatas) {
        super(nombreDeModelo, marca, capacidadDeCombustible, tipoDeMotor, cantidadDeAsientos);
        this.cantidadDeAzafatas = cantidadDeAzafatas;
        this.listaDeServicio = new ArrayList<>();
    }

    public int getCantidadDeAzafatas() {
        return cantidadDeAzafatas;
    }

    public void setCantidadDeAzafatas(int cantidadDeAzafatas) {
        this.cantidadDeAzafatas = cantidadDeAzafatas;
    }

    public ArrayList<String> getListaDeServicio() {
        return listaDeServicio;
    }

    public void addServicio(String servicio) {
        listaDeServicio.add(servicio);
    }

    public void addServicio(String servicio,int index) {
        listaDeServicio.add(index, servicio);
    }


    @Override
    public void darComida() {
        System.out.println("Las azafatas empiezan a servir comida");
    }

    @Override
    public void darManta() {
        System.out.println("Las azafastas empiezan a dar mantas");
    }
}
