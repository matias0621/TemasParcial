package Clases.BonusTrack.Aviones;

import Clases.BonusTrack.Tipos.TiposDeArmas;

public class AvionMilitar extends Avion{
    private TiposDeArmas tipoDeArmas;
    private int cantidadDeBalas;

    public AvionMilitar(String nombreDeModelo, String marca, Double capacidadDeCombustible, String tipoDeMotor, int cantidadDeAsientos, TiposDeArmas tipoDeArmas, int cantidadDeBalas) {
        super(nombreDeModelo, marca, capacidadDeCombustible, tipoDeMotor, cantidadDeAsientos);
        this.tipoDeArmas = tipoDeArmas;
        this.cantidadDeBalas = cantidadDeBalas;
    }

    public TiposDeArmas getTipoDeArmas() {
        return tipoDeArmas;
    }

    public void setTipoDeArmas(TiposDeArmas tipoDeArmas) {
        this.tipoDeArmas = tipoDeArmas;
    }

    public int getCantidadDeBalas() {
        return cantidadDeBalas;
    }

    public void setCantidadDeBalas(int cantidadDeBalas) {
        this.cantidadDeBalas = cantidadDeBalas;
    }
}
