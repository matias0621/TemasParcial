package Clases.BonusTrack.Aviones;

import Clases.BonusTrack.Interfaces.DarComida;
import Clases.BonusTrack.Interfaces.DarManta;
import Clases.BonusTrack.Interfaces.VerMundial;

public class AvionPrivado extends Avion implements DarManta, DarComida, VerMundial {
    private boolean jacuzzi;
    private String claveWifi;

    public AvionPrivado(String nombreDeModelo, String marca, Double capacidadDeCombustible, String tipoDeMotor, int cantidadDeAsientos, boolean jacuzzi, String claveWifi) {
        super(nombreDeModelo, marca, capacidadDeCombustible, tipoDeMotor, cantidadDeAsientos);
        this.jacuzzi = jacuzzi;
        this.claveWifi = claveWifi;
    }

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public String getClaveWifi() {
        return claveWifi;
    }

    public void setClaveWifi(String claveWifi) {
        this.claveWifi = claveWifi;
    }


    @Override
    public void darComida() {
        System.out.println("Las azafatas empiezan a servir comida");
    }

    @Override
    public void darManta() {
        System.out.println("Las azafastas empiezan a dar mantas");
    }

    @Override
    public boolean verMundial() {
        return true;
    }
}
