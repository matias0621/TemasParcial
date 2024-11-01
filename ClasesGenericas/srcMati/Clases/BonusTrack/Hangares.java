package Clases.BonusTrack;

import Clases.BonusTrack.Aviones.Avion;
import Clases.BonusTrack.Excepciones.TamañoMaximo;

import java.util.ArrayList;

public class Hangares {
    private int capacidadMaxima;
    private ArrayList<Avion> avionesEnElHangar;
    private int capacidadDeLosHangares;

    public Hangares(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.avionesEnElHangar = new ArrayList<>();
        this.capacidadDeLosHangares = 3;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public ArrayList<Avion> getAvionesEnElHangar() {
        return avionesEnElHangar;
    }

    public void addAvion(Avion avion) throws TamañoMaximo {
        if (this.avionesEnElHangar.size() > this.capacidadDeLosHangares){
            throw new TamañoMaximo("No hay mas espacio compa");
        }
        else {
            this.avionesEnElHangar.add(avion);
        }
    }

    public void addAvion(Avion avion, int index) {
        this.avionesEnElHangar.add(index, avion);
    }

    public Avion getAvion(int index) {
        return this.avionesEnElHangar.get(index);
    }

    

}
