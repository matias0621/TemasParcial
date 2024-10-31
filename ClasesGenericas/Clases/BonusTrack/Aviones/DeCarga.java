package Clases.BonusTrack.Aviones;

import Clases.BonusTrack.Interfaces.DescargarContenido;
import Clases.BonusTrack.Interfaces.Ingresar;

import java.util.ArrayList;

public class DeCarga extends Avion implements Ingresar, DescargarContenido {
    private double carga;
    private ArrayList<String> posiblesProductor;

    public DeCarga(String nombreDeModelo, String marca, Double capacidadDeCombustible, String tipoDeMotor, int cantidadDeAsientos, double carga) {
        super(nombreDeModelo, marca, capacidadDeCombustible, tipoDeMotor, cantidadDeAsientos);
        this.carga = carga;
        this.posiblesProductor = new ArrayList<>();
    }

    public void addPosibleProductor(String producto) {
        posiblesProductor.add(producto);
    }

    public void addPosibleProductor(String producto,int index) {
        posiblesProductor.add(index, producto);
    }

    public ArrayList<String> returnPosiblesProductos(){
        return posiblesProductor;
    }


    @Override
    public void descargarcontenido() {
        if (!ingresar()){
            System.out.println("No hay nada dentro del avion");
        }
        else {
            System.out.println("Descargando el contenido");
        }
    }

    @Override
    public boolean ingresar() {
        return false;
    }
}
